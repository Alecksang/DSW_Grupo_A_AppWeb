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
}