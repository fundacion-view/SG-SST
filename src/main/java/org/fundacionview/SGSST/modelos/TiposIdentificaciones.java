package org.fundacionview.SGSST.modelos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tbl_tipos_identificaciones", schema="")
public class TiposIdentificaciones {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer secuencia;
	
	@Column(length=3, nullable=false ,unique=true)
	private String prefijo;
	
	@Column(length=80, nullable=false, unique=true)
	private String nombre;
		
	//Para eliminar logicamente 1=Activo 0=Bloqueado
	@Column(length=1, nullable=false)
	private Integer estado;

	public TiposIdentificaciones() {
		super();
	}

	public TiposIdentificaciones(String prefijo, String nombre) {
		super();
		this.prefijo = prefijo.toUpperCase();
		this.nombre = nombre.toUpperCase();
		this.estado = 1;
	}

	public Integer getSecuencia() {
		return secuencia;
	}
	public void setSecuencia(Integer secuencia) {
		this.secuencia = secuencia;
	}

	public String getPrefijo() {
		return prefijo;
	}
	public void setPrefijo(String prefijo) {
		this.prefijo = prefijo.toUpperCase();
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
		return "TiposIdentificaciones [secuencia=" + secuencia + ", prefijo=" + prefijo + ", nombre=" + nombre
				+ ", estado=" + estado + "]";
	}
	
}