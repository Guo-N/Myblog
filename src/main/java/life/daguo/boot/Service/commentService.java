package life.daguo.boot.Service;

import life.daguo.boot.Pojo.comment;
import life.daguo.boot.Pojo.user;

import javax.servlet.http.HttpSession;
import java.util.List;

public interface commentService {
    int saveComment(comment comment);
    List<comment> listCommentByBlogId(Integer id);

 }
