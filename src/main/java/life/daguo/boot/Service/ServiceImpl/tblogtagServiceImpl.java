package life.daguo.boot.Service.ServiceImpl;

import life.daguo.boot.Dao.tagMapper;
import life.daguo.boot.Dao.tblogtagsMapper;
import life.daguo.boot.Pojo.tag;
import life.daguo.boot.Pojo.tblogtags;
import life.daguo.boot.Pojo.tblogtagsExample;
import life.daguo.boot.Service.tblogtagsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class tblogtagServiceImpl implements tblogtagsService {

    @Autowired
    tblogtagsMapper tblogtagsMapper;
    @Autowired
    tagMapper tagMapper;
    @Override
    public boolean saveTag(Integer blogid,String tagid) {
        if("".equals(tagid)){
            return false;
        }
        tblogtags t=new tblogtags();
        tblogtagsExample tblog=new tblogtagsExample();
        tblogtagsExample.Criteria criteria = tblog.createCriteria();
        criteria.andBlogsIdEqualTo(blogid);
        List<tblogtags>list=tblogtagsMapper.selectByExample(tblog);
        t.setBlogsId(blogid);
        String[] split = tagid.split(",");
        if(! list.isEmpty()){
            tblogtagsMapper.deleteByExample(tblog);
        }
            for (String i:split) {
                t.setTagsId(Integer.parseInt(i));
                tblogtagsMapper.insert(t);
            }
            return true;
        }
    @Override
    public List<tag> getallTag() {
       return null;

    }

    @Override
    public List<tag> getTagByblogId(Integer blogId) {
        tblogtagsExample Example=new tblogtagsExample();
        tblogtagsExample.Criteria criteria = Example.createCriteria();
        criteria.andBlogsIdEqualTo(blogId);
        List<tblogtags> tblogtags = tblogtagsMapper.selectByExample(Example);
        List<tag> taglist=new ArrayList<>();
        for (tblogtags tblogtags1:tblogtags) {
            tag tag = tagMapper.selectByPrimaryKey(tblogtags1.getTagsId());
            taglist.add(tag);
        }
        return taglist;
    }

    @Override
    public String getTagIdsByblogId(Integer id) {
        tblogtagsExample example=new tblogtagsExample();
        tblogtagsExample.Criteria criteria = example.createCriteria();
        criteria.andBlogsIdEqualTo(id);
        List<tblogtags> tblogtags = tblogtagsMapper.selectByExample(example);
       String tagids="";
       int count=0;
        for (tblogtags t:tblogtags) {
            count++;
            tagids = (count==tblogtags.size())?tagids+t.getTagsId():tagids+t.getTagsId()+",";
        }
        return tagids;
    }
}
