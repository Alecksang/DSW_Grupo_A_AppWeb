package com.ucab.cmcapp.common.entities;

import javax.persistence.*;

@Entity
@Table(name = "admin")
public class Admin {


    @Id
    @Column(name = "id_admin")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long _id;

    @Column(name = "username", nullable = false, unique = true)
    private String _username;

    @Column(name = "correo", nullable = false, unique = true)
    private String _correo;

    @Column(name = "password", nullable = false)
    private String _password;


    public Admin() {

    }

    public Admin(Admin usuario) {
        _username = usuario._username;
        _correo = usuario._correo;
        _password = usuario._password;
    }

    public Admin(long id) {
        _id = id;
    }

    public Admin(String username) {
        _username = username;
    }

    public long get_id() {
        return _id;
    }

    public void set_id(long _id) {
        this._id = _id;
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


    public String get_password() {
        return _password;
    }

    public void set_password(String _password) {
        this._password = _password;
    }

}