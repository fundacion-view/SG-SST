package org.fundacionview.SGSST.modelos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

//import org.fundacionview.SGSST.Utilidades.Utilidades;

@Entity
@Table(name="tbl_ausentismos", schema="")
public class Ausentismos {

		
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long consecutivo;

	// @Column(nullable=false)
	// private Long codempleado;
	@ManyToOne
	@JoinColumn(name="codempleado")
	private Empleados empleados;

	@ManyToOne
	@JoinColumn(name="area")
	private Areas areas;

	@Column(length=80, nullable = false)
	private String cargo;

	@Column(length=10, nullable=false, scale=2)
	private double salario;
	
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

	@Column(length=80, nullable=false)
	private String tipoincapacidad;

	// @Column(length=10, nullable=false)
	// private String codigodiagnostico;
	@ManyToOne
	@JoinColumn(name="diagnostico")
	private Diagnosticos diagnosticos;

	//yyyy-mm-dd
	@Column(length=10, nullable=false)
	private String fechainicio;

	//yyyy-mm-dd
	@Column(length=10, nullable=false)
	private String fechafin;
	
	@Column(length=5, nullable=false)
	private Long duracion;

	@Column(length=10, nullable=false)
	private String clasificacion;
	
	//Para eliminar logicamente 1=Activo 0=Bloqueado
	@Column(length=1, nullable=false)
	private Integer estado;
	

	//Utilidades libreriaUtilidades = new Utilidades();

	public Ausentismos()
	{
		super();
	}
	
	public Ausentismos(Empleados empleados, Areas areas, String cargo, double salario, Entidades entidadesEps,
			Entidades entidadesAfp, Entidades entidadesArl, String tipoincapacidad, Diagnosticos diagnosticos,
			String fechainicio, String fechafin, Long duracion, String clasificacion) {
		super();
		this.empleados = empleados;
		this.areas = areas;
		this.cargo = cargo.toUpperCase();
		this.salario = salario;
		this.entidadesEps = entidadesEps;
		this.entidadesAfp = entidadesAfp;
		this.entidadesArl = entidadesArl;
		this.tipoincapacidad = tipoincapacidad;
		this.diagnosticos = diagnosticos;
		this.fechainicio = fechainicio;
		this.fechafin = fechafin;
		this.duracion = duracion;//libreriaUtilidades.RestarFechas(fechainicio, fechafin); 
		this.clasificacion = clasificacion;
		this.estado = 1;
	}

	public Long getConsecutivo() {
		return consecutivo;
	}
	public void setConsecutivo(Long consecutivo) {
		this.consecutivo = consecutivo;
	}

	public Empleados getEmpleados() {
		return empleados;
	}

	public void setEmpleados(Empleados empleados) {
		this.empleados = empleados;
	}

	public String getTipoincapacidad() {
		return tipoincapacidad;
	}
	public void setTipoincapacidad(String tipoincapacidad) {
		this.tipoincapacidad = tipoincapacidad;
	}

	public Diagnosticos getDiagnosticos() {
		return diagnosticos;
	}

	public void setDiagnosticos(Diagnosticos diagnosticos) {
		this.diagnosticos = diagnosticos;
	}

	public String getFechainicio() {
		return fechainicio;
	}
	public void setFechainicio(String fechainicio) {
		this.fechainicio = fechainicio;
	}

	public String getFechafin() {
		return fechafin;
	}
	public void setFechafin(String fechafin) {
		this.fechafin = fechafin;
	}
	
	public Long getDuracion() {
		return duracion;
	}
	public void setDuracion(Long duracion) {
		this.duracion = duracion;
	}

	public String getClasificacion() {
		return clasificacion;
	}
	public void setClasificacion(String clasificacion) {
		this.clasificacion = clasificacion.toUpperCase();
	}

	public double getSalario() {
		return salario;
	}
	public void setSalario(double salario) {
		this.salario = salario;
	}

	public Areas getAreas() {
		return areas;
	}
	public void setAreas(Areas areas) {
		this.areas = areas;
	}

	public String getCargo() {
		return cargo;
	}
	public void setCargo(String cargo) {
		this.cargo = cargo.toUpperCase();
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
		return "Ausentismos [consecutivo=" + consecutivo + ", empleados=" + empleados + ", areas=" + areas + ", cargo="
				+ cargo + ", salario=" + salario + ", entidadesEps=" + entidadesEps + ", entidadesAfp=" + entidadesAfp
				+ ", entidadesArl=" + entidadesArl + ", tipoincapacidad=" + tipoincapacidad + ", diagnosticos="
				+ diagnosticos + ", fechainicio=" + fechainicio + ", fechafin=" + fechafin + ", duracion=" + duracion
				+ ", clasificacion=" + clasificacion + ", estado=" + estado + "]";
	}

}
