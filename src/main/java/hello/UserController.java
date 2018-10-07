package hello;

import org.json.JSONException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@RestController
public class UserController {
    @GetMapping("/users")
    public String userList(HttpServletRequest request, HttpServletResponse response) throws JSONException, IOException {

        return "";
    }

}
