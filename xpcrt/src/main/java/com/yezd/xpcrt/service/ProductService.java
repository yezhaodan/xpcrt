package com.yezd.xpcrt.service;

import com.yezd.xpcrt.dao.entity.ProductEntity;
import com.yezd.xpcrt.dto.entity.ProductDTO;
import com.yezd.xpcrt.util.ServerResponse;

public interface ProductService {
    public ServerResponse saveProduct(ProductDTO product);
    public ServerResponse deleteProduct(Integer productId);
    public ServerResponse updateProduct (ProductEntity product);
    public ServerResponse getPInfoList(Integer pageNum,Integer pageSize);
    public ServerResponse getPInfoListByNameLike(String name,Integer pageNum,Integer pageSize);
    public ServerResponse getPInfoListByType(String type,Integer pageNum,Integer pageSize);
    public ServerResponse getPInfoListByBrandLike(String brand,Integer pageNum,Integer pageSize);
    public ServerResponse getPInfoListByStock(String stock,Integer pageNum,Integer pageSize);
}
