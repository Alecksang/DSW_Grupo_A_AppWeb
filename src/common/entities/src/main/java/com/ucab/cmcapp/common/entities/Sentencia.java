package com.ucab.cmcapp.common.entities;


import javax.persistence.*;


import javax.persistence.*;

@Entity
@Table(name = "sentencia_av")
public class Sentencia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdAlej")
    private long _IdAlej;


    @Column(name = "DistanciaMinima")
    private float _distanciaMinima;

    @Column(name = "_tiempo_control")
    private int _tiempo_control;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "Victima_id", nullable = false)
    private Usuario _victima;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "Agresor_id", nullable = false)
    private Usuario _agresor;

    public Sentencia() {

    }

    public Sentencia(Sentencia sentencia){
        _distanciaMinima = sentencia._distanciaMinima;
        _victima = sentencia._victima;
        _agresor = sentencia._agresor;
    }

    public Sentencia(int _tiempo_control) {
        this._tiempo_control = _tiempo_control;
    }

    public Sentencia(long id){
        _IdAlej = id;
    }

    public long get_IdAlej() {
        return _IdAlej;
    }

    public void set_IdAlej(long _IdAlej) {
        this._IdAlej = _IdAlej;
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

    public Usuario get_victima() {
        return _victima;
    }

    public void set_victima(Usuario _victima) {
        this._victima = _victima;
    }

    public Usuario get_agresor() {
        return _agresor;
    }

    public void set_agresor(Usuario _agresor) {
        this._agresor = _agresor;
    }


}
