package com.ucab.cmcapp.logic.commands.usuario.atomic;

import com.ucab.cmcapp.common.entities.User;
import com.ucab.cmcapp.common.entities.Usuarios;
import com.ucab.cmcapp.logic.commands.Command;
import com.ucab.cmcapp.logic.commands.user.atomic.GetUserByEmailCommand;
import com.ucab.cmcapp.persistence.DBHandler;
import com.ucab.cmcapp.persistence.DaoFactory;
import com.ucab.cmcapp.persistence.dao.UserDao;
import com.ucab.cmcapp.persistence.dao.UsuarioDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
public class GetUsuarioByUsernameCommand extends Command<Usuarios> {
    private static Logger _logger = LoggerFactory.getLogger( GetUsuarioByUsernameCommand.class );
    private Usuarios usuarios_username;
    private UsuarioDao _dao;
    public GetUsuarioByUsernameCommand(Usuarios usuario )
    {
        //region Instrumentation DEBUG
        _logger.debug( String.format( "Get in GetUserByUsernameCommand.ctor: parameter {%s}", usuario.toString() ) );
        usuarios_username = usuario;
        setHandler(new DBHandler());
        _dao = DaoFactory.createUsuarioDao(getHandler());

        //region Instrumentation DEBUG
        _logger.debug( String.format( "Leavin GetUserByUsernameCommand.ctor: atribute {%s}", usuario.toString() ) );
        //endregion
    }

    public GetUsuarioByUsernameCommand(Usuarios usuario, DBHandler handler )
    {
        //region Instrumentation DEBUG
        _logger.debug( String.format( "Get in GetUserByUsernameCommand.ctor: parameter {%s}", usuario.toString() ) );
        usuarios_username = usuario;;
        setHandler(handler);
        _dao = DaoFactory.createUsuarioDao(getHandler());

        //region Instrumentation DEBUG
        _logger.debug( String.format( "Leavin GetUserByUsernameCommand.ctor: atribute {%s}", usuario.toString() ) );
        //endregion
    }

    @Override
    public void execute()
    {
        //region Instrumentation DEBUG
        _logger.debug( "Get in  GetUserByEmailCommand.execute" );
        //endregion
        usuarios_username = _dao.getUsuarioByUsername(usuarios_username.getUsuarios_username());
        //region Instrumentation DEBUG
        _logger.debug( "Leavin  GetUserByEmailCommand.execute" );
        //endregion
    }

    @Override
    public Usuarios getReturnParam()
    {
        return usuarios_username;
    }

    @Override
    public void closeHandlerSession()
    {
        getHandler().closeSession();
    }
}
