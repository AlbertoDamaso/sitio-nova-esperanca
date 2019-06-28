package com.sitio.mvc.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@SuppressWarnings("serial")
@Entity
@Table(name = "GADO")
public class Gado extends AbstractEntity<Long> {

	@NotBlank(message = "O nome do gado é obrigatório.")
	@Size(max = 60, message = "O nome do gado deve conter no máximo 60 caracteres.")
	@Column(name = "nome", nullable = false, unique = true, length = 60)
	private String nome;
	
	@NotNull(message = "Selecione o vacasp relativo ao gado.")
	@ManyToOne
	@JoinColumn(name = "id_vacasp_fk")
	private Vacasp vacasp;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Vacasp getVacasp() {
		return vacasp;
	}

	public void setVacasp(Vacasp vacasp) {
		this.vacasp = vacasp;
	}

}
