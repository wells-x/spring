package hello;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;


import org.json.*;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@RestController
public class HelloController {
    @GetMapping("/")
    public String index(String username, String password) {
        System.out.println("Success");
        System.out.println(username);
        System.out.println(password);
        return "Greetings from Spring Boot!";
    }

    @PostMapping(value = "/", produces = "text/html;charset=utf-8")
    public String postIndex(HttpServletRequest request) throws JSONException, IOException {
        RestUtils restUtils = new RestUtils();
        String s = restUtils.getBodyData(request);
        System.out.println(s);

        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.setContentType(MediaType.valueOf("text/plain;charset='utf-8'"));
        String username = request.getParameter("data");
        String password = request.getParameter("password");
        System.out.println("username is:" + username);
        System.out.println("password is:" + password);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("code", 200);
        jsonObject.put("data", null);
        return s;
    }
}
