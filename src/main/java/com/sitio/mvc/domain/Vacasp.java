package com.sitio.mvc.domain;

import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@SuppressWarnings("serial")
@Entity
@Table(name = "VACASP")
public class Vacasp extends AbstractEntity<Long> {

	@NotBlank(message = "Informe um nome.")
	@Size(min = 3, max = 60, message = "O nome do vaca deve ter entre {min} e {max} caracteres.")
	@Column(name = "nome", nullable = false, unique = true, length = 60)
	private String nome;
	
	@OneToMany(mappedBy = "vacasp")
	private List<Gado> gado;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Gado> getGado() {
		return gado;
	}

	public void setGado(List<Gado> gado) {
		this.gado = gado;
	}
}
