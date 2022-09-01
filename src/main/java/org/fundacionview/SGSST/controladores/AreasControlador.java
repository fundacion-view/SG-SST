package org.fundacionview.SGSST.controladores;

import java.util.Optional;

import org.fundacionview.SGSST.modelos.Areas;
import org.fundacionview.SGSST.servicios.ServicioAreas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AreasControlador {

	@Autowired
	private ServicioAreas servicio;

    //Listar
	@GetMapping({ "/areas", "/" })
	public String listarAreas(Model modelo) {
		modelo.addAttribute("areas", servicio.listarAreas());
		return "/areas/index";
	}

	// Crear
	@GetMapping({ "/areas/nuevo", "/areas/crear" })
	public String mostrarFormularioRegistro(Model modelo) {
		Areas area = new Areas();
		modelo.addAttribute("area", area);
		return "/areas/crear_area";
	}

	@PostMapping("/areas")
	public String guardarArea(@ModelAttribute("area") Areas area) {
		servicio.guardarArea(area);
		return "redirect:/areas";
	}

	// Actualizar
	@GetMapping({ "/areas/actualizar/{id}", "/areas/modificar/{id}" })
	public String mostrarFormularioEdicion(@PathVariable Long id, Model modelo) {
		modelo.addAttribute("area", servicio.obtenerAreaPorId(id));
		Optional<Areas> areaExistente = servicio.obtenerAreaPorId((long) id);
		if (areaExistente.isPresent()) {
			return "/areas/editar_area";
		}
		return "redirect:/areas";
	}

	@PostMapping({"/areas/{id}"})
	public String actualizarArea(@ModelAttribute("area") Areas area, Model modelo) {
		Optional<Areas> areaExistente = servicio.obtenerAreaPorId(area.getSecuencia());
		areaExistente.get().setNombre(area.getNombre());
		areaExistente.get().setEstado(area.getEstado());
		servicio.actualizarArea(areaExistente.get());
		return "redirect:/areas";
	}

	// Eliminar logicamente
	@GetMapping({ "/areas/eliminar/{id}", "/areas/borrar/{id}" })
	public String eliminarLogicamenteArea(@PathVariable Long id) {
		Optional<Areas> areaExistente = servicio.obtenerAreaPorId((long) id);
		if (areaExistente.isPresent()) {
			servicio.eliminarLogicamenteArea(id);
			//return "redirect:/areas";
		}
		return "redirect:/areas";

	}
	
	// Restaurar logicamente
	@GetMapping({ "/areas/restaurar/{id}", "/areas/habilitar/{id}" })
	public String restaurarLogicamenteArea(@PathVariable Long id) {
		Optional<Areas> areaExistente = servicio.obtenerAreaPorId((long) id);
		if (areaExistente.isPresent()) {
			servicio.restaurarLogicamenteArea((long) id);
			//return "redirect:/areas";
		}
		return "redirect:/areas";
	}

}
