package org.fundacionview.SGSST.controladores.dto;

import org.fundacionview.SGSST.modelos.Empleados;

public class UsuarioRegistroDTO {

	private Long id;
	private Empleados empleado;
	private String rol;
	private String usuario;
	private String clave;

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	public Empleados getEmpleado() {
		return empleado;
	}
	public void setEmpleado(Empleados empleado) {
		this.empleado = empleado;
	}
	
	public String getRol() {
		return rol;
	}
	public void setRol(String rol) {
		this.rol = rol;
	}

	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getClave() {
		return clave;
	}
	public void setClave(String clave) {
		this.clave = clave;
	}

	public UsuarioRegistroDTO(Empleados empleado, String rol, String usuario, String clave) {
		super();
		this.empleado = empleado;
		this.rol = rol;
		this.usuario = usuario;
		this.clave = clave;
	}
	
	public UsuarioRegistroDTO() {

	}

}
