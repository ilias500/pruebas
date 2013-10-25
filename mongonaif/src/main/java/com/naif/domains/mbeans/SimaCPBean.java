package com.naif.domains.mbeans;

import com.naif.domains.beans.SimaBean;
import com.naif.domains.models.Domains;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.Cookie;
import org.primefaces.context.RequestContext;

/**
 *
 * @author Apress
 */
@Named("simacp")
@RequestScoped
public class SimaCPBean {

    @Inject
    private SimaBean simaBean;

    private int total;

    private List<Domains> domains = new ArrayList<Domains>();

    public List<String> extractSystemsModelsAction() {
        return simaBean.extractSystemsModels();
    }

    public void extractDomainsAction() {
        Map<Integer, List<Domains>> results = simaBean.extractDomains(getSystemsModels(), getPageNumber());
        total = results.keySet().iterator().next();
        this.domains = results.get(total);

        RequestContext context = RequestContext.getCurrentInstance();
        context.execute("pagination('" + total + "')");
    }

    private String getSystemsModels() {
        Object cat_cookie = FacesContext.getCurrentInstance().getExternalContext().getRequestCookieMap().get("systemsModels");
        if (cat_cookie != null) {
            String cat_cookie_value = (((Cookie) cat_cookie).getValue());
            if (!"nocookie".equals(cat_cookie_value)) {
                return cat_cookie_value;
            }
        }
        return "";
    }

    private int getPageNumber() {
        Object page_cookie = FacesContext.getCurrentInstance().getExternalContext().getRequestCookieMap().get("page");
        if (page_cookie != null) {
            String page_cookie_value = (((Cookie) page_cookie).getValue());
            if (!"nocookie".equals(page_cookie_value)) {
                return Integer.valueOf(page_cookie_value);
            }
        }
        return 0;
    }

    public List<String> getDomains() {
        return simaBean.allDomains();
    }

    public List<String> pruebas() {
 System.out.println("Prueba No.1");      
        return simaBean.pruebas();
    }

}



