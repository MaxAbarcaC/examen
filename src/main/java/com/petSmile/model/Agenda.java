package com.petSmile.model;


import java.time.*;

public class Agenda {

	private int id;
	private int idMascota;
	private String rutDueno;
	private String nombreMascota;
	private LocalTime hora;
	private LocalDate fecha;
	
	
	
	public Agenda(int id, int idMascota, String rutDueno, String nombreMascota, LocalTime hora, LocalDate fecha) {
		super();
		this.id = id;
		this.idMascota = idMascota;
		this.rutDueno = rutDueno;
		this.nombreMascota = nombreMascota;
		this.hora = hora;
		this.fecha = fecha;
	}
	
	
	public Agenda() {
		
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public String getNombreMascota() {
		return nombreMascota;
	}
	public void setNombreMascota(String nombreMascota) {
		this.nombreMascota = nombreMascota;
	}
	public LocalTime getHora() {
		return hora;
	}
	public void setHora(LocalTime time) {
		this.hora = time;
	}
	public LocalDate getFecha() {
		return fecha;
	}
	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}
	@Override
	public String toString() {
		return "Agenda [id=" + id + ", idMascota=" + idMascota + ", rutDueno=" + rutDueno + ", nombreMascota="
				+ nombreMascota + ", hora=" + hora + ", fecha=" + fecha + "]";
	}
	
	
}
