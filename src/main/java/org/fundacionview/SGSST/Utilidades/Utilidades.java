package org.fundacionview.SGSST.Utilidades;

import java.text.DecimalFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class Utilidades {

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	//NumberFormat formatoNumero = NumberFormat.getNumberInstance();
	//DecimalFormat formatoDecimal = new DecimalFormat("#,###.00");
	DecimalFormat formatoDecimal2 = new DecimalFormat("####.00");

	
	public String Codificar(String dato) 
    {
        return passwordEncoder.encode(dato);
    }

	public Double SalarioPorDia (Double salario)
	{
		return salario/30;
	}

	public Long RestarFechas (String fechaInicial, String fechaFinal)
	{
		LocalDate d1 = LocalDate.parse(fechaInicial, DateTimeFormatter.ISO_LOCAL_DATE);
        LocalDate d2 = LocalDate.parse(fechaFinal, DateTimeFormatter.ISO_LOCAL_DATE);

		Duration diff = Duration.between(d1.atStartOfDay(), d2.atStartOfDay());
        Period period = Period.between(d1, d2);

		long diffDays = diff.toDays();
        int years = Math.abs(period.getYears());
        int months = Math.abs(period.getMonths());
        int days = Math.abs(period.getDays());
        System.out.println("La diferencia entre fechas es : "+(diffDays + 1)+ "dias");
        System.out.println("Diferencia : "+years+" años, "+months+" meses, "+days+" dias");
		return (diffDays+1);
	}

	public List CalcularIncapacidad (Double salarioEmpleado, String tipoIncapacidad, String clasificacion, String fechaInicial, String fechaFinal)
	{
		Double valorEmpresa = 0.0;
		Double valorEps = 0.0;
		Double valorAfp = 0.0;
		Double valorArl = 0.0;
		Double valorAfpOrEps = 0.0;
		String nota181To540="";
		String notaFrom541="";

		Double salarioDia = SalarioPorDia(salarioEmpleado);

		long duracion = RestarFechas(fechaInicial, fechaFinal);
		List<Object> datosCalculo = new ArrayList<>();
		
		// Creating HashMap
		HashMap<String, String> calculo	= new HashMap<String, String>();

		System.out.println(":::::::::::::: CALCULOS INCAPACIDAD :::::::::::::::");
		switch (tipoIncapacidad.toUpperCase())
		{
            case "ORIGEN COMUN" : 
			{
				System.out.println("ORIGEN COMUN");
				if(duracion>=1 && duracion<=180)
				{
					if(clasificacion.toString().toUpperCase() == "PRORROGA")
					{
						System.out.println("PRORROGA");
						valorEps=(duracion*salarioDia)*0.6667;
					}
					else
					{
						System.out.println("INICIO");
						if(duracion<3)
						{
							valorEmpresa=2*salarioDia;
						}
						else
						{
							valorEps=((duracion-2)*salarioDia)*0.6667;
						}
					}
				}
				else if (duracion>=181 && duracion<=540)
				{
					valorAfp=((duracion-180)*salarioDia)*0.5;
					nota181To540="Los paga el fondo de pensión siempre que la EPS haya remitido al fondo de pensión el concepto de rehabilitación, pues si no lo hace, la EPS debe pagar esas incapacidades.";
				}
				else
				{
					valorAfpOrEps=((duracion-540)*salarioDia)*0.5;
					notaFrom541="";
				}
                break;
            }

            case "ACCIDENTE DE TRABAJO":
			{
				System.out.println("ACCIDENTE DE TRABAJO");
				valorArl=duracion*salarioDia;
                break;
            }

            case "ENFERMEDAD LABORAL":
			{
                System.out.println("ENFERMEDAD LABORAL");
				valorArl=duracion*salarioDia;
                break;
            }

			case "LICENCIA DE MATERNIDAD":
			{
				System.out.println("LICENCIA DE MATERNIDAD");
				//Antes 14, ahora de 16 a 18 semanas
                //valorEps=duracion*salarioDia;
				valorEps=120*salarioDia;
                break;
            }

			case "LICENCIA DE PATERNIDAD":
			{
				System.out.println("LICENCIA DE PATERNIDAD");
				//14 dias calendario
				//valorEps=duracion*salarioDia;
				valorEps=14*salarioDia;
                break;
            }

			case "ACCIDENTE DE TRANSITO":
			{
				System.out.println("ACCIDENTE DE TRANSITO");
				if(duracion<3)
				{
					valorEmpresa=2*salarioDia;
				}
				else
				{
					valorEps=((duracion-2)*salarioDia)*0.6667;
				}
                break;
            }

			case "FP":
			{
                break;
            }

            default: 
			{
                System.out.println("Opcion incorrecta");
            }
      }

		calculo.put("valorEmpresa", ""+ formatoDecimal2.format(valorEmpresa));
		calculo.put("valorEps", ""+ formatoDecimal2.format(valorEps));
		calculo.put("valorArl", ""+ formatoDecimal2.format(valorArl));
		calculo.put("valorAfp", ""+ formatoDecimal2.format(valorAfp));
		calculo.put("valorAfpOrEps", ""+ formatoDecimal2.format(valorAfpOrEps));

		datosCalculo.add(calculo);
		return (datosCalculo);
	}

    
}
