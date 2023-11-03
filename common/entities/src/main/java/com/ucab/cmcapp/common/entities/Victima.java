package com.ucab.cmcapp.common.entities;

public class Victima extends Usuario{
    private int vi_ID;
    private String vi_usuario;
    private String vi_correo;
    private String vi_clave;

    public Victima(int vi_ID, String vi_usuario, String vi_correo, String vi_clave, int user_ID, String user_nombre, String user_apellido) {
        super(user_ID, user_nombre, user_apellido);
        this.vi_ID = vi_ID;
        this.vi_usuario = vi_usuario;
        this.vi_correo = vi_correo;
        this.vi_clave = vi_clave;
    }

    // Getters and setters for the attributes
    public int getVi_ID() {
        return vi_ID;
    }

    public void setVi_ID(int vi_ID) {
        this.vi_ID = vi_ID;
    }

    public String getVi_usuario() {
        return vi_usuario;
    }

    public void setVi_usuario(String vi_usuario) {
        this.vi_usuario = vi_usuario;
    }

    public String getVi_correo() {
        return vi_correo;
    }

    public void setVi_correo(String vi_correo) {
        this.vi_correo = vi_correo;
    }

    public String getVi_clave() {
        return vi_clave;
    }

    public void setVi_clave(String vi_clave) {
        this.vi_clave = vi_clave;
    }
}
