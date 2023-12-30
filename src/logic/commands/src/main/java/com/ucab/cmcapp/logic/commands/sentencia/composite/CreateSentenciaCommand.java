package com.ucab.cmcapp.logic.commands.sentencia.composite;

import com.ucab.cmcapp.common.entities.Sentencia;
import com.ucab.cmcapp.common.entities.User;
import com.ucab.cmcapp.logic.commands.Command;
import com.ucab.cmcapp.logic.commands.CommandFactory;
import com.ucab.cmcapp.logic.commands.sentencia.atomic.AddSentenciaCommand;
import com.ucab.cmcapp.logic.commands.user.atomic.AddUserCommand;
import com.ucab.cmcapp.persistence.DBHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CreateSentenciaCommand extends Command<Sentencia>
{
    private static Logger _logger = LoggerFactory.getLogger( CreateSentenciaCommand.class );
    private Sentencia _distancia;
    private Sentencia _result;
    private AddSentenciaCommand _addSentenciaCommand;

    public CreateSentenciaCommand(Sentencia distancia )
    {
        //region Instrumentation DEBUG
        _logger.debug( "Entering CreateSentenciaCommand.ctor");
        //endregion

        _distancia = distancia;
        setHandler(new DBHandler());

        //region Instrumentation DEBUG
        _logger.debug( "Leaving CreateSentenciaCommand.ctor");
        //endregion
    }

    @Override
    public void execute()
    {
        //region Instrumentation DEBUG
        _logger.debug( "Entering CreateSentenciaCommand.execute");
        //endregion

        try
        {
            getHandler().beginTransaction();
            _addSentenciaCommand = CommandFactory.createAddSentenciaCommand(_distancia, getHandler());
            _addSentenciaCommand.execute();
            _result = _addSentenciaCommand.getReturnParam();
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
        _logger.debug( "Leaving CreateSentenciaCommand.execute");
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
