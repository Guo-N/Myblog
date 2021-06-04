package life.daguo.boot.Service.ServiceImpl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import life.daguo.boot.Dao.*;
import life.daguo.boot.Pojo.*;
import life.daguo.boot.Service.blogService;
import life.daguo.boot.util.MarkDownUtils;
import org.apache.ibatis.javassist.NotFoundException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
public class blogServiceImpl implements blogService {
    @Autowired
    blogMapper blogMapper;
    @Autowired
    typeMapper typeMapper;
    @Autowired
    userMapper userMapper;
    @Autowired
    tagMapper tagMapper;
    @Autowired
    tblogtagsMapper tblogtagsMapper;
    @Override
    public blog getBolg(Integer id) {
        List<tag> blogtags=new ArrayList<>();
        tblogtagsExample example=new tblogtagsExample();
        blog blog = blogMapper.selectByPrimaryKey(id);
        user user=userMapper.selectByPrimaryKey(blog.getUserId());
        type type = typeMapper.selectByPrimaryKey(blog.getTypeId());
        tblogtagsExample.Criteria criteria = example.createCriteria();
        criteria.andBlogsIdEqualTo(id);
        List<tblogtags> tblogtags = tblogtagsMapper.selectByExample(example);
        for(int i=0;i<tblogtags.size();i++) {
            tag tag = tagMapper.selectByPrimaryKey(tblogtags.get(i).getTagsId());
            blogtags.add(tag);
        }
        blog.setUser(user);
        blog.setType(type);
        blog.setTags(blogtags);
        return blog;
    }


    @Override
    public List<blog> getBlogById(Integer id) {
      blogExample example=new blogExample();
        blogExample.Criteria criteria = example.createCriteria();
        blogExample.Criteria criteria1 = criteria.andTypeIdEqualTo(id);
        List<blog> blogs = blogMapper.selectByExample(example);
        for(int i=0;i<blogs.size();i++){
            blog blog = blogMapper.selectByPrimaryKey(blogs.get(i).getId());
            type type = typeMapper.selectByPrimaryKey(blog.getTypeId());
            user user = userMapper.selectByPrimaryKey(blog.getUserId());
            blogs.get(i).setUser(user);
            blogs.get(i).setType(type);
        }
        return blogs;
    }

    @Override
    public List<blog> getall() {
        List<blog> blogs = blogMapper.selectByExample(null);
        for(int i=0;i<blogs.size();i++){
            blog blog = blogMapper.selectByPrimaryKey(blogs.get(i).getId());
            type type = typeMapper.selectByPrimaryKey(blog.getTypeId());
            user user = userMapper.selectByPrimaryKey(blog.getUserId());
            blogs.get(i).setUser(user);
            blogs.get(i).setType(type);
        }
        return blogs;
    }

    @Override
    public PageInfo<blog> listBlog(String query) {
        blogExample example=new blogExample();
        blogExample.Criteria criteria = example.createCriteria();
        query="%"+query+"%";
        example.or().andTitleLike(query);
        example.or().andContentLike(query);
        List<blog> blogs = blogMapper.selectByExample(example);
        for(int i=0;i<blogs.size();i++){
            blog blog = blogMapper.selectByPrimaryKey(blogs.get(i).getId());
            type type = typeMapper.selectByPrimaryKey(blog.getTypeId());
            user user = userMapper.selectByPrimaryKey(blog.getUserId());
            blogs.get(i).setUser(user);
            blogs.get(i).setType(type);
        }
        PageHelper.startPage(0,10,"updateTime desc");
        PageInfo<blog> page=new PageInfo<>(blogs);
        return page;
    }
    @Override
    public List<blog> listRecommendBlogTop(Integer size) {
        PageHelper.startPage(0,size,"updateTime desc");
        PageInfo<blog> page=new PageInfo<>(blogMapper.selectByExample(null));
        return  blogMapper.findTop(page);
    }


