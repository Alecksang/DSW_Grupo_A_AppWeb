package com.ucab.cmcapp.logic.dtos;

public class ZonaSeguraDto extends BaseDto {

    private String _nombre;

    private UsuarioDto _usuario;

    public ZonaSeguraDto() {

    }

    public ZonaSeguraDto(long id) {
        super(id);
    }

    public String get_nombre() {
        return _nombre;
    }

    public void set_nombre(String _nombre) {
        this._nombre = _nombre;
    }

    public UsuarioDto get_usuario() {
        return _usuario;
    }

    public void set_usuario(UsuarioDto _usuario) {
        this._usuario = _usuario;
    }
}
