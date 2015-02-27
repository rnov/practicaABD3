package p3.queries;

import java.util.List;

import com.db4o.ObjectSet;
import com.db4o.query.Predicate;

import p3.model.Equipo;
import p3.model.Partido;

public class Query4 extends CollectionQuery<Partido> {

	@Override
	@Consulta(
			numero = 4,
			enunciado = "Partidos en los que la diferencia de puntuación (sin contar prorroga ni penaltis) entre el ganador y el perdedor es de tres goles o más",
			tipo = "Consultas nativas (clase Predicate<T>)"
			)
	public List<Partido> ejecutar() {
		ObjectSet<Partido> result =
				db.query(new Predicate<Partido>() {
					public boolean match(Partido par) {
						return ( (par.getResultado().getEquipo1() - par.getResultado().getEquipo2())>=3 ||
								
									(par.getResultado().getEquipo2() - par.getResultado().getEquipo1())>=3 );
					}
				});
		
		
		
		
		return result;
	}

}
