package cn.fmnx.copy.serializable;

public class Demo {
    public static void main(String[] args) {
        Car car=new Car(100, "宝马");
        Person p1 = new Person(30, "张三", car);
        Person p2 = p1.copy();
        System.out.println(p1==p2);
        System.out.println(p1.getCar()==p2.getCar());


    }
}
