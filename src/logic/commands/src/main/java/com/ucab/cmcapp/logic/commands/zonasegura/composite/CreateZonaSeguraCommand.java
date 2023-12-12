package com.ucab.cmcapp.logic.commands.zonasegura.composite;

import com.ucab.cmcapp.common.entities.ZonaSegura;
import com.ucab.cmcapp.logic.commands.Command;
import com.ucab.cmcapp.logic.commands.CommandFactory;
import com.ucab.cmcapp.logic.commands.zonasegura.atomic.AddZonaSeguraCommand;
import com.ucab.cmcapp.persistence.DBHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CreateZonaSeguraCommand extends Command<ZonaSegura>
{
    private static Logger _logger = LoggerFactory.getLogger( CreateZonaSeguraCommand.class );
    private ZonaSegura _user;
    private ZonaSegura _result;
    private AddZonaSeguraCommand _addZonaSeguridadCommand;

    public CreateZonaSeguraCommand(ZonaSegura user )
    {
        //region Instrumentation DEBUG
        _logger.debug( "Entering CreateZonaSeguraCommand.ctor");
        //endregion

        _user = user;
        setHandler(new DBHandler());

        //region Instrumentation DEBUG
        _logger.debug( "Leaving CreateZonaSeguraCommand.ctor");
        //endregion
    }

    @Override
    public void execute()
    {
        //region Instrumentation DEBUG
        _logger.debug( "Entering CreateZonaSeguraCommand.execute");
        //endregion

        try
        {
            getHandler().beginTransaction();
            _addZonaSeguridadCommand = CommandFactory.createAddZonaSeguraCommand(_user, getHandler());
            _addZonaSeguridadCommand.execute();
            _result = _addZonaSeguridadCommand.getReturnParam();
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
    public ZonaSegura getReturnParam()
    {
        return _result;
    }

    @Override
    public void closeHandlerSession()
    {
        getHandler().closeSession();
    }
}
