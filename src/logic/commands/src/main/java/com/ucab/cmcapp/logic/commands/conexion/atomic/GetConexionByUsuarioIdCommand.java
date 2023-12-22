package com.ucab.cmcapp.logic.commands.conexion.atomic;

import com.ucab.cmcapp.common.entities.Conexion;
import com.ucab.cmcapp.logic.commands.Command;
import com.ucab.cmcapp.persistence.DBHandler;
import com.ucab.cmcapp.persistence.DaoFactory;
import com.ucab.cmcapp.persistence.dao.ConexionDao;

import java.util.List;

public class GetConexionByUsuarioIdCommand extends Command<Conexion> {

    private Conexion _Conexion;
    private List<Conexion> _result;
    private ConexionDao _dao;

    public GetConexionByUsuarioIdCommand(Conexion zonaSegura) {
        _Conexion = zonaSegura;
        setHandler(new DBHandler());
        _dao = DaoFactory.createConexionDao(getHandler());
    }

    @Override
    public void execute() {
        _result = _dao.getAllConexionByUserId(_Conexion.get_usuario());
    }

    @Override
    public List<Conexion> getReturnParam() {
        return _result;
    }

    @Override
    public void closeHandlerSession() {
        getHandler().closeSession();
    }

}
