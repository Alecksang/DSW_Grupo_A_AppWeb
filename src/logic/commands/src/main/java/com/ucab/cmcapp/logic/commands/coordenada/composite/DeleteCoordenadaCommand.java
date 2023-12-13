package com.ucab.cmcapp.logic.commands.coordenada.composite;

import com.ucab.cmcapp.common.entities.Coordenada;
import com.ucab.cmcapp.logic.commands.Command;
import com.ucab.cmcapp.logic.commands.CommandFactory;
import com.ucab.cmcapp.logic.commands.coordenada.atomic.DeleteCoordenadaByIdCommand;
import com.ucab.cmcapp.persistence.DBHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DeleteCoordenadaCommand extends Command<Coordenada>
{
    private static Logger _logger = LoggerFactory.getLogger( DeleteCoordenadaCommand.class );
    private Coordenada _user;
    private Coordenada _result;
    private DeleteCoordenadaByIdCommand _addCoordenadaZonaSeguridadCommand;

    public DeleteCoordenadaCommand(Coordenada user )
    {
        //region Instrumentation DEBUG
        _logger.debug( "Entering DeleteCoordenadaCommand.ctor");
        //endregion

        _user = user;
        setHandler(new DBHandler());

        //region Instrumentation DEBUG
        _logger.debug( "Leaving DeleteCoordenadaCommand.ctor");
        //endregion
    }

    @Override
    public void execute()
    {
        //region Instrumentation DEBUG
        _logger.debug( "Entering DeleteCoordenadaCommand.execute");
        //endregion

        try
        {
            getHandler().beginTransaction();
            _addCoordenadaZonaSeguridadCommand = CommandFactory.createDeleteCoordenadaByIdCommand(_user, getHandler());
            _addCoordenadaZonaSeguridadCommand.execute();
            _result = _addCoordenadaZonaSeguridadCommand.getReturnParam();
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
        _logger.debug( "Leaving DeleteCoordenadaCommand.execute");
        //endregion
    }

    @Override
    public Coordenada getReturnParam()
    {
        return _result;
    }

    @Override
    public void closeHandlerSession()
    {
        getHandler().closeSession();
    }
}
