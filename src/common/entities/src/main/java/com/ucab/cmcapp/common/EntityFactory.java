package com.ucab.cmcapp.common;
import com.ucab.cmcapp.common.entities.*;
public class EntityFactory

{

    public static User createUser()
    {
        return new User();
    }
    public static User createUser(long id)
    {
        return new User(id);
    }



    //Metodos para la clase USUARIO
    public static Usuario createUsuario()
    {
        return new Usuario();
    }
    public static Usuario createUsuario(long id)
    {
        return new Usuario(id);
    }

    //Metodos para la clase VICTIMA
    public static Victima createVictima()
    {
        return new Victima();
    }
    public static Victima createVictima(long id)
    {
        return new Victima(id);
    }

    //Metodos para la clase AGRESOR
    public static Agresor createAgresor() {
        return new Agresor();
    }
    public static Agresor createAgresor(long id) {
        return new Agresor(id);
    }

    //Metodos para la clase ZONA SEGURA
    public static ZonaSegura createZonaSegura(long id) {
        return new ZonaSegura(id);
    }
    public static ZonaSegura createZonaSegura() {
        return new ZonaSegura();
    }

    //Metodos para la clase ALERTA
    public static Alerta createAlerta()
    {
        return new Alerta();
    }
    public static Alerta createAlerta(long id)
    {
        return new Alerta(id);
    }

    //Metodos para la clase COORDENADA
    public static Coordenada createCoordenada() {
        return new Coordenada();
    }
    public static Coordenada createCoordenada(long id) {
        return new Coordenada(id);
    }

    //Metodos para la clase SENTENCIA
    public static Sentencia_AV createSentencia_AV() {
        return new Sentencia_AV();
    }
    public static Sentencia_AV createSentencia_AV(long id) {
        return new Sentencia_AV(id);
    }

    //Metodos para la clase ADMINISTRADOR
    public static Admin createAdmin() {
        return new Admin();
    }
    public static Admin createAdmin(long id) {
        return new Admin(id);
    }



    /**
     * Method that returns an instance of UserType class
     */
    public static UserType createUserType()
    {
        return new UserType();
    }
    /**
     * Method that returns an instance of UserType class
     */
    public static UserType createUserType(long id)
    {
        return new UserType(id);
    }
}
