package com.ucab.cmcapp.logic.dtos;

public class CoordenadaDto extends BaseDto {

    private float _latitud;
    private float _longitud;

    private ZonaSeguraDto _zonasegura;

    public CoordenadaDto() {

    }

    public CoordenadaDto(long id) {
        super(id);
    }

    public float get_latitudY() {
        return _latitud;
    }

    public void set_latitudY(float _latitud) {
        this._latitud = _latitud;
    }

    public float get_longitudX() {
        return _longitud;
    }

    public void set_longitudX(float _longitud) {
        this._longitud = _longitud;
    }

    public ZonaSeguraDto get_zona_segura() {
        return _zonasegura;
    }
    public void set_zona_segura(ZonaSeguraDto _zona_segura) {
        this._zonasegura = _zona_segura;
    }
}
