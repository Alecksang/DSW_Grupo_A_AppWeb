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
    public static Sentencia createSentencia() {
        return new Sentencia();
    }
    public static Sentencia createSentencia(long id) {
        return new Sentencia(id);
    }

    //Metodos para la clase ADMINISTRADOR
    public static Admin createAdmin() {
        return new Admin();
    }
    public static Admin createAdmin(long id) {
        return new Admin(id);
    }

    //Metodos para la clase CONEXION
    public static Conexion createConexion() {
        return new Conexion();
    }
    public static Conexion createConexion(long id) {
        return new Conexion(id);
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
