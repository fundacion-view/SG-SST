package org.fundacionview.SGSST;

import org.fundacionview.SGSST.modelos.Areas;
import org.fundacionview.SGSST.modelos.Ausentismos;
import org.fundacionview.SGSST.modelos.Diagnosticos;
import org.fundacionview.SGSST.modelos.Empleados;
import org.fundacionview.SGSST.modelos.Entidades;
import org.fundacionview.SGSST.modelos.Roles;
import org.fundacionview.SGSST.modelos.TiposIdentificaciones;
import org.fundacionview.SGSST.repositorios.RepositorioAreas;
import org.fundacionview.SGSST.repositorios.RepositorioAusentismos;
import org.fundacionview.SGSST.repositorios.RepositorioEmpleados;
import org.fundacionview.SGSST.repositorios.RepositorioEntidades;
import org.fundacionview.SGSST.repositorios.RepositorioRoles;
import org.fundacionview.SGSST.repositorios.RepositorioTiposIndentificaciones;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*
@SpringBootApplication
public class SgsstApplication {

	public static void main(String[] args) {
		System.setProperty("server.servlet.context-path", "/springbootapp");
		SpringApplication.run(SgsstApplication.class, args);
	}

}
*/


@SpringBootApplication
public class SgsstApplication  implements CommandLineRunner {
	
	public static void main(String[] args) {
		//System.setProperty("server.servlet.context-path", "/login"); //ruta contexto
		SpringApplication.run(SgsstApplication.class, args);
	}
	
	@Autowired
	private RepositorioEntidades repositorioEntidades;

	@Autowired
	private RepositorioAreas repositorioAreas;

	@Autowired
	private RepositorioEmpleados repositorioEmpleados;

	@Autowired
	private RepositorioRoles repositorioRoles;

	@Autowired
	private RepositorioTiposIndentificaciones repositorioTiposID;

	@Autowired
	private RepositorioAusentismos repositorioAusentismos;

	@Override
	public void run(String... args) throws Exception{

		//TIPOS ID PRUEBA
		TiposIdentificaciones tipoCC = new TiposIdentificaciones("CC", "Cedula de ciudadania");
		TiposIdentificaciones tipoCE = new TiposIdentificaciones("CE", "Cedula de extranjeria");
		TiposIdentificaciones tipoPSP = new TiposIdentificaciones("PSP", "Pasaporte");
		tipoCC.setSecuencia(1);
		//repositorioTiposID.save(tipoCC);
		tipoCE.setSecuencia(2);
		//repositorioTiposID.save(tipoCE);
		tipoPSP.setSecuencia(3);
		//repositorioTiposID.save(tipoPSP);

		//AREAS PRUEBA
		Areas area1 = new Areas("Sistemas y comunicaciones");
		repositorioAreas.save(area1);

		//ENTIDADES PRUEBAS
		Entidades entidad1 = new Entidades("EPS","EPS SURA","800088702-2",1);
		Entidades entidad2 = new Entidades("AFP","PROTECCION S.A.","800138188-",1);
		Entidades entidad3 = new Entidades("ARL","AXA COLPATRIA S.A.S.","860002184-6",1);
		repositorioEntidades.save(entidad1);
		repositorioEntidades.save(entidad2);
		repositorioEntidades.save(entidad3);

		//EMPLEADO PRUEBA
		//Empleados empleado1 = new Empleados("Duhan", "Renteria", tipoCC, "1128275", 2500000.0, area1, "Ingeniero de sistemas", entidad1, entidad2, entidad3);
		
		Empleados empleado1 = new Empleados();
		empleado1.setNombres("Duhan");
		empleado1.setApellidos("Renteria");
		empleado1.setTiposIdentificaciones(tipoCC);
		empleado1.setIdentificacion("1128275");
		empleado1.setSalario(2200000);
		empleado1.setAreas(area1);
		empleado1.setCargo("Ingeniero");
		empleado1.setEntidadesEps(entidad1);
		empleado1.setEntidadesAfp(entidad2);
		empleado1.setEntidadesArl(entidad3);
		empleado1.setEstado(1);
		
		repositorioEmpleados.save(empleado1);

		//USUARIO
		Roles rolAdmin = new Roles("Administrador");
		rolAdmin.setId((long) 1);
		//repositorioRoles.save(rolAdmin);

		// //Usuarios usuarioAdmin = new Usuarios(empleado1, "admin", rolAdmin, "$2a$10$CLJoB6HrpILIPdu67BtIU.uk/UrFWp.IYuQFkAEPKZNKHVjLj3g.q",1);
		// Usuario usuarioAdmin = new Usuario(empleado1,Arrays.asList(new Roles("Administrador")),"admin", "admin");
		// usuarioAdmin.setEstado(1);
		// repositorioUsuarios.save(usuarioAdmin);

		//INCAPACIDAD PRUEBA
		//enfermedad 8477 = U072 covid
		Diagnosticos diagnostico1 = new Diagnosticos("U072", "COVID-19", "grupo_dx", "seg_osteomuscular", "origen");
		diagnostico1.setId((long) 8477);
		
		Ausentismos incapacidadEC20= new Ausentismos(empleado1, area1, "Ingeniero de sistemas", 2500000.00, entidad1, entidad2, entidad3, "ORIGEN COMUN", diagnostico1, "2021-12-11", "2021-12-17",(long) 7, "PRORROGA");
		repositorioAusentismos.save(incapacidadEC20);

		Ausentismos incapacidadEC= new Ausentismos(empleado1, area1, "Ingeniero de sistemas", 2500000.00, entidad1, entidad2, entidad3, "ORIGEN COMUN", diagnostico1, "2021-08-16", "2021-08-17",(long) 2, "INICIO");
		repositorioAusentismos.save(incapacidadEC);

		Ausentismos incapacidadEC1= new Ausentismos(empleado1, area1, "Ingeniero de sistemas", 2500000.00, entidad1, entidad2, entidad3, "ORIGEN COMUN", diagnostico1, "2021-12-09", "2021-12-10",(long) 2, "INICIO");
		repositorioAusentismos.save(incapacidadEC1);

		Ausentismos incapacidadEC2= new Ausentismos(empleado1, area1, "Ingeniero de sistemas", 2500000.00, entidad1, entidad2, entidad3, "ORIGEN COMUN", diagnostico1, "2021-12-11", "2021-12-17",(long) 7, "PRORROGA");
		repositorioAusentismos.save(incapacidadEC2);

	}

}
