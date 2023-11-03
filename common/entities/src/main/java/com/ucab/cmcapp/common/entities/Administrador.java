package com.ucab.cmcapp.common.entities;

public class Administrador extends Usuario{
    private int admin_ID;
    private String admin_usuario;
    private String admin_clave;

    public Administrador(int admin_ID, String admin_usuario, String admin_clave, int user_ID, String user_nombre, String user_apellido) {
        super(user_ID, user_nombre, user_apellido);
        this.admin_ID = admin_ID;
        this.admin_usuario = admin_usuario;
        this.admin_clave = admin_clave;
    }

    // Getter para admin_ID
    public int getAdmin_ID() {
        return admin_ID;
    }

    // Setter para admin_ID
    public void setAdmin_ID(int admin_ID) {
        this.admin_ID = admin_ID;
    }

    // Getter para admin_usuario
    public String getAdmin_usuario() {
        return admin_usuario;
    }

    // Setter para admin_usuario
    public void setAdmin_usuario(String admin_usuario) {
        this.admin_usuario = admin_usuario;
    }

    // Getter para admin_clave
    public String getAdmin_clave() {
        return admin_clave;
    }

    // Setter para admin_clave
    public void setAdmin_clave(String admin_clave) {
        this.admin_clave = admin_clave;
    }

}
