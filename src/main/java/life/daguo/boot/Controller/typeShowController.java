package life.daguo.boot.Controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import life.daguo.boot.Dao.typeMapper;
import life.daguo.boot.Pojo.blog;
import life.daguo.boot.Pojo.type;
import life.daguo.boot.Service.TypeService;
import life.daguo.boot.Service.blogService;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class typeShowController {

    @Autowired
    TypeService typeService;

    @Autowired
    blogService blogService;
    @GetMapping("/types/{id}")
    public String types(@PathVariable("id")Integer id, Model model){
        List<type> types = typeService.listTypeTop(10000);
        if(id == -1){
            id=types.get(0).getId();
        }
        blogService.getBlogById(id);
        List<blog> blogById =  blogService.getBlogById(id);
        PageHelper.startPage(0,10);
        PageInfo<blog> page=new PageInfo<>(blogById);
        model.addAttribute("types",types);
        model.addAttribute("page",page);
        model.addAttribute("activeTypeId",id);
        return "types";
    }
}
