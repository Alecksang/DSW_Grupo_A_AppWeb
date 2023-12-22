package com.ucab.cmcapp.logic.commands.conexion.atomic;

import com.ucab.cmcapp.common.entities.Conexion;
import com.ucab.cmcapp.logic.commands.Command;
import com.ucab.cmcapp.persistence.DBHandler;
import com.ucab.cmcapp.persistence.DaoFactory;
import com.ucab.cmcapp.persistence.dao.ConexionDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AddConexionCommand extends Command<Conexion> {
    private static Logger _logger = LoggerFactory.getLogger(AddConexionCommand.class);
    private Conexion _Conexion;
    private ConexionDao _dao;

    public AddConexionCommand(Conexion Conexion, DBHandler handler) {
        //region Instrumentation DEBUG
        _logger.debug(String.format("Get in AddConexionCommand.ctor: parameter {%s}",
                Conexion.toString()));
        setHandler(handler);
        _Conexion = Conexion;
        _dao = DaoFactory.createConexionDao(getHandler());


        //region Instrumentation DEBUG
        _logger.debug(String.format("Leaving AddConexionCommand.ctor: attribute {%s}",
                _Conexion.toString()));
        //endregion
    }

    public AddConexionCommand(Conexion Conexion) {
        //region Instrumentation DEBUG
        _logger.debug(String.format("Get in AddConexionCommand.ctor: parameter {%s}",
                Conexion.toString()));
        _Conexion = Conexion;
        setHandler(new DBHandler());
        _dao = DaoFactory.createConexionDao(getHandler());


        //region Instrumentation DEBUG
        _logger.debug(String.format("Leaving AddConexionCommand.ctor: attribute {%s}",
                _Conexion.toString()));
        //endregion
    }

    @Override
    public void execute() {
        //region Instrumentation DEBUG
        _logger.debug("Get in  AddConexionCommand.execute");
        //endregion

        _Conexion = _dao.insert(_Conexion);

        //region Instrumentation DEBUG
        _logger.debug("Get in  AddConexionCommand.execute");
        //endregion
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
