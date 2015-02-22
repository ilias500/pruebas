package org.hibernate.ogm.demos.ogm101.part2;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.transaction.TransactionManager;

import java.lang.reflect.InvocationTargetException;

//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;

public class App {

    //private static Logger log = LoggerFactory.getLogger(App.class);

    public static void main( String[] args ){

        System.out.println( "--> Beginning..." ); //log.info(">>> ESTO es una PRUEBA 2");

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hikeWithMongo-PU");

        try {

            EntityManager em = emf.createEntityManager();
            em.getTransaction().begin();

            Person p = new Person("Nelson","Fernandez");

            em.persist(p);
            em.getTransaction().commit();
            em.close();

            emf.close();

        } catch ( Exception e ) {
            e.printStackTrace();
        }

    } // main

} // App