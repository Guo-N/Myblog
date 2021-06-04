package life.daguo.boot.Controller;

import life.daguo.boot.Service.blogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class archiveShowController {
    @Autowired
    blogService blogService;
    @GetMapping("/archives")
    public String archive(Model model){
      model.addAttribute("archiveMap",blogService.archiveBlog());
      model.addAttribute("blogCount",blogService.countBlog());
      return "archives";
    }
}
