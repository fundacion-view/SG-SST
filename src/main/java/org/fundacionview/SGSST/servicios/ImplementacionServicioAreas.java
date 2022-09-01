package org.fundacionview.SGSST.servicios;

import java.util.List;
import java.util.Optional;

import org.fundacionview.SGSST.modelos.Areas;
import org.fundacionview.SGSST.repositorios.RepositorioAreas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImplementacionServicioAreas implements ServicioAreas{

    @Autowired
    private RepositorioAreas repositorio;

    @Override
    public List<Areas> listarAreas(){
        return repositorio.findAll();
    }

    @Override
    public List<Areas> listarAreasActivas(){
       return repositorio.listarAreasActivas();
    }

    @Override
    public Optional<Areas> obtenerAreaPorId(Long id){
        return repositorio.findById(id);
    }
    
    @Override
    public Areas guardarArea(Areas Area) {
        Area.setEstado(1);
    	return repositorio.save(Area);
    }
    
    @Override
    public Areas actualizarArea(Areas Area) {
    	return repositorio.save(Area);
    }
    
    @Override
    public void eliminarRealmenteArea(Long id) {
    	//return repositorio.deleteById(id);
    }
    
    @Override
    public Optional<Areas>  eliminarLogicamenteArea(Long id){
    	Optional<Areas> AreaExistente = repositorio.findById(id);
		if (AreaExistente.isPresent()) {
			AreaExistente.get().setEstado(0);
		repositorio.save(AreaExistente.get());
		return repositorio.findById(id);
		}
        return null;
    }

	@Override
	public Optional<Areas> restaurarLogicamenteArea(Long id) {
		Optional<Areas> AreaExistente = repositorio.findById(id);
		if (AreaExistente.isPresent()) {
			AreaExistente.get().setEstado(1);
		repositorio.save(AreaExistente.get());
		return repositorio.findById(id);
		}
        return null;
	}

}
