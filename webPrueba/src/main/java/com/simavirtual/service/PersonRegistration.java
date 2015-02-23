package com.simavirtual.service;

import com.simavirtual.model.Person;

import javax.ejb.Stateless;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.logging.Logger;

// The @Stateless annotation eliminates the need for manual transaction demarcation
@Stateless
public class PersonRegistration {

    @Inject
    private Logger log;

    @Inject
    private EntityManager em;

    @Inject
    private Event<Person> personEventSrc;

    public void register(Person person) throws Exception {
        log.info("Registering " + person.getName());
        em.persist(person);
        personEventSrc.fire(person);
    }
}
