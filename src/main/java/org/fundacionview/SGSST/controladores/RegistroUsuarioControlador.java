package org.fundacionview.SGSST.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.fundacionview.SGSST.controladores.dto.UsuarioRegistroDTO;
import org.fundacionview.SGSST.servicios.ServicioUsuarios;

@Controller
@RequestMapping("/registro")
public class RegistroUsuarioControlador {

	private ServicioUsuarios usuarioServicio;

	public RegistroUsuarioControlador(ServicioUsuarios usuarioServicio) {
		super();
		this.usuarioServicio = usuarioServicio;
	}
	
	@ModelAttribute("datosUsuario")
	public UsuarioRegistroDTO retornarNuevoUsuarioRegistroDTO() {
		return new UsuarioRegistroDTO();
	}

	@GetMapping
	public String mostrarFormularioDeRegistro() {
		return "registro";
	}
	
	@PostMapping
	public String registrarCuentaDeUsuario(@ModelAttribute("datosUsuario") UsuarioRegistroDTO registroDTO) {
		usuarioServicio.guardarUsuario(registroDTO);
		return "redirect:/registro?exito";
	}
}
