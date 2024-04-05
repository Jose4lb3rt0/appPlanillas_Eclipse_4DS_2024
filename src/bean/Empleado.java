package bean;

public class Empleado {
	int id, idDomiciliado, idEstadoCivil, idNivelEducativo;
	int idDepartamento, idProvincia, idDistrito;
	String Dni, Ruc, Nombres, ApellidoPaterno, ApellidoMaterno;
	String FechaNacimiento, Direccion, Correo, Celular, Password;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdDomiciliado() {
		return idDomiciliado;
	}

	public void setIdDomiciliado(int idDomiciliado) {
		this.idDomiciliado = idDomiciliado;
	}

	public int getIdEstadoCivil() {
		return idEstadoCivil;
	}

	public void setIdEstadoCivil(int idEstadoCivil) {
		this.idEstadoCivil = idEstadoCivil;
	}

	public int getIdNivelEducativo() {
		return idNivelEducativo;
	}

	public void setIdNivelEducativo(int idNivelEducativo) {
		this.idNivelEducativo = idNivelEducativo;
	}

	public int getIdDepartamento() {
		return idDepartamento;
	}

	public void setIdDepartamento(int idDepartamento) {
		this.idDepartamento = idDepartamento;
	}

	public int getIdProvincia() {
		return idProvincia;
	}

	public void setIdProvincia(int idProvincia) {
		this.idProvincia = idProvincia;
	}

	public int getIdDistrito() {
		return idDistrito;
	}

	public void setIdDistrito(int idDistrito) {
		this.idDistrito = idDistrito;
	}

	public String getDni() {
		return Dni;
	}

	public void setDni(String dni) {
		Dni = dni;
	}

	public String getRuc() {
		return Ruc;
	}

	public void setRuc(String ruc) {
		Ruc = ruc;
	}

	public String getNombres() {
		return Nombres;
	}

	public void setNombres(String nombres) {
		Nombres = nombres;
	}

	public String getApellidoPaterno() {
		return ApellidoPaterno;
	}

	public void setApellidoPaterno(String apellidoPaterno) {
		ApellidoPaterno = apellidoPaterno;
	}

	public String getApellidoMaterno() {
		return ApellidoMaterno;
	}

	public void setApellidoMaterno(String apellidoMaterno) {
		ApellidoMaterno = apellidoMaterno;
	}

	public String getFechaNacimiento() {
		return FechaNacimiento;
	}

	public void setFechaNacimiento(String fechaNacimiento) {
		FechaNacimiento = fechaNacimiento;
	}

	public String getDireccion() {
		return Direccion;
	}

	public void setDireccion(String direccion) {
		Direccion = direccion;
	}

	public String getCorreo() {
		return Correo;
	}

	public void setCorreo(String correo) {
		Correo = correo;
	}

	public String getCelular() {
		return Celular;
	}

	public void setCelular(String celular) {
		Celular = celular;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

	public void setRegistro(String[] aRegistro) {
		if ( aRegistro == null ) return;
		
		id = Integer.parseInt( aRegistro[0] );
		Dni = aRegistro[1];
		Ruc = aRegistro[2];
		Nombres = aRegistro[3];
		ApellidoPaterno = aRegistro[4];
		ApellidoMaterno = aRegistro[5];
		FechaNacimiento = aRegistro[6];
		Direccion = aRegistro[7];
		Correo = aRegistro[8];
		Celular = aRegistro[9];
		Password = aRegistro[10];
		idDomiciliado = Integer.parseInt( aRegistro[11] );
		idEstadoCivil = Integer.parseInt( aRegistro[12] );
		idNivelEducativo = Integer.parseInt( aRegistro[13] );
		idDepartamento = Integer.parseInt( aRegistro[14] );
		idProvincia = Integer.parseInt( aRegistro[15] );
		idDistrito = Integer.parseInt( aRegistro[16] );
	}
}