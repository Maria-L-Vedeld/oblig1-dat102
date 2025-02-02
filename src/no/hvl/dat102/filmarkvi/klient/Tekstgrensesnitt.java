package no.hvl.dat102.filmarkvi.klient;

import java.util.Scanner;

import no.hvl.dat102.filmarkiv.adt.FilmarkivADT;
import no.hvl.dat102.filmarkiv.impl.Film;
import no.hvl.dat102.filmarkiv.impl.Sjanger;

public class Tekstgrensesnitt {
    private Scanner scanner = new Scanner(System.in);

    // Leser inn opplysninger om en film fra tastatur og returnerer et Film-objekt
    public Film lesFilm() {
        System.out.println("Oppgi filmnr:");
        int filmId = scanner.nextInt();
        scanner.nextLine(); // For å tømme bufferet

        System.out.println("Oppgi filmskaper:");
        String produsent = scanner.nextLine();

        System.out.println("Oppgi tittel:");
        String tittel = scanner.nextLine();

        System.out.println("Oppgi lanseringsår:");
        int lanseringsår = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Velg sjanger (ACTION, DRAMA, HISTORY, SCIFI, ROMANCE, DOCUMENTARY):");
        String sjangerInput = scanner.nextLine().toUpperCase();
        Sjanger sjanger = Sjanger.valueOf(sjangerInput);

        System.out.println("Oppgi filmselskap:");
        String filmselskap = scanner.nextLine();

        return new Film(filmId, produsent, tittel, lanseringsår, sjanger, filmselskap);
    }

    // Skriver ut en film med alle opplysninger på skjerm
    public void skrivUtFilm(Film film) {
        if (film != null) {
            System.out.println("Filmnr: " + film.getFilmnr());
            System.out.println("Produsent: " + film.getFilmskaper());
            System.out.println("Tittel: " + film.getTittel());
            System.out.println("År: " + film.getUtgivelse());
            System.out.println("Sjanger: " + film.getSjanger());
            System.out.println("Filmselskap: " + film.getFilmselskap());
            System.out.println("-----------------------------");
        } else {
            System.out.println("Filmen finnes ikke.");
        }
    }

    // Skriver ut alle filmer med en spesiell delstreng i tittelen
    public void skrivUtFilmDelstrengITittel(FilmarkivADT arkiv, String delstreng) {
        Film[] filmer = arkiv.sokTittel(delstreng);
        System.out.println("Filmer med '" + delstreng + "' i tittelen:");
        for (Film film : filmer) {
            skrivUtFilm(film);
        }
    }

    // Skriver ut alle filmer av en produsent (produsent er delstreng)
    public void skrivUtFilmProdusent(FilmarkivADT arkiv, String delstreng) {
        System.out.println("Filmer produsert av '" + delstreng + "':");
        Film[] filmer = arkiv.sokFilmskaper(delstreng);
        for (Film film : filmer) {
            skrivUtFilm(film);
        }
    }

    // Skriver ut statistikk om filmarkivet
    public void skrivUtStatistikk(FilmarkivADT arkiv) {
        System.out.println("Antall filmer totalt: " + arkiv.antall());
        for (Sjanger s : Sjanger.values()) {
            System.out.println("Antall filmer i sjangeren " + s + ": " + arkiv.antall(s));
        }
    }
}
