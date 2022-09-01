package org.fundacionview.SGSST.servicios;

import java.util.List;
import java.util.Optional;

import org.fundacionview.SGSST.modelos.Diagnosticos;

public interface ServicioDiagnosticos{

    public List<Diagnosticos> listarDiagnosticos();

    public Optional<Diagnosticos> obtenerDiagnosticoPorId(Long id);

    // public Diagnosticos guardarDiagnostico(Diagnosticos Diagnostico);
        
    // public Diagnosticos actualizarDiagnostico(Diagnosticos Diagnostico);
        
}
