package com.ucab.cmcapp.logic.commands.conexion.atomic;


import com.ucab.cmcapp.common.entities.User;
import com.ucab.cmcapp.common.entities.Conexion;
import com.ucab.cmcapp.logic.commands.Command;
import com.ucab.cmcapp.persistence.DBHandler;
import com.ucab.cmcapp.persistence.DaoFactory;
import com.ucab.cmcapp.persistence.dao.BaseDao;
import com.ucab.cmcapp.persistence.dao.UserDao;
import com.ucab.cmcapp.persistence.dao.ConexionDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EraseConexionCommand extends Command<Conexion>
{
    private static Logger _logger = LoggerFactory.getLogger( com.ucab.cmcapp.logic.commands.conexion.atomic.EraseConexionCommand.class );
    private Conexion _usuario;
    private ConexionDao _dao;

    public EraseConexionCommand( Conexion conexion, DBHandler handler )
    {
        //region Instrumentation DEBUG
        _logger.debug( String.format( "Get in EraseConexionByIdCommand.ctor: parameter {%s}",
                conexion.toString() ) );
        setHandler(handler);
        _usuario = conexion;
        _dao = DaoFactory.createConexionDao(getHandler());


        //region Instrumentation DEBUG
        _logger.debug( String.format( "Leaving EraseConexionCommand.ctor: attribute {%s}",
                _usuario.toString() ) );
        //endregion
    }

    public EraseConexionCommand( Conexion conexion )
    {
        //region Instrumentation DEBUG
        _logger.debug( String.format( "Get in EraseConexionCommand.ctor: parameter {%s}",
                conexion.toString() ) );
        _usuario = conexion;
        setHandler(new DBHandler());
        _dao = DaoFactory.createConexionDao(getHandler());


        //region Instrumentation DEBUG
        _logger.debug( String.format( "Leaving EraseConexionCommand.ctor: attribute {%s}",
                _usuario.toString() ) );
        //endregion
    }

    @Override
    public void execute()
    {
        //region Instrumentation DEBUG
        _logger.debug( "Get in  EraseConexionCommand.execute" );

        //endregion
        _dao.delete( _usuario);
        //SI SE QUIERE ELIMINAR DE LA BD, SE PONE .delete()
        //AQUI HACE UN DELETE LOGICO: .update()

        //region Instrumentation DEBUG
        _logger.debug( "Get in  EraseConexionCommand.execute" );
        //endregion
    }

    @Override
    public Conexion getReturnParam()
    {
        return _usuario;
    }

    @Override
    public void closeHandlerSession()
    {
        getHandler().closeSession();
    }
}
