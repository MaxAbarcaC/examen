package com.petSmile.model;

public class Mascota {
	
	private int idMascota;
	private String rutDueno;
	private String tipoMascota;
	private int edad;
	private String nombreMascota;
	public Mascota(int idMascota, String rutDueno, String tipoMascota, int edad, String nombreMascota) {
		super();
		this.idMascota = idMascota;
		this.rutDueno = rutDueno;
		this.tipoMascota = tipoMascota;
		this.edad = edad;
		this.nombreMascota = nombreMascota;
	}
	public int getIdMascota() {
		return idMascota;
	}
	public void setIdMascota(int idMascota) {
		this.idMascota = idMascota;
	}
	public String getRutDueno() {
		return rutDueno;
	}
	public void setRutDueno(String rutDueno) {
		this.rutDueno = rutDueno;
	}
	public String getTipoMascota() {
		return tipoMascota;
	}
	public void setTipoMascota(String tipoMascota) {
		this.tipoMascota = tipoMascota;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	public String getNombreMascota() {
		return nombreMascota;
	}
	public void setNombreMascota(String nombreMascota) {
		this.nombreMascota = nombreMascota;
	}
	@Override
	public String toString() {
		return "Mascota [idMascota=" + idMascota + ", rutDueno=" + rutDueno + ", tipoMascota=" + tipoMascota + ", edad="
				+ edad + ", nombreMascota=" + nombreMascota + "]";
	}
	
	
}
