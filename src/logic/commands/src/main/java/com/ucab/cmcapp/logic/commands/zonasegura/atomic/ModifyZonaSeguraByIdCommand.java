package com.ucab.cmcapp.logic.commands.zonasegura.atomic;

import com.ucab.cmcapp.common.entities.ZonaSegura;
import com.ucab.cmcapp.logic.commands.Command;
import com.ucab.cmcapp.persistence.DBHandler;
import com.ucab.cmcapp.persistence.DaoFactory;
import com.ucab.cmcapp.persistence.dao.ZonaSeguraDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ModifyZonaSeguraByIdCommand extends Command<ZonaSegura>
{
    private static Logger _logger = LoggerFactory.getLogger( ModifyZonaSeguraByIdCommand.class );
    private ZonaSegura _ZonaSegura;
    private ZonaSeguraDao _dao;

    public ModifyZonaSeguraByIdCommand(ZonaSegura ZonaSeguridad, DBHandler handler )
    {
        //region Instrumentation DEBUG
        _logger.debug( String.format( "Get in ModifyZonaSeguraByIdCommand.ctor: parameter {%s}",
                ZonaSeguridad.toString() ) );
        setHandler(handler);
        _ZonaSegura = ZonaSeguridad;
        _dao = DaoFactory.createZonaSeguraDao(getHandler());


        //region Instrumentation DEBUG
        _logger.debug( String.format( "Leaving ModifyZonaSeguraByIdCommand.ctor: attribute {%s}",
                _ZonaSegura.toString() ) );
        //endregion
    }

    public ModifyZonaSeguraByIdCommand(ZonaSegura ZonaSeguridad )
    {
        //region Instrumentation DEBUG
        _logger.debug( String.format( "Get in ModifyZonaSeguraByIdCommand.ctor: parameter {%s}",
                ZonaSeguridad.toString() ) );
        _ZonaSegura = ZonaSeguridad;
        setHandler(new DBHandler());
        _dao = DaoFactory.createZonaSeguraDao(getHandler());


        //region Instrumentation DEBUG
        _logger.debug( String.format( "Leaving UpdateZonaSeguraByIdCommand.ctor: attribute {%s}",
                _ZonaSegura.toString() ) );
        //endregion
    }

    @Override
    public void execute()
    {
        //region Instrumentation DEBUG
        _logger.debug( "Get in  ModifyeZonaSeguraByIdCommand.execute" );
        //endregion

        _dao.update( _ZonaSegura);


        //region Instrumentation DEBUG
        _logger.debug( "Get in  ModifyZonaSeguraByIdCommand.execute" );
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
