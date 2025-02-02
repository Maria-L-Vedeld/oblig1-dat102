package no.hvl.dat102.filmarkiv.impl;

import no.hvl.dat102.filmarkiv.adt.FilmarkivADT;

public class Filmarkiv2 implements FilmarkivADT {
    private int antall;
    private LinearNode<Film> start;

    public Filmarkiv2() {
        start = null;
        antall = 0;
    }

    @Override
    public Film finnFilm(int nr) {
        LinearNode<Film> aktuell = start;
        while (aktuell != null) {
            if (aktuell.data.getFilmnr() == nr) {
                return aktuell.data;
            }
            aktuell = aktuell.neste;
        }
        return null;
    }

    @Override
    public void leggTilFilm(Film nyFilm) {
        LinearNode<Film> nyNode = new LinearNode<>(nyFilm);
        nyNode.neste = start;
        start = nyNode;
        antall++;
    }

    @Override
    public boolean slettFilm(int filmnr) {
        LinearNode<Film> aktuell = start, forrige = null;
        while (aktuell != null) {
            if (aktuell.data.getFilmnr() == filmnr) {
                if (forrige == null) {
                    start = aktuell.neste;
                } else {
                    forrige.neste = aktuell.neste;
                }
                antall--;
                return true;
            }
            forrige = aktuell;
            aktuell = aktuell.neste;
        }
        return false;
    }

    @Override
    public int antall() {
        return antall;
    }

    @Override
    public int antall(Sjanger sjanger) {
        int teller = 0;
        LinearNode<Film> aktuell = start;
        while (aktuell != null) {
            if (aktuell.data.getSjanger() == sjanger) {
                teller++;
            }
            aktuell = aktuell.neste;
        }
        return teller;
    }

    @Override
    public Film[] sokTittel(String delstreng) {
        return sok(film -> film.getTittel().toLowerCase().contains(delstreng.toLowerCase()));
    }

    @Override
    public Film[] sokFilmskaper(String delstreng) {
        return sok(film -> film.getFilmskaper().toLowerCase().contains(delstreng.toLowerCase()));
    }

    private Film[] sok(java.util.function.Predicate<Film> kriterie) {
        Film[] resultat = new Film[antall];
        int indeks = 0;
        LinearNode<Film> aktuell = start;
        while (aktuell != null) {
            if (kriterie.test(aktuell.data)) {
                resultat[indeks++] = aktuell.data;
            }
            aktuell = aktuell.neste;
        }
        return trimTab(resultat, indeks);
    }

    private Film[] trimTab(Film[] tab, int n) {
        return java.util.Arrays.copyOf(tab, n);
    }
}
