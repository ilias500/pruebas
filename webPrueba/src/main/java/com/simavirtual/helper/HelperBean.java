package com.simavirtual.helper;

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
@Named("helperbean")
public class HelperBean {

    @PersistenceContext(unitName = "webMongo-PU-JTA")
    private EntityManager em;
    private static final Logger log = Logger.getLogger(HelperBean.class.getName());

    public void populateTest() {

        log.info("Please wait while preparing database data ... ");

/*
        Person p = new Person("James","Rodriguez");
        em.persist(p);
        em.flush();
*/

        log.info("Database successfully populated ... ");

    } // end : populateTest Method

}