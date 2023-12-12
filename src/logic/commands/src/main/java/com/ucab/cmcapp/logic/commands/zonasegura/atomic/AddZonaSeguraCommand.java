package com.ucab.cmcapp.logic.commands.zonasegura.atomic;
import com.ucab.cmcapp.common.entities.ZonaSegura;
import com.ucab.cmcapp.logic.commands.Command;
import com.ucab.cmcapp.persistence.DBHandler;
import com.ucab.cmcapp.persistence.DaoFactory;
import com.ucab.cmcapp.persistence.dao.ZonaSeguraDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AddZonaSeguraCommand extends Command<ZonaSegura>
{
    private static Logger _logger = LoggerFactory.getLogger( AddZonaSeguraCommand.class );
    private ZonaSegura _ZonaSegura;
    private ZonaSeguraDao _dao;

    public AddZonaSeguraCommand( ZonaSegura ZonaSeguridad, DBHandler handler )
    {
        //region Instrumentation DEBUG
        _logger.debug( String.format( "Get in AddZonaSeguraCommand.ctor: parameter {%s}",
                ZonaSeguridad.toString() ) );
        setHandler(handler);
        _ZonaSegura= ZonaSeguridad;
        _dao = DaoFactory.createZonaSeguraDao(getHandler());


        //region Instrumentation DEBUG
        _logger.debug( String.format( "Leaving AddZonaSeguraCommand.ctor: attribute {%s}",
                _ZonaSegura.toString() ) );
        //endregion
    }

    public AddZonaSeguraCommand( ZonaSegura ZonaSeguridad )
    {
        //region Instrumentation DEBUG
        _logger.debug( String.format( "Get in AddZonaSeguraCommand.ctor: parameter {%s}",
                ZonaSeguridad.toString() ) );
        _ZonaSegura = ZonaSeguridad;
        setHandler(new DBHandler());
        _dao = DaoFactory.createZonaSeguraDao(getHandler());


        //region Instrumentation DEBUG
        _logger.debug( String.format( "Leaving AddZonaSeguraCommand.ctor: attribute {%s}",
                _ZonaSegura.toString() ) );
        //endregion
    }

    @Override
    public void execute()
    {
        //region Instrumentation DEBUG
        _logger.debug( "Get in  AddZonaSeguraCommand.execute" );
        //endregion

        _ZonaSegura= _dao.insert( _ZonaSegura);

        //region Instrumentation DEBUG
        _logger.debug( "Get in  AddZonaSeguraCommand.execute" );
        //endregion
    }

    @Override
    public ZonaSegura getReturnParam()
    {
        return _ZonaSegura;
    }

    @Override
    public void closeHandlerSession()
    {
        getHandler().closeSession();
    }
}
