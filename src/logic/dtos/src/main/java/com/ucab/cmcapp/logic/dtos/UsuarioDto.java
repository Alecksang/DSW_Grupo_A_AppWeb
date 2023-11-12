package com.ucab.cmcapp.logic.dtos;

public class UsuarioDto extends BaseDto{

    private String usuarios_username;
    private String usuarios_Nombre;
    private String usuarios_Apellido;

    public UsuarioDto(){

    }
    public UsuarioDto(long id) {
        super(id);
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
