package com.sitio.mvc.domain;

import java.time.LocalDate;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.*;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

@SuppressWarnings("serial")
@Entity
@Table(name = "PESSOA")
public class Pessoa extends AbstractEntity<Long> {

	@NotBlank
	@Size(max = 255, min = 3)
	@Column(nullable = false, unique = true)
	private String nome;
	
	@NotBlank
	@Size(max = 255, min = 3)
	@Column(nullable = false,unique = true)
	private String email;
	
	@NotBlank
	@Size(max = 14, min = 11)
	@Column(nullable = false, unique = true)
	private String cpf;
	
	@NotNull
	@DateTimeFormat(iso = ISO.DATE, pattern = "")
	@Column(name= "data_nasc", nullable = false, columnDefinition = "DATE")
	private LocalDate dataEntrada;
	
	@Valid
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "endereco_id_fk")
	private Endereco endereco;
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public LocalDate getDataEntrada() {
		return dataEntrada;
	}

	public void setDataEntrada(LocalDate dataEntrada) {
		this.dataEntrada = dataEntrada;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	

}
