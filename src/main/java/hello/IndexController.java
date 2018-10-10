package hello;

import com.google.gson.Gson;
import hello.dao.model.ConnectionPool;
import hello.dao.model.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.json.*;

import javax.servlet.http.HttpServletRequest;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

@RestController
public class IndexController {
    @GetMapping("/")
    public String index(String username, String password) throws Exception {
/*
 ①　ConnectionPool connPool
                = new ConnectionPool("com.microsoft.jdbc.sqlserver.SQLServerDriver"
                ,"jdbc:microsoft:sqlserver://localhost:1433;DatabaseName=MyDataForTest"
                ,"Username"
                ,"Password");
 ②　connPool .createPool();
        Connection conn = connPool .getConnection();
        connPool.returnConnection(conn);
        connPool.refreshConnections();
        connPool.closeConnectionPool();
*/
        ConnectionPool connPool = new ConnectionPool(
                "com.mysql.jdbc.Driver",
                "jdbc:mysql://localhost:3306/java",
                "wells",
                "991005214");
        connPool.setMaxConnections(10);
        connPool.setTestTable("users");
        connPool.createPool();
        Connection conn = connPool.getConnection();

        Statement stmt = conn.createStatement();
        String sql = "SELECT id, name, email FROM users";
        ResultSet rs = stmt.executeQuery(sql);
        while (rs.next()) {
            // 通过字段检索
            int id = rs.getInt("id");
            String name = rs.getString("name");
            String email = rs.getString("email");

            // 输出数据
            System.out.print("ID: " + id);
            System.out.print(", 姓名: " + name);
            System.out.print(", Email: " + email);
            System.out.print("\n");
        }
        connPool.returnConnection(conn);
        connPool.refreshConnections();
        connPool.closeConnectionPool();


        User user = new User((long) 2, "姓名",
                "18513362609", "newaccount",
                "12345", "Email@163.com");
        Gson gson = new Gson();
        String str = gson.toJson(user);
        System.out.println(str);

        /*
        Person person = new Person("栗霖", 18);
        Gson gson = new GsonBuilder().create();
        Map<String, Person[]> map = new HashMap<>();
        Person[] list = {person};
        map.put("data", list);
        System.out.println(map);
        Response response = new Response(200, map, "请求成功");
        String str = gson.toJson(response);
        System.out.println(str);
        */
        /*
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
        */
        return str;
    }

    @PostMapping(value = "/", produces = "text/html;charset=utf-8")
    public JSONObject postIndex(HttpServletRequest request) throws JSONException {
        RestUtils restUtils = new RestUtils();
        String requestJson = restUtils.getBodyData(request);
        System.out.println(requestJson);
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
