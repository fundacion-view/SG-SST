package org.fundacionview.SGSST.repositorios;

import org.fundacionview.SGSST.modelos.TiposIdentificaciones;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioTiposIndentificaciones extends JpaRepository<TiposIdentificaciones, Integer>  {

}
