package com.ucab.cmcapp.common.entities;

import javax.persistence.*;

@Entity
@Table(name = "victima", uniqueConstraints = @UniqueConstraint(columnNames = "id_usuario"))
public class Victima {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long _id;
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn( name = "id_usuario")
    private Usuarios _usuario;

    public Victima(){}

    public Victima(long _id) {
        this._id = _id;
    }
    public Victima(Usuarios _usuario) {
        this._usuario = _usuario;
    }

    public long get_id() {
        return _id;
    }

    public void set_id(long _id) {
        this._id = _id;
    }

    public Usuarios get_usuario() {
        return _usuario;
    }

    public void set_usuario(Usuarios _usuario) {
        this._usuario = _usuario;
    }
}