package com.ucab.cmcapp.logic.commands.conexion.composite;

import com.ucab.cmcapp.common.entities.User;
import com.ucab.cmcapp.common.entities.Conexion;
import com.ucab.cmcapp.logic.commands.Command;
import com.ucab.cmcapp.logic.commands.CommandFactory;
import com.ucab.cmcapp.logic.commands.user.atomic.AddUserCommand;
import com.ucab.cmcapp.logic.commands.conexion.atomic.AddConexionCommand;
import com.ucab.cmcapp.logic.commands.conexion.atomic.EraseConexionCommand;
import com.ucab.cmcapp.persistence.DBHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DeleteConexionCommand extends Command<Conexion>
{
    private static Logger _logger = LoggerFactory.getLogger( com.ucab.cmcapp.logic.commands.conexion.composite.DeleteConexionCommand.class );
    private Conexion _user;
    private Conexion _result;
    private EraseConexionCommand _addUsuarioCommand;

    public DeleteConexionCommand(Conexion conexion )
    {
        //region Instrumentation DEBUG
        _logger.debug( "Entering DeleteConexionCommand.ctor");
        //endregion

        _user = conexion;
        setHandler(new DBHandler());

        //region Instrumentation DEBUG
        _logger.debug( "Leaving DeleteConexionCommand.ctor");
        //endregion
    }

    @Override
    public void execute()
    {
        //region Instrumentation DEBUG
        _logger.debug( "Entering DeleteConexionCommand.execute");
        //endregion

        try
        {
            getHandler().beginTransaction();
            _addUsuarioCommand = CommandFactory.createEraseConexionCommand(_user, getHandler());
            _addUsuarioCommand.execute();
            _result = _addUsuarioCommand.getReturnParam();
            getHandler().finishTransaction();
            getHandler().closeSession();
        }
        catch (Exception e)
        {
            getHandler().rollbackTransaction();
            getHandler().closeSession();
            throw e;
        }
        //region Instrumentation DEBUG
        _logger.debug( "Leaving DeleteUsuarioCommand.execute");
        //endregion
    }
    @Override
    public Conexion getReturnParam()
    {
        return _result;
    }

    @Override
    public void closeHandlerSession()
    {
        getHandler().closeSession();
    }
}
