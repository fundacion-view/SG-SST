package org.fundacionview.SGSST.controladores;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.fundacionview.SGSST.Utilidades.Utilidades;
import org.fundacionview.SGSST.modelos.Ausentismos;
import org.fundacionview.SGSST.repositorios.RepositorioAusentismos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ReportesControlador {

	Utilidades libreriaUtilidades = new Utilidades();

	@Autowired
	private RepositorioAusentismos repositorioAusentismos;

	@GetMapping({ "/reportes" })
	public String listarAusentismos(Model modelo) {

		List<Object> datosReporte = new ArrayList<>();

		for (Ausentismos str : repositorioAusentismos.ausentismosPorTipoIncapacidad("EG")) {
			// Creating HashMap
			HashMap<String, Object> reporteTemp = new HashMap<String, Object>();
			reporteTemp.put("identificacion", str.getEmpleados().getTiposIdentificaciones().getPrefijo() + " - "
					+ str.getEmpleados().getIdentificacion());
			reporteTemp.put("empleado", str.getEmpleados().getNombres() + " " + str.getEmpleados().getApellidos());
			reporteTemp.put("area", str.getAreas().getNombre());
			reporteTemp.put("cargo", str.getCargo());
			// NumberFormat formatoNumero = NumberFormat.getNumberInstance();
			// DecimalFormat formatoDecimal = new DecimalFormat("#,###.00");
			DecimalFormat formatoDecimal2 = new DecimalFormat("####.00");
			reporteTemp.put("salario", "" + formatoDecimal2.format(str.getSalario()));
			reporteTemp.put("salarioPorDia",
					"" + formatoDecimal2.format(libreriaUtilidades.SalarioPorDia(str.getSalario())));
			reporteTemp.put("eps", str.getEntidadesEps().getNombre());
			reporteTemp.put("afp", str.getEntidadesAfp().getNombre());
			reporteTemp.put("arl", str.getEntidadesArl().getNombre());
			reporteTemp.put("tipoIncapacidad", str.getTipoincapacidad());
			reporteTemp.put("clasificacion", str.getClasificacion());
			reporteTemp.put("diagnostico",
					str.getDiagnosticos().getCodigo() + " - " + str.getDiagnosticos().getDiagnostico());
			reporteTemp.put("fechaInicio", str.getFechainicio());
			reporteTemp.put("fechaFin", str.getFechafin());
			reporteTemp.put("duracion", "" + libreriaUtilidades.RestarFechas(str.getFechainicio(), str.getFechafin()));
			reporteTemp.put("valorIncapacidad", libreriaUtilidades.CalcularIncapacidad(str.getSalario(),str.getTipoincapacidad().toUpperCase(), str.getClasificacion().toUpperCase(), str.getFechainicio(), str.getFechafin()).get(0));
			reporteTemp.put("valorAsumidoPorEmpresa", "Por calcular");
			reporteTemp.put("valorAsumidoPorEps", "Por calcular");
			reporteTemp.put("valorAsumidoPorAfp", "Por calcular");
			reporteTemp.put("valorAsumidoPorArl", "Por calcular");
			reporteTemp.put("estado", "" + str.getEstado());

			datosReporte.add(reporteTemp);
		}

		modelo.addAttribute("ausentismos", repositorioAusentismos.ausentismosPorTipoIncapacidad("ORIGEN COMUN"));
		modelo.addAttribute("datosReporte", datosReporte);
		return "/reportes/index";

	}

	/*
	 * // crear
	 * 
	 * @GetMapping({ "/ausentismos/nuevo", "/ausentismos/crear" }) public String
	 * mostrarFormularioRegistro(Model modelo) { Ausentismos ausentismo = new
	 * Ausentismos(); modelo.addAttribute("ausentismo", ausentismo);
	 * modelo.addAttribute("diagnosticos", diagnosticos.listarDiagnosticos());
	 * modelo.addAttribute("empleados", empleados.listarTodosLosEmpleados());
	 * modelo.addAttribute("areas", areas.listarAreas());
	 * modelo.addAttribute("listaEps", entidades.listarEntidadesEps());
	 * modelo.addAttribute("listaAfp", entidades.listarEntidadesAfp());
	 * modelo.addAttribute("listaArl", entidades.listarEntidadesArl()); return
	 * "/ausentismos/crear_ausentismo"; }
	 * 
	 * 
	 * @PostMapping("/ausentismos") public String
	 * guardarAusentismo(@ModelAttribute("ausentismo") Ausentismos ausentismo) {
	 * servicio.guardarAusentismo(ausentismo); return "redirect:/ausentismos"; }
	 * 
	 * // actualizar
	 * 
	 * @GetMapping({ "/ausentismos/actualizar/{id}", "/ausentismos/modificar/{id}"
	 * }) public String mostrarFormularioEdicion(@PathVariable Long id, Model
	 * modelo) { modelo.addAttribute("ausentismo",
	 * servicio.obtenerAusentismoPorId(id)); modelo.addAttribute("diagnosticos",
	 * diagnosticos.listarDiagnosticos()); modelo.addAttribute("empleados",
	 * empleados.listarTodosLosEmpleados()); modelo.addAttribute("areas",
	 * areas.listarAreas()); modelo.addAttribute("listaEps",
	 * entidades.listarEntidadesEps()); modelo.addAttribute("listaAfp",
	 * entidades.listarEntidadesAfp()); modelo.addAttribute("listaArl",
	 * entidades.listarEntidadesArl());
	 * 
	 * Optional<Ausentismos> ausentismoExistente =
	 * servicio.obtenerAusentismoPorId((long) id);
	 * 
	 * if (ausentismoExistente.isEmpty()) { return "redirect:/ausentismos"; }else{
	 * modelo.addAttribute("salarioxdia",
	 * SalarioByDia(ausentismoExistente.get().getSalario()));
	 * modelo.addAttribute("totalDiasIncapacidad",
	 * RestarFechas(ausentismoExistente.get().getFechainicio(),
	 * ausentismoExistente.get().getFechafin())); } return
	 * "/ausentismos/editar_ausentismo"; }
	 * 
	 * @PostMapping({"/ausentismos/{id}"}) public String
	 * actualizarAusentismo(@ModelAttribute("ausentismo") Ausentismos ausentismo,
	 * Model modelo) { Optional<Ausentismos> ausentismoExistente =
	 * servicio.obtenerAusentismoPorId((long) ausentismo.getConsecutivo());
	 * //ausentismoExistente.get().setCodigo(id);
	 * ausentismoExistente.get().setSalario(ausentismo.getSalario());
	 * ausentismoExistente.get().setCargo(ausentismo.getCargo());
	 * ausentismoExistente.get().setEntidadesEps(ausentismo.getEntidadesEps());
	 * ausentismoExistente.get().setEntidadesAfp(ausentismo.getEntidadesAfp());
	 * ausentismoExistente.get().setEntidadesArl(ausentismo.getEntidadesArl());
	 * //ausentismoExistente.get().setEstado(ausentismo.getEstado());
	 * 
	 * servicio.actualizarAusentismo(ausentismoExistente.get()); return
	 * "redirect:/ausentismos"; }
	 * 
	 * // eliminar logicamente
	 * 
	 * @GetMapping({ "/ausentismos/eliminar/{id}", "/ausentismos/borrar/{id}" })
	 * public String eliminarLogicamenteAusentismo(@PathVariable Long id) {
	 * Optional<Ausentismos> ausentismoExistente =
	 * servicio.obtenerAusentismoPorId((long) id); if
	 * (ausentismoExistente.isEmpty()) { return "redirect:/ausentismos"; }
	 * //servicio.eliminarRealmenteAusentismo(id);
	 * servicio.eliminarLogicamenteAusentismo((long) id); return
	 * "redirect:/ausentismos"; }
	 * 
	 * // Restaurar logicamente
	 * 
	 * @GetMapping({ "/ausentismos/restaurar/{id}", "/ausentismos/habilitar/{id}" })
	 * public String restaurarLogicamenteAusentismo(@PathVariable Long id) {
	 * Optional<Ausentismos> ausentismoExistente =
	 * servicio.obtenerAusentismoPorId((long) id); if
	 * (ausentismoExistente.isEmpty()) { return "redirect:/ausentismos"; }
	 * //servicio.eliminarRealmenteAusentismo(id);
	 * servicio.restaurarLogicamenteAusentismo((long) id); return
	 * "redirect:/ausentismos"; }
	 * 
	 * public Double SalarioByDia (Double salario) { return salario/30; }
	 * 
	 * public Long RestarFechas (String fechaInicial, String FechaFinal) { LocalDate
	 * d1 = LocalDate.parse(fechaInicial, DateTimeFormatter.ISO_LOCAL_DATE);
	 * LocalDate d2 = LocalDate.parse(FechaFinal, DateTimeFormatter.ISO_LOCAL_DATE);
	 * 
	 * Duration diff = Duration.between(d1.atStartOfDay(), d2.atStartOfDay());
	 * Period period = Period.between(d1, d2);
	 * 
	 * long diffDays = diff.toDays(); int years = Math.abs(period.getYears()); int
	 * months = Math.abs(period.getMonths()); int days = Math.abs(period.getDays());
	 * System.out.println("La diferencia entre fechas es : "+(diffDays + 1)+
	 * "dias"); System.out.println("Diferencia : "+years+" años, "+months+" meses, "
	 * +days+" dias");
	 * 
	 * return (diffDays+1); }
	 * 
	 */
}
