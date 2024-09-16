package com.ucab.cmcapp.common.entities;

import javax.persistence.*;

@Entity
@Table(name = "zonaSegura")
public class ZonaSegura {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long _idZona;

    @Column(name = "nombre", nullable = false)
    private String _nombreZona;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "IdUsuario", nullable = false)
    private Usuario _usuario;

    public ZonaSegura() {
    }

    public ZonaSegura(String _nombreZona, Usuario _usuario) {
        this._nombreZona = _nombreZona;
        this._usuario = _usuario;
    }

    public ZonaSegura(long _idZona) {
        this._idZona = _idZona;
    }

    public long get_idZona() {
        return _idZona;
    }

    public void set_idZona(long _idZona) {
        this._idZona = _idZona;
    }

    public String get_nombreZona() {
        return _nombreZona;
    }

    public void set_nombreZona(String _nombreZona) {
        this._nombreZona = _nombreZona;
    }

    public Usuario getUsuario() {
        return _usuario;
    }

    public void setUsuario(Usuario _usuario) {
        this._usuario = _usuario;
    }
}