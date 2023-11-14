package com.ucab.cmcapp.common.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
public class Alerta implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long _alertaId;
    private String _alertaTipo;
    @ManyToOne
    private Usuarios _victima;
    private Date _alertaFechaHora;

    public Alerta() {
    }

    public Alerta(String _alertaTipo, Usuarios _victima, Date _alertaFechaHora) {
        this._alertaTipo = _alertaTipo;
        this._victima = _victima;
        this._alertaFechaHora = _alertaFechaHora;
    }

    public Alerta(long id) {
        this._alertaId = id;
    }

    public long get_alertaId() {
        return _alertaId;
    }

    public void set_alertaId(long _alertaId) {
        this._alertaId = _alertaId;
    }

    public String get_alertaTipo() {
        return _alertaTipo;
    }

    public void set_alertaTipo(String _alertaTipo) {
        this._alertaTipo = _alertaTipo;
    }

    public Usuarios get_victima() {
        return _victima;
    }

    public void set_victima(Usuarios _victima) {
        this._victima = _victima;
    }

    public Date get_alertaFechaHora() {
        return _alertaFechaHora;
    }

    public void set_alertaFechaHora(Date _alertaFechaHora) {
        this._alertaFechaHora = _alertaFechaHora;
    }
}
