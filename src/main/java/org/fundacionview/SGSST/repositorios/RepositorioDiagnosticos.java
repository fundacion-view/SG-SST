package org.fundacionview.SGSST.repositorios;

import java.util.List;

//import java.util.List;

import org.fundacionview.SGSST.modelos.Diagnosticos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioDiagnosticos extends JpaRepository<Diagnosticos, Long>  {
    
    @Query(nativeQuery = true, value=" SELECT * FROM tbl_diagnosticos_cie10 WHERE codigo=:codigo ")
    public List<Diagnosticos> buscarDiagnosticoPorCodigo(String codigo);

}
