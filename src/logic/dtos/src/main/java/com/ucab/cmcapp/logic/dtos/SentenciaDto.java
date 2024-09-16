package com.ucab.cmcapp.logic.dtos;


import java.util.List;

public class SentenciaDto extends BaseDto
{
    private float _distanciaMinima;

    private int _tiempo_control;
    private UsuarioDto _victima;

    private UsuarioDto _agresor;




    public SentenciaDto()
    {
    }

    public SentenciaDto( long id )
    {
        super( id );
    }

    public float get_distanciaMinima() {
        return _distanciaMinima;
    }

    public void set_distanciaMinima(float _distanciaMinima) {
        this._distanciaMinima = _distanciaMinima;
    }

    public int get_tiempo_control() {
        return _tiempo_control;
    }

    public void set_tiempo_control(int _tiempo_control) {
        this._tiempo_control = _tiempo_control;
    }

    public UsuarioDto get_victima() {
        return _victima;
    }

    public void set_victima(UsuarioDto _victima) {
        this._victima = _victima;
    }

    public UsuarioDto get_agresor() {
        return _agresor;
    }

    public void set_agresor(UsuarioDto _agresor) {
        this._agresor = _agresor;
    }


}
