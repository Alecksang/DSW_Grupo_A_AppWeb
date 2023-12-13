package com.ucab.cmcapp.logic.commands.coordenada.atomic;
import com.ucab.cmcapp.common.entities.Coordenada;
import com.ucab.cmcapp.logic.commands.Command;
import com.ucab.cmcapp.persistence.DBHandler;
import com.ucab.cmcapp.persistence.DaoFactory;
import com.ucab.cmcapp.persistence.dao.CoordenadaDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DeleteCoordenadaByIdCommand extends Command<Coordenada>
{
    private static Logger _logger = LoggerFactory.getLogger( DeleteCoordenadaByIdCommand.class );
    private Coordenada _Coordenada;
    private CoordenadaDao _dao;

    public DeleteCoordenadaByIdCommand( Coordenada CoordenadaZonaSeguridad, DBHandler handler )
    {
        //region Instrumentation DEBUG
        _logger.debug( String.format( "Get in DeleteCoordenadaByIdCommand.ctor: parameter {%s}",
                CoordenadaZonaSeguridad.toString() ) );
        setHandler(handler);
        _Coordenada = CoordenadaZonaSeguridad;
        _dao = DaoFactory.createCoordenadaDao(getHandler());


        //region Instrumentation DEBUG
        _logger.debug( String.format( "Leaving DeleteCoordenadaByIdCommand.ctor: attribute {%s}",
                _Coordenada.toString() ) );
        //endregion
    }

    public DeleteCoordenadaByIdCommand( Coordenada CoordenadaZonaSeguridad )
    {
        //region Instrumentation DEBUG
        _logger.debug( String.format( "Get in DeleteCoordenadaByIdCommand.ctor: parameter {%s}",
                CoordenadaZonaSeguridad.toString() ) );
        _Coordenada = CoordenadaZonaSeguridad;
        setHandler(new DBHandler());
        _dao = DaoFactory.createCoordenadaDao(getHandler());


        //region Instrumentation DEBUG
        _logger.debug( String.format( "Leaving DeleteCoordenadaByIdCommand.ctor: attribute {%s}",
                _Coordenada.toString() ) );
        //endregion
    }

    @Override
    public void execute()
    {
        //region Instrumentation DEBUG
        _logger.debug( "Get in  DeleteCoordenadaByIdCommand.execute" );

        //endregion
        _dao.delete( _Coordenada);
        //SI SE QUIERE ELIMINAR DE LA BD, SE PONE .delete()
        //AQUI HACE UN DELETE LOGICO: .update()

        //region Instrumentation DEBUG
        _logger.debug( "Get in  DeleteCoordenadaByIdCommand.execute" );
        //endregion
    }

    @Override
    public Coordenada getReturnParam()
    {
        return _Coordenada;
    }

    @Override
    public void closeHandlerSession()
    {
        getHandler().closeSession();
    }
}
