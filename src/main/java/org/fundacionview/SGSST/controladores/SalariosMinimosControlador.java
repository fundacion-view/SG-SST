package org.fundacionview.SGSST.controladores;

import org.fundacionview.SGSST.servicios.ServicioSalariosMinimos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SalariosMinimosControlador {

	@Autowired
	private ServicioSalariosMinimos servicio;

    //Listar
	@GetMapping({ "/salariosminimos" })
	public String listarSalariosMinimos(Model modelo) {
		modelo.addAttribute("salariosMinimos", servicio.listarSalariosMinimos());
		return "/SMLMV/index";
	}

    /* 
	// Crear
	@GetMapping({ "/salariosminimos/nuevo", "/salariosminimos/crear" })
	public String mostrarFormularioRegistro(Model modelo) {
		SalariosMinimos salarioMinimo = new SalariosMinimos();
		modelo.addAttribute("salarioMinimo", salarioMinimo);
		return "/SMLMV/crear_salariominimo";
	}

	@PostMapping("/salariosminimos")
	public String guardarSalarioMinimo(@ModelAttribute("salarioMinimo") SalariosMinimos salarioMinimo) {
		servicio.guardarSalarioMinimo(salarioMinimo);
		return "redirect:/salariosminimos";
	}

	// Actualizar
	@GetMapping({ "/salariosminimos/actualizar/{id}", "/salariosminimos/modificar/{id}" })
	public String mostrarFormularioEdicion(@PathVariable Long id, Model modelo) {
		modelo.addAttribute("salarioMinimo", servicio.obtenerSalarioMinimoPorId(id));
		Optional<SalariosMinimos> salarioMinimoExistente = servicio.obtenerSalarioMinimoPorId((long) id);
		if (salarioMinimoExistente.isEmpty()) {
			return "redirect:/salariosminimos";
		}
		return "/SMLMV/editar_salariominimo";
	}

	@PostMapping({"/salariosminimos/{id}"})
	public String actualizarSalarioMinimo(@ModelAttribute("salarioMinimo") SalariosMinimos salarioMinimo, Model modelo) {
		Optional<SalariosMinimos> salarioMinimoExistente = servicio.obtenerSalarioMinimoPorId(salarioMinimo.getSecuencia());
		salarioMinimoExistente.get().setNombre(salarioMinimo.getNombre());
		salarioMinimoExistente.get().setEstado(salarioMinimo.getEstado());
		servicio.actualizarSalarioMinimo(salarioMinimoExistente.get());
		return "redirect:/salariosminimos";
	}

*/

}
