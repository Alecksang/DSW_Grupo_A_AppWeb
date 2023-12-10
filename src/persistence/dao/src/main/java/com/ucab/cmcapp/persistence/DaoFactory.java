package com.ucab.cmcapp.persistence;

import com.ucab.cmcapp.common.entities.Agresor;
import com.ucab.cmcapp.persistence.dao.*;
import com.ucab.cmcapp.common.entities.Victima;

public class DaoFactory
{
    private DaoFactory() {}

    public static UserDao createUserDao( DBHandler handler )
    {
        return new UserDao( handler );
    }

    //Usuario Dao
    public static UsuarioDao createUsuarioDao( DBHandler handler )
    {
        return new UsuarioDao( handler );
    }
    //Victima Dao
    public static VictimaDao createVictimaDao( DBHandler handler )
    {
        return new VictimaDao( handler );
    }
    //Agresor Dao
    public static AgresorDao createAgresorDao(DBHandler handler) {
        return new AgresorDao(handler);
    }
    //Alerta Dao
    public static AlertaDao createAlertaDao( DBHandler handler )
    {
        return new AlertaDao( handler );
    }
}
