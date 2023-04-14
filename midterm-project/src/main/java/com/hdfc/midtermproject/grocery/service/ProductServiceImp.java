package com.hdfc.midtermproject.grocery.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hdfc.midtermproject.grocery.dto.ProductDTO;
import com.hdfc.midtermproject.grocery.entity.Product;
import com.hdfc.midtermproject.grocery.exception.CustomerNotFound;
import com.hdfc.midtermproject.grocery.exception.ProductNotFound;
import com.hdfc.midtermproject.grocery.repository.ProductRepo;

@Service
public class ProductServiceImp implements IProductService {

	@Autowired
	ProductRepo repo;
	@Override
	public ProductDTO insertProduct(ProductDTO p) {
		// TODO Auto-generated method stub
		  
		  return  toDTO(repo.save(toEntity(p)));
		  
		 
	}
	
	public ProductDTO updateProduct(ProductDTO p) {
			 return  toDTO(repo.save(toEntity(p)));
	}
	public String deleteProduct(long id) throws ProductNotFound {
		
		if(repo.existsById(id)) {
		repo.deleteById(id);
		return "Product Deleted";
	    }
		else{
			throw new ProductNotFound();
		}
    }
	public ProductDTO getById(long id) throws ProductNotFound {
		
		if(repo.existsById(id)) {
			return toDTO(repo.findById(id).orElse(null));
		}
		else
		{
			throw new ProductNotFound();
		}
	}
	
	
	public List<ProductDTO> findByProductName(String pname) throws ProductNotFound{
		
		List<Product> products=repo.findByProductName(pname);
		if(products.isEmpty()) {
			throw new ProductNotFound();
		}
		
		
		return products.stream().map(product->this.toDTO(product)).collect(Collectors.toList());
	}
	
    public List<ProductDTO> findByProductBrand(String bname) throws ProductNotFound{
		
		List<Product> products=repo.findByProductBrand(bname);
		if(products.isEmpty()) {
			throw new ProductNotFound();
		}
		return products.stream().map(product->this.toDTO(product)).collect(Collectors.toList());
	}
    public List<ProductDTO> findByProductCategory(String cname) throws ProductNotFound{
	
	   List<Product> products=repo.findByProductCategory(cname);
	   if(products.isEmpty()) {
		throw new ProductNotFound();
	   }
	   return products.stream().map(product->this.toDTO(product)).collect(Collectors.toList());
    }
    
    public List<ProductDTO> findAll() throws ProductNotFound{
    	
 	   List<Product> products=repo.findAll();
 	   if(products.isEmpty()) {
 		throw new ProductNotFound();
 	   }
 	   return products.stream().map(product->this.toDTO(product)).collect(Collectors.toList());
     }
    
    
    
    public Product toEntity(ProductDTO p)
    {
    	 Product product=new Product();
		  product.setProductBrand(p.getProductBrand());
		  product.setLive(p.isLive());
		  product.setProductCategory(p.getProductCategory());
		  product.setProductDescription(p.getProductDescription());
		  product.setProductImageName(p.getProductImageName());
		  product.setProductName(p.getProductName());
		  product.setProductPrice(p.getProductPrice());
		  
		  product.setStock(p.isStock());
		  return product;
    	
    }
    
    public ProductDTO toDTO(Product product) {
    	ProductDTO p=new ProductDTO();
    
          p.setProductBrand(product.getProductBrand());
		  p.setLive(product.isLive());
		  p.setProductCategory(product.getProductCategory());
		  p.setProductDescription(product.getProductDescription());
		  p.setProductImageName(product.getProductImageName());
		  p.setProductName(product.getProductName());
		  p.setProductPrice(product.getProductPrice());
		 
		  p.setStock(product.isStock());
		  return p;
    }
    
    
}
