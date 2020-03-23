package com.yezd.xpcrt.service.impl;

import com.yezd.xpcrt.dao.entity.ProductEntity;
import com.yezd.xpcrt.dao.repository.ProductRepository;
import com.yezd.xpcrt.dto.entity.ProductDTO;
import com.yezd.xpcrt.service.ProductService;
import com.yezd.xpcrt.util.ServerResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {
    @Resource
    private ProductRepository productRepository;

    @Override
    public ServerResponse saveProduct(ProductDTO product) {
        ProductEntity productEntity = new ProductEntity(product);
        ProductEntity productDTO = productRepository.save(productEntity);
        return ServerResponse.createBySuccess(productDTO);
    }

    @Override
    public ServerResponse deleteProduct(Integer productId) {
        productRepository.deleteById(productId);
        return ServerResponse.createBySuccessMessage("删除成功");
    }

    @Override
    public ServerResponse updateProduct(ProductEntity product) {
        product.setId(product.getId());
        ProductEntity productDTO = productRepository.saveAndFlush(product);
        return ServerResponse.createBySuccess(productDTO);
    }

    @Override
    public ServerResponse getPInfoList(Integer pageNum,Integer pageSize) {
        Pageable pageable = PageRequest.of(pageNum, pageSize, Sort.by("id"));
        Page<ProductEntity> productList = productRepository.findAll(pageable);
        return ServerResponse.createBySuccess(productList);
    }

    @Override
    public ServerResponse getPInfoListByNameLike(String name,Integer pageNum,Integer pageSize) {
        Pageable pageable = PageRequest.of(pageNum, pageSize, Sort.by("id"));
        Page<ProductEntity> productList = productRepository.findByNameLike(name,pageable);
        return ServerResponse.createBySuccess(productList);
    }

    @Override
    public ServerResponse getPInfoListByType(String type,Integer pageNum,Integer pageSize) {
        Pageable pageable = PageRequest.of(pageNum, pageSize, Sort.by("id"));
        Page<ProductEntity> productList = productRepository.findByType(type,pageable);
        return ServerResponse.createBySuccess(productList);
    }

    @Override
    public ServerResponse getPInfoListByBrandLike(String brand,Integer pageNum,Integer pageSize) {

        Pageable pageable = PageRequest.of(pageNum, pageSize, Sort.by("id"));
        Page<ProductEntity> productList = productRepository.findByBrandLike(brand,pageable);
        return ServerResponse.createBySuccess(productList);
    }

    @Override
    public ServerResponse getPInfoListByStock(String stock,Integer pageNum,Integer pageSize) {
        Pageable pageable = PageRequest.of(pageNum, pageSize, Sort.by("id"));
        Page<ProductEntity> productList = productRepository.findByStock(stock,pageable);
        return ServerResponse.createBySuccess(productList);
    }
}
