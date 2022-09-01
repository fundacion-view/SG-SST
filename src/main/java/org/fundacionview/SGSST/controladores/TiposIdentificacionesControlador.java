package org.fundacionview.SGSST.controladores;

import java.util.Optional;

import org.fundacionview.SGSST.modelos.TiposIdentificaciones;
import org.fundacionview.SGSST.servicios.ServicioTiposIdentificaciones;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class TiposIdentificacionesControlador {

	@Autowired
	private ServicioTiposIdentificaciones servicio;

    //Listar
	@GetMapping({ "/tiposID", "/" })
	public String listarTiposIdentificaciones(Model modelo) {
		modelo.addAttribute("tiposIdentificaciones", servicio.listarTiposIdentificaciones());
		return "/tiposID/index";
	}

	// Crear
	@GetMapping({ "/tiposID/nuevo", "/tiposID/crear" })
	public String mostrarFormularioRegistro(Model modelo) {
		TiposIdentificaciones tipoIdentificacion = new TiposIdentificaciones();
		modelo.addAttribute("tipoIdentificacion", tipoIdentificacion);
		return "/tiposID/crear_tipoID";
	}

	@PostMapping("/tiposID")
	public String guardarTipoIdentificacion(@ModelAttribute("tipoIdentificacion") TiposIdentificaciones tipoIdentificacion) {
		servicio.guardarTipoIdentificacion(tipoIdentificacion);
		return "redirect:/tiposID";
	}

	// Actualizar
	@GetMapping({ "/tiposID/actualizar/{id}", "/tiposID/modificar/{id}" })
	public String mostrarFormularioEdicion(@PathVariable Integer id, Model modelo) {
		modelo.addAttribute("tipoIdentificacion", servicio.obtenerTipoIdentificacionPorId(id));
		Optional<TiposIdentificaciones> tipoIdentificacionExistente = servicio.obtenerTipoIdentificacionPorId(id);
		if (tipoIdentificacionExistente.isPresent()) {
		return "/tiposID/editar_tipoID";
		}
		return "redirect:/tiposID";
		
	}

	@PostMapping({"/tiposID/{id}"})
	public String actualizarTipoIdentificacion(@ModelAttribute("tipoIdentificacion") TiposIdentificaciones tipoIdentificacion, Model modelo) {
		Optional<TiposIdentificaciones> tipoIdentificacionExistente = servicio.obtenerTipoIdentificacionPorId(tipoIdentificacion.getSecuencia());
        tipoIdentificacionExistente.get().setPrefijo(tipoIdentificacion.getPrefijo());
		tipoIdentificacionExistente.get().setNombre(tipoIdentificacion.getNombre());
		tipoIdentificacionExistente.get().setEstado(tipoIdentificacion.getEstado());
		servicio.actualizarTipoIdentificacion(tipoIdentificacionExistente.get());
		return "redirect:/tiposID";
	}

	// Eliminar logicamente
	@GetMapping({ "/tiposID/eliminar/{id}", "/tiposID/borrar/{id}" })
	public String eliminarLogicamenteTipoIdentificacion(@PathVariable Integer id) {
		Optional<TiposIdentificaciones> tipoIdentificacionExistente = servicio.obtenerTipoIdentificacionPorId(id);
		if (tipoIdentificacionExistente.isPresent()) {
			servicio.eliminarLogicamenteTipoIdentificacion(id);
			//return "redirect:/tiposID";
		}
		return "redirect:/tiposID";
	}
	
	// Restaurar logicamente
	@GetMapping({ "/tiposID/restaurar/{id}", "/tiposID/habilitar/{id}" })
	public String restaurarLogicamenteTipoIdentificacion(@PathVariable Integer id) {
		Optional<TiposIdentificaciones> tipoIdentificacionExistente = servicio.obtenerTipoIdentificacionPorId(id);
		if (tipoIdentificacionExistente.isPresent()) {
			servicio.restaurarLogicamenteTipoIdentificacion(id);
			//return "redirect:/tiposID";
		}
		return "redirect:/tiposID";
	}

}
