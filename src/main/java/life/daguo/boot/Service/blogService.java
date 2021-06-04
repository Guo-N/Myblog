package life.daguo.boot.Service;

import com.github.pagehelper.PageInfo;
import life.daguo.boot.Pojo.blog;
import org.apache.ibatis.javassist.NotFoundException;

import java.util.List;
import java.util.Map;

public interface blogService {
    blog getBolg(Integer id);
    List<blog> getall();
   PageInfo<blog> listBlog(String query);
    List<blog>  listRecommendBlogTop(Integer size);
    List<blog>  getBlogById(Integer id);
    blog getAndConvert(Integer id) throws NotFoundException;
    int saveBlog(blog blog);
    int updateBlog(Integer id,blog blog) throws NotFoundException;
    int deleteBlog(Integer id);
    List<blog> getBlogBytagId(Integer id);
    Map<String,List<blog>> archiveBlog();
    Integer countBlog();
}
