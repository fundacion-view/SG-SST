package org.fundacionview.SGSST.controladores;

//import java.util.Optional;

//import org.fundacionview.SGSST.modelos.Diagnosticos;
import org.fundacionview.SGSST.servicios.ServicioDiagnosticos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class DiagnosticosControlador {

	@Autowired
	private ServicioDiagnosticos servicio;

    //Listar
	@GetMapping({ "/diagnosticos", "/" })
	public String listarDiagnosticos(Model modelo) {
		modelo.addAttribute("diagnosticos", servicio.listarDiagnosticos());
		return "/diagnosticos/index";
	}

    /* 
	// Crear
	@GetMapping({ "/diagnosticos/nuevo", "/diagnosticos/crear" })
	public String mostrarFormularioRegistro(Model modelo) {
		Diagnosticos diagnostico = new Diagnosticos();
		modelo.addAttribute("diagnostico", diagnostico);
		return "/diagnosticos/crear_diagnostico";
	}

	@PostMapping("/diagnosticos")
	public String guardarDiagnostico(@ModelAttribute("diagnostico") Diagnosticos diagnostico) {
		servicio.guardarDiagnostico(diagnostico);
		return "redirect:/diagnosticos";
	}

	// Actualizar
	@GetMapping({ "/diagnosticos/actualizar/{id}", "/diagnosticos/modificar/{id}" })
	public String mostrarFormularioEdicion(@PathVariable Long id, Model modelo) {
		modelo.addAttribute("diagnostico", servicio.obtenerDiagnosticoPorId(id));
		Optional<Diagnosticos> diagnosticoExistente = servicio.obtenerDiagnosticoPorId((long) id);
		if (diagnosticoExistente.isEmpty()) {
			return "redirect:/diagnosticos";
		}
		return "/diagnosticos/editar_diagnostico";
	}

	@PostMapping({"/diagnosticos/{id}"})
	public String actualizarDiagnostico(@ModelAttribute("diagnostico") Diagnosticos diagnostico, Model modelo) {
		Optional<Diagnosticos> diagnosticoExistente = servicio.obtenerDiagnosticoPorId(diagnostico.getSecuencia());
		diagnosticoExistente.get().setNombre(diagnostico.getNombre());
		diagnosticoExistente.get().setEstado(diagnostico.getEstado());
		servicio.actualizarDiagnostico(diagnosticoExistente.get());
		return "redirect:/diagnosticos";
	}

*/

}
