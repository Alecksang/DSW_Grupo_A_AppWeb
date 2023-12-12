package com.ucab.cmcapp.logic.commands.zonasegura.atomic;

import com.ucab.cmcapp.common.entities.ZonaSegura;
import com.ucab.cmcapp.logic.commands.Command;
import com.ucab.cmcapp.persistence.DBHandler;
import com.ucab.cmcapp.persistence.DaoFactory;
import com.ucab.cmcapp.persistence.dao.ZonaSeguraDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DeleteZonaSeguraByIdCommand extends Command<ZonaSegura>
{
    private static Logger _logger = LoggerFactory.getLogger( DeleteZonaSeguraByIdCommand.class );
    private ZonaSegura _ZonaSegura;
    private ZonaSeguraDao _dao;

    public DeleteZonaSeguraByIdCommand(ZonaSegura ZonaSeguridad, DBHandler handler )
    {
        //region Instrumentation DEBUG
        _logger.debug( String.format( "Get in DeleteZonaSeguraByIdCommand.ctor: parameter {%s}",
                ZonaSeguridad.toString() ) );
        setHandler(handler);
        _ZonaSegura = ZonaSeguridad;
        _dao = DaoFactory.createZonaSeguraDao(getHandler());


        //region Instrumentation DEBUG
        _logger.debug( String.format( "Leaving DeleteZonaSeguraByIdCommand.ctor: attribute {%s}",
                _ZonaSegura.toString() ) );
        //endregion
    }

    public DeleteZonaSeguraByIdCommand(ZonaSegura ZonaSeguridad )
    {
        //region Instrumentation DEBUG
        _logger.debug( String.format( "Get in DeleteZonaSeguraByIdCommand.ctor: parameter {%s}",
                ZonaSeguridad.toString() ) );
        _ZonaSegura = ZonaSeguridad;
        setHandler(new DBHandler());
        _dao = DaoFactory.createZonaSeguraDao(getHandler());


        //region Instrumentation DEBUG
        _logger.debug( String.format( "Leaving DeleteZonaSeguraByIdCommand.ctor: attribute {%s}",
                _ZonaSegura.toString() ) );
        //endregion
    }

    @Override
    public void execute()
    {
        //region Instrumentation DEBUG
        _logger.debug( "Get in  DeleteZonaSeguraByIdCommand.execute" );

        //endregion
        _dao.delete( _ZonaSegura);
        //SI SE QUIERE ELIMINAR DE LA BD, SE PONE .delete()
        //AQUI HACE UN DELETE LOGICO: .update()

        //region Instrumentation DEBUG
        _logger.debug( "Get in  DeleteZonaSeguradByIdCommand.execute" );
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
