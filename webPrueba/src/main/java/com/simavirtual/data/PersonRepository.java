package com.simavirtual.data;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

import com.simavirtual.model.Person;

@ApplicationScoped
public class PersonRepository {

    @Inject
    private EntityManager em;

    public Person findById(String id) {
        return em.find(Person.class, id);
    }

    public Person findByEmail(String email) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Person> criteria = cb.createQuery(Person.class);
        Root<Person> person = criteria.from(Person.class);
        // Swap criteria statements if you would like to try out type-safe criteria queries, a new
        // feature in JPA 2.0
        // criteria.select(person).where(cb.equal(person.get(Person_.name), email));
        criteria.select(person).where(cb.equal(person.get("email"), email));
        return em.createQuery(criteria).getSingleResult();
    }

    public List<Person> findAllOrderedByName() {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Person> criteria = cb.createQuery(Person.class);
        Root<Person> person = criteria.from(person.class);
        // Swap criteria statements if you would like to try out type-safe criteria queries, a new
        // feature in JPA 2.0
        // criteria.select(person).orderBy(cb.asc(person.get(Person_.name)));
        criteria.select(person).orderBy(cb.asc(person.get("name")));
        return em.createQuery(criteria).getResultList();
    }
}
