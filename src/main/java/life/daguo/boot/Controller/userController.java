package life.daguo.boot.Controller;

import life.daguo.boot.Pojo.user;
import life.daguo.boot.Service.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class userController {

    @Autowired
    userService userService;

    @GetMapping
    public String toLoginPage(){
        return "admin/login";
    }

    @PostMapping("/login")
    public String login(@RequestParam(value = "username")String username,
                        @RequestParam(value = "password")String password,
                        RedirectAttributes redirectAttributes,
                        HttpSession session){
       List<user> user = userService.checkUser(username, password);
        if(! user.isEmpty()){
            user user1=user.get(0);
            user1.setPassword(null);
            session.setAttribute("user",user1);
            return "admin/index";
        }else{
            redirectAttributes.addAttribute("message","账号或密码错误");
            return "redirect:/admin";
        }

    }

    @GetMapping("/logout")
    public String logout(HttpSession session){
        session.removeAttribute("user");
        return "redirect:/admin";
    }
}
