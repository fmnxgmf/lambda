package cn.fmnx.serializable.demo1;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.ResourceUtils;

import java.io.*;
import java.net.URL;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * 序列化反序列化
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class Demo1Test {
    /**
     * 基本步骤：
     * ① 对象实体类实现Serializable 标记接口
     * ② 创建序列化输出流对象ObjectOutputStream，该对象的创建依赖于其它输出流对象，通常我们将对象序列化为文件存储，所以这里用文件相关的输出流对象 FileOutputStream
     * ③ 通过ObjectOutputStream 的 writeObject()方法将对象序列化为文件
     * ④ 关闭流 这里采用1.7开始的新语法  try-with-resources  而不用自己控制流的关闭
     */
    @Test
    public void demo() throws Exception {
        User user = new User.UserBuilder()
                .name("出租车")
                .age(20)
                .password("123456")
                .date(new Date())
                .build();
//        User user = new User("出租车","123456",20);
        File directory = new File("");
        String courseFile = directory.getCanonicalPath();
        try(ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(courseFile+""+File.separator+"user"))) {
           os.writeObject(user);
        }catch (Exception e){
            e.printStackTrace();
        }
        //睡眠
        TimeUnit.SECONDS.sleep(5);
        /**
         * 基本步骤：
         * ① 创建输入流对象ObjectOutputStream。同样依赖于其它输入流对象，这里是文件输入流 FileInputStream
         * ② 通过 ObjectInputStream 的 readObject()方法，将文件中的对象读取到内存
         * ③ 关闭流 同上
         */
        try {
            ObjectInputStream is = new ObjectInputStream(new FileInputStream(courseFile+""+File.separator+"user"));
            User o = (User)is.readObject();
            System.out.println("user = " + o);
            System.out.println("当前时间"+new Date());
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    public void pathDemo() throws IOException {
        // 第一种：获取类加载的根路径  E:\IDEA_workplace\lambda\target\test-classes
        File f = new File(this.getClass().getResource("/").getPath());
        System.out.println(f);

        // 获取当前类的所在工程路径; 如果不加“/” 获取当前类的加载目录  E:\IDEA_workplace\lambda\target\test-classes\cn\fmnx\serializable\demo1
        File f2 = new File(this.getClass().getResource("").getPath());
        System.out.println(f2);

        // 第二种：获取项目路径    E:\IDEA_workplace\lambda
        File directory = new File("");// 参数为空
        String courseFile = directory.getCanonicalPath();
        System.out.println(courseFile);

        // 第三种：  file:/E:/IDEA_workplace/lambda/target/test-classes/
        URL xmlpath = this.getClass().getClassLoader().getResource("");
        System.out.println(xmlpath);

        // 第四种： 获取当前工程路径 D:\IDEAWorkspace\hs-bluetooth-lock
        System.out.println(System.getProperty("user.dir"));

        // 第五种：  获取所有的类路径 包括jar包的路径
        System.out.println(System.getProperty("java.class.path"));

        String jar_parent = new File(ResourceUtils.getURL("classpath:").getPath())
                .getParentFile()
                .getParentFile()
                .getParent();
        System.out.println("jar_parent = " + jar_parent);
    }

}
