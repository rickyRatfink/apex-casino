package com.casino.junit.test;

import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Response;

import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;
import org.jboss.resteasy.plugins.providers.DataSourceProvider;


/*
 * Automated Unit Testing for CasinoApp
 * AUTHOR: Ricky Ratliff
 * DATE: 04/17/2020
 * COMPANY: APEX Systems
 */
public class DeckRunner {

	public static void main(String[] args) {

		try {
			Result result = JUnitCore.runClasses(DeckTestJunit.class);
			for (Failure failure : result.getFailures()) {
				System.out.println(failure.toString());
			}
			System.out.println("*************\n\rJunit tests ran and result was " + result.wasSuccessful());
		} 
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
		finally {
			System.out.println("test automation done!\n\r************************8\n\r");
		
		}

	}
}
