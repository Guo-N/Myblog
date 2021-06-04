package life.daguo.boot.Controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import life.daguo.boot.Pojo.blog;
import life.daguo.boot.Pojo.tag;
import life.daguo.boot.Service.blogService;
import life.daguo.boot.Service.tagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class tagShowController {
    @Autowired
    tagService tagService;

    @Autowired
    blogService blogService;
    @GetMapping("/tags/{id}")
    public String types(@PathVariable("id")Integer id, Model model){
        List<tag> tags = tagService.listTagTop(10000);
        if(id == -1){
            id=tags.get(0).getId();
        }
        PageHelper.startPage(1,10);
        PageInfo<blog> page=new PageInfo<>(blogService.getBlogBytagId(id));
        model.addAttribute("tags",tags);
        model.addAttribute("page",page);
        model.addAttribute("activeTagId",id);
        return "tags";
    }
}
