package com.yezd.xpcrt.dao.repository;

import com.yezd.xpcrt.dao.entity.ProductEntity;
import com.yezd.xpcrt.dto.entity.BrandDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository extends JpaRepository<ProductEntity, String> {

    @Query(value = "select t from ProductEntity t where t.name like %?1%")
    Page<ProductEntity> findByNameLike(String name, Pageable pageable);

    Page<ProductEntity> findByType(String type, Pageable pageable);

    @Query(value = "select t from ProductEntity t where t.brand like %?1%")
    Page<ProductEntity> findByBrandLike(String brand, Pageable pageable);

    Page<ProductEntity> findByStock(String stock, Pageable pageable);

    void deleteById(Integer productId);
}
