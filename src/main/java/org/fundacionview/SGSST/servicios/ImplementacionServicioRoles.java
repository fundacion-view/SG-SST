package org.fundacionview.SGSST.servicios;

import java.util.List;
import java.util.Optional;

import org.fundacionview.SGSST.modelos.Roles;
import org.fundacionview.SGSST.repositorios.RepositorioRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImplementacionServicioRoles implements ServicioRoles{

    @Autowired
    private RepositorioRoles repositorio;

    @Override
    public List<Roles> listarTodosLosRoles(){
        return repositorio.findAll();
    }
    
    @Override
    public List<Roles> listarRolesActivos() {
        return repositorio.listarRolesActivos();
    }

    @Override
    public Optional<Roles> obtenerRolPorId(Long id){
        return repositorio.findById(id);
    }
    
    @Override
    public Roles guardarRol(Roles rol) {
    	return repositorio.save(rol);
    }
    
    @Override
    public Roles actualizarRol(Roles rol) {
    	return repositorio.save(rol);
    }
    
    @Override
    public void eliminarRealmenteRol(Long id) {
    	//return repositorio.deleteById(id);
    }
    
    @Override
    public Optional<Roles>  eliminarLogicamenteRol(Long id){
    	Optional<Roles> rolExistente = repositorio.findById((long) id);
		if (rolExistente.isPresent()) {
            rolExistente.get().setEstado(0);
		repositorio.save(rolExistente.get());
		return repositorio.findById(id);
		}
	return null;	
    }

	@Override
	public Optional<Roles> restaurarLogicamenteRol(Long id) {
		Optional<Roles> rolExistente = repositorio.findById((long) id);
		if (rolExistente.isPresent()) {
            rolExistente.get().setEstado(1);
		repositorio.save(rolExistente.get());
		return repositorio.findById(id);
			
		}
		return null;
	}

}
