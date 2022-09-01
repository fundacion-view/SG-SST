package org.fundacionview.SGSST.servicios;

import java.util.List;
import java.util.Optional;

import org.fundacionview.SGSST.modelos.Ausentismos;

public interface ServicioAusentismos{

    public List<Ausentismos> listarTodosLosAusentismos();
    
    public Ausentismos guardarAusentismo(Ausentismos ausentismo);
    
    public Optional<Ausentismos> obtenerAusentismoPorId(Long id);
    
    public Ausentismos actualizarAusentismo(Ausentismos ausentismo);
    
    public void eliminarRealmenteAusentismo(Long id);
    
    public Optional<Ausentismos> eliminarLogicamenteAusentismo(Long id);
    
    public Optional<Ausentismos> restaurarLogicamenteAusentismo(Long id);
    
}
