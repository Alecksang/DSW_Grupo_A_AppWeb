package com.ucab.cmcapp.logic.commands.conexion.atomic;

import com.ucab.cmcapp.common.entities.Conexion;
import com.ucab.cmcapp.logic.commands.Command;
import com.ucab.cmcapp.persistence.DBHandler;
import com.ucab.cmcapp.persistence.DaoFactory;
import com.ucab.cmcapp.persistence.dao.ConexionDao;

public class ModifyConexionCommand extends Command<Conexion> {

    private Conexion _Conexion;
    private ConexionDao _dao;

    public ModifyConexionCommand(Conexion Conexion, DBHandler handler) {
        setHandler(handler);
        _Conexion = Conexion;
        _dao = DaoFactory.createConexionDao(getHandler());
    }

    @Override
    public void execute() {
        _Conexion = _dao.update(_Conexion);
    }

    @Override
    public Conexion getReturnParam() {
        return _Conexion;
    }

    @Override
    public void closeHandlerSession() {
        getHandler().closeSession();
    }
}
