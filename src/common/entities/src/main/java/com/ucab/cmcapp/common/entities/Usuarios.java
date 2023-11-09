package com.ucab.cmcapp.common.entities;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Usuarios {
    @Id
    @GeneratedValue
    private String usarios_ID;
    @Basic
    private String usuarios_Nombre;
    private String usuarios_Apellido;

    public Usuarios() {
    }

    public Usuarios(String usarios_ID, String usuarios_Nombre, String usuarios_Apellido) {
        this.usarios_ID = usarios_ID;
        this.usuarios_Nombre = usuarios_Nombre;
        this.usuarios_Apellido = usuarios_Apellido;
    }

    public String getUsarios_ID() {
        return usarios_ID;
    }

    public void setUsarios_ID(String usarios_ID) {
        this.usarios_ID = usarios_ID;
    }

    public String getUsuarios_Nombre() {
        return usuarios_Nombre;
    }

    public void setUsuarios_Nombre(String usuarios_Nombre) {
        this.usuarios_Nombre = usuarios_Nombre;
    }

    public String getUsuarios_Apellido() {
        return usuarios_Apellido;
    }

    public void setUsuarios_Apellido(String usuarios_Apellido) {
        this.usuarios_Apellido = usuarios_Apellido;
    }
}
