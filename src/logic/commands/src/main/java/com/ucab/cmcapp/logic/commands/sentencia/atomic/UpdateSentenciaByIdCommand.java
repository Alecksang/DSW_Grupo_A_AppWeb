package com.ucab.cmcapp.logic.commands.sentencia.atomic;

import com.ucab.cmcapp.common.entities.Sentencia;
import com.ucab.cmcapp.common.entities.Usuario;
import com.ucab.cmcapp.logic.commands.Command;
import com.ucab.cmcapp.persistence.DBHandler;
import com.ucab.cmcapp.persistence.DaoFactory;
import com.ucab.cmcapp.persistence.dao.SentenciaDao;
import com.ucab.cmcapp.persistence.dao.UsuarioDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UpdateSentenciaByIdCommand extends Command<Sentencia>
{
    private static Logger _logger = LoggerFactory.getLogger( UpdateSentenciaByIdCommand.class );
    private Sentencia _distancia;
    private SentenciaDao _dao;

    public UpdateSentenciaByIdCommand(Sentencia distancia, DBHandler handler )
    {
        //region Instrumentation DEBUG
        _logger.debug( String.format( "Get in UpdateSentenciaByIdCommand.ctor: parameter {%s}",
                distancia.toString() ) );
        setHandler(handler);
        _distancia = distancia;
        _dao = DaoFactory.createSentenciaDao(getHandler());


        //region Instrumentation DEBUG
        _logger.debug( String.format( "Leaving UpdateSentenciaByIdCommand.ctor: attribute {%s}",
                _distancia.toString() ) );
        //endregion
    }

    public UpdateSentenciaByIdCommand(Sentencia distancia )
    {
        //region Instrumentation DEBUG
        _logger.debug( String.format( "Get in UpdateSentenciaByIdCommand.ctor: parameter {%s}",
                distancia.toString() ) );
        _distancia = distancia;
        setHandler(new DBHandler());
        _dao = DaoFactory.createSentenciaDao(getHandler());


        //region Instrumentation DEBUG
        _logger.debug( String.format( "Leaving UpdateSentenciaByIdCommand.ctor: attribute {%s}",
                _distancia.toString() ) );
        //endregion
    }

    @Override
    public void execute()
    {
        //region Instrumentation DEBUG
        _logger.debug( "Get in  UpdateSentenciaByIdCommand.execute" );
        //endregion

        _dao.update( _distancia);


        //region Instrumentation DEBUG
        _logger.debug( "Get in  UpdateSentenciaByIdCommand.execute" );
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
