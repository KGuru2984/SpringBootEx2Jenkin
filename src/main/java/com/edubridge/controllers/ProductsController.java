package com.edubridge.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


import com.edubridge.models.Products;

import com.edubridge.repository.ProductsRepository;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/product")
public class ProductsController 
{
	@Autowired
	ProductsRepository productsRepo;
	
	@ResponseBody
	@GetMapping(value = {"/"},produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Products>> getAllUserInfo()
	{
		return new ResponseEntity<List<Products>>(productsRepo.findAll(),HttpStatus.OK);
		
	}
	@ResponseBody
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public ResponseEntity<Void> createProduct(@RequestBody Products prod) 
	{
		productsRepo.save(prod);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	
	@ResponseBody
	@RequestMapping(value = "/update", method = RequestMethod.PATCH)
	public ResponseEntity<Void> updateUser(@RequestBody Products prod) 
	{
		productsRepo.save(prod);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@ResponseBody
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> deleteUser(@PathVariable("id") Integer uid) 
	{
		Products prod=new Products();
		prod.setProductid(uid);
		
		productsRepo.delete(prod);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	@GetMapping(value = {"/id/{prodid}"})
	public ResponseEntity<Products> getUserById(@PathVariable("prodid") Integer pid)
	{
		return new ResponseEntity<Products>(productsRepo.findByProductid(pid),HttpStatus.OK);
	}
	
}
