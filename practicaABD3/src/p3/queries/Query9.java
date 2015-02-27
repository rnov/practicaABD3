package p3.queries;

import java.util.List;

import com.db4o.ObjectSet;
import com.db4o.query.Query;

import p3.model.Equipo;
import p3.model.Jugador;

public class Query9 extends CollectionQuery<Equipo> {

	@Override
	@Consulta(
			numero = 9,
			enunciado = "Equipos que contengan algún jugador que mida dos metros o más",
			tipo = "SODA"
			)
	public List<Equipo> ejecutar() {
		
		Query q = db.query();
		q.constrain(Equipo.class);
		
		q.descend("jugadores").descend("altura").constrain(200).equal().greater();//200 > cm !!
		
		ObjectSet <Equipo> result = q.execute();
		
		return result;
		
		
		
		
		
	}

}
