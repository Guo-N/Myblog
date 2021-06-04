package life.daguo.boot.Service.ServiceImpl;

import life.daguo.boot.Dao.blogMapper;
import life.daguo.boot.Dao.commentMapper;
import life.daguo.boot.Pojo.blog;
import life.daguo.boot.Pojo.comment;
import life.daguo.boot.Pojo.commentExample;
import life.daguo.boot.Service.commentService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class commentServiceImpl implements commentService {
    @Autowired
    blogMapper blogMapper;
    @Autowired
    commentMapper commentMapper;
    @Override
    public int saveComment(comment comment) {
        Integer parentCommentId=comment.getParentCommentId();
        if(parentCommentId != -1){
            comment.setParentComment(commentMapper.selectByPrimaryKey(parentCommentId));
        }else{
            comment.setParentComment(null);
            comment.setParentCommentId(null);
        }
        blog blog = blogMapper.selectByPrimaryKey(comment.getBlogId());
        comment.setBlog(blog);
        comment.setCreateTime(new Date());
        comment.setCreatetime(new Date());
        return commentMapper.insert(comment);
    }

    @Override
    public List<comment> listCommentByBlogId(Integer id) {
        commentExample example=new commentExample();
        commentExample.Criteria criteria = example.createCriteria();
        example.setOrderByClause("createTime");
        criteria.andBlogIdEqualTo(id);
        criteria.andParentCommentIdIsNull();
        List<comment> comments = commentMapper.selectByExample(example);
        for(int i=0;i<comments.size();i++){
            commentExample example1=new commentExample();
            commentExample.Criteria criteria1;
            criteria1 = example1.createCriteria();
            criteria1.andParentCommentIdEqualTo(comments.get(i).getId());
            List<comment> comments1 = commentMapper.selectByExample(example1);
//            List<comment> replyComments = comments.get(i).getReplyComments();
            for(int k=0;k<comments1.size();k++){
                commentExample example2=new commentExample();
                commentExample.Criteria criteria2 = example2.createCriteria();
                criteria2.andParentCommentIdEqualTo(comments1.get(k).getId());
                comments1.get(k).setReplyComments(commentMapper.selectByExample(example2));
                for(int l=0;l<comments1.get(k).getReplyComments().size();l++){
                    comments1.get(k).getReplyComments().get(l).setParentComment(comments1.get(k));
                }
//                System.out.println();
            }
            comments.get(i).setReplyComments(comments1);
            for(int j=0;j<comments.get(i).getReplyComments().size();j++){
                comments.get(i).getReplyComments().get(j).setParentComment(comments.get(i));
            }
        }
//        System.out.println(eachComment(comments));
        return eachComment(comments);
    }
//
//    private void setreplaycommentforreply(Integer id){
//        commentExample example=new commentExample();
//        commentExample.Criteria criteria = example.createCriteria();
//        example.setOrderByClause("createTime DESC");
//        criteria.andBlogIdEqualTo(id);
//        criteria.andParentCommentIdIsNotNull();
//        List<comment> comments = commentMapper.selectByExample(example);
//        for(int i=0;i<comments.size();i++){
//            commentExample example1=new commentExample();
//            commentExample.Criteria criteria1 = example1.createCriteria();
//            criteria1.andParentCommentIdEqualTo(comments.get(i).getId());
//            List<comment> comments1 = commentMapper.selectByExample(example);
//            comments.get(i).setReplyComments(comments1);
//        }
//    }
    private List<comment> eachComment(List<comment> comments) {
        List<comment> commentsView = new ArrayList<>();
        for (comment comment : comments) {
            comment c = new comment();
            BeanUtils.copyProperties(comment,c);
            commentsView.add(c);
        }
        //合并评论的各层子代到第一级子代集合中
        combineChildren(commentsView);
//        System.out.println(commentsView);
        return commentsView;
    }

    private void combineChildren(List<comment> comments) {
        for (comment comment : comments) {
            List<comment> replys1 = comment.getReplyComments();
            for(comment reply1 : replys1) {
                //循环迭代，找出子代，存放在tempReplys中
                recursively(reply1);
            }
            //修改顶级节点的reply集合为迭代处理后的集合
            comment.setReplyComments(tempReplys);
            //清除临时存放区
            tempReplys = new ArrayList<>();
        }

    }

    private void recursively(comment comment) {
        tempReplys.add(comment);
        //顶节点添加到临时存放集合
        if (comment.getReplyComments().size()>0) {
            List<comment> replys = comment.getReplyComments();
            for (comment reply : replys) {
                tempReplys.add(reply);
                if (reply.getReplyComments().size()>0) {
                    recursively(reply);
                }
            }
        }
    }
    private List<comment> tempReplys = new ArrayList<>();
}
