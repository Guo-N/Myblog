package life.daguo.boot.Service.ServiceImpl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import life.daguo.boot.Dao.blogMapper;
import life.daguo.boot.Dao.typeMapper;
import life.daguo.boot.Pojo.blog;
import life.daguo.boot.Pojo.blogExample;
import life.daguo.boot.Pojo.type;
import life.daguo.boot.Pojo.typeExample;
import life.daguo.boot.Service.TypeService;
import org.apache.ibatis.javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TypeServiceImpl implements TypeService {

    @Autowired
    typeMapper typeMapper;

    @Autowired
    blogMapper blogMapper;
    @Transactional
    @Override
    public int saveType(type type) {
        return typeMapper.insert(type);
    }

    @Transactional
    @Override
    public type getType(Integer id) {
        type type = typeMapper.selectByPrimaryKey(id);
        return type;
    }

    @Override
    public List<type> getalltypes() {
        List<type> types = typeMapper.selectByExample(null);
        return types;
    }

    @Override
    public List<type> getTypeByName(String name) {
        typeExample example=new typeExample();
        typeExample.Criteria criteria = example.createCriteria();
        typeExample.Criteria criteria1 = criteria.andNameEqualTo(name);
        return typeMapper.selectByExample(example);
    }

    @Override
    public List<type> listTypeTop(Integer size) {
        List<type> types = typeMapper.selectByExample(null);
        for (int i=0;i<types.size();i++) {
            blogExample blogExample=new blogExample();
            life.daguo.boot.Pojo.blogExample.Criteria criteria = blogExample.createCriteria();
            criteria.andTypeIdEqualTo(types.get(i).getId());
            List<blog> blogs = blogMapper.selectByExample(blogExample);
            types.get(i).setBlogs(blogs);
        }
        PageHelper.startPage(0,size,"blogs.size desc");
        PageInfo<type> page=new PageInfo<>(types);
        return page.getList();
    }

    @Transactional
    @Override
    public int updateType(Integer id,type type1) throws NotFoundException {
        int insert=0;
        type type = typeMapper.selectByPrimaryKey(id);
        if(type!=null){
            typeMapper.deleteByPrimaryKey(id);
             insert = typeMapper.insert(type1);
            return insert;
        }
        else{
            throw new NotFoundException("该类型不存在");
        }
    }

    @Transactional
    @Override
    public void deleteType(Integer id) {
        int i = typeMapper.deleteByPrimaryKey(id);
    }
}
