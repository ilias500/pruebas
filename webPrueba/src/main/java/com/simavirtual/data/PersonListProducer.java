package com.simavirtual.data;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.event.Observes;
import javax.enterprise.event.Reception;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

import com.simavirtual.model.Person;

@RequestScoped
public class PersonListProducer {

    @Inject
    private PersonRepository personRepository;

    private List<Person> persons;

    // @Named provides access the return value via the EL variable name "persons" in the UI (e.g.
    // Facelets or JSP view)
    @Produces
    @Named
    public List<Person> getPersons() {
        return persons;
    }

    public void onPersonListChanged(@Observes(notifyObserver = Reception.IF_EXISTS) final Person person) {
        retrieveAllPersonsOrderedByName();
    }

    @PostConstruct
    public void retrieveAllPersonsOrderedByName() {
        persons = personRepository.findAllOrderedByName();
    }
}
