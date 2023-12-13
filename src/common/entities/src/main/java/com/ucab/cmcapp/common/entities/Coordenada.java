package com.ucab.cmcapp.common.entities;

import javax.persistence.*;

@Entity
@Table(name = "coordenada")
public class Coordenada {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long _id;

    @Column(name = "latitud", nullable = false)
    private float _latitudY;

    @Column(name = "longitud", nullable = false)
    private float _longitudX;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn( name = "id_zona_segura", nullable = false )
    private ZonaSegura _zona_segura;

    public Coordenada() {
    }

    public Coordenada(long _id) {
        this._id = _id;
    }

    public Coordenada(float _latitudY, float _longitudX) {
        this._latitudY = _latitudY;
        this._longitudX = _longitudX;
    }

    public long get_id() {
        return _id;
    }

    public void set_id(long _id) {
        this._id = _id;
    }

    public float get_latitudY() {
        return _latitudY;
    }

    public void set_latitudY(float _latitudY) {
        this._latitudY = _latitudY;
    }

    public float get_longitudX() {
        return _longitudX;
    }

    public void set_longitudX(float _longitudX) {
        this._longitudX = _longitudX;
    }

    public ZonaSegura get_zona_segura() {
        return _zona_segura;
    }

    public void set_zona_segura(ZonaSegura _zona_segura) {
        this._zona_segura = _zona_segura;
    }
}
