package cn.fmnx.copy.deep;

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
    protected Person clone() throws CloneNotSupportedException {
        Person p=(Person)super.clone();
        p.car = (Car) this.car.clone();
        return p;
    }
}
