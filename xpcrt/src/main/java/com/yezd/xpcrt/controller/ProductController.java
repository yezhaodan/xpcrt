package com.yezd.xpcrt.controller;

import com.yezd.xpcrt.dao.entity.ProductEntity;
import com.yezd.xpcrt.dto.entity.ProductDTO;
import com.yezd.xpcrt.service.ProductService;
import com.yezd.xpcrt.util.ServerResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.math.BigDecimal;

@RestController
public class ProductController {

    @Autowired
    ProductService productService;

    @RequestMapping("/productManager/addproduct")
    public ServerResponse saveProduct(
            @RequestParam(value = "name") String name,
            @RequestParam(value = "type") String type,
            @RequestParam(value = "capacity") String capacity,
            @RequestParam(value = "stock") String stock,
            @RequestParam(value = "brand") String brand,
            @RequestParam(value = "facevalue") BigDecimal facevalue,
            @RequestParam(value = "retailprice") BigDecimal retailprice,
            @RequestParam(value = "purchaseprice") BigDecimal purchaseprice,
            @RequestParam(value = "discount") String discount){
        ProductDTO product = new ProductDTO(name,type,capacity,brand,stock,facevalue,
                retailprice,purchaseprice,discount);
        return productService.saveProduct(product);
    }

    @RequestMapping("/productManager/deleteProduct")
    public ServerResponse deleteProduct(
            @RequestParam(value = "productId") Integer productId){
        return productService.deleteProduct(productId);
    }

    @RequestMapping("/productManager/updateProduct")
    public ServerResponse updateProduct (
            @RequestBody ProductEntity product){
        return productService.updateProduct(product);
    }

    @RequestMapping("/productManager/getPInfoList")
    public ServerResponse getPInfoList(
            @RequestParam(value = "pageNum") Integer pageNum,
            @RequestParam(value = "pageSize") Integer pageSize){
        return productService.getPInfoList(pageNum,pageSize);
    }

    @RequestMapping("/productManager/getPInfoListByName")
    public ServerResponse getPInfoListByNameLike(
            @RequestParam(value = "name") String name,
            @RequestParam(value = "pageNum") Integer pageNum,
            @RequestParam(value = "pageSize") Integer pageSize){
        return productService.getPInfoListByNameLike(name,pageNum,pageSize);
    }

    @RequestMapping("/productManager/getPInfoListByType")
    public ServerResponse getPInfoListByType(
            @RequestParam(value = "type") String type,
            @RequestParam(value = "pageNum") Integer pageNum,
            @RequestParam(value = "pageSize") Integer pageSize){
        return productService.getPInfoListByType(type,pageNum,pageSize);
    }

    @RequestMapping("/productManager/getPInfoListByBrand")
    public ServerResponse getPInfoListByBrandLike(
            @RequestParam(value = "brand") String brand,
            @RequestParam(value = "pageNum") Integer pageNum,
            @RequestParam(value = "pageSize") Integer pageSize) {
        return productService.getPInfoListByBrandLike(brand, pageNum, pageSize);
    }

    @RequestMapping("/productManager/getPInfoListByStock")
    public ServerResponse getPInfoListByStock(@RequestParam(value = "stock") String stock,
                                              @RequestParam(value = "pageNum") Integer pageNum,
                                              @RequestParam(value = "pageSize") Integer pageSize) {
        return productService.getPInfoListByStock(stock, pageNum, pageSize);
    }

}
