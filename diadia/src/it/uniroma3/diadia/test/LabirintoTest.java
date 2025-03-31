package it.uniroma3.diadia.test;
import static org.junit.Assert.*;

import org.junit.Test;

import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.Stanza;

public class LabirintoTest {
	private final Labirinto l = new Labirinto();
	private final Stanza si = new Stanza("Atrio");
	private final Stanza sd = new Stanza("Stanza diversa");
	private final Stanza sv = new Stanza("Biblioteca");
	
	@Test
	public void testGetStanzaIniziale() {
		assertEquals(si.getNome(), l.getStanzaIniziale().getNome());
	}
	
	@Test
	public void testGetStanzaVincente() {
		assertEquals(sv.getNome(), l.getStanzaVincente().getNome());
	}
	
	@Test
	public void testStanzaInzialeDiversoAtrio() {
		assertFalse(l.getStanzaIniziale().getNome()== sd.getNome());
	}
	
	
}

