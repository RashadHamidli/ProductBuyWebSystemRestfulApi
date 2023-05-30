package com.company.entities;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.company.dto.ClientDTO;
import com.company.utils.ConversibleContract;
import com.company.utils.Gender;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
public class Client implements Serializable, ConversibleContract<ClientDTO> {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long id;

	@Column(nullable = false, unique = true, length = 50)
	public String email;

	@Column(nullable = false, unique = false, length = 1)
	public Gender gender;

	@Column(nullable = false, unique = false, length = 100)
	public String name;

	@Column(nullable = false, unique = false, length = 100)
	private String password;

	@Column(nullable = true, unique = true, length = 14)
	private String cpf;

	@Column(nullable = false, unique = false)
	private Double balance;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable = false, unique = false)
	public LocalDateTime dateRegister = LocalDateTime.now();

	@JsonIgnore
	@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.REMOVE}, fetch = FetchType.LAZY)
	@JoinTable(name = "product_client", joinColumns = @JoinColumn(name = "client_id"), inverseJoinColumns = @JoinColumn(name = "product_id"))
	public List<Product> productList = new ArrayList<>();

	public Client() {
	}

	public Client(ClientDTO dto) {
		this.email = dto.getEmail();
		this.name = dto.getName();
		this.cpf = dto.getCpf();
		this.id = dto.getId();
		this.balance = dto.getBalance();
		this.gender = dto.getGender();
		this.password = dto.getPassword();
		this.productList = dto.getProductList();
	}

	public LocalDateTime getDateRegister() {
		return dateRegister;
	}

	public List<Product> getProduct_list() {
		return productList;
	}

	public void setDateRegister(LocalDateTime dateRegister) {
		this.dateRegister = dateRegister;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Product> getProductList() {
		return productList;
	}

	public void setProductList(List<Product> productList) {
		this.productList = productList;
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
	public int hashCode() {
		return Objects.hash(cpf, email, id, password);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Client other = (Client) obj;
		return Objects.equals(cpf, other.cpf) && Objects.equals(email, other.email) && Objects.equals(id, other.id)
				&& Objects.equals(password, other.password);
	}

	@Override
	public String toString() {
		return "Client [id=" + id + ", email=" + email + ", password=" + password + ", cpf=" + cpf + "]";
	}

	@Override
	public ClientDTO fromConvert() {
		return new ClientDTO(this);
	}

}
