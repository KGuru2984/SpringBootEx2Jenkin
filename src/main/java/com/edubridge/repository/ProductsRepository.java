package com.edubridge.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.edubridge.models.Products;

public interface ProductsRepository extends JpaRepository<Products, Integer>
{
	Products findByProductid(Integer productid);
}
