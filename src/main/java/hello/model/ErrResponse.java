package hello.model;

import java.util.Map;

public class ErrResponse extends Response {
    public ErrResponse(int code, Map data, String msg) {
        super(code, data, msg);

    }
}
