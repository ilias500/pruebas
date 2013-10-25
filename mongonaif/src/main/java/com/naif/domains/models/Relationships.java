/* Powered by NAIF. Generated by NAIF v.rc2-1.0.0*/
package com.naif.domains.models;

import java.io.Serializable;

import java.util.Date;
import java.util.Set;
import java.util.HashSet;

import java.lang.Override;

import javax.persistence.Table;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.Version;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.OrderBy;

import javax.xml.bind.annotation.XmlRootElement;

import com.naif.domains.models.Cardinalities;
import com.naif.domains.models.PropertiesAttributes;
import com.naif.domains.models.Entities;
import com.naif.domains.models.Entities;
import com.naif.domains.models.LinksModels;

@NamedQueries({
  @NamedQuery(name = "Relationships.findAll",
              query = "select o from Relationships o"),

  @NamedQuery(name = "Relationships.findId",
              query = "select o from Relationships o where o.id = :id")
})
@XmlRootElement
@Entity
@Table(name = "relationships", catalog="", schema="")

public class Relationships implements java.io.Serializable {

    private static final long serialVersionUID = 1L;

    private Integer optlock;

    private boolean optionality;
    private String name;
    private String mappedby;
    private String annotationsField;
    private String annotationsMethod;
    private String tabla;
    private String idTabla1;
    private String idTabla2;
    private String description;
    private String observaciones;
    private double orden;

    // Muchos a Uno Unidireccional No.3:Cardinalities
    @ManyToOne(optional=true,
               fetch=FetchType.LAZY, targetEntity=void.class)
    @JoinColumn(name = "idCardinalities", nullable=true, unique=false,
                insertable=true, updatable=true, columnDefinition="",
                referencedColumnName = "id",table="")
    Cardinalities cardinalities;

    // Muchos a Uno Unidireccional No.3:PropertiesAttributes
    @ManyToOne(optional=true,
               fetch=FetchType.LAZY, targetEntity=void.class)
    @JoinColumn(name = "idPropertiesAttributes", nullable=true, unique=false,
                insertable=true, updatable=true, columnDefinition="",
                referencedColumnName = "id",table="")
    PropertiesAttributes propertiesAttributes;

    // Muchos a Uno Unidireccional No.3:Entities
    @ManyToOne(optional=true,
               fetch=FetchType.LAZY, targetEntity=void.class)
    @JoinColumn(name = "idFrom", nullable=true, unique=false,
                insertable=true, updatable=true, columnDefinition="",
                referencedColumnName = "id",table="")
    Entities from;

    // Muchos a Uno Unidireccional No.3:Entities
    @ManyToOne(optional=true,
               fetch=FetchType.LAZY, targetEntity=void.class)
    @JoinColumn(name = "idTo", nullable=true, unique=false,
                insertable=true, updatable=true, columnDefinition="",
                referencedColumnName = "id",table="")
    Entities to;

    // Muchos a Uno Unidireccional No.3:LinksModels
    @ManyToOne(optional=true,
               fetch=FetchType.LAZY, targetEntity=void.class)
    @JoinColumn(name = "idLinksModels", nullable=true, unique=false,
                insertable=true, updatable=true, columnDefinition="",
                referencedColumnName = "id",table="")
    LinksModels linksModels;



    @Id
    private @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false, nullable = false)
    Long id = null;
    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Version
    @Column(name = "optlock", nullable=true, unique=false, length=0, precision=0, columnDefinition="")
    public Integer getOptlock() {
        return this.optlock;
    }

    public void setOptlock(Integer optlock) {
        this.optlock = optlock;
    }

    
    @Column(name = "optionality", nullable=false, unique=false, length=0, precision=0, columnDefinition="")
    public boolean getOptionality() {
        return optionality;
    }

    public void setOptionality(boolean optionality) {
        this.optionality = optionality;
    }

    
    @Column(name = "name", nullable=true, unique=false, length=0, precision=0, columnDefinition="")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    
    @Column(name = "mappedby", nullable=true, unique=false, length=0, precision=0, columnDefinition="")
    public String getMappedby() {
        return mappedby;
    }

    public void setMappedby(String mappedby) {
        this.mappedby = mappedby;
    }

    
    @Column(name = "annotationsField", nullable=true, unique=false, length=0, precision=0, columnDefinition="")
    public String getAnnotationsField() {
        return annotationsField;
    }

    public void setAnnotationsField(String annotationsField) {
        this.annotationsField = annotationsField;
    }

    
    @Column(name = "annotationsMethod", nullable=true, unique=false, length=0, precision=0, columnDefinition="")
    public String getAnnotationsMethod() {
        return annotationsMethod;
    }

    public void setAnnotationsMethod(String annotationsMethod) {
        this.annotationsMethod = annotationsMethod;
    }

    
    @Column(name = "tabla", nullable=true, unique=false, length=0, precision=0, columnDefinition="")
    public String getTabla() {
        return tabla;
    }

    public void setTabla(String tabla) {
        this.tabla = tabla;
    }

    
    @Column(name = "idTabla1", nullable=true, unique=false, length=0, precision=0, columnDefinition="")
    public String getIdTabla1() {
        return idTabla1;
    }

    public void setIdTabla1(String idTabla1) {
        this.idTabla1 = idTabla1;
    }

    
    @Column(name = "idTabla2", nullable=true, unique=false, length=0, precision=0, columnDefinition="")
    public String getIdTabla2() {
        return idTabla2;
    }

    public void setIdTabla2(String idTabla2) {
        this.idTabla2 = idTabla2;
    }

    
    @Column(name = "description", nullable=true, unique=false, length=0, precision=0, columnDefinition="")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    
    @Column(name = "observaciones", nullable=true, unique=false, length=0, precision=0, columnDefinition="")
    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    @Column(name = "orden", nullable=true, unique=false, length=0, precision=0, columnDefinition="")
    public double getOrden() {
        return this.orden;
    }

    public void setOrden(double orden) {
        this.orden = orden;
    }

// Relaciones
    // Muchos a Uno Unidireccional No.3:Cardinalities
    public Cardinalities getCardinalities() {
        return this.cardinalities;
    }
    public void setCardinalities(Cardinalities cardinalities) {
        this.cardinalities = cardinalities;
    }

    // Muchos a Uno Unidireccional No.3:PropertiesAttributes
    public PropertiesAttributes getPropertiesAttributes() {
        return this.propertiesAttributes;
    }
    public void setPropertiesAttributes(PropertiesAttributes propertiesAttributes) {
        this.propertiesAttributes = propertiesAttributes;
    }

    // Muchos a Uno Unidireccional No.3:Entities
    public Entities getFrom() {
        return this.from;
    }
    public void setFrom(Entities from) {
        this.from = from;
    }

    // Muchos a Uno Unidireccional No.3:Entities
    public Entities getTo() {
        return this.to;
    }
    public void setTo(Entities to) {
        this.to = to;
    }

    // Muchos a Uno Unidireccional No.3:LinksModels
    public LinksModels getLinksModels() {
        return this.linksModels;
    }
    public void setLinksModels(LinksModels linksModels) {
        this.linksModels = linksModels;
    }


} // Fin de la clase