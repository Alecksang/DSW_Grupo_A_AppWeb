package com.ucab.cmcapp.logic.commands.sentencia.composite;

import com.ucab.cmcapp.common.entities.Sentencia;
import com.ucab.cmcapp.common.entities.User;
import com.ucab.cmcapp.common.entities.Usuario;
import com.ucab.cmcapp.logic.commands.Command;
import com.ucab.cmcapp.logic.commands.CommandFactory;
import com.ucab.cmcapp.logic.commands.sentencia.atomic.DeleteSentenciaByIdCommand;
import com.ucab.cmcapp.logic.commands.user.atomic.AddUserCommand;
import com.ucab.cmcapp.logic.commands.usuario.atomic.AddUsuarioCommand;
import com.ucab.cmcapp.logic.commands.usuario.atomic.DeleteUsuarioByIdCommand;
import com.ucab.cmcapp.persistence.DBHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DeleteSentenciaCommand extends Command<Sentencia>
{
    private static Logger _logger = LoggerFactory.getLogger( DeleteSentenciaCommand.class );
    private Sentencia _distancia;
    private Sentencia _result;
    private DeleteSentenciaByIdCommand _addSentenciaCommand;

    public DeleteSentenciaCommand(Sentencia distancia )
    {
        //region Instrumentation DEBUG
        _logger.debug( "Entering DeleteSentenciaCommand.ctor");
        //endregion

        _distancia = distancia;
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
            _addSentenciaCommand = CommandFactory.createDeleteSentenciaByIdCommand(_distancia, getHandler());
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
        _logger.debug( "Leaving DeleteSentenciaCommand.execute");
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

