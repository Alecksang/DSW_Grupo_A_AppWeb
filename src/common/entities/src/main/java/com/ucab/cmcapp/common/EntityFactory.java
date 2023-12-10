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



    /*Metodos para la clase usuario*/
    public static Usuarios createUsuario()
    {
        return new Usuarios();
    }
    public static Usuarios createUsuario(long id)
    {
        return new Usuarios(id);
    }


    //Metodos para la clase victima
    public static Victima createVictima()
    {
        return new Victima();
    }
    public static Victima createVictima(long id)
    {
        return new Victima(id);
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
