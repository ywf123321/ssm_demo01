package com.ywf.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ywf.pojo.Product;
import com.ywf.pojo.Result;
import com.ywf.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/{pageNum}/{pageSize}")
    public Result getAll(@PathVariable int pageNum, @PathVariable int pageSize,
                         @RequestParam("type") String type, @RequestParam("label") String label){
        PageHelper.startPage(pageNum,pageSize);
        List<Product> all = productService.getAll(type,label);
        PageInfo<Product> pageInfo=new PageInfo<>(all,5);
        System.out.println(pageInfo);
        return new Result(200,pageInfo,"ok");
    }

    @GetMapping("/type")
    public Result getTypes(){
        return new Result(200,productService.getTypes(),"ok");
    }
    @GetMapping("/label")
    public Result getLabels(){
        return new Result(200,productService.getLabels(),"ok");
    }
}
