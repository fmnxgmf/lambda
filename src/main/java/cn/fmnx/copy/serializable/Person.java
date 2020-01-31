package cn.fmnx.copy.serializable;

import lombok.Data;

import java.io.*;
@Data
public class Person implements Serializable {

    private static final long serialVersionUID = -1135670184306049756L;
    private int age;
    private String name;
    private Car car;

    public Person(int age, String name, Car car) {
        this.age = age;
        this.name = name;
        this.car = car;
    }
    //通过序列化反序列化实现深度克隆
    public Person copy() {
        ByteArrayOutputStream bos = null;
        ObjectOutputStream oos = null;
        ByteArrayInputStream bis = null;
        ObjectInputStream ois = null;
        try {
            //序列化
            bos = new ByteArrayOutputStream();
            oos = new ObjectOutputStream(bos);
            oos.writeObject(this);

            //反序列化
            bis = new ByteArrayInputStream(bos.toByteArray());
            ois = new ObjectInputStream(bis);
            Person pp =(Person)ois.readObject();
            return pp;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }finally {
            try {
                bos.close();
                bis.close();
                oos.close();
                ois.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}
