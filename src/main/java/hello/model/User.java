package hello.model;

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

    public User(Long id, String name, String account, String password, String email) {
        this.id = id;
        this.name = name;
        this.account = account;
        this.password = password;
        this.email = email;
    }
}
