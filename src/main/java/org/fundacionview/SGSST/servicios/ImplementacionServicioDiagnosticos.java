package org.fundacionview.SGSST.servicios;

import java.util.List;
import java.util.Optional;

import org.fundacionview.SGSST.modelos.Diagnosticos;
import org.fundacionview.SGSST.repositorios.RepositorioDiagnosticos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImplementacionServicioDiagnosticos implements ServicioDiagnosticos{

    @Autowired
    private RepositorioDiagnosticos repositorio;

    @Override
    public List<Diagnosticos> listarDiagnosticos(){
        return repositorio.findAll();
    }

    @Override
    public Optional<Diagnosticos> obtenerDiagnosticoPorId(Long id){
        return repositorio.findById(id);
    }
    
    // @Override
    // public Diagnosticos guardarDiagnostico(Diagnosticos Diagnostico) {
    // 	return repositorio.save(Diagnostico);
    // }
    
    // @Override
    // public Diagnosticos actualizarDiagnostico(Diagnosticos Diagnostico) {
    // 	return repositorio.save(Diagnostico);
    // }
    
}
