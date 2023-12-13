package com.ucab.cmcapp.common.entities;


import javax.persistence.*;


@Entity
@Table(name = "sentencia_AV")
public class Sentencia_AV {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long _id;

    @Column(name = "distancia", nullable = false)
    private float _distancia;

//    @Column(name = "tiempo", nullable = false)
//    private float _tiempo;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_victima", nullable = false, unique = true)
    private Victima _victima;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_agresor", nullable = false, unique = true)
    private Agresor _agresor;

    public Sentencia_AV() {

    }

    public Sentencia_AV(long id) {
        _id = id;
    }

    public Sentencia_AV(Sentencia_AV usuario) {
        _distancia = usuario._distancia;
    }

    public long get_id() {
        return _id;
    }

    public void set_id(long _id) {
        this._id = _id;
    }

    public float get_distancia() {
        return _distancia;
    }

    public void set_distancia(float _distancia) {
        this._distancia = _distancia;
    }

    public Victima get_victima() {
        return _victima;
    }

    public void set_victima(Victima _victima) {
        this._victima = _victima;
    }

    public Agresor get_agresor() {
        return _agresor;
    }

    public void set_agresor(Agresor _agresor) {
        this._agresor = _agresor;
    }


}