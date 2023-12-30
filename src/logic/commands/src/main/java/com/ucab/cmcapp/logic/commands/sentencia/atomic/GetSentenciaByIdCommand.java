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
public class GetSentenciaByIdCommand extends Command<Sentencia>
{
    private static Logger _logger = LoggerFactory.getLogger( GetSentenciaByIdCommand.class );
    private long _IdAlej;
    private Sentencia _result;
    private SentenciaDao _dao;

    public GetSentenciaByIdCommand( DBHandler handler, long IdAlej )
    {
        //region Instrumentation DEBUG
        _logger.debug( String.format( "Get in GetSentenciaByIdCommand.ctor: parameter {%s}", IdAlej ) );
        //endregion

        _IdAlej = IdAlej;
        setHandler(handler);
        _dao = DaoFactory.createSentenciaDao(getHandler());

        //region Instrumentation DEBUG
        _logger.debug( String.format( "Leaving GetSentenciaByIdCommand.ctor: attribute {%s}", IdAlej ) );
        //endregion
    }

    @Override
    public void execute()
    {
        //region Instrumentation DEBUG
        _logger.debug( "Get in  GetSentenciaByIdCommand.execute" );
        //endregion
        _result = _dao.find(_IdAlej, Sentencia.class);
        //region Instrumentation DEBUG
        _logger.debug( "Leaving  GetSentenciaByIdCommand.execute" );
        //endregion
    }

    @Override
    public Sentencia getReturnParam()
    {
        return _result;
    }

    @Override
    public void closeHandlerSession()
    {
        getHandler().closeSession();
    }
}
