package no.hvl.dat102.filmarkiv.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import no.hvl.dat102.filmarkiv.adt.FilmarkivADT;
import no.hvl.dat102.filmarkiv.impl.Film;
import no.hvl.dat102.filmarkiv.impl.Filmarkiv;
import no.hvl.dat102.filmarkiv.impl.Filmarkiv2;
import no.hvl.dat102.filmarkiv.impl.Sjanger;

class FilmarkivTest {

    private FilmarkivADT[] arkiver; //legger inn filmarkiv og filmarkiv 2 her

    @BeforeEach
    void setup() {
        arkiver = new FilmarkivADT[]{new Filmarkiv(10), new Filmarkiv2()};

        for (FilmarkivADT arkiv : arkiver) {
            arkiv.leggTilFilm(new Film(1, "James Cameron", "Avatar", 2009, Sjanger.SCIFI, "20th Century Fox"));
            arkiv.leggTilFilm(new Film(2, "Christopher Nolan", "Inception", 2010, Sjanger.ACTION, "Warner Bros"));
        }
    }

    @Test
    void testFinnFilm() {
        for (FilmarkivADT arkiv : arkiver) {
            assertNotNull(arkiv.finnFilm(1));
            assertNull(arkiv.finnFilm(99));
        }
    }

    @Test
    void testSlettFilm() {
        for (FilmarkivADT arkiv : arkiver) {
            assertTrue(arkiv.slettFilm(1));
            assertFalse(arkiv.slettFilm(99));
        }
    }

    @Test
    void testTittel() {
        for (FilmarkivADT arkiv : arkiver) {
            assertEquals(1, arkiv.sokTittel("Avatar").length);
        }
    }

    @Test
    void testFilmskaper() {
        for (FilmarkivADT arkiv : arkiver) {
            assertEquals(1, arkiv.sokFilmskaper("Christopher Nolan").length);
        }
    }

    @Test
    void testAntall() {
        for (FilmarkivADT arkiv : arkiver) {
            assertEquals(2, arkiv.antall());
        }
    }

    @Test
    void testAntallSjanger() {
        for (FilmarkivADT arkiv : arkiver) {
            assertEquals(1, arkiv.antall(Sjanger.SCIFI));
            assertEquals(1, arkiv.antall(Sjanger.ACTION));
            assertEquals(0, arkiv.antall(Sjanger.DRAMA));
        }
    }
}
