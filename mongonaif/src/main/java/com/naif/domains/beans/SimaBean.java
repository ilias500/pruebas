package com.naif.domains.beans;

import com.naif.domains.models.SystemsModels;
import com.naif.domains.models.Domains;

import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.StringTokenizer;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.LockModeType;
import javax.persistence.OptimisticLockException;
import javax.persistence.PersistenceContext;
import org.apache.lucene.search.NumericRangeQuery;
import org.apache.lucene.search.Sort;
import org.apache.lucene.search.SortField;
import org.hibernate.search.jpa.FullTextEntityManager;
import org.hibernate.search.jpa.FullTextQuery;
import org.hibernate.search.query.DatabaseRetrievalMethod;
import org.hibernate.search.query.ObjectLookupMethod;
import org.hibernate.search.query.dsl.QueryBuilder;


/**
 *
 * @author Apress
 */
@Stateless
@LocalBean
public class SimaBean {

    @PersistenceContext(unitName = "SIMA_PU")
    private EntityManager em;
    //private static final Logger log = Logger.getLogger(EShopBean.class.getName());

    // loading categories ids and names
    public List<String> extractSystemsModels() {

        FullTextEntityManager fullTextEntityManager = org.hibernate.search.jpa.Search.getFullTextEntityManager(em);

        QueryBuilder queryBuilder = fullTextEntityManager.getSearchFactory().buildQueryBuilder().forEntity(SystemsModels.class).get();
        org.apache.lucene.search.Query query = queryBuilder.all().createQuery();

        FullTextQuery fullTextQuery = fullTextEntityManager.createFullTextQuery(query, SystemsModels.class);
        fullTextQuery.setProjection(FullTextQuery.ID, "name");
        Sort sort = new Sort(new SortField("name", SortField.STRING));
        fullTextQuery.setSort(sort);

        fullTextQuery.initializeObjectsWith(ObjectLookupMethod.SKIP, DatabaseRetrievalMethod.FIND_BY_ID);

        List<String> results = fullTextQuery.getResultList();

        return results;
    }

    // loading products of a category
    public Map<Integer, List<Domains>> extractDomains(String id, int page) {

        FullTextEntityManager fullTextEntityManager = org.hibernate.search.jpa.Search.getFullTextEntityManager(em);

        QueryBuilder queryBuilder = fullTextEntityManager.getSearchFactory().buildQueryBuilder().forEntity(Domains.class).get();
        org.apache.lucene.search.Query query = queryBuilder.keyword().onField("systemsModels.id").matching(id).createQuery();

        FullTextQuery fullTextQuery = fullTextEntityManager.createFullTextQuery(query, Domains.class);
        Sort sort = new Sort(new SortField("orden", SortField.DOUBLE));
        fullTextQuery.setSort(sort);

        fullTextQuery.initializeObjectsWith(ObjectLookupMethod.SKIP, DatabaseRetrievalMethod.FIND_BY_ID);

        fullTextQuery.setFirstResult(page * 3);
        fullTextQuery.setMaxResults(3);
        List<Domains> results = fullTextQuery.getResultList();

        Map<Integer, List<Domains>> results_and_total = new HashMap<Integer, List<Domains>>();
        results_and_total.put(fullTextQuery.getResultSize(), results);

        return results_and_total;
    }

   public List<String> allDomains() {

        FullTextEntityManager fullTextEntityManager = org.hibernate.search.jpa.Search.getFullTextEntityManager(em);

        QueryBuilder queryBuilder = fullTextEntityManager.getSearchFactory().buildQueryBuilder().forEntity(Domains.class).get();
        org.apache.lucene.search.Query query = queryBuilder.all().createQuery();

        FullTextQuery fullTextQuery = fullTextEntityManager.createFullTextQuery(query, Domains.class);
/*
        fullTextQuery.setProjection(FullTextQuery.ID, "name");
        Sort sort = new Sort(new SortField("name", SortField.STRING));
        fullTextQuery.setSort(sort);

        fullTextQuery.initializeObjectsWith(ObjectLookupMethod.SKIP, DatabaseRetrievalMethod.FIND_BY_ID);
*/

        List<String> results = fullTextQuery.getResultList();

        return results;
    }

    public List<String> pruebas() {

        FullTextEntityManager fullTextEntityManager = org.hibernate.search.jpa.Search.getFullTextEntityManager(em);

        QueryBuilder queryBuilder = fullTextEntityManager.getSearchFactory().buildQueryBuilder().forEntity(Domains.class).get();
        org.apache.lucene.search.Query query = queryBuilder.all().createQuery();

        FullTextQuery fullTextQuery = fullTextEntityManager.createFullTextQuery(query, Domains.class);
        fullTextQuery.setProjection(FullTextQuery.ID, "name");
        Sort sort = new Sort(new SortField("name", SortField.STRING));
        fullTextQuery.setSort(sort);

        fullTextQuery.initializeObjectsWith(ObjectLookupMethod.SKIP, DatabaseRetrievalMethod.FIND_BY_ID);

        List<String> results = fullTextQuery.getResultList();
        
 System.out.println("Prueba No.2");        

        return results;
    }

}