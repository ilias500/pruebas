package com.mycompany.demo;

import javax.persistence.Entity;
import javax.persistence.Id;
 
import org.hibernate.annotations.Type;
 
@Entity
public class Persona {
 
@Id
@Type(type = "objectid")
private String id;
 
public String getId() {
return id;
}
 
public void setId(String id) {
this.id = id;
}
 
private String nombre;
private String apellidos;
 
public String getApellidos() {
return apellidos;
}
 
public void setApellidos(String apellidos) {
this.apellidos = apellidos;
}
 
public String getNombre() {
return nombre;
}
 
public Persona() {
super();
}
 
public Persona(String nombre) {
super();
this.nombre = nombre;
}
 
public void setNombre(String nombre) {
this.nombre = nombre;
}
 
}