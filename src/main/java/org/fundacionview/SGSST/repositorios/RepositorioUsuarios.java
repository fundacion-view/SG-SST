package org.fundacionview.SGSST.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

import org.fundacionview.SGSST.modelos.Usuarios;

@Repository
public interface RepositorioUsuarios extends JpaRepository<Usuarios, Long>{

	public Usuarios findByUsuario(String usuario);

	@Query(nativeQuery = true, value=" SELECT * FROM tbl_usuarios WHERE estado=1 ")
    public List<Usuarios> listarUsuariosActivos();

    // @Query(" FROM tbl_usuarios where usuario=:username and clave=:password")
	// public Usuarios loginUser(@Param("username") String username,@Param("password") String password);
	
	// @Query(value=" SELECT *FROM Usuario where id_empleado=:id_empleado limit 1",nativeQuery =true)
	// public Usuarios ComprobarCrearUser(@Param("id_empleado")int id_empleado);
}
