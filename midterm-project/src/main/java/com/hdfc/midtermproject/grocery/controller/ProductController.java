package com.hdfc.midtermproject.grocery.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hdfc.midtermproject.grocery.dto.ProductDTO;
import com.hdfc.midtermproject.grocery.entity.Product;
import com.hdfc.midtermproject.grocery.exception.ProductNotFound;
import com.hdfc.midtermproject.grocery.service.IProductService;

@RestController
@RequestMapping("/product")
public class ProductController {

	@Autowired
	IProductService service;
	
	@PostMapping("/admin/insert")
	public ProductDTO createProduct(@RequestBody ProductDTO productdto)
	{
		return service.insertProduct(productdto) ;
	}
	
	@PutMapping("/admin/update")
	public ProductDTO updateProduct(@RequestBody ProductDTO productdto)
	{
		return service.updateProduct(productdto);
	}
	@GetMapping("/admin/getbyid/{id}")
	public ProductDTO getById(@PathVariable long id) throws ProductNotFound {
		return service.getById(id);
	}
	@DeleteMapping("/admin/delete/{id}")
	public String deleteProduct(@PathVariable long id) throws ProductNotFound
	{
		return service.deleteProduct(id);
		
	}
	@GetMapping("/public/getbyname/{pname}")
	public List<ProductDTO> getByName(@PathVariable String pname) throws ProductNotFound{
		
		return service.findByProductName(pname);
	}
	
	@GetMapping("/public/getbybrand/{bname}")
    public List<ProductDTO> getByBrand(@PathVariable String bname) throws ProductNotFound{
		
		return service.findByProductBrand(bname);
	}
	
	@GetMapping("/public/getbycategory/{cname}")
    public List<ProductDTO> getByCategory(@PathVariable String cname) throws ProductNotFound{
		
		return service.findByProductCategory(cname);
	}
	
	@GetMapping("/user/getall")
	public List<ProductDTO> getAll() throws ProductNotFound{
		return service.findAll();
	}
}
