package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.entities.Category;
import com.example.demo.entities.Product;
import com.example.demo.repositories.CategoryRepository;
import com.example.demo.repositories.ProductRepository;

@Controller
public class ProductController {
	
	@Autowired
	private ProductRepository repo;
	
	@Autowired
	private CategoryRepository categoryRepo;
	
	@GetMapping("/products/new")
	public String showNewProductForm(Model model) {
		List<Category> listCategories = categoryRepo.findAll();
		model.addAttribute("product", new Product());
		model.addAttribute("listCategories", listCategories);
		
		return "product_form";
	}

	@PostMapping("/product/save")
	public String saveProduct(Product product) {
		repo.save(product);
		return "redirect:/products";
	}
	
	@GetMapping("/products")
	public String getProducts(Model model) {
		List<Product> listProducts = repo.findAll();
		model.addAttribute("listProducts",listProducts);
		return "products";
	}
}
