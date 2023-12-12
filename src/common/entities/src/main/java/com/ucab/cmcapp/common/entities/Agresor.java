package com.ucab.cmcapp.common.entities;

import javax.persistence.*;

@Entity
//@Table(name = "agresor", uniqueConstraints = @UniqueConstraint(columnNames = "id_usuario"))
public class Agresor {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long _id;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn( name = "id_usuario")
    private Usuario _usuario;

    public Agresor() {
    }

    public Agresor(long _id) {
        this._id = _id;
    }

    public Agresor(Usuario _usuario) {
        this._usuario = _usuario;
    }

    public long get_id() {
        return _id;
    }

    public void set_id(long _id) {
        this._id = _id;
    }

    public Usuario get_usuario() {
        return _usuario;
    }

    public void set_usuario(Usuario _usuario) {
        this._usuario = _usuario;
    }
}