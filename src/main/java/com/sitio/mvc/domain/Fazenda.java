package com.sitio.mvc.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "fazenda")
public class Fazenda extends AbstractEntity<Long> {

	@Column(name = "fazcnpj", nullable = false, length = 14)
	private String cnpj;
	
	@Column(name = "faznom", nullable = false, length = 60)
	private String nome;
	
	@Column(name = "fazloc", nullable = true, length = 100)
	private String local;
	
	@Column(name = "fazmod", nullable = true, length = 100)
	private String modif;
	
	@Column(name = "fazstatus", nullable = true, length = 20)
	private String status;


	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getLocal() {
		return local;
	}

	public void setLocal(String local) {
		this.local = local;
	}

	public String getModif() {
		return modif;
	}

	public void setModif(String modif) {
		this.modif = modif;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	
}
