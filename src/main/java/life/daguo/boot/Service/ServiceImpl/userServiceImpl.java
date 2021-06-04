package life.daguo.boot.Service.ServiceImpl;

import life.daguo.boot.Dao.userMapper;
import life.daguo.boot.Pojo.user;
import life.daguo.boot.Pojo.userExample;
import life.daguo.boot.Service.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class userServiceImpl  implements userService {
    @Autowired
    userMapper userMapper;
    public List<user>  checkUser(String username, String password) {
        userExample userExample=new userExample();
        life.daguo.boot.Pojo.userExample.Criteria criteria = userExample.createCriteria();
        criteria.andUsernameEqualTo(username);
        criteria.andPasswordEqualTo(password);
        return  userMapper.selectByExample(userExample);
    }
}
