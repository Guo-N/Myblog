package life.daguo.boot.Service;

import life.daguo.boot.Pojo.tag;
import life.daguo.boot.Pojo.type;
import org.apache.ibatis.javassist.NotFoundException;

import java.util.List;

public interface tagService {
    int saveTag(tag tag);
    tag getTag(Integer id);
    List<tag> getalltags();
    List<tag> listtag(String ids);
    List<tag> getTagByName(String name);
    List<tag> listTagTop(Integer size);
//    List<tag> getTagByName(String name);
    int updateTag(Integer id,tag tag) throws NotFoundException;
    void deleteTag(Integer id);
}
