package org.fundacionview.SGSST.repositorios;

import java.util.List;

import org.fundacionview.SGSST.modelos.Entidades;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioEntidades extends JpaRepository<Entidades, Long>  {

    @Query(nativeQuery = true, value=" SELECT * FROM tbl_entidades WHERE tipo LIKE %:tipoEntidad% ")
    public List<Entidades> listarPorTipoEntidad(String tipoEntidad);

    List<Entidades> findByTipo(String tipo);

    @Query(nativeQuery = true, value=" SELECT * FROM tbl_entidades WHERE estado=1 and tipo LIKE %:tipoEntidad% ")
    public List<Entidades> listarByTipoEntidadesActivas(String tipoEntidad);
    
}
