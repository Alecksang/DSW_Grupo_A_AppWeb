package com.ucab.cmcapp.logic.commands.zonasegura.composite;
import com.ucab.cmcapp.common.entities.ZonaSegura;
import com.ucab.cmcapp.logic.commands.Command;
import com.ucab.cmcapp.logic.commands.CommandFactory;
import com.ucab.cmcapp.logic.commands.zonasegura.atomic.DeleteZonaSeguraByIdCommand;
import com.ucab.cmcapp.persistence.DBHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DeleteZonaSeguraCommand extends Command<ZonaSegura>
{
    private static Logger _logger = LoggerFactory.getLogger( DeleteZonaSeguraCommand.class );
    private ZonaSegura _user;
    private ZonaSegura _result;
    private DeleteZonaSeguraByIdCommand _addZonaSeguraCommand;

    public DeleteZonaSeguraCommand(ZonaSegura user )
    {
        //region Instrumentation DEBUG
        _logger.debug( "Entering DeleteZonaSeguraCommand.ctor");
        //endregion

        _user = user;
        setHandler(new DBHandler());

        //region Instrumentation DEBUG
        _logger.debug( "Leaving DeleteZonaSeguraCommand.ctor");
        //endregion
    }

    @Override
    public void execute()
    {
        //region Instrumentation DEBUG
        _logger.debug( "Entering DeleteZonaSeguraCommand.execute");
        //endregion

        try
        {
            getHandler().beginTransaction();
            _addZonaSeguraCommand = CommandFactory.createDeleteZonaSeguraByIdCommand(_user, getHandler());
            _addZonaSeguraCommand.execute();
            _result = _addZonaSeguraCommand.getReturnParam();
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
        _logger.debug( "Leaving DeleteZonaSeguraCommand.execute");
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
