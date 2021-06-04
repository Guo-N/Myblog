package life.daguo.boot.Controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import life.daguo.boot.Pojo.blog;
import life.daguo.boot.Service.TypeService;
import life.daguo.boot.Service.blogService;
import life.daguo.boot.Service.tagService;
import org.apache.ibatis.javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
public class indexController {

    @Autowired
    blogService blogService;
    @Autowired
    TypeService typeService;
    @Autowired
    tagService tagService;
    @GetMapping("/")
    public String index(@RequestParam(value = "pn",defaultValue = "1")Integer pn, Model model){
        List<blog> getall = blogService.getall();
//        System.out.println(blogService.getall());
        PageHelper.startPage(pn,10);
        PageInfo<blog> page=new PageInfo<>(getall);
        model.addAttribute("page",page);
        model.addAttribute("types",typeService.listTypeTop(6));
        model.addAttribute("tags",tagService.listTagTop(10));
        model.addAttribute("recommendblogs",blogService.listRecommendBlogTop(8));
        return "index";
    }

    @PostMapping("/search")
    public String search(@RequestParam("query")String query,Model model){
        model.addAttribute("page",blogService.listBlog(query));
        model.addAttribute("query",query);
        return "search";
    }

    @GetMapping("/blog/{id}")
    public String blog(@PathVariable("id")Integer id, Model model, HttpSession session) throws NotFoundException {
//        System.out.println(id);
        model.addAttribute("blog",blogService.getAndConvert(id));
        return "blog";
    }

    @GetMapping("/footer/newblog")
    public String newblogs(Model model){
        List<blog> blogs = blogService.listRecommendBlogTop(4);
        List<blog> newblogs=new ArrayList<>();
        for(int i=0;i<3;i++){
            newblogs.add(blogs.get(i));
        }
        model.addAttribute("newblogs",newblogs);
        return "_fragments :: newblogList";
    }
}
