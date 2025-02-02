package no.hvl.dat102.filmarkiv.impl;

import no.hvl.dat102.filmarkiv.adt.FilmarkivADT;

public class Filmarkiv implements FilmarkivADT{
	private Film[] filmer;
	private int antall;
	
	public Filmarkiv(int kapasitet) {
		filmer = new Film[kapasitet];
		antall = 0;
	}
	
	private void utvid() {
		Film[] nyTabell = new Film [filmer.length * 2];
		System.arraycopy(filmer, 0, nyTabell, 0, filmer.length);
		filmer = nyTabell;
	}
	@Override
	public Film finnFilm(int nr) {
		for (int i = 0; i < antall; i++) {
			if (filmer[i].getFilmnr() == nr) {
				return filmer[i];
			}
		}
		return null;
	}
	@Override
	public void leggTilFilm(Film nyFilm) {
		if (antall == filmer.length) {
			utvid();
		}
		filmer[antall++] = nyFilm;
	}
	
	@Override
	public boolean slettFilm(int filmnr) {
		for (int i = 0; i < antall; i++) {
			if ( filmer[i].getFilmnr() == filmnr) {
				filmer[i] = filmer[--antall];
				filmer[antall] = null;
				return true;
			}
		}
		return false;
	}
	
	
	@Override
	public Film[] sokTittel(String delstreng) {
		Film[] resultat = new Film[antall];
		int indeks = 0;
		for (Film film : filmer) {
			if (film != null && film.getTittel().toLowerCase().contains(delstreng.toLowerCase())) {
				resultat[indeks++] = film;
			}
		}
		return trimTab(resultat, indeks);
	}
	
	
	@Override
	public Film[] sokFilmskaper(String delstreng) {
		Film[] resultat = new Film[antall];
		int indeks = 0;
		for (Film film : filmer) {
			if (film != null && film.getFilmskaper().toLowerCase().contains(delstreng.toLowerCase())) {
				resultat[indeks++] = film;
				}
		}
		return trimTab(resultat, indeks);
	}
	
	@Override
	public int antall (Sjanger sjanger) {
		int count = 0;
		for (Film film : filmer) {
			if (film != null && film.getSjanger() == sjanger) {
				count++;
			}
		}
		return count;
	}
	
	@Override
	public int antall() {
		return antall;
	}
	
	private Film[] trimTab(Film[] tab, int n) {
		Film[] nyTab = new Film[n];
		int i = 0;
		while (i < 0) {
			nyTab[i] = tab[i];
			i++;
		}
		return nyTab;
	}
	
}






