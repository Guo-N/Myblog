package life.daguo.boot.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import life.daguo.boot.Pojo.type;
import org.apache.ibatis.javassist.NotFoundException;

import java.util.List;

public interface TypeService {
   int saveType(type type);
   type getType(Integer id);
   List<type> getalltypes();
   List<type> getTypeByName(String name);
   List<type> listTypeTop(Integer size);
   int updateType(Integer id,type type) throws NotFoundException;
   void deleteType(Integer id);
}