    @Override
    public blog getAndConvert(Integer id) throws NotFoundException {
        List<tag> blogtags=new ArrayList<>();
        tblogtagsExample example=new tblogtagsExample();
        blog blog = blogMapper.selectByPrimaryKey(id);
        user user=userMapper.selectByPrimaryKey(blog.getUserId());
        type type = typeMapper.selectByPrimaryKey(blog.getTypeId());
        tblogtagsExample.Criteria criteria = example.createCriteria();
        criteria.andBlogsIdEqualTo(id);
        List<tblogtags> tblogtags = tblogtagsMapper.selectByExample(example);
        for(int i=0;i<tblogtags.size();i++) {
            tag tag = tagMapper.selectByPrimaryKey(tblogtags.get(i).getTagsId());
            blogtags.add(tag);
        }
        blog.setUser(user);
        blog.setType(type);
        blog.setTags(blogtags);
        blog b=new blog();
        BeanUtils.copyProperties(blog,b);
        if(blog==null){
            throw new NotFoundException("该博客不存在或已被删除");
        }
       String content=b.getContent();
       b.setContent(MarkDownUtils.markdownToHtmlExtensions(content));
       blogMapper.updateViews(id);
       return b;
    }

    @Transactional
    @Override
    public int saveBlog(blog blog) {
        if(blog.getId()==null){
            blog.setCreatetime(new Date());
            blog.setUpdatetime(new Date());
            blog.setViews(0);
            blog.setTypeId(blog.getType().getId());
            blog.setUserId(blog.getUser().getId());
        }else{
            blog.setUpdatetime(new Date());
            return blogMapper.updateByPrimaryKeySelective(blog);
        }
        if("".equals(blog.getFlag())){
            blog.setFlag("原创");
        }
        return blogMapper.insert(blog);
    }

    @Transactional
    @Override
    public int updateBlog(Integer id, blog blog) throws NotFoundException {
        life.daguo.boot.Pojo.blog blog1 = blogMapper.selectByPrimaryKey(id);
        if(blog1==null) {
            throw new NotFoundException("该博客不存在或已被删除");
        }
        return blogMapper.insert(blog);
    }

    @Transactional
    @Override
    public int deleteBlog(Integer id) {
        return blogMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<blog> getBlogBytagId(Integer id) {
        List<blog> blogtags=new ArrayList<>();
        tblogtagsExample example = new tblogtagsExample();
        tblogtagsExample.Criteria criteria = example.createCriteria();
        criteria.andTagsIdEqualTo(id);
        List<tblogtags> tblogtags = tblogtagsMapper.selectByExample(example);
//        tblogtagsExample example1=new tblogtagsExample();
//        tblogtagsExample.Criteria criteria1 = example1.createCriteria();
        for(int i=0;i<tblogtags.size();i++){
            List<tag> tagblogs=new ArrayList<>();
            blog blog = blogMapper.selectByPrimaryKey(tblogtags.get(i).getBlogsId());
            tblogtagsExample example1=new tblogtagsExample();
            tblogtagsExample.Criteria criteria1 = example1.createCriteria();
            criteria1.andBlogsIdEqualTo(tblogtags.get(i).getBlogsId());
            List<tblogtags> tblogtags1 = tblogtagsMapper.selectByExample(example1);
            for(int j=0;j<tblogtags1.size();j++){
                tag tag = tagMapper.selectByPrimaryKey(tblogtags1.get(j).getTagsId());
                tagblogs.add(tag);
            }
            user user = userMapper.selectByPrimaryKey(blog.getUserId());
            type type = typeMapper.selectByPrimaryKey(blog.getTypeId());
            blog.setUser(user);
            blog.setType(type);
            blog.setTags(tagblogs);
            blogtags.add(blog);
        }
        return blogtags;
    }

    @Override
    public Map<String, List<blog>> archiveBlog() {
        List<String> groupYear = blogMapper.findGroupYear();
        Map<String,List<blog>> map=new HashMap<>();
        for (String year:groupYear) {
            map.put(year, blogMapper.getBlogByYear(year));
        }
        return map;
    }

    @Override
    public Integer countBlog() {
        blogExample example=new blogExample();
        blogExample.Criteria criteria = example.createCriteria();
        criteria.andIdIsNotNull();
        return blogMapper.countByExample(example);
    }
}
