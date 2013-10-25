package com.naif.domains.initdb;

import com.naif.domains.models.SystemsModels;
import com.naif.domains.models.Domains;

import java.util.Calendar;
import java.util.Random;
import javax.ejb.LocalBean;
import javax.ejb.Singleton;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.jboss.logging.Logger;

/**
 *
 * @author Apress
 */
@Singleton
@LocalBean
@Named("domainsdb")
public class DomainsDb {

    @PersistenceContext(unitName = "NAIF_PU")
    private EntityManager em;
    private static final Logger log = Logger.getLogger(DomainsDb.class.getName());

    public void init() {

        log.info("Please wait while preparing database data ... ");

        SystemsModels systemsModels = new SystemsModels();
        systemsModels.setName("DOMAIN MODELS");
        systemsModels.setOrden(1.0);
        em.persist(systemsModels);
        em.flush();

//      MODELOS DE DOMINIO
        Domains domains1 = new Domains();
        domains1.setName("SYSTEMS MODELS");
        domains1.setOrden(1.0);
        domains1.setSystemsModels(systemsModels);
        em.persist(domains1);
        em.flush();

        Domains domains2 = new Domains();
        domains2.setName("LINKS MODELS");
        domains2.setOrden(2.0);
        domains2.setSystemsModels(systemsModels);
        em.persist(domains2);
        em.flush();

        Domains domains3 = new Domains();
        domains3.setName("ENTITIES");
        domains3.setOrden(3.0);
        domains3.setSystemsModels(systemsModels);
        em.persist(domains3);
        em.flush();

        Domains domains4 = new Domains();
        domains4.setName("ATTRIBUTES");
        domains4.setOrden(4.0);
        domains4.setSystemsModels(systemsModels);
        em.persist(domains4);
        em.flush();

        Domains domains5 = new Domains();
        domains5.setName("RELATIONSHIPS");
        domains5.setOrden(5.0);
        domains5.setSystemsModels(systemsModels);
        em.persist(domains5);
        em.flush();

        SystemsModels systemsModels1 = new SystemsModels();
        systemsModels1.setName("MODELO BASE");
        systemsModels1.setOrden(2.0);
        em.persist(systemsModels1);
        em.flush();

        Domains domains11 = new Domains();
        domains11.setName("SISTEMAS");
        domains11.setOrden(1.0);
        domains11.setSystemsModels(systemsModels);
        em.persist(domains11);
        em.flush();

        Domains domains22 = new Domains();
        domains22.setName("USUARIOS");
        domains22.setOrden(2.0);
        domains22.setSystemsModels(systemsModels1);
        em.persist(domains22);
        em.flush();

        Domains domains33 = new Domains();
        domains3.setName("PERMISOS");
        domains3.setOrden(3.0);
        domains3.setSystemsModels(systemsModels1);
        em.persist(domains3);
        em.flush();

        Domains domains44 = new Domains();
        domains44.setName("DIVISIONES POLITICAS");
        domains44.setOrden(4.0);
        domains44.setSystemsModels(systemsModels1);
        em.persist(domains44);
        em.flush();

        Domains domains55 = new Domains();
        domains55.setName("DIRECCIONES");
        domains55.setOrden(5.0);
        domains55.setSystemsModels(systemsModels1);
        em.persist(domains55);
        em.flush();

        Domains domains6 = new Domains();
        domains6.setName("TELEFONOS");
        domains6.setOrden(6.0);
        domains6.setSystemsModels(systemsModels1);
        em.persist(domains6);
        em.flush();

        log.info("Database successfully populated ... ");
    }
}
