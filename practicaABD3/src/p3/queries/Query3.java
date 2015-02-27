package p3.queries;

import java.util.List;

import com.db4o.ObjectSet;
import com.db4o.query.Predicate;

import p3.model.Jugador;

public class Query3 extends CollectionQuery<Jugador> {

	@Override
	@Consulta(
			numero = 3,
			enunciado = "Jugadores del Chelsea (Chelsea (ENG)) nacidos entre 1980 y 1989 (inclusive)",
			tipo = "Consultas nativas (clase Predicate<T>)"
			)
	public List<Jugador> ejecutar() {
		ObjectSet<Jugador> result = db.query(new Predicate<Jugador>(){
					
					public boolean match(Jugador jug) {
						return ( jug.getClub().equals("Chelsea (ENG)")  && (jug.getFechaNacimiento().getAnyo() >= 1980
								&& jug.getFechaNacimiento().getAnyo() <=1989)
								);
							}
				});
		return result;
	}

}
