package com.ucab.cmcapp.logic.commands.alerta.atomic;

import com.ucab.cmcapp.common.entities.Alerta;

import com.ucab.cmcapp.logic.commands.Command;
import com.ucab.cmcapp.persistence.DBHandler;
import com.ucab.cmcapp.persistence.DaoFactory;
import com.ucab.cmcapp.persistence.dao.AlertaDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GetAlertaByTipoCommand extends Command<Alerta>
{
    private static Logger _logger = LoggerFactory.getLogger( GetAlertaByTipoCommand.class );
    private Alerta _alerta;
    private AlertaDao _dao;

    public GetAlertaByTipoCommand(Alerta alerta )
    {
        //region Instrumentation DEBUG
        _logger.debug( String.format( "Get in GetAlertaByTipoCommand.ctor: parameter {%s}", alerta.toString() ) );
        _alerta = alerta;
        setHandler(new DBHandler());
        _dao = DaoFactory.createAlertaDao(getHandler());

        //region Instrumentation DEBUG
        _logger.debug( String.format( "Leavin GetAlertaByTipoCommand.ctor: atribute {%s}", _alerta.toString() ) );
        //endregion
    }

    public GetAlertaByTipoCommand(Alerta alerta, DBHandler handler )
    {
        //region Instrumentation DEBUG
        _logger.debug( String.format( "Get in GetAlertaByTipoCommand.ctor: parameter {%s}", alerta.toString() ) );
        _alerta = alerta;
        setHandler(handler);
        _dao = DaoFactory.createAlertaDao(getHandler());

        //region Instrumentation DEBUG
        _logger.debug( String.format( "Leavin GetAlertaByTipoCommand.ctor: atribute {%s}", _alerta.toString() ) );
        //endregion
    }

    @Override
    public void execute()
    {
        //region Instrumentation DEBUG
        _logger.debug( "Get in  GetAlertaByTipoAlertaCommand.execute" );
        //endregion
        _alerta = _dao.getAlertaByTipo(_alerta.get_alertaTipo());
        //region Instrumentation DEBUG
        _logger.debug( "Leavin  GetAlertaByTipoAlertaCommand.execute" );
        //endregion
    }

    @Override
    public Alerta getReturnParam()
    {
        return _alerta;
    }

    @Override
    public void closeHandlerSession()
    {
        getHandler().closeSession();
    }
}
