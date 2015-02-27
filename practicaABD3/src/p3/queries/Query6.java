package p3.queries;
import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import com.db4o.query.Query;

import p3.Decididor;
import p3.model.Fecha;
import p3.model.Jugador;

public class Query6 extends SingleValueQuery<Fecha> {

	@Override
	@Consulta(
			numero = 6,
			enunciado = "Fecha de nacimiento del jugador que tiene la cadena \"DAVID VILLA\" en su camiseta",
			tipo = "SODA"
			)
	public Fecha ejecutar() {
		Query q = db.query();
		q.constrain(Jugador.class);
		q.descend("nombreCamiseta").constrain("DAVID VILLA").equal();
		
		ObjectSet <Jugador> result = q.execute();
        Jugador jug = result.get(0);
        return jug.getFechaNacimiento();
	
	}

	
	
}
