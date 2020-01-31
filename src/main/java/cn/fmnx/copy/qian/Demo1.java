package cn.fmnx.copy.qian;

public class Demo1 {
    public static void main(String[] args) throws Exception {
        Car car = new Car(100,"宝马");
        Person p1 = new Person(30, "张三", car);
        Person p2 = (Person)p1.clone();
        System.out.println(p1==p2);
        System.out.println(p1.getCar()==p2.getCar());
        p1.setName("李四");
        System.out.println("p1 name:"+p1.getName());
        System.out.println("p2 name:"+p2.getName());
    }
}
