package org.fundacionview.SGSST.servicios;

import java.util.List;
import java.util.Optional;

import org.fundacionview.SGSST.modelos.SalariosMinimos;
import org.fundacionview.SGSST.repositorios.RepositorioSalariosMinimos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImplementacionServicioSalariosMinimos implements ServicioSalariosMinimos{

    @Autowired
    private RepositorioSalariosMinimos repositorio;

    @Override
    public List<SalariosMinimos> listarSalariosMinimos(){
        return repositorio.findAll();
    }
    
    @Override
    public Optional<SalariosMinimos> obtenerSalarioMinimoPorId(Integer id){
        return repositorio.findById(id);
    }

    @Override
    public Optional<SalariosMinimos> obtenerSalarioMinimoPorYear(Integer valor){
        return repositorio.findByValor(valor);
    }
    
    @Override
    public SalariosMinimos guardarSalarioMinimo(SalariosMinimos SalarioMinimo) {
    	return repositorio.save(SalarioMinimo);
    }
    
    @Override
    public SalariosMinimos actualizarSalarioMinimo(SalariosMinimos SalarioMinimo) {
    	return repositorio.save(SalarioMinimo);
    }
        
}
