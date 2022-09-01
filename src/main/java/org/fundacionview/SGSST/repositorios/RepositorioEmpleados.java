package org.fundacionview.SGSST.repositorios;

import org.fundacionview.SGSST.modelos.Empleados;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioEmpleados extends JpaRepository<Empleados, Long>  {

}
