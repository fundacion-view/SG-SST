package org.fundacionview.SGSST.controladores;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AppControlador {
	
	@GetMapping({ "/index", "/home", "/dashboard" })
	public String goAdministracion(Model model) {
		model.addAttribute("titulo", "Bienvenid@");
		return "/dashboard/inicio";
	}

	@GetMapping({ "/login", "/login/", "/auth", "/", "" })
	public String iniciarSesion() {
		return "/login/login";
	}

	// @GetMapping({ "/reportes"})
	// public String reportes(Model model) {
	// 	model.addAttribute("titulo", "Bienvenid@, pagina de login");
	// 	return "/reportes//index";
	// }
	
}
