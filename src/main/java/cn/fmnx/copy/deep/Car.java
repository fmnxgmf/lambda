package cn.fmnx.copy.deep;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Car implements Cloneable{
    private int price;
    private String name;

    @Override
    protected Car clone() throws CloneNotSupportedException {
        return (Car)super.clone();
    }
}
