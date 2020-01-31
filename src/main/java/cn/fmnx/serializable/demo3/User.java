package cn.fmnx.serializable.demo3;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.beans.Transient;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User implements Serializable {
    private static final long serialVersionUID = -3905781699541159743L;
    private Date date = new Date();

    private String name;

    private transient String password;
    private List<Menu> menus;
    private int age;

    public User(String name, String password, int age) {
        this.name = name;
        this.password = password;
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "date=" + date +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", menu=" + menus +
                ", age=" + age +
                '}';
    }
}
