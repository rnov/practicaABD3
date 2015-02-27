package p3.queries;

import java.util.List;

import com.db4o.ObjectSet;

import p3.model.Estadio;
import p3.model.Fecha;
import p3.model.Partido;
import p3.model.Resultado;
import p3.model.ResultadoProrroga;

public class Query2 extends CollectionQuery<Partido> {

	@Override
	@Consulta(
			numero = 2,
			enunciado = "Partidos que tuvieron prórroga (independientemente de que luego hubiese fase de penaltis)",
			tipo = "QBE"
			)
		public List<Partido> ejecutar() {
			
			Partido par = new Partido();
			
			ResultadoProrroga res =new ResultadoProrroga(0,0,0,0);
			par.setResultado(res);
			
			ObjectSet<Partido> result = db.queryByExample(par);
			

			return result;

	}
}