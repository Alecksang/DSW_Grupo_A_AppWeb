package com.ucab.cmcapp.logic.commands.sentencia.composite;


import com.ucab.cmcapp.common.entities.Sentencia;
import com.ucab.cmcapp.common.entities.User;
import com.ucab.cmcapp.logic.commands.Command;
import com.ucab.cmcapp.logic.commands.CommandFactory;
import com.ucab.cmcapp.logic.commands.sentencia.atomic.GetSentenciaByIdCommand;
import com.ucab.cmcapp.logic.commands.user.atomic.GetUserByIdCommand;
import com.ucab.cmcapp.persistence.DBHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GetSentenciaCommand extends Command<Sentencia>
{
    private static Logger _logger = LoggerFactory.getLogger( GetSentenciaCommand.class );
    private Sentencia _distancia;
    long _id;

    public GetSentenciaCommand( Sentencia distancia )
    {
        //region Instrumentation DEBUG
        _logger.debug( String.format( "Get in GetSentenciaCommand.ctor: parameter {%s}",
                distancia.toString() ) );
        _id = distancia.get_IdAlej();
        _distancia = distancia;
        setHandler(new DBHandler());

        //region Instrumentation DEBUG
        _logger.debug( String.format( "Leaving GetSentenciaCommand.ctor: attribute {%s}",
                _distancia.toString() ) );
        //endregion
    }

    @Override
    public void execute()
    {
        try
        {
            GetSentenciaByIdCommand getSentenciaByIdCommand = CommandFactory.createGetSentenciaByIdCommand(getHandler(), _id);
            getSentenciaByIdCommand.execute();
            _distancia = getSentenciaByIdCommand.getReturnParam();
        }
        catch (Exception e)
        {
            getHandler().rollbackTransaction();
            getHandler().closeSession();
            throw e;
        }
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
