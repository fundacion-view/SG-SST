package org.fundacionview.SGSST.servicios;

import java.util.List;
import java.util.Optional;

import org.springframework.security.core.userdetails.UserDetailsService;

import org.fundacionview.SGSST.controladores.dto.UsuarioRegistroDTO;
import org.fundacionview.SGSST.modelos.Usuarios;

public interface ServicioUsuarios extends UserDetailsService{
	
	public List<Usuarios> listarUsuarios();

    public Optional<Usuarios> obtenerUsuarioPorId(Long id);

    public List<Usuarios> listarUsuariosActivos();

    //public Usuarios findByUsuario(String usuario);
    
	public Usuarios guardarUsuario(UsuarioRegistroDTO registroDTO);
        
    public Usuarios actualizarUsuario(Usuarios Usuario);
    
    public void eliminarRealmenteUsuario(Long id);
    
    public Optional<Usuarios> eliminarLogicamenteUsuario(Long id);
    
    public Optional<Usuarios> restaurarLogicamenteUsuario(Long id);
	
}
