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

public class AddSentenciaCommand extends Command<Sentencia>
{
    private static Logger _logger = LoggerFactory.getLogger( AddSentenciaCommand.class );
    private Sentencia _distancia;
    private SentenciaDao _dao;

    public AddSentenciaCommand( Sentencia distancia, DBHandler handler )
    {
        //region Instrumentation DEBUG
        _logger.debug( String.format( "Get in AddSentenciaCommand.ctor: parameter {%s}",
                distancia.toString() ) );
        setHandler(handler);
        _distancia = distancia;
        _dao = DaoFactory.createSentenciaDao(getHandler());


        //region Instrumentation DEBUG
        _logger.debug( String.format( "Leaving AddSentenciaCommand.ctor: attribute {%s}",
                _distancia.toString() ) );
        //endregion
    }

    public AddSentenciaCommand( Sentencia distancia )
    {
        //region Instrumentation DEBUG
        _logger.debug( String.format( "Get in AddSentenciaCommand.ctor: parameter {%s}",
                distancia.toString() ) );
        _distancia = distancia;
        setHandler(new DBHandler());
        _dao = DaoFactory.createSentenciaDao(getHandler());


        //region Instrumentation DEBUG
        _logger.debug( String.format( "Leaving AddSentenciaCommand.ctor: attribute {%s}",
                _distancia.toString() ) );
        //endregion
    }

    @Override
    public void execute()
    {
        //region Instrumentation DEBUG
        _logger.debug( "Get in  AddSentenciaCommand.execute" );
        //endregion

        _distancia = _dao.insert( _distancia);

        //region Instrumentation DEBUG
        _logger.debug( "Get in  AddSentenciaCommand.execute" );
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
