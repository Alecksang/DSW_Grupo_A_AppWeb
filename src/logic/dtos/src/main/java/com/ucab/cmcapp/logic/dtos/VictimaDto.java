package com.ucab.cmcapp.logic.dtos;


import java.util.Date;

public class VictimaDto extends BaseDto {

    private UsuarioDto _usuario;


    public VictimaDto() {

    }

    public VictimaDto(long id) {
        super(id);
    }

    public UsuarioDto get_usuario() {
        return _usuario;
    }

    public void set_usuario(UsuarioDto _usuario) {
        this._usuario = _usuario;
    }
}
