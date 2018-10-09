package hello.dao;

//import com.baomidou.mybatisplus.mapper.BaseMapper;
import hello.dao.model.UserList;
import hello.user.controller.model.UserQuery;
import org.apache.catalina.User;

import java.util.List;

public interface UserDao extends User {

    List<UserList> queryList(UserQuery userQuery);
}
