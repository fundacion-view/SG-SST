package org.fundacionview.SGSST.servicios;

import java.util.List;
import java.util.Optional;

import org.fundacionview.SGSST.modelos.Ausentismos;
import org.fundacionview.SGSST.repositorios.RepositorioAusentismos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImplementacionServicioAusentismos implements ServicioAusentismos{

    @Autowired
    private RepositorioAusentismos repositorio;

    @Override
    public List<Ausentismos> listarTodosLosAusentismos(){
        return repositorio.findAll();
    }
    
    @Override
    public Optional<Ausentismos> obtenerAusentismoPorId(Long id){
        return repositorio.findById(id);
    }
    
    @Override
    public Ausentismos guardarAusentismo(Ausentismos ausentismo) {
        ausentismo.setEstado(1);
    	return repositorio.save(ausentismo);
    }
    
    @Override
    public Ausentismos actualizarAusentismo(Ausentismos ausentismo) {
    	return repositorio.save(ausentismo);
    }
    
    @Override
    public void eliminarRealmenteAusentismo(Long id) {
    	//return repositorio.deleteById(id);
    }
    
    @Override
    public Optional<Ausentismos>  eliminarLogicamenteAusentismo(Long id){
    	Optional<Ausentismos> ausentismoExistente = repositorio.findById((long) id);
		if (ausentismoExistente.isPresent()) {
            ausentismoExistente.get().setEstado(0);
		repositorio.save(ausentismoExistente.get());
		return repositorio.findById(id);
		}
		return null;
    }

	@Override
	public Optional<Ausentismos> restaurarLogicamenteAusentismo(Long id) {
		Optional<Ausentismos> ausentismoExistente = repositorio.findById((long) id);
		if (ausentismoExistente.isPresent()) {
			ausentismoExistente.get().setEstado(1);
		repositorio.save(ausentismoExistente.get());
		return repositorio.findById(id);
		}
        return null;
		
	}
}
