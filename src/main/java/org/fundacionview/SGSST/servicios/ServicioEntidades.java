package org.fundacionview.SGSST.servicios;

import java.util.List;
import java.util.Optional;

import org.fundacionview.SGSST.modelos.Entidades;

public interface ServicioEntidades{

    public List<Entidades> listarTodasLasEntidades();

    public List<Entidades> listarEntidadesEps();

    public List<Entidades> listarEpsActivas();

    public List<Entidades> listarEntidadesAfp();

    public List<Entidades> listarAfpActivas();

    public List<Entidades> listarEntidadesArl();

    public List<Entidades> listarArlActivas();
    
    public Entidades guardarEntidad(Entidades entidad);
    
    public Optional<Entidades> obtenerEntidadPorId(Long id);
    
    public Entidades actualizarEntidad(Entidades entidad);
    
    public void eliminarRealmenteEntidad(Long id);
    
    public Optional<Entidades> eliminarLogicamenteEntidad(Long id);
    
    public Optional<Entidades> restaurarLogicamenteEntidad(Long id);
    
}
