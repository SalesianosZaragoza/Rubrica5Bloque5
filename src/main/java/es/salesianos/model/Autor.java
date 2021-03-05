package es.salesianos.model;

import org.springframework.stereotype.Component;

@Component
public class Autor {
	private Integer codAutor;
	private String nombre;
	private String fechaNac;

	public Autor(Integer codAutor, String nombre, String fechaNac) {
		setCodAutor(codAutor);
		setNombre(nombre);
		setFechaNac(fechaNac);
	}

	public Autor() {

	}

	public Integer getCodAutor() {
		return codAutor;
	}

	public void setCodAutor(Integer codAutor) {
		this.codAutor = codAutor;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getFechaNac() {
		return fechaNac;
	}

	public void setFechaNac(String fechaNac) {
		this.fechaNac = fechaNac;
	}
}