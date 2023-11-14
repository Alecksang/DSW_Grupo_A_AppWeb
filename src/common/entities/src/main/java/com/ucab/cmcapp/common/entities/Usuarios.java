package com.ucab.cmcapp.common.entities;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Usuarios {
    @Id
    private long usarios_ID;

    private String usuarios_username;
    private String usuarios_Nombre;
    private String usuarios_Apellido;

    public Usuarios() {
    }

    public Usuarios(String usuarios_username, String usuarios_Nombre, String usuarios_Apellido) {
        this.usuarios_username = usuarios_username;
        this.usuarios_Nombre = usuarios_Nombre;
        this.usuarios_Apellido = usuarios_Apellido;
    }

    public Usuarios (long id) {
        usarios_ID= id;
    }

    public long getUsarios_ID() {
        return usarios_ID;
    }

    public void setUsarios_ID(long usarios_ID) {
        this.usarios_ID = usarios_ID;
    }

    public String getUsuarios_username() {
        return usuarios_username;
    }

    public void setUsuarios_username(String usuarios_username) {
        this.usuarios_username = usuarios_username;
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

