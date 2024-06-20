package com.edubridge.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="ProductCatalog")
public class Products 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer productid;
	private String name;
	private String price;
	public Integer getProductid() {
		return productid;
	}
	public void setProductid(Integer productid) {
		this.productid = productid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public Products(String name, String price) {
		super();
		this.name = name;
		this.price = price;
	}
	public Products() {
		super();
	}
	@Override
	public String toString() {
		return "Products [productid=" + productid + ", name=" + name + ", price=" + price + "]";
	}
	
}
