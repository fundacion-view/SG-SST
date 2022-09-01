package org.fundacionview.SGSST.servicios;

import java.util.List;
import java.util.Optional;

import org.fundacionview.SGSST.modelos.Entidades;
import org.fundacionview.SGSST.repositorios.RepositorioEntidades;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImplementacionServicioEntidades implements ServicioEntidades{

    @Autowired
    private RepositorioEntidades repositorio;

    @Override
    public List<Entidades> listarTodasLasEntidades(){
        return repositorio.findAll();
    }

    @Override
    public List<Entidades> listarEntidadesEps() {
        //return repositorio.listarPorTipoEntidad("EPS");
        return repositorio.findByTipo("EPS");
    }

    @Override
    public List<Entidades> listarEpsActivas() {
        //return repositorio.listarPorTipoEntidad("AFP");
        return repositorio.listarByTipoEntidadesActivas("EPS");
    }

    @Override
    public List<Entidades> listarEntidadesAfp() {
        //return repositorio.listarPorTipoEntidad("AFP");
        return repositorio.findByTipo("AFP");
    }

    @Override
    public List<Entidades> listarAfpActivas() {
        //return repositorio.listarPorTipoEntidad("AFP");
        return repositorio.listarByTipoEntidadesActivas("AFP");
    }

    @Override
    public List<Entidades> listarEntidadesArl() {
        //return repositorio.listarPorTipoEntidad("ARL");
        return repositorio.findByTipo("ARL");
    }

    @Override
    public List<Entidades> listarArlActivas() {
        //return repositorio.listarPorTipoEntidad("AFP");
        return repositorio.listarByTipoEntidadesActivas("ARL");
    }
    
    @Override
    public Optional<Entidades> obtenerEntidadPorId(Long id){
        return repositorio.findById(id);
    }
    
    @Override
    public Entidades guardarEntidad(Entidades entidad) {
    	return repositorio.save(entidad);
    }
    
    @Override
    public Entidades actualizarEntidad(Entidades entidad) {
    	return repositorio.save(entidad);
    }
    
    @Override
    public void eliminarRealmenteEntidad(Long id) {
    	//return repositorio.deleteById(id);
    }
    
    @Override
    public Optional<Entidades>  eliminarLogicamenteEntidad(Long id){
    	Optional<Entidades> entidadExistente = repositorio.findById((long) id);
		if (entidadExistente.isPresent()) {
            entidadExistente.get().setEstado(0);
		repositorio.save(entidadExistente.get());
		return repositorio.findById(id);
			
		}
		return null;
    }

	@Override
	public Optional<Entidades> restaurarLogicamenteEntidad(Long id) {
		Optional<Entidades> entidadExistente = repositorio.findById((long) id);
		if (entidadExistente.isPresent()) {
			entidadExistente.get().setEstado(1);
		repositorio.save(entidadExistente.get());
		return repositorio.findById(id);
		}
        return null;
		
	}

}
