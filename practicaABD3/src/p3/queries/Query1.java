package p3.queries;

import java.util.List;

import com.db4o.ObjectSet;

import p3.model.Equipo;
import p3.model.Estadio;
import p3.model.Fecha;
import p3.model.Hora;
import p3.model.Partido;
import p3.model.TipoPartido;

public class Query1 extends CollectionQuery<Partido> {

	@Override
	@Consulta(
			numero = 1,
			enunciado = "Partidos jugados en Johannesburgo (Johannesburg) durante el mes de Julio",
			tipo = "QBE"
			)
	public List<Partido> ejecutar() {
		
		Partido par = new Partido();
		
		Fecha fecha =new Fecha(0,7,2010);
		
		par.setFecha(fecha);
		
		Estadio est =new Estadio(null,"Johannesburg");
		par.setEstadio(est);
		
		ObjectSet<Partido> result = db.queryByExample(par);
		
		
		return result;
	}

}
