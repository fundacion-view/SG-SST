package org.fundacionview.SGSST.servicios;

import java.util.List;
import java.util.Optional;

import org.fundacionview.SGSST.modelos.Roles;

public interface ServicioRoles {

    public List<Roles> listarTodosLosRoles();

    public Optional<Roles> obtenerRolPorId(Long id);

    public List<Roles> listarRolesActivos();

    //public Roles findByRol(String rol);
    
    public Roles guardarRol(Roles Rol);
        
    public Roles actualizarRol(Roles Rol);
    
    public void eliminarRealmenteRol(Long id);
    
    public Optional<Roles> eliminarLogicamenteRol(Long id);
    
    public Optional<Roles> restaurarLogicamenteRol(Long id);

}
