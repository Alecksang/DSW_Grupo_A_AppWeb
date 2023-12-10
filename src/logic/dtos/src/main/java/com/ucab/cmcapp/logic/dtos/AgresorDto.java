package com.ucab.cmcapp.logic.dtos;

public class AgresorDto extends BaseDto {

    private UsuarioDto _usuario;


    public AgresorDto() {

    }

    public AgresorDto(long id) {
        super(id);
    }

    public UsuarioDto get_usuario() {
        return _usuario;
    }

    public void set_usuario(UsuarioDto _usuario) {
        this._usuario = _usuario;
    }
}
