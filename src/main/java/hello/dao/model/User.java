package hello.dao.model;

public class User {
    /**
     * 用户id
     */
    private Long id;
    /**
     * 昵称
     */
    private String name;
    /**
     * 手机号
     */
    private String phone;
    /**
     * 账户
     */
    private String account;
    /**
     * 密码
     */
    private String password;
    /**
     * 邮箱
     */
    private String email;

    public User(Long id, String name, String phone, String account, String password, String email) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.account = account;
        this.password = password;
        this.email = email;
    }
}
