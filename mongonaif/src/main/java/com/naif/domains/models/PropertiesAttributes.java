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

import com.naif.domains.models.Relationships;
import com.naif.domains.models.Attributes;

@NamedQueries({
  @NamedQuery(name = "PropertiesAttributes.findAll",
              query = "select o from PropertiesAttributes o"),

  @NamedQuery(name = "PropertiesAttributes.findId",
              query = "select o from PropertiesAttributes o where o.id = :id")
})
@XmlRootElement
@Entity
@Table(name = "propertiesAttributes", catalog="", schema="")

public class PropertiesAttributes implements java.io.Serializable {

    private static final long serialVersionUID = 1L;

    private Integer optlock;

    private String name;
    private String value;
    private String observaciones;
    private double orden;

    // Uno a Muchos Bidireccional No.5:Relationships
    @OneToMany(mappedBy="propertiesAttributes",
               fetch=FetchType.LAZY, targetEntity=void.class)
    private Set<Relationships> relationships = new HashSet<Relationships>(0);

    // Uno a Muchos Bidireccional No.5:Attributes
    @OneToMany(mappedBy="propertiesAttributes",
               fetch=FetchType.LAZY, targetEntity=void.class)
    private Set<Attributes> attributes = new HashSet<Attributes>(0);



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

    
    @Column(name = "name", nullable=false, unique=false, length=0, precision=0, columnDefinition="")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    
    @Column(name = "value", nullable=false, unique=false, length=0, precision=0, columnDefinition="")
    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
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
    // Uno a Muchos Bidireccional No.5:Relationships
    public Set<Relationships> getRelationships() {
        return this.relationships;
    }
    public void setRelationships(Set<Relationships> relationships) {
        this.relationships = relationships;
    }

    // Uno a Muchos Bidireccional No.5:Attributes
    public Set<Attributes> getAttributes() {
        return this.attributes;
    }
    public void setAttributes(Set<Attributes> attributes) {
        this.attributes = attributes;
    }


} // Fin de la clase