package com.springboot.springboot_first_app.controller;

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

import com.springboot.springboot_first_app.entity.Product;
import com.springboot.springboot_first_app.repo.ProductRepo;


@RestController
@RequestMapping("/product")
public class ProductEntryController {
	
	@Autowired
	ProductRepo repo;
	
	//private Map<Long ,Product> products = new HashMap<>();
	
	@GetMapping
	public List<Product> getAll(){
		return repo.findAll();
		//return new ArrayList<>(products.values());
	}
	
	@PostMapping
	public boolean createEntry(@RequestBody Product myEntry) {
		repo.save(myEntry);
		//products.put(myEntry.getId(), myEntry);
		return true;
	}
	
	@GetMapping("id/{myId}")
	public Product getProductById(@PathVariable int myId) {
		return repo.findById(myId).orElse(new Product());
		//return products.get(myId);
	}
	
	@DeleteMapping("id/{myId}")
	public boolean deleteProductById(@PathVariable int myId) {
		repo.deleteById(myId);
		// products.remove(myId);
		return true;
	}
	
	@PutMapping("id/{myId}")
	public Product updateProductById(@PathVariable int myId, @RequestBody Product myEntry) {
		repo.save(myEntry);
		return repo.findById(myId).orElse(new Product());
		//return products.put(myId,myEntry);
	}
}
