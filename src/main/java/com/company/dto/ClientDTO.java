package com.company.dto;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.company.entities.Client;
import com.company.entities.Product;
import com.company.utils.ConversibleContract;
import com.company.utils.Gender;

public class ClientDTO implements ConversibleContract<Client> {

	public Long id;
	public String email;
	public Gender gender;
	public String name;
	private String password;
	private String cpf;
	private Double balance;
	public LocalDateTime dateRegister;
	public List<Product> productList = new ArrayList<>();

	public ClientDTO() {
	}

	public ClientDTO(Client client) {
		this.email = client.getEmail();
		this.name = client.getName();
		this.cpf = client.getCpf();
		this.id = client.getId();
		this.balance = client.getBalance();
		this.gender = client.getGender();
		this.password = client.getPassword();
		this.dateRegister = client.getDateRegister();
		this.productList = client.getProduct_list();
	}

	public ClientDTO(Long id, String email, Gender gender, String name, String password, String cpf, Double balance,
			LocalDateTime dateRegister, List<Product> productList) {
		this.id = id;
		this.email = email;
		this.gender = gender;
		this.name = name;
		this.password = password;
		this.cpf = cpf;
		this.balance = balance;
		this.dateRegister = dateRegister;
		this.productList = productList;
	}

	public List<Product> getProductList() {
		return productList;
	}

	public LocalDateTime getDateRegister() {
		return dateRegister;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	@Override
	public Client fromConvert() {
		return new Client(this);
	}

	@Override
	public int hashCode() {
		return Objects.hash(balance, cpf, dateRegister, email, gender, id, name, password);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ClientDTO other = (ClientDTO) obj;
		return Objects.equals(balance, other.balance) && Objects.equals(cpf, other.cpf)
				&& Objects.equals(dateRegister, other.dateRegister) && Objects.equals(email, other.email)
				&& gender == other.gender && Objects.equals(id, other.id) && Objects.equals(name, other.name)
				&& Objects.equals(password, other.password);
	}

	@Override
	public String toString() {
		return "ClientDTO [id=" + id + ", email=" + email + ", gender=" + gender + ", name=" + name + ", password="
				+ password + ", cpf=" + cpf + ", balance=" + balance + ", dateRegister=" + dateRegister
				+ ", productList=" + productList + "]";
	}

}
