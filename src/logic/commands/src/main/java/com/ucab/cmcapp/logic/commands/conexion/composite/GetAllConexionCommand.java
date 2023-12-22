package com.ucab.cmcapp.logic.commands.conexion.composite;

import com.ucab.cmcapp.common.entities.Conexion;
import com.ucab.cmcapp.logic.commands.Command;
import com.ucab.cmcapp.logic.commands.CommandFactory;
import com.ucab.cmcapp.logic.commands.conexion.atomic.GetConexionByListCommand;
import com.ucab.cmcapp.logic.commands.conexion.composite.GetConexionCommand;
import com.ucab.cmcapp.persistence.DBHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class GetAllConexionCommand extends Command <Conexion> {
    private static Logger _logger = LoggerFactory.getLogger(GetConexionCommand.class);
    private List<Conexion> _Conexion;

    public GetAllConexionCommand() {
        //region Instrumentation DEBUG

        setHandler(new DBHandler());

        //endregion
    }

    @Override
    public void execute() {
        try {
            GetConexionByListCommand getConexionByListCommand = CommandFactory.createGetConexionByListCommand(getHandler());
            getConexionByListCommand.execute();
            _Conexion = getConexionByListCommand.getReturnParam();
        } catch (Exception e) {
            getHandler().rollbackTransaction();
            getHandler().closeSession();
            throw e;
        }
    }

    @Override
    public List <Conexion> getReturnParam() {
        return _Conexion;
    }

    @Override
    public void closeHandlerSession() {
        getHandler().closeSession();
    }
}
