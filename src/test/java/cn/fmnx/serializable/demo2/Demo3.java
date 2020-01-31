package cn.fmnx.serializable.demo2;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.*;
import java.util.Date;
import java.util.concurrent.TimeUnit;

@SpringBootTest
@RunWith(SpringRunner.class)
public class Demo3 {

    @Test
    public void demo() throws Exception {
        //序列化
        User user = new User("陈本布衣", "123456", 100);
        Menu menu = new Menu(1,"菜单1","/menu1");
        user.setMenu(menu);
        File directory = new File("");
        String courseFile = directory.getCanonicalPath();
        String path = courseFile+File.separator+"user2";
        try (ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(path))) {
            os.writeObject(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //先睡5秒
        TimeUnit.SECONDS.sleep(5);

        //反序列化
        try (ObjectInputStream is = new ObjectInputStream(new FileInputStream(path))) {
            User o = (User) is.readObject();
            System.out.println(o);
            System.out.println("当前时间："+new Date());
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
