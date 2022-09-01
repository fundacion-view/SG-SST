package org.fundacionview.SGSST.servicios;

import java.util.List;
import java.util.Optional;

import org.fundacionview.SGSST.modelos.Empleados;

public interface ServicioEmpleados{

    public List<Empleados> listarTodosLosEmpleados();
    
    public Empleados guardarEmpleado(Empleados empleado);
    
    public Optional<Empleados> obtenerEmpleadoPorId(Long id);
    
    public Empleados actualizarEmpleado(Empleados empleado);
    
    public void eliminarRealmenteEmpleado(Long id);
    
    public Optional<Empleados> eliminarLogicamenteEmpleado(Long id);
    
    public Optional<Empleados> restaurarLogicamenteEmpleado(Long id);
    

}
