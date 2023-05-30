package com.company.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.company.dto.ProductDTO;
import com.company.services.ProductService;

@RestController
@RequestMapping("/product/v1")
public class ProductController {

	@Autowired
	ProductService service;

	@PostMapping(path = "/", consumes = { MediaType.APPLICATION_JSON_VALUE }, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ProductDTO> insert(@RequestBody ProductDTO dto) {
		return ResponseEntity.ok().body(service.insert(dto));
	}
}
