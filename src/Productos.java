public class Productos {
	private int id;
	private String direccion;
	private int cp;
	private String Nombre;
	private String Descripcion;
	private int Precio;
	
	 
	public Productos(int id, String direccion, int cp, String Nombre, String Descripcion, int Precio){
		this.id = id;
		this.direccion = direccion;
		this.cp= cp;
		this.Nombre= Nombre;
		this.Descripcion= Descripcion;
		this.Precio= Precio;
		
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getDireccion() {
		return direccion;
	}


	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}


	public int getCp() {
		return cp;
	}


	public void setCp(int cp) {
		this.cp = cp;
	}


	public String getNombre() {
		return Nombre;
	}


	public void setNombre(String nombre) {
		Nombre = nombre;
	}


	public String getDescripcion() {
		return Descripcion;
	}


	public void setDescripcion(String descripcion) {
		Descripcion = descripcion;
	}


	public int getPrecio() {
		return Precio;
	}


	public void setPrecio(int precio) {
		Precio = precio;
	}

	
 }
