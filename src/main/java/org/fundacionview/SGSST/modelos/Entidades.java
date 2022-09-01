package org.fundacionview.SGSST.modelos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_entidades", schema = "")
public class Entidades {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;

	@Column(nullable = false)
	private String tipo;

	@Column(length = 80, nullable = false)
	private String nombre;

	@Column(length = 13, nullable = false, unique = true)
	private String nit;

	// Para eliminar logicamente 1=Activo 0=Bloqueado
	@Column(length = 1, nullable = false)
	private Integer estado;

	public Entidades() {
		super();
	}

	public Entidades(String tipo, String nombre, String nit, Integer estado) {
		super();
		this.tipo = tipo.toUpperCase();
		this.nombre = nombre.toUpperCase();
		this.nit = nit;
		this.estado = estado;
	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo.toUpperCase();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre.toUpperCase();
	}

	public String getNit() {
		return nit;
	}

	public void setNit(String nit) {
		this.nit = nit;
	}

	public Integer getEstado() {
		return estado;
	}

	public void setEstado(Integer estado) {
		this.estado = estado;
	}

	@Override
	public String toString() {
		return "Entidades [codigo=" + codigo + ", tipo=" + tipo + ", nombre=" + nombre + ", nit=" + nit + ", estado="
				+ estado + "]";
	}

}
