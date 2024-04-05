package dao;

import bean.Empleado;
import db.Db;

public class EmpleadoDAO {
	Db db = new Db("planilla");
	//Db db = new Db("srv1101.hstgr.io","3306","u584908256_planillas", "Senati2023@", "u584908256_planillas");

	public boolean Login(Empleado empleado) {
		db.Sentencia( String.format("call sp_getEmpleadoLogin('%s','%s')", empleado.getDni(), empleado.getPassword() ) );
		empleado.setRegistro( db.getRegistro() );
		return empleado.getId() > 0;
	}

}