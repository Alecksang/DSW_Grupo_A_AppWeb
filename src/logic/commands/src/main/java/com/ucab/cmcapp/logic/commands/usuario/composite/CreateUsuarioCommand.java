package com.ucab.cmcapp.logic.commands.usuario.composite;

import com.ucab.cmcapp.common.entities.User;
import com.ucab.cmcapp.common.entities.Usuarios;
import com.ucab.cmcapp.logic.commands.Command;
import com.ucab.cmcapp.logic.commands.CommandFactory;
import com.ucab.cmcapp.logic.commands.user.atomic.AddUserCommand;
import com.ucab.cmcapp.logic.commands.usuario.atomic.AddUsuarioCommand;
import com.ucab.cmcapp.persistence.DBHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
public class CreateUsuarioCommand extends Command<Usuarios>{
    private static Logger _logger = LoggerFactory.getLogger( CreateUsuarioCommand.class );
    private Usuarios _usuario;
    private Usuarios _result;
    private AddUsuarioCommand _addUsuarioCommand;
    public CreateUsuarioCommand(Usuarios usuario )
    {
        //region Instrumentation DEBUG
        _logger.debug( "Entering CreateUsuarioCommand.ctor");
        //endregion

        _usuario = usuario;
        setHandler(new DBHandler());

        //region Instrumentation DEBUG
        _logger.debug( "Leaving CreateUsuarioCommand.ctor");
        //endregion
    }
    @Override
    public void execute()
    {
        //region Instrumentation DEBUG
        _logger.debug( "Entering CreateUserCommand.execute");
        //endregion

        try
        {
            getHandler().beginTransaction();
            _addUsuarioCommand = CommandFactory.createAddUsuarioCommand(_usuario, getHandler());
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
        _logger.debug( "Leaving CreateUserCommand.execute");
        //endregion
    }

    @Override
    public Usuarios getReturnParam()
    {
        return _result;
    }

    @Override
    public void closeHandlerSession()
    {
        getHandler().closeSession();
    }

}
