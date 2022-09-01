package org.fundacionview.SGSST.servicios;

import java.util.List;
import java.util.Optional;

import org.fundacionview.SGSST.modelos.SalariosMinimos;

public interface ServicioSalariosMinimos{

    public List<SalariosMinimos> listarSalariosMinimos();

    public Optional<SalariosMinimos> obtenerSalarioMinimoPorId(Integer id);

    public Optional<SalariosMinimos> obtenerSalarioMinimoPorYear(Integer anho);
    
    public SalariosMinimos guardarSalarioMinimo(SalariosMinimos salarioMinimo);
       
    public SalariosMinimos actualizarSalarioMinimo(SalariosMinimos salarioMinimo);

}
