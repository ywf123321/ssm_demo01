package com.ywf.service;

import com.ywf.pojo.Product;

import java.util.List;

public interface ProductService {
    List<Product> getAll(String type,String label);

    List<String> getTypes();
    List<String> getLabels();
}
