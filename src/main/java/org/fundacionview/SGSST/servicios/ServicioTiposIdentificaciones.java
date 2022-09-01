package org.fundacionview.SGSST.servicios;

import java.util.List;
import java.util.Optional;

import org.fundacionview.SGSST.modelos.TiposIdentificaciones;

public interface ServicioTiposIdentificaciones{

    public List<TiposIdentificaciones> listarTiposIdentificaciones();

    public Optional<TiposIdentificaciones> obtenerTipoIdentificacionPorId(Integer id);

    public Optional<TiposIdentificaciones> listarTiposIdentificacionesActivas();
    
    public TiposIdentificaciones guardarTipoIdentificacion(TiposIdentificaciones TipoIdentificacion);
        
    public TiposIdentificaciones actualizarTipoIdentificacion(TiposIdentificaciones TipoIdentificacion);
    
    public void eliminarRealmenteTipoIdentificacion(Integer id);
    
    public Optional<TiposIdentificaciones> eliminarLogicamenteTipoIdentificacion(Integer id);
    
    public Optional<TiposIdentificaciones> restaurarLogicamenteTipoIdentificacion(Integer id);
    
}
