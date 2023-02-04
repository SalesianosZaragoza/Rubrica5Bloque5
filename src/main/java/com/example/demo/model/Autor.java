package com.example.demo.model;

import java.sql.Date;

import org.springframework.stereotype.Component;	

@Component
public class Autor {
	private String nombre;
    private Date fecha_nacimiento;
    

    public Date getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(Date fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
	
	
	

}
