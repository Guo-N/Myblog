package life.daguo.boot.Controller;

import life.daguo.boot.Pojo.comment;
import life.daguo.boot.Pojo.user;
import life.daguo.boot.Service.blogService;
import life.daguo.boot.Service.commentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.net.ssl.HttpsURLConnection;
import javax.servlet.http.HttpSession;

@Controller
public class CommentController {
    @Autowired
    commentService commentService;
    @Value("/images/avatar.png")
    private String avatar;
    @GetMapping("/comments/{blogId}")
    public String comment(@PathVariable("blogId")Integer blogId, Model model) {
        model.addAttribute("comments",commentService.listCommentByBlogId(blogId));
      return "blog :: commentList";
    }

    @PostMapping("/comments")
    public String Post(comment comment, HttpSession session){
        comment.setAvatar(avatar);
//        System.out.println(session.getAttribute("user"));
        user user= (life.daguo.boot.Pojo.user) session.getAttribute("user" );
        if(user!=null){
            comment.setAdminComment(true);
            comment.setAvatar("/images/admin_avatar.jpg");
        }else{
            comment.setAdminComment(false);
            comment.setAvatar(avatar);
        }
       commentService.saveComment(comment);
        return "redirect:/comments/"+comment.getBlogId();
    }
}
