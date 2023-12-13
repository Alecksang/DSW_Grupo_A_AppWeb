package com.ucab.cmcapp.logic.dtos;

public class Sentencia_AVDto extends BaseDto {

    private float _distancia;
    private VictimaDto _victima;
    private AgresorDto _agresor;


    public Sentencia_AVDto() {

    }

    public Sentencia_AVDto(long id) {
        super(id);
    }

    public float get_distancia() {
        return _distancia;
    }

    public void set_distancia(float _distancia) {
        this._distancia = _distancia;
    }

    public VictimaDto get_victima() {
        return _victima;
    }

    public void set_victima(VictimaDto _usuario_victima) {
        this._victima = _victima;
    }

    public AgresorDto get_agresor() {
        return _agresor;
    }

    public void set_agresor(AgresorDto _agresor) {
        this._agresor = _agresor;
    }
}
