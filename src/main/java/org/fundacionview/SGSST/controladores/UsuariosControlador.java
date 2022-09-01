package org.fundacionview.SGSST.controladores;

import java.util.Optional;

import org.fundacionview.SGSST.controladores.dto.UsuarioRegistroDTO;
import org.fundacionview.SGSST.modelos.Usuarios;
import org.fundacionview.SGSST.servicios.ServicioEmpleados;
import org.fundacionview.SGSST.servicios.ServicioUsuarios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UsuariosControlador {

	@Autowired
	private ServicioUsuarios servicio;

	@Autowired
	private ServicioEmpleados empleados;

    public UsuariosControlador(ServicioUsuarios usuarioServicio) {
		super();
		this.servicio = usuarioServicio;
	}

	@GetMapping({ "/usuarios", "/" })
	public String listarUsuarios(Model modelo) {
		modelo.addAttribute("listaUsuarios", servicio.listarUsuarios());
		return "/usuarios/index";
	}

// crear
	@ModelAttribute("datosUsuario")
	public UsuarioRegistroDTO retornarNuevoUsuarioRegistroDTO() {
		return new UsuarioRegistroDTO();
	}

	@GetMapping({ "/usuarios/nuevo", "/usuarios/crear" })
	public String mostrarFormularioRegistro(Model modelo) {
		//Usuarios usuario = new Usuarios();
		UsuarioRegistroDTO usuarioRegistroDTO = new UsuarioRegistroDTO();
		modelo.addAttribute("datosUsuario", usuarioRegistroDTO);
		modelo.addAttribute("empleados", empleados.listarTodosLosEmpleados());
		return "/usuarios/crear_usuario";
	}

	@PostMapping("/usuarios")
	public String guardarUsuario(@ModelAttribute("datosUsuario")  UsuarioRegistroDTO registroDTO) {
		servicio.guardarUsuario(registroDTO);
		return "redirect:/usuarios";
	}

	// actualizar
	@GetMapping({ "/usuarios/actualizar/{id}", "/usuarios/modificar/{id}" })
	public String mostrarFormularioEdicion(@PathVariable Long id, Model modelo) {
		modelo.addAttribute("datosUsuario", servicio.obtenerUsuarioPorId(id));
		modelo.addAttribute("empleados", empleados.listarTodosLosEmpleados());
		Optional<Usuarios> usuarioExistente = servicio.obtenerUsuarioPorId(id);
		if (usuarioExistente.isPresent()) {
			return "/usuarios/editar_usuario";
		}
		return "redirect:/usuarios";
		
	}

	@PostMapping({"/usuarios/{id}"})
	public String actualizarUsuario(@ModelAttribute("datosUsuario") Usuarios datosUsuario, Model modelo) {
		Optional<Usuarios> usuarioExistente = servicio.obtenerUsuarioPorId((long) datosUsuario.getId());
		usuarioExistente.get().setEmpleados(datosUsuario.getEmpleados());
		usuarioExistente.get().setUsuario(datosUsuario.getUsuario());
		//usuarioExistente.get().setClave(usuario.getClave());
		usuarioExistente.get().setEstado(datosUsuario.getEstado());

		servicio.actualizarUsuario(usuarioExistente.get());
		return "redirect:/usuarios";
	}

	// eliminar logicamente
	@GetMapping({ "/usuarios/eliminar/{id}", "/usuarios/borrar/{id}" })
	public String eliminarLogicamenteUsuario(@PathVariable Long id) {
		Optional<Usuarios> usuarioExistente = servicio.obtenerUsuarioPorId((long) id);
		if (usuarioExistente.isPresent()) {
			servicio.eliminarLogicamenteUsuario((long) id);
			//return "redirect:/usuarios";
		}
		return "redirect:/usuarios";
	}
	
	// Restaurar logicamente
	@GetMapping({ "/usuarios/restaurar/{id}", "/usuarios/habilitar/{id}" })
	public String restaurarLogicamenteUsuario(@PathVariable Long id) {
		Optional<Usuarios> usuarioExistente = servicio.obtenerUsuarioPorId((long) id);
		if (usuarioExistente.isPresent()) {
			servicio.restaurarLogicamenteUsuario((long) id);
			//return "redirect:/usuarios";
		}
		return "redirect:/usuarios";
	}

}
