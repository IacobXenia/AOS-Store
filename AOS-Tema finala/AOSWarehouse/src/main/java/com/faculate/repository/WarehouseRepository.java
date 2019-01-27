package com.faculate.repository;
import org.springframework.data.repository.CrudRepository;

import com.faculate.product.Product;

public interface WarehouseRepository extends CrudRepository<Product,Integer>  {
Product findByID(long id);
}
