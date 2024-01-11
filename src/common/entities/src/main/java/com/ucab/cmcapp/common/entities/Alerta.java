package com.ucab.cmcapp.common.entities;


import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Alertas")
public class Alerta  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdAlerta")
    private long _IdAlerta;

    @Column(name = "latitud", nullable = false)
    private float _latitudY;

    @Column(name = "longitud", nullable = false)
    private float _longitudX;

    @Column(name = "TipoAlerta")
    private String _tipoAlerta;

    @Column(name = "FechaHora")
    private Date _fechaHora;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn( name = "IdUsuario", nullable = false )
    private Usuario usuario;

    public Alerta() {
    }

    public Alerta(String _tipoAlerta, Date _fechaHora, Usuario usuario) {
        this._tipoAlerta = _tipoAlerta;
        this._fechaHora = _fechaHora;
        this.usuario = usuario;
    }

    public Alerta(float _latitudY, float _longitudX) {
        this._latitudY = _latitudY;
        this._longitudX = _longitudX;
    }

    public Alerta(long _IdAlerta) {
        this._IdAlerta = _IdAlerta;
    }

    public long get_IdAlerta() {
        return _IdAlerta;
    }

    public void set_IdAlerta(long _IdAlerta) {
        this._IdAlerta = _IdAlerta;
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

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
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
}