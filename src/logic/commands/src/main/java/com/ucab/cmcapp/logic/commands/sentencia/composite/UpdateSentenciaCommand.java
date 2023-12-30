package com.ucab.cmcapp.logic.commands.sentencia.composite;


import com.ucab.cmcapp.common.entities.Sentencia;
import com.ucab.cmcapp.logic.commands.Command;
import com.ucab.cmcapp.logic.commands.CommandFactory;
import com.ucab.cmcapp.logic.commands.sentencia.atomic.DeleteSentenciaByIdCommand;
import com.ucab.cmcapp.logic.commands.sentencia.atomic.UpdateSentenciaByIdCommand;
import com.ucab.cmcapp.persistence.DBHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UpdateSentenciaCommand extends Command<Sentencia>
{
    private static Logger _logger = LoggerFactory.getLogger( UpdateSentenciaCommand.class );
    private Sentencia _user;
    private Sentencia _result;
    private UpdateSentenciaByIdCommand _addDistanciaCommand;

    public UpdateSentenciaCommand(Sentencia user )
    {
        //region Instrumentation DEBUG
        _logger.debug( "Entering DeleteSentenciaCommand.ctor");
        //endregion

        _user = user;
        setHandler(new DBHandler());

        //region Instrumentation DEBUG
        _logger.debug( "Leaving DeleteSentenciaCommand.ctor");
        //endregion
    }

    @Override
    public void execute()
    {
        //region Instrumentation DEBUG
        _logger.debug( "Entering DeleteSentenciaCommand.execute");
        //endregion

        try
        {
            getHandler().beginTransaction();
            _addDistanciaCommand = CommandFactory.createUpdateSentenciaByIdCommand(_user, getHandler());
            _addDistanciaCommand.execute();
            _result = _addDistanciaCommand.getReturnParam();
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
        _logger.debug( "Leaving DeleteDistanciaCommand.execute");
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
