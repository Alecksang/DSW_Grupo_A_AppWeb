package com.ucab.cmcapp.logic.dtos;

import java.util.Date;
import java.util.List;

public class AlertaDto extends BaseDto
{
    private String _tipoAlerta;
    private Date _fechaHora;

    private float _latitud;
    private float _longitud;

    private UsuarioDto usuario;

    public AlertaDto()
    {
    }



    public AlertaDto(long id )
    {
        super( id );
    }

    public String get_tipoAlerta() {
        return _tipoAlerta;
    }

    public void set_tipoAlerta(String _tipoAlerta) {
        this._tipoAlerta = _tipoAlerta;
    }

    public Date get_fechaHora() {
        return _fechaHora;
    }

    public void set_fechaHora(Date _fechaHora) {
        this._fechaHora = _fechaHora;
    }

    public float get_latitud() {
        return _latitud;
    }

    public void set_latitud(float _latitud) {
        this._latitud = _latitud;
    }

    public float get_longitud() {
        return _longitud;
    }

    public void set_longitud(float _longitud) {
        this._longitud = _longitud;
    }

    public UsuarioDto getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioDto usuario) {
        this.usuario = usuario;
    }
}
