package cn.fmnx.copy.serializable;

import lombok.Data;

import java.io.Serializable;
@Data
public class Car implements Serializable {
    private static final long serialVersionUID = 3244451791127044900L;
    private int price;
    private String name;
    public Car(int price, String name) {
        super();
        this.price = price;
        this.name = name;
    }

}
