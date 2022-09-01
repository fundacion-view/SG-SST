package org.fundacionview.SGSST.servicios;

import java.util.List;
import java.util.Optional;

import org.fundacionview.SGSST.modelos.TiposIdentificaciones;
import org.fundacionview.SGSST.repositorios.RepositorioTiposIndentificaciones;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImplementacionServicioTiposIdentificaciones implements ServicioTiposIdentificaciones{

    @Autowired
    private RepositorioTiposIndentificaciones repositorio;

    @Override
    public List<TiposIdentificaciones> listarTiposIdentificaciones(){
        return repositorio.findAll();
    }

    @Override
    public Optional<TiposIdentificaciones> listarTiposIdentificacionesActivas(){
       // return repositorio.findAll();
       return Optional.empty();
    }

    @Override
    public Optional<TiposIdentificaciones> obtenerTipoIdentificacionPorId(Integer id){
        return repositorio.findById(id);
    }
    
    @Override
    public TiposIdentificaciones guardarTipoIdentificacion(TiposIdentificaciones tipoIdentificacion) {
        tipoIdentificacion.setEstado(1);
    	return repositorio.save(tipoIdentificacion);
    }
    
    @Override
    public TiposIdentificaciones actualizarTipoIdentificacion(TiposIdentificaciones tipoIdentificacion) {
    	return repositorio.save(tipoIdentificacion);
    }
    
    @Override
    public void eliminarRealmenteTipoIdentificacion(Integer id) {
    	//return repositorio.deleteById(id);
    }
    
    @Override
    public Optional<TiposIdentificaciones>  eliminarLogicamenteTipoIdentificacion(Integer id){
    	Optional<TiposIdentificaciones> tipoIdentificacionExistente = repositorio.findById(id);
		if (tipoIdentificacionExistente.isPresent()) {
            tipoIdentificacionExistente.get().setEstado(0);
		repositorio.save(tipoIdentificacionExistente.get());
		return repositorio.findById(id);
		}
		return null;
    }

	@Override
	public Optional<TiposIdentificaciones> restaurarLogicamenteTipoIdentificacion(Integer id) {
		Optional<TiposIdentificaciones> tipoIdentificacionExistente = repositorio.findById(id);
		if (tipoIdentificacionExistente.isPresent()) {
            tipoIdentificacionExistente.get().setEstado(1);
		repositorio.save(tipoIdentificacionExistente.get());
		return repositorio.findById(id);
		}
		return null;
	}

}
