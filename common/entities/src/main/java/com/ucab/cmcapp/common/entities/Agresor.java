package com.ucab.cmcapp.common.entities;

public class Agresor extends Usuario{
    private int ag_ID;
    private String ag_usuario;
    private String ag_correo;
    private String ag_clave;

    public Agresor(int ag_ID, String ag_usuario, String ag_correo, String ag_clave, int user_ID, String user_nombre, String user_apellido) {
        super(user_ID, user_nombre, user_apellido);
        this.ag_ID = ag_ID;
        this.ag_usuario = ag_usuario;
        this.ag_correo = ag_correo;
        this.ag_clave = ag_clave;
    }

    // Getter para ag_ID
    public int getAg_ID() {
        return ag_ID;
    }

    // Setter para ag_ID
    public void setAg_ID(int ag_ID) {
        this.ag_ID = ag_ID;
    }

    // Getter para ag_usuario
    public String getAg_usuario() {
        return ag_usuario;
    }

    // Setter para ag_usuario
    public void setAg_usuario(String ag_usuario) {
        this.ag_usuario = ag_usuario;
    }

    // Getter para ag_correo
    public String getAg_correo() {
        return ag_correo;
    }

    // Setter para ag_correo
    public void setAg_correo(String ag_correo) {
        this.ag_correo = ag_correo;
    }

    // Getter para ag_clave
    public String getAg_clave() {
        return ag_clave;
    }

    // Setter para ag_clave
    public void setAg_clave(String ag_clave) {
        this.ag_clave = ag_clave;
    }
}
