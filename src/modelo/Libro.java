package modelo;

public class Libro {
	
	private int idLibro;
	private String nombreLibro;
	private String generoLibro;
	private String autor;
	private String Descripcion;
	
	
	public String getNombreLibro() {
		return nombreLibro;
	}
	public void setNombreLibro(String nombreLibro) {
		this.nombreLibro = nombreLibro;
	}
	public String getGeneroLibro() {
		return generoLibro;
	}
	public void setGeneroLibro(String generoLibro) {
		this.generoLibro = generoLibro;
	}
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public String getDescripcion() {
		return Descripcion;
	}
	public void setDescripcion(String descripcion) {
		Descripcion = descripcion;
	}
	public int getID() {
		return idLibro;
	}
	public void setID(int idLibro) {
		this.idLibro = idLibro;
	}
	
}