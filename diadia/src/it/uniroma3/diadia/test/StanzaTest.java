package it.uniroma3.diadia.test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;

class StanzaTest {
    private Stanza stanza;
    private Attrezzo spada;

    @BeforeEach
    void setUp() {
        stanza = new Stanza("Biblioteca");
        spada = new Attrezzo("Spada", 3);
    }

    @Test
    void testGetNome() {
        assertEquals("Biblioteca", stanza.getNome(), "Il nome della stanza dovrebbe essere 'Biblioteca'");
    }

    @Test
    void testAddAttrezzo() {
        assertTrue(stanza.addAttrezzo(spada), "Dovrebbe essere possibile aggiungere un attrezzo");
        assertFalse(stanza.hasAttrezzo("Spada"), "La stanza dovrebbe contenere la Spada");
    }

    @Test
    void testHasAttrezzo() {
        stanza.addAttrezzo(spada);
        assertTrue(stanza.hasAttrezzo("Spada"), "La stanza deve contenere la Spada");
        assertFalse(stanza.hasAttrezzo("Scudo"), "La stanza non dovrebbe contenere lo Scudo");
    }

    @Test
    void testGetAttrezzo() {
        stanza.addAttrezzo(spada);
        assertNotNull(stanza.getAttrezzo("Spada"), "Dovrebbe restituire l'attrezzo Spada");
        assertNull(stanza.getAttrezzo("Scudo"), "Non dovrebbe trovare l'attrezzo Scudo");
    }

    @Test
    void testRemoveAttrezzo() {
        stanza.addAttrezzo(spada);
        assertTrue(stanza.removeAttrezzo(spada), "L'attrezzo dovrebbe essere rimosso");
        assertFalse(stanza.hasAttrezzo("Spada"), "Dopo la rimozione, la Spada non dovrebbe essere presente");
    }

    @Test
    void testImpostaStanzaAdiacenteEGetStanzaAdiacente() {
        Stanza cucina = new Stanza("Cucina");
        stanza.impostaStanzaAdiacente("nord", cucina);
        assertEquals(cucina, stanza.getStanzaAdiacente("nord"), "La stanza a nord dovrebbe essere la Cucina");
        assertNull(stanza.getStanzaAdiacente("sud"), "Non c'è nessuna stanza a sud");
    }
}

