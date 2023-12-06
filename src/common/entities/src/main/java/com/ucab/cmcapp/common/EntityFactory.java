package com.ucab.cmcapp.common;

import com.ucab.cmcapp.common.entities.*;

public class EntityFactory

{
    /**
     * Method that returns an instance of User class
     */
    public static User createUser()
    {
        return new User();
    }

    /**
     * Method that returns an instance of User class
     */
    public static Usuarios createUsuario()
    {
        return new Usuarios();
    }


    /*Metodos para la clase usuario*/
    public static Usuarios createUsuario(long id)
    {
        return new Usuarios(id);
    }

    public static User createUser(long id)
    {
        return new User(id);
    }

    /*Metodos para la clase alerta*/
    public static Alerta createAlerta()
    {
        return new Alerta();
    }

    public static Alerta createAlerta(long id)
    {
        return new Alerta(id);
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
