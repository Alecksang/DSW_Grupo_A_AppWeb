package com.ucab.cmcapp.logic.dtos;

import java.util.Date;

public class AlertaDto extends BaseDto{
    private String _alertaTipo;
    private UsuarioDto _usuario;
    private Date _alertaFechaHora;
    public AlertaDto()
    {
    }
    public AlertaDto(long id )
    {
        super( id );
    }

    public String get_alertaTipo() {
        return _alertaTipo;
    }

    public void set_alertaTipo(String _alertaTipo) {
        this._alertaTipo = _alertaTipo;
    }

    public UsuarioDto get_usuario() {
        return _usuario;
    }

    public void set_usuario(UsuarioDto _usuario) {
        this._usuario = _usuario;
    }

    public Date get_alertaFechaHora() {
        return _alertaFechaHora;
    }

    public void set_alertaFechaHora(Date _alertaFechaHora) {
        this._alertaFechaHora = _alertaFechaHora;
    }
}
