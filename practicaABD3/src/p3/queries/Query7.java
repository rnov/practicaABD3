package p3.queries;

import com.db4o.ObjectSet;
import com.db4o.query.Query;

import p3.model.Jugador;

public class Query7 extends SingleValueQuery<Jugador> {

	@Override
	@Consulta(
			numero = 7,
			enunciado = "Jugador cuyo apellido acaba con la cadena \"COCA\". Consulta el método endsWith() en la documentación de db4o",
			tipo = "SODA"
			)
	public Jugador ejecutar() {
		Query q = db.query();
		q.constrain(Jugador.class);
		q.descend("apellido").constrain("COCA").endsWith(true);
		
		ObjectSet <Jugador> result = q.execute();
        Jugador jug = result.get(0);
        return jug;
	}

}
