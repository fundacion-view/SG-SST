package org.fundacionview.SGSST.modelos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="tbl_empleados", schema="")
public class Empleados {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codempleado;
	
	@Column(length=80, nullable=false)
	private String nombres;
	
	@Column(length=80, nullable=false)
	private String apellidos;
	
	// @Column(length=80, nullable=false)
	// private String tipoidentificacion;
	@ManyToOne
	@JoinColumn(name="tipoidentificacion")
	private TiposIdentificaciones tiposIdentificaciones;
	
	@Column(length=11, nullable=false, unique=true)
	private String identificacion;
	
	//@Column(length=10, nullable=false, scale = 2)
	@Column(length=10, nullable=false, scale=2)
	private double salario;
	
	@Column(length=80, nullable = false)
	private String cargo;
	
	//@Column(length=80, nullable=false)
	//private String area;
	@ManyToOne
	@JoinColumn(name="area")
	private Areas areas;
	
	// @Column(length=80, nullable=false)
	// private String eps;
	@ManyToOne
	@JoinColumn(name="eps")
	private Entidades entidadesEps;
	
	// @Column(length=80, nullable=false)
	// private String afp;
	@ManyToOne
	@JoinColumn(name="afp")
	private Entidades entidadesAfp;
	
	// @Column(length=80, nullable=false)
	// private String arl;
	@ManyToOne
	@JoinColumn(name="arl")
	private Entidades entidadesArl;
	
	//Para eliminar logicamente 1=Activo 0=Bloqueado
	@Column(length=1, nullable=false)
	private Integer estado;
	
	public Empleados()
	{
		super();
	}
	
	public Empleados(String nombres, String apellidos, TiposIdentificaciones tiposIdentificaciones,
			String identificacion, double salario, Areas areas, String cargo, Entidades entidadesEps,
			Entidades entidadesAfp, Entidades entidadesArl, Integer estado) {
		super();
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.tiposIdentificaciones = tiposIdentificaciones;
		this.identificacion = identificacion;
		this.salario = salario;
		this.cargo = cargo;
		this.areas = areas;
		this.entidadesEps = entidadesEps;
		this.entidadesAfp = entidadesAfp;
		this.entidadesArl = entidadesArl;
		this.estado = 1;
	}

	public Long getCodempleado() {
		return codempleado;
	}
	public void setCodempleado(Long codempleado) {
		this.codempleado = codempleado;
	}

	public String getNombres() {
		return nombres;
	}
	public void setNombres(String nombres) {
		this.nombres = nombres.toUpperCase();
	}

	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos.toUpperCase();
	}

	public TiposIdentificaciones getTiposIdentificaciones() {
		return tiposIdentificaciones;
	}
	public void setTiposIdentificaciones(TiposIdentificaciones tiposIdentificaciones) {
		this.tiposIdentificaciones = tiposIdentificaciones;
	}

	public String getIdentificacion() {
		return identificacion;
	}
	public void setIdentificacion(String identificacion) {
		this.identificacion = identificacion.toUpperCase();
	}

	public double getSalario() {
		return salario;
	}
	public void setSalario(double salario) {
		this.salario = salario;
	}

	public String getCargo() {
		return cargo;
	}
	public void setCargo(String cargo) {
		this.cargo = cargo.toUpperCase();
	}

	public Areas getAreas() {
		return areas;
	}
	public void setAreas(Areas areas) {
		this.areas = areas;
	}

	public Entidades getEntidadesEps() {
		return entidadesEps;
	}
	public void setEntidadesEps(Entidades entidadesEps) {
		this.entidadesEps = entidadesEps;
	}

	public Entidades getEntidadesAfp() {
		return entidadesAfp;
	}
	public void setEntidadesAfp(Entidades entidadesAfp) {
		this.entidadesAfp = entidadesAfp;
	}

	public Entidades getEntidadesArl() {
		return entidadesArl;
	}
	public void setEntidadesArl(Entidades entidadesArl) {
		this.entidadesArl = entidadesArl;
	}

	public Integer getEstado() {
		return estado;
	}
	public void setEstado(Integer estado) {
		this.estado = estado;
	}

	@Override
	public String toString() {
		return "Empleados [codempleado=" + codempleado + ", nombres=" + nombres + ", apellidos=" + apellidos
				+ ", tiposIdentificaciones=" + tiposIdentificaciones + ", identificacion=" + identificacion
				+ ", salario=" + salario + ", cargo=" + cargo + ", area=" + areas + ", entidadesEps=" + entidadesEps
				+ ", entidadesAfp=" + entidadesAfp + ", entidadesArl=" + entidadesArl + ", estado=" + estado + "]";
	}

}
