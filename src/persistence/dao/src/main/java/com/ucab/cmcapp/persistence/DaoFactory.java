package com.ucab.cmcapp.persistence;

import com.ucab.cmcapp.common.entities.Agresor;
import com.ucab.cmcapp.common.entities.Sentencia_AV;
import com.ucab.cmcapp.common.entities.Victima;
import com.ucab.cmcapp.persistence.dao.*;

public class DaoFactory
{
    private DaoFactory() {}

    public static UserDao createUserDao( DBHandler handler )
    {
        return new UserDao( handler );
    }

    //USUARIO DAO
    public static UsuarioDao createUsuarioDao( DBHandler handler )
    {
        return new UsuarioDao( handler );
    }

    //VICTIMA DAO
    public static VictimaDao createVictimaDao( DBHandler handler )
    {
        return new VictimaDao( handler );
    }

    //AGRESOR DAO
    public static AgresorDao createAgresorDao(DBHandler handler) {
        return new AgresorDao(handler);
    }

    //ALERTA DAO
    public static AlertaDao createAlertaDao( DBHandler handler )
    {
        return new AlertaDao( handler );
    }

    //ZONA SEGURA DAO
    public static ZonaSeguraDao createZonaSeguraDao(DBHandler handler) {
        return new ZonaSeguraDao(handler);
    }

    //COORDENADA DAO
    public static CoordenadaDao createCoordenadaDao( DBHandler handler )
    {
        return new CoordenadaDao( handler );
    }

    //SENTENCIA_AV DAO
    public static Sentencia_AVDao createSentencia_AVDao(DBHandler handler )
    {
        return new Sentencia_AVDao( handler );
    }

    //ADMIN DAO
    public static AdminDao createAdminDao(DBHandler handler)
    {
        return new AdminDao(handler);
    }

    //CONEXION DAO
    public static ConexionDao createConexionDao(DBHandler handler)
    {
        return new ConexionDao(handler);
    }



}
