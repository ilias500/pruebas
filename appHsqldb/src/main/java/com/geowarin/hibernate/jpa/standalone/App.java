package com.geowarin.hibernate.jpa.standalone;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.geowarin.hibernate.jpa.standalone.model.User;

public class App{
  
    private static Logger log = LoggerFactory.getLogger(App.class);

    public static void main( String[] args ){
      
        System.out.println( "Hello World!" );

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("persistence");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

	User found = entityManager.find(User.class, 1L);
	log.info("found=" + found);
        System.out.println( "Paso!" );	


    } // main

} // App
