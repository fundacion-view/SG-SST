package org.fundacionview.SGSST.modelos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tbl_roles", schema="")
public class Roles {

    @Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	@Column(length=80, nullable=false, unique=true)
	private String nombre;

	@Column(length=1, nullable=false)
	private Integer estado;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getEstado() {
		return estado;
	}
	public void setEstado(Integer estado) {
		this.estado = estado;
	}

	public Roles(Long id, String nombre, Integer estado) {
		super();
		this.id = id;
		this.nombre = nombre;
	}

	public Roles(String nombre) {
		super();
		this.nombre = nombre;
		this.estado=1;
	}

	public Roles() {
		
	}

	@Override
	public String toString() {
		return "Roles [id=" + id + ", nombre=" + nombre + ", estado=" + estado + "]";
	}
	
	
}
