package org.fundacionview.SGSST.modelos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tbl_salarios_minimos", schema="")
public class SalariosMinimos {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer secuencia;
	
	@Column(length=4, nullable=false ,unique=true)
	private Integer anho;
	
	@Column(length=12, nullable=false)
	private Double valor;

	public SalariosMinimos() {
		super();
	}

	public SalariosMinimos(Integer anho, Double valor) {
		super();
		this.anho = anho;
		this.valor = valor;
	}
	
	public Integer getSecuencia() {
		return secuencia;
	}
	public void setSecuencia(Integer secuencia) {
		this.secuencia = secuencia;
	}

	public Integer getAnho() {
		return anho;
	}
	public void setAnho(Integer anho) {
		this.anho = anho;
	}

	public Double getValor() {
		return valor;
	}
	public void setValor(Double valor) {
		this.valor = valor;
	}

	@Override
	public String toString() {
		return "SalariosMinimos [secuencia=" + secuencia + ", anho=" + anho + ", valor=" + valor + "]";
	}

}