package org.fundacionview.SGSST.servicios;

import java.util.List;
import java.util.Optional;

import org.fundacionview.SGSST.modelos.Empleados;
import org.fundacionview.SGSST.repositorios.RepositorioEmpleados;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImplementacionServicioEmpleados implements ServicioEmpleados{

    @Autowired
    private RepositorioEmpleados repositorio;

    @Override
    public List<Empleados> listarTodosLosEmpleados(){
        return repositorio.findAll();
    }
    
    @Override
    public Optional<Empleados> obtenerEmpleadoPorId(Long id){
        return repositorio.findById(id);
    }
    
    @Override
    public Empleados guardarEmpleado(Empleados empleado) {
    	return repositorio.save(empleado);
    }
    
    @Override
    public Empleados actualizarEmpleado(Empleados empleado) {
    	return repositorio.save(empleado);
    }
    
    @Override
    public void eliminarRealmenteEmpleado(Long id) {
    	//return repositorio.deleteById(id);
    }
    
    @Override
    public Optional<Empleados>  eliminarLogicamenteEmpleado(Long id){
    	Optional<Empleados> empleadoExistente = repositorio.findById((long) id);
		if (empleadoExistente.isPresent()) {
            empleadoExistente.get().setEstado(0);
		repositorio.save(empleadoExistente.get());
		return repositorio.findById(id);
		}
	return null;	
    }

	@Override
	public Optional<Empleados> restaurarLogicamenteEmpleado(Long id) {
		Optional<Empleados> empleadoExistente = repositorio.findById((long) id);
		if (empleadoExistente.isPresent()) {
            empleadoExistente.get().setEstado(1);
		repositorio.save(empleadoExistente.get());
		return repositorio.findById(id);
			
		}
		return null;
	}
}
