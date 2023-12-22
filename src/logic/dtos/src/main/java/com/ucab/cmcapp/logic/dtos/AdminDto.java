package com.ucab.cmcapp.logic.dtos;

public class AdminDto extends BaseDto {


    private String _username;
    private String _correo;
    private String _password;


    public AdminDto() {

    }

    public AdminDto(long id) {
        super(id);
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