package com.simavirtual;

import com.simavirtual.models.conta.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.transaction.TransactionManager;

import java.lang.reflect.InvocationTargetException;

public class App{

    public static void main( String[] args ){

        System.out.println( "Hello World!" );

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("conta-PU");

        try {

            EntityManager em = emf.createEntityManager();
            em.getTransaction().begin();
            
            Person p = new Person("Nelson","Fernandez");

            em.persist(p);
            em.getTransaction().commit();
            em.close();



/*
            Pucs pucs = new Pucs("Cuentas x Cobrar");
            em.persist(pucs);
*/


            emf.close();

        } catch ( Exception e ) {
            e.printStackTrace();
        }


    } // main

} // App
