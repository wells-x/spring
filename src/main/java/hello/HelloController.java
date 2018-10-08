package hello;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;


import org.json.*;

import javax.servlet.http.HttpServletRequest;

@RestController
public class HelloController {
    @GetMapping("/")
    public String index(String username, String password) throws JSONException {
//        HttpHeaders responseHeaders = new HttpHeaders();
//        responseHeaders.setContentType(MediaType.valueOf("text/plain;charset='utf-8'"));
        System.out.println("Success");
//        System.out.println(username);
//        System.out.println(password);
        JSONObject jsonObject = new JSONObject(),
                data = new JSONObject();
        JSONArray jsonArray = new JSONArray();
        jsonArray.put("1");
        data.put("list", jsonArray);
        int len = jsonArray.length();
        data.put("length", len);

        jsonObject.put("code", 200);
        jsonObject.put("data", data);
        jsonObject.put("msg", len > 0 ? "请求成功" : "值为空");
        return jsonObject.toString();
//        return "Greetings from Spring Boot!";
    }

    @PostMapping(value = "/", produces = "text/html;charset=utf-8")
    public JSONObject postIndex(HttpServletRequest request) throws JSONException {
        RestUtils restUtils = new RestUtils();
        String requestJson = restUtils.getBodyData(request);
        System.out.println(requestJson);

//        HttpHeaders responseHeaders = new HttpHeaders();
//        responseHeaders.setContentType(MediaType.valueOf("text/plain;charset='utf-8'"));
        String username = request.getParameter("data");
        String password = request.getParameter("password");
        System.out.println("username is:" + username);
        System.out.println("password is:" + password);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("code", 200);
        jsonObject.put("data", null);
        jsonObject.put("msg", "值为空");
        return jsonObject;
    }
}
