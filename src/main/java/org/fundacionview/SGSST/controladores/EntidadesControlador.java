package org.fundacionview.SGSST.controladores;

import java.util.Optional;

import org.fundacionview.SGSST.modelos.Entidades;
import org.fundacionview.SGSST.servicios.ServicioEntidades;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class EntidadesControlador {

	@Autowired
	private ServicioEntidades servicio;

	@GetMapping({ "/entidades", "/" })
	public String listarEntidades(Model modelo) {
		modelo.addAttribute("entidades", servicio.listarTodasLasEntidades());
		return "/entidades/index";
	}

	// crear
	@GetMapping({ "/entidades/nuevo", "/entidades/crear" })
	public String mostrarFormularioRegistro(Model modelo) {
		Entidades entidad = new Entidades();
		modelo.addAttribute("entidad", entidad);
		return "/entidades/crear_entidad";
	}

	@PostMapping("/entidades")
	public String guardarEntidad(@ModelAttribute("entidad") Entidades entidad) {
		servicio.guardarEntidad(entidad);
		return "redirect:/entidades";
	}

	// actualizar
	@GetMapping({ "/entidades/actualizar/{id}", "/entidades/modificar/{id}" })
	public String mostrarFormularioEdicion(@PathVariable Long id, Model modelo) {
		modelo.addAttribute("entidad", servicio.obtenerEntidadPorId(id));
		Optional<Entidades> entidadExistente = servicio.obtenerEntidadPorId((long) id);
		if (entidadExistente.isPresent()) {
			return "/entidades/editar_entidad";
		}
		return "redirect:/entidades";
		
	}

	@PostMapping({"/entidades/{id}"})
	public String actualizarEntidad(@ModelAttribute("entidad") Entidades entidad, Model modelo) {
		Optional<Entidades> entidadExistente = servicio.obtenerEntidadPorId((long) entidad.getCodigo());
		//entidadExistente.get().setCodigo(id);
		entidadExistente.get().setNombre(entidad.getNombre());
		entidadExistente.get().setNit(entidad.getNit());
		entidadExistente.get().setTipo(entidad.getTipo());
		entidadExistente.get().setEstado(entidad.getEstado());

		servicio.actualizarEntidad(entidadExistente.get());
		return "redirect:/entidades";
	}

	// eliminar logicamente
	@GetMapping({ "/entidades/eliminar/{id}", "/entidades/borrar/{id}" })
	public String eliminarLogicamenteEntidad(@PathVariable Long id) {
		Optional<Entidades> entidadExistente = servicio.obtenerEntidadPorId((long) id);
		if (entidadExistente.isPresent()) {
			servicio.eliminarLogicamenteEntidad((long) id);
			//return "redirect:/entidades";
		}
		return "redirect:/entidades";
	}
	
	// Restaurar logicamente
	@GetMapping({ "/entidades/restaurar/{id}", "/entidades/habilitar/{id}" })
	public String restaurarLogicamenteEntidad(@PathVariable Long id) {
		Optional<Entidades> entidadExistente = servicio.obtenerEntidadPorId((long) id);
		if (entidadExistente.isPresent()) {
			servicio.restaurarLogicamenteEntidad((long) id);
			//return "redirect:/entidades";
		}
		return "redirect:/entidades";
	}

}
