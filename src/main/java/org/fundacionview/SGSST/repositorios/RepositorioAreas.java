package org.fundacionview.SGSST.repositorios;

import java.util.List;

import org.fundacionview.SGSST.modelos.Areas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioAreas extends JpaRepository<Areas, Long>  {
    
    @Query(nativeQuery = true, value=" SELECT * FROM tbl_areas WHERE estado=1 ")
    public List<Areas> listarAreasActivas();

}
