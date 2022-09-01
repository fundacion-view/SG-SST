package org.fundacionview.SGSST.repositorios;

import java.util.List;

import org.fundacionview.SGSST.modelos.Ausentismos;
import org.fundacionview.SGSST.modelos.Empleados;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioAusentismos extends JpaRepository<Ausentismos, Long>  {

   
    @Query(nativeQuery = true, value=" SELECT * FROM tbl_ausentismos WHERE area =:area ")
    public List<Ausentismos> ausentismosPorArea(Long area);

    //List<Ausentismos> findByTipo(String tipo);

    @Query(nativeQuery = true, value=" SELECT * FROM tbl_ausentismos WHERE tipoincapacidad =:tipo ")
    public List<Ausentismos> ausentismosPorTipoIncapacidad(String tipo);

    @Query(nativeQuery = true, value=" SELECT * FROM tbl_ausentismos WHERE codempleado =:empleado ")
    public List<Ausentismos> ausentismosPorEmpleado(Empleados empleado);


}
