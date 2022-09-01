package org.fundacionview.SGSST.repositorios;

import java.util.List;

import org.fundacionview.SGSST.modelos.Roles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioRoles extends JpaRepository<Roles, Long>  {
    
    // @Query(nativeQuery = true, value=" SELECT * FROM tbl_roles WHERE estado=1 ")
    // public List<Roles> listarUsuariosActivos();

    // @Query(" FROM tbl_usuarios where usuario=:username and clave=:password")
	// public Usuarios loginUser(@Param("username") String username,@Param("password") String password);
	
	// @Query(value=" SELECT *FROM Usuario where id_empleado=:id_empleado limit 1",nativeQuery =true)
	// public Usuarios ComprobarCrearUser(@Param("id_empleado")int id_empleado);

    @Query(nativeQuery = true, value=" SELECT * FROM tbl_roles WHERE estado=1 ")
    public List<Roles> listarRolesActivos();

    Roles findByNombre(String nombre);

}
