package com.ucab.cmcapp.logic.commands.usuario.atomic;

import com.ucab.cmcapp.common.entities.User;
import com.ucab.cmcapp.common.entities.Usuarios;
import com.ucab.cmcapp.logic.commands.Command;
import com.ucab.cmcapp.logic.commands.user.atomic.GetUserByEmailCommand;
import com.ucab.cmcapp.persistence.DBHandler;
import com.ucab.cmcapp.persistence.DaoFactory;
import com.ucab.cmcapp.persistence.dao.UsuarioDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
public class GetUsuarioByIdCommand extends Command<Usuarios> {
    private static Logger _logger = LoggerFactory.getLogger( GetUsuarioByIdCommand.class );
    private long usarios_ID;
    private Usuarios _result;
    private UsuarioDao _dao;

    public GetUsuarioByIdCommand( DBHandler handler, long userId )
    {
        //region Instrumentation DEBUG
        _logger.debug( String.format( "Get in GetUsuarioByIdCommand.ctor: parameter {%s}", userId ) );
        //endregion

        usarios_ID= userId;
        setHandler(handler);
        _dao = DaoFactory.createUsuarioDao(getHandler());

        //region Instrumentation DEBUG
        _logger.debug( String.format( "Leaving GetUsuarioByIdCommand.ctor: attribute {%s}", userId ) );
        //endregion
    }

    @Override
    public void execute()
    {
        //region Instrumentation DEBUG
        _logger.debug( "Get in  GetUsuarioByIdCommand.execute" );
        //endregion
        _result = _dao.find(usarios_ID, Usuarios.class);
        //region Instrumentation DEBUG
        _logger.debug( "Leaving  GetUsuarioByIdCommand.execute" );
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
