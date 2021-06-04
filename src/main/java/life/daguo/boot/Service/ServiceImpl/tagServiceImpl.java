package life.daguo.boot.Service.ServiceImpl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import life.daguo.boot.Dao.blogMapper;
import life.daguo.boot.Dao.tagMapper;
import life.daguo.boot.Dao.tblogtagsMapper;
import life.daguo.boot.Pojo.*;
import life.daguo.boot.Service.tagService;
import org.apache.ibatis.javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class tagServiceImpl implements tagService {

    @Autowired
    tagMapper tagMapper;
    @Autowired
    blogMapper blogMapper;
    @Autowired
    tblogtagsMapper tblogtagsMapper;
    @Override
    public int saveTag(tag tag) {
        return tagMapper.insert(tag);
    }

    @Override
    public tag getTag(Integer id) {
        return tagMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<tag> getalltags() {
        return tagMapper.selectByExample(null);
    }

    @Override
    public List<tag> listtag(String ids) {
        List<tag> list=new ArrayList<>();
        if(!"".equals(ids)){
           String[] id = ids.split(",");
            for (String id1:id){
                tag tag = tagMapper.selectByPrimaryKey(Integer.parseInt(id1));
                list.add(tag);
            }
        }
        return list;
    }

    @Override
    public List<tag> getTagByName(String name) {
        tagExample example=new tagExample();
        tagExample.Criteria criteria = example.createCriteria();
        criteria.andNameEqualTo(name);
        return tagMapper.selectByExample(example);
    }

    @Override
    public List<tag> listTagTop(Integer size) {
        PageHelper.startPage(0,size,"blogs desc");
        PageInfo<tag> page=new PageInfo<>(tagMapper.selectByExample(null));
        List<tag> tag1=tagMapper.selectByExample(null);
        for(int i=0;i<tag1.size();i++){
            List<blog> tagblogs=new ArrayList<>();
            tblogtagsExample example=new tblogtagsExample();
            tblogtagsExample.Criteria criteria = example.createCriteria();
            criteria.andTagsIdEqualTo(tag1.get(i).getId());
            List<tblogtags> tblogtags = tblogtagsMapper.selectByExample(example);
            for(int j=0;j<tblogtags.size();j++){
               blog blog = blogMapper.selectByPrimaryKey(tblogtags.get(j).getBlogsId());
               tagblogs.add(blog);
           }
            tag1.get(i).setBlogs(tagblogs);
        }
//        System.out.println(tag1);
        return tag1;
    }

    @Override
    public int updateTag(Integer id, tag tag) throws NotFoundException {
        life.daguo.boot.Pojo.tag tag1 = tagMapper.selectByPrimaryKey(id);
        if(tag1==null) {
            throw new NotFoundException("该标签不存在或已被删除");
        }
        tagMapper.deleteByPrimaryKey(id);
        return tagMapper.insert(tag);
    }

    @Override
    public void deleteTag(Integer id) {
   tagMapper.deleteByPrimaryKey(id);
    }
}
