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

    private static final String JBOSS_TM_CLASS_NAME = "com.arjuna.ats.jta.TransactionManager";

    public static TransactionManager getTransactionManager() {
        try {
            Class<?> tmClass = App.class
                                  .getClassLoader()
                                  .loadClass( JBOSS_TM_CLASS_NAME );
            return (TransactionManager) tmClass.getMethod( "transactionManager" ).invoke( null );
        } catch ( ClassNotFoundException e ) {
            e.printStackTrace();
        } catch ( InvocationTargetException e ) {
            e.printStackTrace();
        } catch ( NoSuchMethodException e ) {
            e.printStackTrace();
        } catch ( IllegalAccessException e ) {
            e.printStackTrace();
        }
        return null;
    }    

    public static void main( String[] args ){
        System.out.println( "--> Beginning..." ); //log.info(">>> ESTO es una PRUEBA 2");

        TransactionManager tm = getTransactionManager();
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hikeWithMongo-PU");
        

        try {
            //tm.begin();
            
            EntityManager em = emf.createEntityManager();
            em.getTransaction().begin();

            Person p = new Person("Nelson","Andres");
        
            em.persist(p);
           
            //em.flush();
            //em.close();
            //tm.commit();

            em.getTransaction().commit();
            em.close();

            emf.close();
        } catch ( Exception e ) {
            e.printStackTrace();
        }
    
    } // main

} // App