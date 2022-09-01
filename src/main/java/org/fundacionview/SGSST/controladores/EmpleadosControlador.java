package org.fundacionview.SGSST.controladores;

import java.util.Optional;

import org.fundacionview.SGSST.modelos.Empleados;
import org.fundacionview.SGSST.servicios.ServicioAreas;
import org.fundacionview.SGSST.servicios.ServicioEmpleados;
import org.fundacionview.SGSST.servicios.ServicioEntidades;
import org.fundacionview.SGSST.servicios.ServicioTiposIdentificaciones;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class EmpleadosControlador {

	@Autowired
	private ServicioEmpleados servicio;

	@Autowired
	private ServicioTiposIdentificaciones tipoID;

	@Autowired
	private ServicioEntidades entidades;

	@Autowired
	private ServicioAreas areas;
	
	@GetMapping({ "/empleados"})
	public String listarEmpleados(Model modelo) {
		modelo.addAttribute("empleados", servicio.listarTodosLosEmpleados());
		return "/empleados/index";
	}

	// crear
	@GetMapping({ "/empleados/nuevo", "/empleados/crear" })
	public String mostrarFormularioRegistro(Model modelo) {
		Empleados empleado = new Empleados();
		modelo.addAttribute("empleado", empleado);
		modelo.addAttribute("tipoID", tipoID.listarTiposIdentificaciones());
		modelo.addAttribute("areas", areas.listarAreasActivas());
		modelo.addAttribute("eps", entidades.listarEpsActivas());
		modelo.addAttribute("afp", entidades.listarAfpActivas());
		modelo.addAttribute("arl", entidades.listarArlActivas());
		return "/empleados/crear_empleado";
	}

	@PostMapping("/empleados")
	public String guardarEmpleado(@ModelAttribute("empleado") Empleados empleado) {
		empleado.setEstado(1);
		servicio.guardarEmpleado(empleado);
		return "redirect:/empleados";
	}

	// actualizar
	@GetMapping({ "/empleados/actualizar/{id}", "/empleados/modificar/{id}" })
	public String mostrarFormularioEdicion(@PathVariable Long id, Model modelo) {
		modelo.addAttribute("empleado", servicio.obtenerEmpleadoPorId(id));
		modelo.addAttribute("tipoID", tipoID.listarTiposIdentificaciones());
		modelo.addAttribute("areas", areas.listarAreas());
		modelo.addAttribute("eps", entidades.listarEntidadesEps());
		modelo.addAttribute("afp", entidades.listarEntidadesAfp());
		modelo.addAttribute("arl", entidades.listarEntidadesArl());
		Optional<Empleados> empleadoExistente = servicio.obtenerEmpleadoPorId((long) id);
		if (empleadoExistente.isPresent()) {
			return "/empleados/editar_empleado";
		}
		return "redirect:/empleados";
		
	}

	@PostMapping({"/empleados/{id}"})
	public String actualizarEmpleado(@ModelAttribute("empleado") Empleados empleado, Model modelo) {
		Optional<Empleados> empleadoExistente = servicio.obtenerEmpleadoPorId((long) empleado.getCodempleado());
		//empleadoExistente.get().setCodigo(id);
		empleadoExistente.get().setNombres(empleado.getNombres());
		empleadoExistente.get().setApellidos(empleado.getApellidos());
		empleadoExistente.get().setTiposIdentificaciones(empleado.getTiposIdentificaciones());
		empleadoExistente.get().setIdentificacion(empleado.getIdentificacion());
		empleadoExistente.get().setSalario(empleado.getSalario());
		empleadoExistente.get().setAreas(empleado.getAreas());
		empleadoExistente.get().setCargo(empleado.getCargo());
		empleadoExistente.get().setEntidadesEps(empleado.getEntidadesEps());
		empleadoExistente.get().setEntidadesAfp(empleado.getEntidadesAfp());
		empleadoExistente.get().setEntidadesArl(empleado.getEntidadesArl());
		//empleadoExistente.get().setEstado(empleado.getEstado());

		servicio.actualizarEmpleado(empleadoExistente.get());
		return "redirect:/empleados";
	}

	// eliminar logicamente
	@GetMapping({ "/empleados/eliminar/{id}", "/empleados/borrar/{id}" })
	public String eliminarLogicamenteEmpleado(@PathVariable Long id) {
		Optional<Empleados> empleadoExistente = servicio.obtenerEmpleadoPorId((long) id);
		if (empleadoExistente.isPresent()) {
			servicio.eliminarLogicamenteEmpleado((long) id);
			//return "redirect:/empleados";
		}
		return "redirect:/empleados";
	}
	
	// Restaurar logicamente
	@GetMapping({ "/empleados/restaurar/{id}", "/empleados/habilitar/{id}" })
	public String restaurarLogicamenteEmpleado(@PathVariable Long id) {
		Optional<Empleados> empleadoExistente = servicio.obtenerEmpleadoPorId((long) id);
		if (empleadoExistente.isPresent()) {
			servicio.restaurarLogicamenteEmpleado((long) id);
			//return "redirect:/empleados";
		}
		return "redirect:/empleados";
	}

}
