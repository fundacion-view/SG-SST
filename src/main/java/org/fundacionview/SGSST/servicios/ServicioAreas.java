package org.fundacionview.SGSST.servicios;

import java.util.List;
import java.util.Optional;

import org.fundacionview.SGSST.modelos.Areas;

public interface ServicioAreas{

    public List<Areas> listarAreas();

    public Optional<Areas> obtenerAreaPorId(Long id);

    public List<Areas> listarAreasActivas();
    
    public Areas guardarArea(Areas Area);
        
    public Areas actualizarArea(Areas Area);
    
    public void eliminarRealmenteArea(Long id);
    
    public Optional<Areas> eliminarLogicamenteArea(Long id);
    
    public Optional<Areas> restaurarLogicamenteArea(Long id);
    
}
