package hello.dao;

import hello.dao.model.UserList;
import hello.user.controller.model.UserQuery;
import org.apache.catalina.User;

//import com.nowcoder.model.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface UserDao extends User {
    String TABLE_NAME = "user";
    String INSET_FIELDS = " name, password, salt, head_url ";
    String SELECT_FIELDS = " id, name, password, salt, head_url";

    @Select({"insert into ", TABLE_NAME, "(", INSET_FIELDS, ") values (#{name},#{password},#{salt},#{headUrl})"})
    List<UserList> queryList(UserQuery userQuery);
}
