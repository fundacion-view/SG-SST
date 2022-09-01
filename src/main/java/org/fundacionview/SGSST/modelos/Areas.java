package org.fundacionview.SGSST.modelos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tbl_areas", schema="")
public class Areas {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long secuencia;
	
	@Column(length=80, nullable=false, unique=true)
	private String nombre;
		
	//Para eliminar logicamente 1=Activo 0=Bloqueado
	@Column(length=1, nullable=false)
	private Integer estado;

	public Areas() {
		super();
	}

	public Areas(String nombre) {
		super();
		this.nombre = nombre.toUpperCase();
		this.estado = 1;
	}

	public Long getSecuencia() {
		return secuencia;
	}
	public void setSecuencia(Long secuencia) {
		this.secuencia = secuencia;
	}

	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre.toUpperCase();
	}

	public Integer getEstado() {
		return estado;
	}
	public void setEstado(Integer estado) {
		this.estado = estado;
	}

	@Override
	public String toString() {
		return "Areas [secuencia=" + secuencia + ", nombre=" + nombre
				+ ", estado=" + estado + "]";
	}
	
}