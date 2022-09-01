package org.fundacionview.SGSST.modelos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tbl_diagnosticos_cie10", schema="")
public class Diagnosticos {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(length=10, nullable=false)
	private String codigo;
	
	@Column(length=255, nullable=false)
	private String diagnostico;
	
	@Column(length=255, nullable=false)
	private String grupo_dx;
	
	@Column(length=50, nullable=false)
	private String seg_osteomuscular;
	
	@Column(length=100, nullable=false)
	private String origen;
	
	public Diagnosticos()
	{
		super();
	}

	public Diagnosticos(String codigo, String diagnostico, String grupo_dx, String seg_osteomuscular, String origen) {
		super();
		this.codigo = codigo;
		this.diagnostico = diagnostico;
		this.grupo_dx = grupo_dx;
		this.seg_osteomuscular = seg_osteomuscular;
		this.origen = origen;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getDiagnostico() {
		return diagnostico;
	}

	public void setDiagnostico(String diagnostico) {
		this.diagnostico = diagnostico;
	}

	public String getGrupo_dx() {
		return grupo_dx;
	}

	public void setGrupo_dx(String grupo_dx) {
		this.grupo_dx = grupo_dx;
	}

	public String getSeg_osteomuscular() {
		return seg_osteomuscular;
	}

	public void setSeg_osteomuscular(String seg_osteomuscular) {
		this.seg_osteomuscular = seg_osteomuscular;
	}

	public String getOrigen() {
		return origen;
	}

	public void setOrigen(String origen) {
		this.origen = origen;
	}

	@Override
	public String toString() {
		return "CIE10 [id=" + id + ", codigo=" + codigo + ", diagnostico=" + diagnostico + ", grupo_dx=" + grupo_dx
				+ ", seg_osteomuscular=" + seg_osteomuscular + ", origen=" + origen + "]";
	}

	
}
