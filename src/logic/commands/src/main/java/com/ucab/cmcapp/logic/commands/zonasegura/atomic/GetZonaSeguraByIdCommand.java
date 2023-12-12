package com.ucab.cmcapp.logic.commands.zonasegura.atomic;
import com.ucab.cmcapp.common.entities.ZonaSegura;
import com.ucab.cmcapp.logic.commands.Command;
import com.ucab.cmcapp.persistence.DBHandler;
import com.ucab.cmcapp.persistence.DaoFactory;
import com.ucab.cmcapp.persistence.dao.ZonaSeguraDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GetZonaSeguraByIdCommand extends Command<ZonaSegura>
{
    private static Logger _logger = LoggerFactory.getLogger( GetZonaSeguraByIdCommand.class );
    private long _idZonaSeguridad;
    private ZonaSegura _result;
    private ZonaSeguraDao _dao;

    public GetZonaSeguraByIdCommand(DBHandler handler, long userId )
    {
        //region Instrumentation DEBUG
        _logger.debug( String.format( "Get in GetZonaSeguraByIdCommand.ctor: parameter {%s}", userId ) );
        //endregion

        _idZonaSeguridad = userId;
        setHandler(handler);
        _dao = DaoFactory.createZonaSeguraDao(getHandler());

        //region Instrumentation DEBUG
        _logger.debug( String.format( "Leaving GetZonaSeguraByIdCommand.ctor: attribute {%s}", userId ) );
        //endregion
    }

    @Override
    public void execute()
    {
        //region Instrumentation DEBUG
        _logger.debug( "Get in  GetZonaSeguraByIdCommand.execute" );
        //endregion
        _result = _dao.find(_idZonaSeguridad, ZonaSegura.class);
        //region Instrumentation DEBUG
        _logger.debug( "Leaving  GetZonaSeguraByIdCommand.execute" );
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
