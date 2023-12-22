package com.ucab.cmcapp.logic.commands.conexion.composite;

import com.ucab.cmcapp.common.entities.Conexion;
import com.ucab.cmcapp.logic.commands.Command;
import com.ucab.cmcapp.logic.commands.CommandFactory;
import com.ucab.cmcapp.logic.commands.conexion.atomic.GetConexionByIdCommand;
import com.ucab.cmcapp.persistence.DBHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GetConexionCommand extends Command<Conexion> {
    private static Logger _logger = LoggerFactory.getLogger(GetConexionCommand.class);
    private Conexion _Conexion;
    long _id;

    public GetConexionCommand(Conexion Conexion) {
        //region Instrumentation DEBUG
        _logger.debug(String.format("Get in GetConexionCommand.ctor: parameter {%s}",
                Conexion.toString()));
        _id = Conexion.get_id();
        _Conexion = Conexion;
        setHandler(new DBHandler());

        //region Instrumentation DEBUG
        _logger.debug(String.format("Leaving GetConexionCommand.ctor: attribute {%s}",
                _Conexion.toString()));
        //endregion
    }

    @Override
    public void execute() {
        try {
            GetConexionByIdCommand getConexionByIdCommand = CommandFactory.createGetConexionByIdCommand(getHandler(), _id);
            getConexionByIdCommand.execute();
            _Conexion = getConexionByIdCommand.getReturnParam();
        } catch (Exception e) {
            getHandler().rollbackTransaction();
            getHandler().closeSession();
            throw e;
        }
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
