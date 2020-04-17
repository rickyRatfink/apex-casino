package com.casino.model;

import java.io.Serializable;

/*
 * Entity Object for Deck
 * AUTHOR: Ricky Ratliff
 * DATE: 04/17/2020
 * COMPANY: APEX Systems
 */
public class Deck implements Serializable {
	
	private boolean success;
	private boolean shuffled;
	private boolean jokersEnabled;
	private int remaining;
	private String deckId;
	
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	public boolean isShuffled() {
		return shuffled;
	}
	public void setShuffled(boolean shuffled) {
		this.shuffled = shuffled;
	}	
	public boolean isJokersEnabled() {
		return jokersEnabled;
	}
	public void setJokersEnabled(boolean jokersEnabled) {
		this.jokersEnabled = jokersEnabled;
	}
	public int getRemaining() {
		return remaining;
	}
	public void setRemaining(int remaining) {
		this.remaining = remaining;
	}
	public String getDeckId() {
		return deckId;
	}
	public void setDeckId(String deckId) {
		this.deckId = deckId;
	}
	
	
	
	

}
