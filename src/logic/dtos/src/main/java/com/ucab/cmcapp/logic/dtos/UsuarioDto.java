package com.ucab.cmcapp.logic.dtos;

public class UsuarioDto extends BaseDto {
    private String _username;
    private Boolean _estatus;
    private String _nombre;
    private String _apellido;
    private String _correo;
    private String _IMEI;


    public UsuarioDto() {

    }

    public UsuarioDto(long id) {
        super(id);
    }
    public String get_username() {
        return _username;
    }
    public void set_username(String _username) {
        this._username = _username;
    }

    public Boolean get_estatus() {
        return _estatus;
    }
    public void set_estatus(Boolean _estatus) {
        this._estatus = _estatus;
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
}