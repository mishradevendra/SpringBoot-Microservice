package com.odr.newsoft.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.odr.newsoft.model.Product;
import com.odr.newsoft.repository.ProductRepository;

@RestController
@RequestMapping("/")
public class ProductController {
	@Autowired
	private ProductRepository productRepository;

	@PostMapping("product")
	public Product saveProduct(@RequestBody Product product) {
		return productRepository.save(product);
	}

	@GetMapping("product")
	public List<Product> getProduct() {
		return productRepository.findAll();
	}

	@GetMapping("product/{id}")
	public Optional<Product> getProductById(@PathVariable Integer id) {
		return productRepository.findById(id);
	}

	@DeleteMapping("product/{id}")
	public String deleteById(@PathVariable Integer id) {
		productRepository.deleteById(id);
		return "Record deleted id " + id;

	}

}
