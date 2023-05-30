package com.company.dto;

import java.util.ArrayList;
import java.util.List;

import com.company.entities.Client;
import com.company.entities.Product;
import com.company.utils.ConversibleContract;

public class ProductDTO implements ConversibleContract<Product> {
	public Long id;

	public String name;
	public Double price;
	public String description;
	public List<Client> client = new ArrayList<>();

	public ProductDTO() {
	}

	public ProductDTO(Product entity) {
		this.id = entity.getId();
		this.name = entity.getName();
		this.description = entity.getDescription();
		this.price = entity.getPrice();
		this.client = entity.getClient();
	}

	public List<Client> getClient() {
		return client;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public Product fromConvert() {
		return new Product(this);
	}

	@Override
	public String toString() {
		return "ProductDTO [id=" + id + ", name=" + name + ", price=" + price + ", description=" + description
				+ ", client=" + client + "]";
	}

}
