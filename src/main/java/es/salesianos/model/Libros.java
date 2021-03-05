package es.salesianos.model;

import org.springframework.stereotype.Component;

@Component
public class Libros {
	private Integer id;
	private String titulo;
	private String isbn;
	private String nombreAutor;
	private Integer codAutor;

	public Libros(Integer id, String titulo, String isbn, String nombreAutor, Integer codAutor) {
		setId(id);
		setTitulo(titulo);
		setIsbn(isbn);
		setNombreAutor(nombreAutor);
		setCodAutor(codAutor);
	}

	public Libros() {

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombreAutor() {
		return nombreAutor;
	}

	public void setNombreAutor(String nombreAutor) {
		this.nombreAutor = nombreAutor;
	}

	public Integer getCodAutor() {
		return codAutor;
	}

	public void setCodAutor(Integer codAutor) {
		this.codAutor = codAutor;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
}
