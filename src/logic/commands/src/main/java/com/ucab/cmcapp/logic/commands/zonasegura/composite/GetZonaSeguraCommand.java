package com.ucab.cmcapp.logic.commands.zonasegura.composite;

import com.ucab.cmcapp.common.entities.ZonaSegura;
import com.ucab.cmcapp.logic.commands.Command;
import com.ucab.cmcapp.logic.commands.CommandFactory;
import com.ucab.cmcapp.logic.commands.zonasegura.atomic.GetZonaSeguraByIdCommand;
import com.ucab.cmcapp.persistence.DBHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GetZonaSeguraCommand extends Command<ZonaSegura>
{
    private static Logger _logger = LoggerFactory.getLogger( GetZonaSeguraCommand.class );
    private ZonaSegura _user;
    long _id;

    public GetZonaSeguraCommand( ZonaSegura user )
    {
        //region Instrumentation DEBUG
        _logger.debug( String.format( "Get in GetZonaSeguraCommand.ctor: parameter {%s}",
                user.toString() ) );
        _id = user.get_idZona();
        _user = user;
        setHandler(new DBHandler());

        //region Instrumentation DEBUG
        _logger.debug( String.format( "Leaving GetZonaSeguraCommand.ctor: attribute {%s}",
                _user.toString() ) );
        //endregion
    }

    @Override
    public void execute()
    {
        try
        {
            GetZonaSeguraByIdCommand getZonaSeguraByIdCommand = CommandFactory.createGetZonaSeguraByIdCommand(getHandler(), _id);
            getZonaSeguraByIdCommand.execute();
            _user = getZonaSeguraByIdCommand.getReturnParam();
        }
        catch (Exception e)
        {
            getHandler().rollbackTransaction();
            getHandler().closeSession();
            throw e;
        }
    }

    @Override
    public ZonaSegura getReturnParam()
    {
        return _user;
    }

    @Override
    public void closeHandlerSession()
    {
        getHandler().closeSession();
    }
}

