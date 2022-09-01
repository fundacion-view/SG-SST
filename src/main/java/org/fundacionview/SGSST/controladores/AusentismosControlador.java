package org.fundacionview.SGSST.controladores;

import java.util.Optional;

import org.fundacionview.SGSST.Utilidades.Utilidades;
import org.fundacionview.SGSST.modelos.Ausentismos;
import org.fundacionview.SGSST.servicios.ServicioAreas;
import org.fundacionview.SGSST.servicios.ServicioAusentismos;
import org.fundacionview.SGSST.servicios.ServicioDiagnosticos;
import org.fundacionview.SGSST.servicios.ServicioEmpleados;
import org.fundacionview.SGSST.servicios.ServicioEntidades;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AusentismosControlador {
	
	Utilidades libreriaUtilidades = new Utilidades();

	@Autowired
	private ServicioAusentismos servicio;

	@Autowired
	private ServicioDiagnosticos diagnosticos;

	@Autowired
	private ServicioEmpleados empleados;

	@Autowired
	private ServicioAreas areas;

	@Autowired
	private ServicioEntidades entidades;
	
	@GetMapping({ "/ausentismos"})
	public String listarAusentismos(Model modelo) {
		modelo.addAttribute("ausentismos", servicio.listarTodosLosAusentismos());
		return "/ausentismos/index";
	}

	// crear
	@GetMapping({ "/ausentismos/nuevo", "/ausentismos/crear" })
	public String mostrarFormularioRegistro(Model modelo) {
		Ausentismos ausentismo = new Ausentismos();
		modelo.addAttribute("ausentismo", ausentismo);
		modelo.addAttribute("listaDiagnosticos", diagnosticos.listarDiagnosticos());
		modelo.addAttribute("empleados", empleados.listarTodosLosEmpleados());
		modelo.addAttribute("areas", areas.listarAreas());
		modelo.addAttribute("listaEps", entidades.listarEntidadesEps());
		modelo.addAttribute("listaAfp", entidades.listarEntidadesAfp());
		modelo.addAttribute("listaArl", entidades.listarEntidadesArl());
		return "/ausentismos/crear_ausentismo";
	}

	@PostMapping("/ausentismos")
	public String guardarAusentismo(@ModelAttribute("ausentismo") Ausentismos ausentismo) {
		ausentismo.setDuracion(libreriaUtilidades.RestarFechas(ausentismo.getFechainicio(), ausentismo.getFechafin()));
		servicio.guardarAusentismo(ausentismo);
		return "redirect:/ausentismos";
	}

	// actualizar
	@GetMapping({ "/ausentismos/actualizar/{id}", "/ausentismos/modificar/{id}" })
	public String mostrarFormularioEdicion(@PathVariable Long id, Model modelo) {
		modelo.addAttribute("ausentismo", servicio.obtenerAusentismoPorId(id));
		modelo.addAttribute("listaDiagnosticos", diagnosticos.listarDiagnosticos());
		modelo.addAttribute("empleados", empleados.listarTodosLosEmpleados());
		modelo.addAttribute("areas", areas.listarAreas());
		modelo.addAttribute("listaEps", entidades.listarEntidadesEps());
		modelo.addAttribute("listaAfp", entidades.listarEntidadesAfp());
		modelo.addAttribute("listaArl", entidades.listarEntidadesArl());

		Optional<Ausentismos> ausentismoExistente = servicio.obtenerAusentismoPorId((long) id);

		if (ausentismoExistente.isPresent()) {
			modelo.addAttribute("salarioxdia", libreriaUtilidades.SalarioPorDia(ausentismoExistente.get().getSalario()));
			modelo.addAttribute("totalDiasIncapacidad", libreriaUtilidades.RestarFechas(ausentismoExistente.get().getFechainicio(), ausentismoExistente.get().getFechafin()));
			return "/ausentismos/editar_ausentismo";
		}else{
			
			return "redirect:/ausentismos";
		}
	}

	@PostMapping({"/ausentismos/{id}"})
	public String actualizarAusentismo(@ModelAttribute("ausentismo") Ausentismos ausentismo, Model modelo) {
		Optional<Ausentismos> ausentismoExistente = servicio.obtenerAusentismoPorId((long) ausentismo.getConsecutivo());
		//ausentismoExistente.get().setCodigo(id);
		ausentismoExistente.get().setSalario(ausentismo.getSalario());
		ausentismoExistente.get().setCargo(ausentismo.getCargo());
		ausentismoExistente.get().setEntidadesEps(ausentismo.getEntidadesEps());
		ausentismoExistente.get().setEntidadesAfp(ausentismo.getEntidadesAfp());
		ausentismoExistente.get().setEntidadesArl(ausentismo.getEntidadesArl());
		ausentismoExistente.get().setFechainicio(ausentismo.getFechainicio());
		ausentismoExistente.get().setFechafin(ausentismo.getFechafin());
		ausentismoExistente.get().setDuracion(libreriaUtilidades.RestarFechas(ausentismoExistente.get().getFechainicio(), ausentismoExistente.get().getFechafin()));
		//ausentismoExistente.get().setEstado(ausentismo.getEstado());

		servicio.actualizarAusentismo(ausentismoExistente.get());
		return "redirect:/ausentismos";
	}

	// eliminar logicamente
	@GetMapping({ "/ausentismos/eliminar/{id}", "/ausentismos/borrar/{id}" })
	public String eliminarLogicamenteAusentismo(@PathVariable Long id) {
		Optional<Ausentismos> ausentismoExistente = servicio.obtenerAusentismoPorId((long) id);
		if (ausentismoExistente.isPresent()) {
			servicio.eliminarLogicamenteAusentismo((long) id);
			//return "redirect:/ausentismos";
		}	
		return "redirect:/ausentismos";
	}
	
	// Restaurar logicamente
	@GetMapping({ "/ausentismos/restaurar/{id}", "/ausentismos/habilitar/{id}" })
	public String restaurarLogicamenteAusentismo(@PathVariable Long id) {
		Optional<Ausentismos> ausentismoExistente = servicio.obtenerAusentismoPorId((long) id);
		if (ausentismoExistente.isPresent()) {
			servicio.restaurarLogicamenteAusentismo((long) id);
			//return "redirect:/ausentismos";
		}
		return "redirect:/ausentismos";
	}

}
