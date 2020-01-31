package cn.fmnx.serializable.demo1;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User implements Serializable{

    private static final long serialVersionUID = -4417510930217391594L;

    private  Date date = new Date();

    private String name;

    private String password;

    private int age;

    public User(String name, String password, int age) {
        this.name = name;
        this.password = password;
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "序列化存储的时间=" + date +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", ag='" + age + '\'' +
                '}';
    }
}