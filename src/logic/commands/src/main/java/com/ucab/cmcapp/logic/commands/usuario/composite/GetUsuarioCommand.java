package com.ucab.cmcapp.logic.commands.usuario.composite;

import com.ucab.cmcapp.common.entities.User;
import com.ucab.cmcapp.common.entities.Usuarios;
import com.ucab.cmcapp.logic.commands.Command;
import com.ucab.cmcapp.logic.commands.CommandFactory;
import com.ucab.cmcapp.logic.commands.user.composite.GetUserCommand;
import com.ucab.cmcapp.logic.commands.usuario.atomic.GetUsuarioByIdCommand;
import com.ucab.cmcapp.persistence.DBHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
public class GetUsuarioCommand extends Command<Usuarios> {
    private static Logger _logger = LoggerFactory.getLogger( GetUsuarioCommand.class );
    private Usuarios _usuario;
    long _id;

    public GetUsuarioCommand( Usuarios usuario )
    {
        //region Instrumentation DEBUG
        _logger.debug( String.format( "Get in GetUserCommand.ctor: parameter {%s}",
                usuario.toString() ) );
        _id = usuario.getUsarios_ID();
        _usuario = usuario;
        setHandler(new DBHandler());

        //region Instrumentation DEBUG
        _logger.debug( String.format( "Leaving GetUserCommand.ctor: attribute {%s}",
                _usuario.toString() ) );
        //endregion
    }

    @Override
    public void execute()
    {
        try
        {
            GetUsuarioByIdCommand getUsuarioByIdCommand = CommandFactory.createGetUsuarioByIdCommand(getHandler(), _id);
            getUsuarioByIdCommand.execute();
            _usuario = getUsuarioByIdCommand.getReturnParam();
        }
        catch (Exception e)
        {
            getHandler().rollbackTransaction();
            getHandler().closeSession();
            throw e;
        }
    }
    @Override
    public Usuarios getReturnParam()
    {
        return _usuario;
    }

    @Override
    public void closeHandlerSession()
    {
        getHandler().closeSession();
    }
}
