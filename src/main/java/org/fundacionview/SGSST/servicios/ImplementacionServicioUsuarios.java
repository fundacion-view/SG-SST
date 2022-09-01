package org.fundacionview.SGSST.servicios;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import org.fundacionview.SGSST.controladores.dto.UsuarioRegistroDTO;
import org.fundacionview.SGSST.modelos.Roles;
import org.fundacionview.SGSST.modelos.Usuarios;
import org.fundacionview.SGSST.repositorios.RepositorioUsuarios;

@Service
public class ImplementacionServicioUsuarios implements ServicioUsuarios {

	
	private RepositorioUsuarios repositorioUsuarios;

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	public ImplementacionServicioUsuarios(RepositorioUsuarios repositorioUsuarios) {
		super();
		this.repositorioUsuarios = repositorioUsuarios;
	}

	@Override
    public List<Usuarios> listarUsuarios(){
        return repositorioUsuarios.findAll();
    }

	@Override
    public List<Usuarios> listarUsuariosActivos(){
       return repositorioUsuarios.listarUsuariosActivos();
    }

    @Override
    public Optional<Usuarios> obtenerUsuarioPorId(Long id){
        return repositorioUsuarios.findById(id);
    }

	@Override
	public Usuarios guardarUsuario(UsuarioRegistroDTO registroDTO) {
		// Usuario usuario2 = new Usuario(registroDTO.getEmpleado(), registroDTO.,registroDTO.getEmail(),
		// 		passwordEncoder.encode(registroDTO.getPassword()),Arrays.asList(new Roles("ROLE_USER")));
        Usuarios usuario = new Usuarios(registroDTO.getEmpleado(),Arrays.asList(new Roles(registroDTO.getRol())),registroDTO.getUsuario(),passwordEncoder.encode(registroDTO.getClave()));
		return repositorioUsuarios.save(usuario);
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Usuarios usuario = repositorioUsuarios.findByUsuario(username);
		if(usuario == null) {
			throw new UsernameNotFoundException("Usuario o password inválidos");
		}
		return new User(usuario.getUsuario(),usuario.getClave(), mapearAutoridadesRoles(usuario.getRoles()));
	}

	private Collection<? extends GrantedAuthority> mapearAutoridadesRoles(Collection<Roles> roles){
		return roles.stream().map(role -> new SimpleGrantedAuthority(role.getNombre())).collect(Collectors.toList());
	}

	@Override
    public Usuarios actualizarUsuario(Usuarios Usuario) {
    	return repositorioUsuarios.save(Usuario);
    }
    
    @Override
    public void eliminarRealmenteUsuario(Long id) {
    	//return repositorio.deleteById(id);
    }
    
    @Override
    public Optional<Usuarios>  eliminarLogicamenteUsuario(Long id){
    	Optional<Usuarios> UsuarioExistente = repositorioUsuarios.findById(id);
		if (UsuarioExistente.isPresent()) {
            UsuarioExistente.get().setEstado(0);
            repositorioUsuarios.save(UsuarioExistente.get());
		return repositorioUsuarios.findById(id);
		}
		return null;
    }

	@Override
	public Optional<Usuarios> restaurarLogicamenteUsuario(Long id) {
		Optional<Usuarios> UsuarioExistente = repositorioUsuarios.findById(id);
		if (UsuarioExistente.isPresent()) {
            UsuarioExistente.get().setEstado(1);
            repositorioUsuarios.save(UsuarioExistente.get());
		return repositorioUsuarios.findById(id);
		}
		return null;
	}	

}
