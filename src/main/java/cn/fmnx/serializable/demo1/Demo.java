package cn.fmnx.serializable.demo1;

public class Demo {
    public static void main(String[] args) {
        User user = new User.UserBuilder()
                .name("出租车")
                .age(20)
                .password("123456")
                .build();
    }
}
