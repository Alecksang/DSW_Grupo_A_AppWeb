package com.ucab.cmcapp.common.entities;

import javax.persistence.*;

@Entity
@Table(name = "usuario")
public class Usuario {

    @Id
    @Column(name = "id_usuario")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long _id;
    @Column(name = "username", nullable = false, unique = true)
    private String _username;
    @Column(name = "estado")
    private boolean _estatus;
    @Column(name = "nombre", nullable = false)
    private String _nombre;

    @Column(name = "apellido", nullable = false) //Quitar el apellido y ponerlo junto en un solo campo nombre
    private String _apellido;

    @Column(name = "correo", nullable = false, unique = true)
    private String _correo;

    @Column(name = "IMEI")
    private String _IMEI;
    @Column
    private String _password;

    public Usuario() {
    }


    public Usuario(String _username, boolean _estatus, String _nombre, String _apellido, String _correo, String _IMEI, String _password) {
        this._username = _username;
        this._estatus = _estatus;
        this._nombre = _nombre;
        this._apellido = _apellido;
        this._correo = _correo;
        this._IMEI = _IMEI;
        this._password = _password;
    }

    public Usuario(long id) {
        _id = id;
    }

    public Usuario(String username) {
        _username = username;
    }
    public long get_id() {
        return _id;
    }

    public void set_id(long _id) {
        this._id = _id;
    }

    public String get_nombre() {
        return _nombre;
    }

    public void set_nombre(String _nombre) {
        this._nombre = _nombre;
    }

    public String get_apellido() {
        return _apellido;
    }

    public void set_apellido(String _apellido) {
        this._apellido = _apellido;
    }

    public String get_username() {
        return _username;
    }

    public void set_username(String _username) {
        this._username = _username;
    }


    public String get_correo() {
        return _correo;
    }

    public void set_correo(String _correo) {
        this._correo = _correo;
    }

    public String get_IMEI() {
        return _IMEI;
    }

    public void set_IMEI(String _IMEI) {
        this._IMEI = _IMEI;
    }

    public String get_password() {
        return _password;
    }

    public void set_password(String _password) {
        this._password = _password;
    }

    public Boolean get_estatus() {
        return _estatus;
    }

    public void set_estatus(Boolean _estatus) {
        this._estatus = _estatus;
    }
}
