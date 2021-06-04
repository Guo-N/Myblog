package life.daguo.boot.Service;

import life.daguo.boot.Pojo.user;

import java.util.List;

public interface userService {
   List<user> checkUser(String username, String password);
}
