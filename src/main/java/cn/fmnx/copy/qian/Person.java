package cn.fmnx.copy.qian;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person implements Cloneable{
    private int age;
    private String name;
    private Car car;
    //浅客隆

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return (Person)super.clone();
    }
}
