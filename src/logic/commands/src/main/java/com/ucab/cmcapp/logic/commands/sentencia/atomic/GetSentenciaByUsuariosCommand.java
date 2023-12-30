package com.ucab.cmcapp.logic.commands.sentencia.atomic;

import com.ucab.cmcapp.common.entities.Sentencia;
import com.ucab.cmcapp.common.entities.User;
import com.ucab.cmcapp.logic.commands.Command;
import com.ucab.cmcapp.persistence.DBHandler;
import com.ucab.cmcapp.persistence.DaoFactory;
import com.ucab.cmcapp.persistence.dao.SentenciaDao;
import com.ucab.cmcapp.persistence.dao.UserDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GetSentenciaByUsuariosCommand extends Command<Sentencia>
{
    private static Logger _logger = LoggerFactory.getLogger( GetSentenciaByUsuariosCommand.class );
    private Sentencia _distancia;
    private SentenciaDao _dao;

    public GetSentenciaByUsuariosCommand(Sentencia distancia )
    {
        //region Instrumentation DEBUG
        _logger.debug( String.format( "Get in GetSentenciaByUsuariosCommand.ctor: parameter {%s}", distancia.toString() ) );
        _distancia = distancia;
        setHandler(new DBHandler());
        _dao = DaoFactory.createSentenciaDao(getHandler());

        //region Instrumentation DEBUG
        _logger.debug( String.format( "Leavin GetSentenciaByUsuariosCommand.ctor: atribute {%s}", _distancia.toString() ) );
        //endregion
    }

    public GetSentenciaByUsuariosCommand(Sentencia distancia, DBHandler handler )
    {
        //region Instrumentation DEBUG
        _logger.debug( String.format( "Get in GetSentenciaByUsuariosCommand.ctor: parameter {%s}", distancia.toString() ) );
        _distancia = distancia;
        setHandler(handler);
        _dao = DaoFactory.createSentenciaDao(getHandler());

        //region Instrumentation DEBUG
        _logger.debug( String.format( "Leavin GetSentenciaByUsuariosCommand.ctor: atribute {%s}", _distancia.toString() ) );
        //endregion
    }

    @Override
    public void execute()
    {
        //region Instrumentation DEBUG
        _logger.debug( "Get in  GetSentenciaByUsuariosCommand.execute" );
        //endregion
        //_distancia = _dao.getSentenciaByUsuarios(_distancia.get_victima().get_idUsuario(),_distancia.get_agresor().get_idUsuario());
        //region Instrumentation DEBUG
        _logger.debug( "Leavin  GetSentenciaByUsuariosCommand.execute" );
        //endregion
    }

    @Override
    public Sentencia getReturnParam()
    {
        return _distancia;
    }

    @Override
    public void closeHandlerSession()
    {
        getHandler().closeSession();
    }
}
