package life.daguo.boot.Controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import life.daguo.boot.Pojo.*;
import life.daguo.boot.Service.TypeService;
import life.daguo.boot.Service.blogService;
import life.daguo.boot.Service.tagService;
import life.daguo.boot.Service.tblogtagsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class BlogController{
    @Autowired
    blogService blogService;
    @Autowired
    TypeService typeService;
    @Autowired
    tagService tagService;
    @Autowired
    tblogtagsService tblogtagsService;
    @GetMapping(value = "/blogs")
    public String blogs(@RequestParam(value = "pn",defaultValue = "1")Integer pn, Model model){
        List<type> getalltypes = typeService.getalltypes();
        model.addAttribute("types",getalltypes);
        List<blog> alllist = blogService.getall();
        PageHelper.startPage(pn,3);
        PageInfo<blog> page=new PageInfo<>(alllist);
        model.addAttribute("page",page);
        return "admin/blogs";
    }

    @PostMapping("/blogs/search")
    public String search(@RequestParam(value = "pn",defaultValue = "1")Integer pn, Model model){
        List<blog> alllist = blogService.getall();
        PageHelper.startPage(pn,3);
        PageInfo<blog> page=new PageInfo<>(alllist);
        model.addAttribute("page",page);
        return "admin/blogs :: blogList";
    }

    @GetMapping("blogs/input")
    public String input(Model model){
        SetTypesAndTags(model);
        model.addAttribute("blog",new blog());
        return "admin/blogs-input";
    }

    @GetMapping("/blogs/{id}/input")
    public String editInput(@PathVariable("id")Integer id,Model model){
        SetTypesAndTags(model);
        blog blog = blogService.getBolg(id);
        List<tag> selecttags = tblogtagsService.getTagByblogId(id);
        blog.setTags(selecttags);
        blog.setTagIds(tblogtagsService.getTagIdsByblogId(id));
        model.addAttribute("blog",blog);
//        model.addAttribute("tags",blog.getTags());
        return "admin/blogs-input";
    }
    private void SetTypesAndTags(Model model){
        model.addAttribute("types",typeService.getalltypes());
        model.addAttribute("tags",tagService.getalltags());
    }

    @PostMapping("/blogs")
    public String Post(blog blog, HttpSession session,RedirectAttributes redirectAttributes){
        blog.setUser((user) session.getAttribute("user"));
        blog.setType(typeService.getType(blog.getType().getId()));
        blog.setTags(tagService.listtag(blog.getTagIds()));
        //save
        if(blog.getId()!=null){
         boolean b = tblogtagsService.saveTag(blog.getId(), blog.getTagIds());
        if(!b){
            redirectAttributes.addFlashAttribute("message","操作失败，请重试");
        }
        }

        int i = blogService.saveBlog(blog);
        System.out.println(blog.getId());
        if(i==0){
            redirectAttributes.addFlashAttribute("message","操作失败，请重试");
            //type保存失败
        }else{
            //保存成功
            redirectAttributes.addFlashAttribute("message","操作成功");
        }
        return "redirect:/admin/blogs";
    }

    @GetMapping("/blogs/{id}/delete")
    public String delete(@PathVariable("id")Integer id, RedirectAttributes redirectAttributes){
        blogService.deleteBlog(id);
        redirectAttributes.addFlashAttribute("message","删除成功");
        return "redirect:/admin/blogs";
    }

}
