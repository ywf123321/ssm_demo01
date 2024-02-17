package com.ywf.service.impl;

import com.ywf.mapper.ProductMapper;
import com.ywf.pojo.Product;
import com.ywf.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductMapper productMapper;

    @Override
    public List<Product> getAll(String type,String label) {
        return productMapper.getAllProduct(type,label);
    }

    @Override
    public List<String> getTypes() {
        return productMapper.getTypes();
    }

    @Override
    public List<String> getLabels() {
        return productMapper.getLabels();
    }
}
