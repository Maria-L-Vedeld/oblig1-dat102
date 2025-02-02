package no.hvl.dat102.filmarkvi.klient;

import no.hvl.dat102.filmarkiv.adt.FilmarkivADT;
import no.hvl.dat102.filmarkiv.impl.Film;
import no.hvl.dat102.filmarkiv.impl.Sjanger;

public class Meny {
	private Tekstgrensesnitt tekstgr;
	private FilmarkivADT filmarkiv;
	
	public Meny(FilmarkivADT filmarkiv) {
        tekstgr = new Tekstgrensesnitt();
        this.filmarkiv = filmarkiv;
    }

	public void start() {
        // Legger inn noen testfilmer
        filmarkiv.leggTilFilm(new Film(1, "James Cameron", "Avatar", 2009, Sjanger.SCIFI, "20th Century Fox"));
        filmarkiv.leggTilFilm(new Film(2, "Christopher Nolan", "Inception", 2010, Sjanger.ACTION, "Warner Bros"));
        filmarkiv.leggTilFilm(new Film(3, "Steven Spielberg", "Schindler's List", 1993, Sjanger.DRAMA, "Universal Pictures"));
        filmarkiv.leggTilFilm(new Film(4, "Ridley Scott", "Gladiator", 2000, Sjanger.HISTORY, "DreamWorks"));
        

        System.out.println("Startet Filmarkiv-programmet!\n");

        // Tester ulike metoder i tekstgrensesnittet
        tekstgr.skrivUtStatistikk(filmarkiv);
        tekstgr.skrivUtFilmDelstrengITittel(filmarkiv, "Avatar");
        tekstgr.skrivUtFilmProdusent(filmarkiv, "Christopher Nolan");
    }
}			