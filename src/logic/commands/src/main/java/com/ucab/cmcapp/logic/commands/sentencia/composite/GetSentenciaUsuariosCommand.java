package com.ucab.cmcapp.logic.commands.sentencia.composite;

import com.ucab.cmcapp.common.entities.Sentencia;
import com.ucab.cmcapp.logic.commands.Command;
import com.ucab.cmcapp.logic.commands.CommandFactory;
import com.ucab.cmcapp.logic.commands.sentencia.atomic.GetSentenciaByIdCommand;
import com.ucab.cmcapp.logic.commands.sentencia.atomic.GetSentenciaByUsuariosCommand;
import com.ucab.cmcapp.persistence.DBHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class GetSentenciaUsuariosCommand extends Command<Sentencia>
{
    private static Logger _logger = LoggerFactory.getLogger( GetSentenciaUsuariosCommand.class );
    private List<Sentencia> _distancia;

    private GetSentenciaByUsuariosCommand getDistanciaAlejamientoByUsuariosCommand;
    long _id;

    public GetSentenciaUsuariosCommand(long id)
    {
        _id = id;
        setHandler(new DBHandler());


    }

    @Override
    public void execute()
    {
        try
        {
            getDistanciaAlejamientoByUsuariosCommand = CommandFactory.createGetSentenciaByUsuariosCommand(getHandler(), _id);
            getDistanciaAlejamientoByUsuariosCommand.execute();
            _distancia = getDistanciaAlejamientoByUsuariosCommand.getReturnParam();
        }
        catch (Exception e)
        {
            getHandler().rollbackTransaction();
            getHandler().closeSession();
            throw e;
        }
    }

    @Override
    public List<Sentencia> getReturnParam()
    {
        return _distancia;
    }

    @Override
    public void closeHandlerSession()
    {
        getHandler().closeSession();
    }
}
