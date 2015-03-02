package com.simavirtual.setup;

import com.simavirtual.model.*;

import java.util.Calendar;
import java.util.Random;
import javax.ejb.LocalBean;
import javax.ejb.Singleton;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.jboss.logging.Logger;

@Singleton
@LocalBean
@Named("setuph2bean")
public class SetupH2Bean {

    @PersistenceContext(unitName = "picketlink-custom-identity-model-pu")
    private EntityManager em;
    private static final Logger log = Logger.getLogger(SetupBean.class.getName());

    public void populateTest() {

        log.info("Please wait while preparing database data H2... ");
        
        Person p = new Person("Pedro","Perez");

        em.persist(p);
        em.flush();

        log.info("Database successfully populated H2... ");

    } // end : populateTest Method

}
