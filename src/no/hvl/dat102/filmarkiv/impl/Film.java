package no.hvl.dat102.filmarkiv.impl;

import java.util.Objects;

public class Film {
	private int filmnr; //mulig denne skal være int og ikke data
	private String filmskaper; //filmskaper
	private String tittel; //tittel på film
	private int utgivelse; // år for utgivelse
	private Sjanger sjanger; //ENUM
	private String filmselskap; //filmselskap
	
	
	
	public Film() {
		this.filmnr = 0;
		this.filmskaper = "";
		this.tittel = "";
		this.utgivelse = 0;
		this.sjanger = Sjanger.DRAMA;
		this.filmselskap = "";		
	}
	
	public Film(int filmnr, String filmskaper, String tittel, int utgivelse, Sjanger sjanger, String filmselskap ) {
		this.filmnr = filmnr;
		this.filmskaper = filmskaper;
		this.tittel = tittel;
		this.utgivelse = utgivelse;
		this.sjanger = sjanger;
		this.filmselskap = filmselskap;
	}
	
	public int getFilmnr() {
		return filmnr;
	}
	public void setFilmnr(int nr) {
		filmnr = nr;
	}
	
	public String getFilmskaper() {
		return filmskaper;
	}
	public void setFilmskaper(String film) {
		filmskaper = film;
	}
	
	public String getTittel() {
		return tittel;
	}
	public void setTittel(String ttl) {
		tittel = ttl;
	}
	public int getUtgivelse() {
		return utgivelse;
	}
	public void setUtgivelse(int utgivelse) {
		this.utgivelse = utgivelse;
	}
	public Sjanger getSjanger() {
		return sjanger;
	}
	public void setSjanger(Sjanger sjanger) {
		this.sjanger = sjanger;
	}
	public String getFilmselskap() {
		return filmselskap;
	}
	public void setFilmselskap(String filmselskap) {
		this.filmselskap = filmselskap;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj) 
			return true;
		if (obj == null || getClass() != obj.getClass()) 
			return false;
		Film film = (Film) obj;
		return filmnr == film.filmnr;
	}
	@Override
	public int hashCode() {
		return Objects.hash(filmnr, filmskaper, tittel, utgivelse, sjanger, filmselskap);
	}
	
	@Override
	public String toString() {
		return "Film{" +
	"filmnr= " + filmnr + 
	", filmskaper = " + getFilmskaper() +
	", tittel = " + getTittel() +
	", utgivelse = " + getUtgivelse() +
	", sjanger = " + getSjanger() +
	", filmselskap = " + getFilmselskap() + "}";
	}
	
	
	
}
