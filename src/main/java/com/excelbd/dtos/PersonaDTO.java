package com.excelbd.dtos;

import java.io.Serializable;

public class PersonaDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long cedula;
	
	private String nombre;
	
	private String profesion;

	public Long getCedula() {
		return cedula;
	}

	public void setCedula(Long cedula) {
		this.cedula = cedula;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getProfesion() {
		return profesion;
	}

	public void setProfesion(String profesion) {
		this.profesion = profesion;
	}

	@Override
	public String toString() {
		return "PersonaDTO [cedula=" + cedula + ", nombre=" + nombre + ", profesion=" + profesion + "]";
	}
}
