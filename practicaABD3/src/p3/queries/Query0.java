package p3.queries;

import java.util.List;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;

import p3.model.Equipo;
import p3.model.Hora;
import p3.model.Partido;
import p3.model.TipoPartido;

public class Query0 extends CollectionQuery<Partido> {

	@Override
	@Consulta(
			numero = 0,
			enunciado = "Partidos de primera fase en los que españa (Spain) ha jugado a las 20:30",
			tipo = "QBE"
			)
	public List<Partido> ejecutar() {
		//ObjectContainer db =
				//Db4oEmbedded.openFile("mundial2010.db4o");
		
		Partido par = new Partido();
		Hora hora = new Hora(20,30);
		par.setHora(hora);//20.30
		par.setTipo(TipoPartido.PRIMERA_FASE);
		
		Equipo equi =new Equipo("Spain",null,null);
		//Equipo equi2 =new Equipo("","",null);
		Equipo[] equipos= {equi,null};
		
		par.setEquipos(equipos);
		
		ObjectSet<Partido> result = db.queryByExample(par);
		
		
		
		return result;
	}

}
