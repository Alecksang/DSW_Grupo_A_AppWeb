package com.ucab.cmcapp.logic.commands.conexion.atomic;

import com.ucab.cmcapp.common.entities.Conexion;
import com.ucab.cmcapp.logic.commands.Command;
import com.ucab.cmcapp.persistence.DBHandler;
import com.ucab.cmcapp.persistence.DaoFactory;
import com.ucab.cmcapp.persistence.dao.ConexionDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GetConexionByIdCommand extends Command<Conexion> {
    private static Logger _logger = LoggerFactory.getLogger(GetConexionByIdCommand.class);
    private long _userId;
    private Conexion _result;
    private ConexionDao _dao;

    public GetConexionByIdCommand(DBHandler handler, long userId) {
        //region Instrumentation DEBUG
        _logger.debug(String.format("Get in GetConexionByIdCommand.ctor: parameter {%s}", userId));
        //endregion

        _userId = userId;
        setHandler(handler);
        _dao = DaoFactory.createConexionDao(getHandler());

        //region Instrumentation DEBUG
        _logger.debug(String.format("Leaving GetConexionByIdCommand.ctor: attribute {%s}", userId));
        //endregion
    }

    @Override
    public void execute() {
        //region Instrumentation DEBUG
        _logger.debug("Get in  GetConexionByIdCommand.execute");
        //endregion
        _result = _dao.find(_userId, Conexion.class);
        //region Instrumentation DEBUG
        _logger.debug("Leaving  GetConexionByIdCommand.execute");
        //endregion
    }

    @Override
    public Conexion getReturnParam() {
        return _result;
    }

    @Override
    public void closeHandlerSession() {
        getHandler().closeSession();
    }
}
