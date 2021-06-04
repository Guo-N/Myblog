package life.daguo.boot.Service;

import life.daguo.boot.Pojo.tag;

import java.util.List;

public interface tblogtagsService {
    boolean saveTag(Integer blogId,String tagid);
    List<tag> getallTag();
    List<tag> getTagByblogId(Integer blogId);
    String getTagIdsByblogId(Integer id);
}
