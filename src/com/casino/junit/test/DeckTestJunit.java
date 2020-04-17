package com.casino.junit.test;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import static org.junit.Assert.*;
import com.casino.data.service.DeckService;
import com.casino.model.Deck;



/*
 * JUNIT Tests for the deckofcardsapi
 * AUTHOR: Ricky Ratliff
 * DATE: 04/17/2020
 * COMPANY: APEX Systems
 */

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class DeckTestJunit {
	
	private static String INITIAL_DECK_ID;
	
	/*
	 * This test runs first and deals a new deck via GET
	 */
	@Test
	public void testNewDeck() {
		System.out.println("JUNIT Test #1: dealing new deck");
		String jsonString = DeckService.doRestGet("https://deckofcardsapi.com/api/deck/new/");
		Deck deck = DeckService.convertDataToDeck(jsonString);
		INITIAL_DECK_ID = deck.getDeckId();
        System.out.println("success:"+deck.isSuccess());
        System.out.println( "deck_id:"+INITIAL_DECK_ID);
        assertTrue(deck.isSuccess());
	}

	/*
	 * This test runs second and deals a new deck with jokers included via POST
	 */
	@Test
	public void testNewDeckJokersIncluded() {
		System.out.println("JUNIT Test #2: dealing new deck with jokers included");
		String jsonString = DeckService.doRestGet("https://deckofcardsapi.com/api/deck/new/?jokers_enabled=true");
		Deck deck = DeckService.convertDataToDeck(jsonString);
        System.out.println("success:"+deck.isSuccess());
        System.out.println("jokers:"+deck.isJokersEnabled());
        System.out.println("deck_id:"+deck.getDeckId() );
        System.out.println("remaining:"+deck.getRemaining() );
	}

	/*
	 * This test runs last and draw X number of cards from existing deck with ID represented by INITIAL_DECK_ID via GET;
	 */
	@Test
	public void testNewDrawCardsFromDeck() {	
		int numCards = 1+(int)(Math.random()*10);
		System.out.println("JUNIT Test #3: drawing "+numCards+" cards from existing deck "+INITIAL_DECK_ID);		
		String URI = "https://deckofcardsapi.com/api/deck/"+INITIAL_DECK_ID+"/draw/?count="+numCards;
		URI=URI.replace("\"", "");
		System.out.println (URI);
		String jsonString = DeckService.doRestGet(URI);
		System.out.println(jsonString);
		Deck deck = DeckService.convertDataToDeck(jsonString);
		System.out.println("success:"+deck.isSuccess());
        System.out.println("deck_id:"+deck.getDeckId() );
        System.out.println("remaining:"+deck.getRemaining() );
        int cardsLeft = 52-numCards;        
        assertEquals(cardsLeft, deck.getRemaining());
	}

}
