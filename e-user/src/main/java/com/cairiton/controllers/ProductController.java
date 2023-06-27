package com.cairiton.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.cairiton.model.Product;
import com.cairiton.repository.ProductRepository;

@RestController
@RequestMapping("/products")
@CrossOrigin(origins = "http://localhost:4200")
public class ProductController {
	
	
	@Autowired
	private ProductRepository productRepository;
	
	
	@GetMapping
	public List<Product> getAll() {	
		return productRepository.findAll();
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Product saveProduct(@Valid @RequestBody Product product) {
		return productRepository.save(product);
		
	}
	
	
	@GetMapping("/{productId}")
	public ResponseEntity<Product> getById(@PathVariable Long productId) {
		return productRepository.findById(productId)			
				.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
	}
	
	@PutMapping("/{productId}")
	public ResponseEntity<Product> update(@PathVariable Long productId,@Valid @RequestBody Product product){
		
		if (!productRepository.existsById(productId)) {
			return ResponseEntity.notFound().build();
		}
		product.setId(productId);
		product = productRepository.save(product);
		
		
		return ResponseEntity.ok(product);
	}
	
	@DeleteMapping("/{productId}")
	public ResponseEntity<Void> remover(@PathVariable Long productId){
		
		if (!productRepository.existsById(productId)) {
			return ResponseEntity.notFound().build();
		}
		productRepository.deleteById(productId);
		//catalogoClienteService.excluir(clienteId);
		
		return ResponseEntity.noContent().build();
		}
	

	
}
