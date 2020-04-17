package com.casino.data.service;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.client.Entity;
import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;
import com.casino.model.Deck;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;


/*
 * Service for:
 * 1) Converting JSON Data to Entity<Deck>
 * 2) executing Get Request
 * 3) executing Post Request
 * AUTHOR: Ricky Ratliff
 * DATE: 04/17/2020
 * COMPANY: APEX Systems
 */
public class DeckService {
	
	public static Deck convertDataToDeck(String jsonString) {		
		Gson g = new Gson(); 
		Deck deck = g.fromJson(jsonString, Deck.class);
		JsonElement jsonElement = new JsonParser().parse(jsonString);        
        JsonObject jsonObject = jsonElement.getAsJsonObject();
        deck.setDeckId(jsonObject.get("deck_id").toString());
        return deck;
	}
	
	public static String doRestGet(String URI) {		
		ResteasyClient client = new ResteasyClientBuilder().build();
		ResteasyWebTarget target = client.target(URI);
		Response response = target.request().get();
		String jsonString = response.readEntity(String.class);
		System.out.println(jsonString);
		response.close();
		return jsonString;
	}
	
	public static String doRestPost(String URI) {
		Deck deck = new Deck();
		deck.setJokersEnabled(true);
		ResteasyClient client = new ResteasyClientBuilder().build();
		ResteasyWebTarget target = client.target(URI);
		Response response = target.request().post(Entity.entity(deck, MediaType.TEXT_PLAIN));
		String jsonString = response.readEntity(String.class);
		System.out.println(jsonString);
		response.close();
		return jsonString;
	}

}
