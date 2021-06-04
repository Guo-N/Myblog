package life.daguo.boot.Controller;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import life.daguo.boot.Pojo.tag;
import life.daguo.boot.Service.tagService;
import org.apache.ibatis.javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by 南宫乘风
 */

@Controller
@RequestMapping("/admin")
public class tagController {

    @Autowired
    tagService tagService;


    @GetMapping("/tags")
    public String tags(@RequestParam(value = "pn",defaultValue = "1")Integer pn,Model model) {
        PageHelper.startPage(pn,10);
        PageInfo<tag> page=new PageInfo<>(tagService.getalltags());
        model.addAttribute("page",page);
        return "admin/tags";
    }

    @GetMapping("/tags/input")
    public String input(Model model) {
        model.addAttribute("tag", new tag());
        return "admin/tags-input";
    }

    @GetMapping("/tags/{id}/input")
    public String editInput(@PathVariable Integer id, Model model) {
        model.addAttribute("tag", tagService.getTag(id));
        return "admin/tags-input";
    }


    @PostMapping("/tags")
    public String post(@Valid tag tag,BindingResult result, RedirectAttributes attributes) {
        List<tag> tag1 = tagService.getTagByName(tag.getName());
        if (!tag1 .isEmpty()) {
            result.rejectValue("name","nameError","不能添加重复的分类");
        }
        if (result.hasErrors()) {
            return "admin/tags-input";
        }
        int t = tagService.saveTag(tag);
        if (t == 0 ) {
            attributes.addFlashAttribute("message", "新增失败");
        } else {
            attributes.addFlashAttribute("message", "新增成功");
        }
        return "redirect:/admin/tags";
    }

    @PostMapping("/tags/{id}")
    public String editPost(@Valid tag tag, BindingResult result,
                           @PathVariable("id")Integer id,
                           RedirectAttributes attributes) throws NotFoundException {
        List<tag> tag1 = tagService.getTagByName(tag.getName());
        if (! tag1 .isEmpty()) {
            result.rejectValue("name","nameError","不能添加重复的分类");
        }
        if (result.hasErrors()) {
            return "admin/tags-input";
        }
        int t = tagService.updateTag(id,tag);
        if (t == 0 ) {
            attributes.addFlashAttribute("message", "更新失败");
        } else {
            attributes.addFlashAttribute("message", "更新成功");
        }
        return "redirect:/admin/tags";
    }

    @GetMapping("/tags/{id}/delete")
    public String delete(@PathVariable("id")Integer id,
                         RedirectAttributes attributes) {
        tagService.deleteTag(id);
        attributes.addFlashAttribute("message", "删除成功");
        return "redirect:/admin/tags";
    }


}
