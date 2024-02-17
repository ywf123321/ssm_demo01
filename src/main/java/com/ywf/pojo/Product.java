package com.ywf.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Product {
    private int id;
    private String pName;
    private int price;
    private String type;
    private String label;
    public Product(Integer id) {
        this.id=id;
    }
}
