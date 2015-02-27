package p3.queries;

import p3.model.Equipo;
import p3.model.Grupo;
import p3.model.Jugador;

import com.db4o.ObjectSet;
import com.db4o.query.Predicate;


public class Query5 extends SingleValueQuery<Character> {

	@Override
	@Consulta(
			numero = 5,
			enunciado = "Letra del grupo al que pertenece el equipo de Paraguay.",
			tipo = "Consultas nativas (clase Predicate<T>)"
			)
	public Character ejecutar() {
		
		ObjectSet<Equipo> result =
				db.query(new Predicate<Equipo>() {
					public boolean match(Equipo eq) {
						return (eq.getPais().equals("Paraguay"));
					}
				});
		Equipo equipo = result.get(0);
		char res= equipo.getGrupo().getLetra();
		
      
		
		
		
		return res;
	}

}
