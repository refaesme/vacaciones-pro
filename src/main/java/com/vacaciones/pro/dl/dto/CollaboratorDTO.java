package com.vacaciones.pro.dl.dto;

public class CollaboratorDTO {

	private Long rut;
	private String name;
	private String surName;
	private String email;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurName() {
		return surName;
	}
	public void setSurName(String surName) {
		this.surName = surName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Long getRut() {
		return rut;
	}
	public void setRut(Long rut) {
		this.rut = rut;
	}
	
	
}
