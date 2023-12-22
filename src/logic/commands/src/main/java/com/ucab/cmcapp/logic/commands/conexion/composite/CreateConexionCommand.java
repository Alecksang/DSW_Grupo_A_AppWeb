package com.ucab.cmcapp.logic.commands.conexion.composite;

import com.ucab.cmcapp.common.entities.Conexion;
import com.ucab.cmcapp.logic.commands.Command;
import com.ucab.cmcapp.logic.commands.CommandFactory;
import com.ucab.cmcapp.logic.commands.conexion.atomic.AddConexionCommand;
import com.ucab.cmcapp.persistence.DBHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CreateConexionCommand extends Command<Conexion> {
    private static Logger _logger = LoggerFactory.getLogger(CreateConexionCommand.class);
    private Conexion _Conexion;
    private Conexion _result;
    private AddConexionCommand _addConexionCommand;

    public CreateConexionCommand(Conexion Conexion) {
        //region Instrumentation DEBUG
        _logger.debug("Entering CreateConexionCommand.ctor");
        //endregion

        _Conexion = Conexion;
        setHandler(new DBHandler());

        //region Instrumentation DEBUG
        _logger.debug("Leaving CreateConexionCommand.ctor");
        //endregion
    }

    @Override
    public void execute() {
        //region Instrumentation DEBUG
        _logger.debug("Entering CreateConexionCommand.execute");
        //endregion

        try {
            getHandler().beginTransaction();
            _addConexionCommand = CommandFactory.createAddConexionCommand(_Conexion, getHandler());
            _addConexionCommand.execute();
            _result = _addConexionCommand.getReturnParam();
            getHandler().finishTransaction();
            getHandler().closeSession();
        } catch (Exception e) {
            getHandler().rollbackTransaction();
            getHandler().closeSession();
            throw e;
        }
        //region Instrumentation DEBUG
        _logger.debug("Leaving CreateConexionCommand.execute");
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

