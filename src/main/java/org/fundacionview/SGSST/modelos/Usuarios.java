package org.fundacionview.SGSST.modelos;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Entity
@Table(name = "tbl_usuarios")
public class Usuarios {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

    @ManyToOne
	@JoinColumn(name="codempleado")
	private Empleados empleados;

	@ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	@JoinTable(
			name = "usuarios_roles",
			joinColumns = @JoinColumn(name = "usuario_id",referencedColumnName = "id"),
			inverseJoinColumns = @JoinColumn(name = "rol_id",referencedColumnName = "id")
			)
	private Collection<Roles> roles;
    
	@Column(length=30, nullable=false, unique=true)
	private String usuario;
	
	@Column(length=255, nullable=false)
	private String clave;
	
	//Para eliminar logicamente 1=Activo 0=Bloqueado
	@Column(length=1, nullable=false)
	private Integer estado=1;

	// @Autowired
	// private BCryptPasswordEncoder passwordEncoder;

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	public Empleados getEmpleados() {
		return empleados;
	}
	public void setEmpleados(Empleados empleados) {
		this.empleados = empleados;
	}
	
	public Collection<Roles> getRoles() {
		return roles;
	}
	public void setRoles(Collection<Roles> roles) {
		this.roles = roles;
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
	
	public Integer getEstado() {
		return estado;
	}
	public void setEstado(Integer estado) {
		this.estado = estado;
	}

	public Usuarios(Long id, Empleados empleados, Collection<Roles> roles, String usuario, String clave, Integer estado) {
		super();
		this.id = id;
		this.empleados = empleados;
		this.roles = roles;
		this.usuario = usuario;
		this.clave = clave; //passwordEncoder.encode(clave);
		this.estado = estado;
	}
	
	public Usuarios(Empleados empleados, Collection<Roles> roles, String usuario, String clave) {
		super();
		this.empleados = empleados;
		this.roles = roles;
		this.usuario = usuario;
		this.clave = clave; //passwordEncoder.encode(clave);
		this.estado= 1;
	}
	
	public Usuarios() {
		
	}

}
