package life.daguo.boot.Controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import life.daguo.boot.Pojo.type;
import life.daguo.boot.Service.TypeService;
import org.apache.ibatis.javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class TypeController {
    @Autowired
    TypeService typeService;
    @GetMapping("/types")
    public String types(@RequestParam(value = "pn",defaultValue = "1")Integer pn,
                        Model model){
        PageHelper.startPage(pn,10);
        List<type> typeList = typeService.getalltypes();
        PageInfo<type> page=new PageInfo<>(typeList);
        model.addAttribute("page",page);
        return "admin/types";
    }

    @PostMapping("/types")
    public String posttypes(@Valid type type,BindingResult result, RedirectAttributes redirectAttributes){
        List<life.daguo.boot.Pojo.type> typeByName = typeService.getTypeByName(type.getName());
        if(! typeByName.isEmpty()){
            result.rejectValue("name","typeAlreadyExist","该类型已存在");
        }
        if(result.hasErrors()){
            return "admin/types-input";
        }
        int i = typeService.saveType(type);
        if(i==0){
            redirectAttributes.addFlashAttribute("message","操作失败，请重试");
            //type保存失败
        }else{
            //保存成功
            redirectAttributes.addFlashAttribute("message","操作成功");
        }
        return "redirect:/admin/types";

    }

    @GetMapping("/types/input")
    public String input(Model model){
        model.addAttribute("type",new type());
        return "admin/types-input";
    }


    @GetMapping("/types/{id}/input")
    public String edit(@PathVariable Integer id, Model model){
        model.addAttribute("type",typeService.getType(id));
        return "admin/types-input";
    }

    @PostMapping("/types/{id}")
    public String editPost(@Valid type type,BindingResult result1,@PathVariable Integer id,RedirectAttributes redirectAttributes){
        try {
            List<life.daguo.boot.Pojo.type> typeByName = typeService.getTypeByName(type.getName());
            if(! typeByName.isEmpty()){
                result1.rejectValue("name","TypeAlreadyExist","无法添加重复分类");
            }
            if(result1.hasErrors()){
                return "admin/types-input";
            }
            int i = typeService.updateType(id, type);
            if(i==0){
                redirectAttributes.addFlashAttribute("message","更新失败");
            }else{
                redirectAttributes.addFlashAttribute("message","更新成功");
            }
        } catch (NotFoundException e) {
            e.printStackTrace();
        }
        return "redirect:/admin/types";
    }

    @GetMapping("/types/{id}/delete")
    public String delete(@PathVariable Integer id,RedirectAttributes redirectAttributes){
        typeService.deleteType(id);
        redirectAttributes.addFlashAttribute("message","删除成功");
        return "redirect:/admin/types";
    }
}
