package hello.dao.model;

import java.util.Map;

public class Response {
    private int code;
    private Map data;
    private String msg;

    public Response(int code, Map data, String msg) {
        this.code = code;
        this.data = data;
        this.msg = msg;
    }
}
