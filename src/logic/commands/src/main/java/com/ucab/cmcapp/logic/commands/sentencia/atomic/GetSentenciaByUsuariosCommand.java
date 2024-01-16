package com.ucab.cmcapp.logic.commands.sentencia.atomic;

import com.ucab.cmcapp.common.entities.Sentencia;
import com.ucab.cmcapp.logic.commands.Command;
import com.ucab.cmcapp.persistence.DBHandler;
import com.ucab.cmcapp.persistence.DaoFactory;
import com.ucab.cmcapp.persistence.dao.SentenciaDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class GetSentenciaByUsuariosCommand extends Command<Sentencia>
{
    private static Logger _logger = LoggerFactory.getLogger( GetSentenciaByUsuariosCommand.class );
    private List<Sentencia> _distancia;
    private SentenciaDao _dao;

    private long _IdAlej;

    public GetSentenciaByUsuariosCommand(DBHandler handler , long id)
    {
        //region Instrumentation DEBUG
        _IdAlej = id;
        setHandler(handler);
        _dao = DaoFactory.createSentenciaDao(getHandler());

        //region Instrumentation DEBUG
        //endregion
    }


    @Override
    public void execute()
    {
        //region Instrumentation DEBUG
        _logger.debug( "Get in  GetDistanciaAlejamientoByUsuariosCommand.execute" );
        //endregion
        _distancia = _dao.getSentenciaByUsuarios(_IdAlej);
        //region Instrumentation DEBUG
        _logger.debug( "Leavin  GetDistanciaAlejamientoByUsuariosCommand.execute" );
        //endregion
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
