package com.ywf.mapper;

import com.ywf.pojo.Product;
import org.apache.ibatis.annotations.Param;


import java.util.List;


public interface ProductMapper {

    List<Product> getAllProduct(@Param("type") String type,@Param("label") String label);
    List<String> getTypes();
    List<String> getLabels();
}
