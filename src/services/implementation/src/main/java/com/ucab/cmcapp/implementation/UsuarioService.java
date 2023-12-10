package com.ucab.cmcapp.implementation;

import com.ucab.cmcapp.common.entities.User;
import com.ucab.cmcapp.common.entities.Usuarios;
import com.ucab.cmcapp.logic.commands.CommandFactory;
import com.ucab.cmcapp.logic.commands.user.atomic.GetUserByEmailCommand;
import com.ucab.cmcapp.logic.commands.user.composite.CreateUserCommand;
import com.ucab.cmcapp.logic.commands.user.composite.GetUserCommand;
import com.ucab.cmcapp.logic.commands.usuario.atomic.GetUsuarioByIdCommand;
import com.ucab.cmcapp.logic.commands.usuario.atomic.GetUsuarioByUsernameCommand;
import com.ucab.cmcapp.logic.commands.usuario.composite.CreateUsuarioCommand;
import com.ucab.cmcapp.logic.commands.usuario.composite.GetUsuarioCommand;
import com.ucab.cmcapp.logic.dtos.UserDto;
import com.ucab.cmcapp.logic.dtos.UsuarioDto;
import com.ucab.cmcapp.logic.mappers.UserMapper;
import com.ucab.cmcapp.logic.mappers.UsuarioMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.PathParam;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path( "/usuarios" )
@Produces( MediaType.APPLICATION_JSON )
@Consumes( MediaType.APPLICATION_JSON )
public class UsuarioService {
    private static Logger _logger = LoggerFactory.getLogger( UsuarioService.class );
    @GET
    @Path( "/{id}" )
    public UsuarioDto getUsuario(@PathParam( "id" ) long userId )
    {
        Usuarios entity;
        UsuarioDto response;
        GetUsuarioCommand command = null;
        //region Instrumentation DEBUG
        _logger.debug( "Get in UsuarioService.getUsuario" );
        //endregion

        try
        {
            entity = UsuarioMapper.mapDtoToEntity( userId );
            command = CommandFactory.createGetUsuarioCommand( entity );
            command.execute();
            response = UsuarioMapper.mapEntityToDto( command.getReturnParam() );
            _logger.info( "Response getUsuario: {} ", response );
        }
        catch ( Exception e )
        {
            _logger.error("error {} getting usuario {}: {}", e.getMessage(), userId, e.getCause());
            throw new WebApplicationException( Response.status( Response.Status.INTERNAL_SERVER_ERROR ).
                    entity( e ).build() );
        }
        finally
        {
            if (command != null)
                command.closeHandlerSession();
        }

        _logger.debug( "Leaving UsuarioService.getUsuario" );
        return response;
    }

    @GET
    @Path( "username/{username}" )
    public UsuarioDto getUsuario(@PathParam( "username" ) String username )
    {
        Usuarios entity;
        UsuarioDto response;
        GetUsuarioByUsernameCommand command = null;
        //region Instrumentation DEBUG
        _logger.debug( "Get in UserService.getUser" );
        //endregion

        try
        {
            entity = UsuarioMapper.mapDtoToEntityUsername( username );
            command = CommandFactory.createGetUsuarioByUsernameCommand( entity );
            command.execute();
            response = UsuarioMapper.mapEntityToDto( command.getReturnParam() );
            _logger.info( "Response getUsuario: {} ", response );
        }
        catch ( Exception e )
        {
            _logger.error("error {} getting usuario {}: {}", e.getMessage(), username, e.getCause());
            throw new WebApplicationException( Response.status( Response.Status.INTERNAL_SERVER_ERROR ).
                    entity( e ).build() );
        }
        finally
        {
            if (command != null)
                command.closeHandlerSession();
        }

        _logger.debug( "Leaving UsuarioService.getUser" );
        return response;
    }

    @POST
    public UsuarioDto addUsuario( UsuarioDto userDto )
    {
        Usuarios entity;
        UsuarioDto response;
        CreateUsuarioCommand command = null;
        //region Instrumentation DEBUG
        _logger.debug( "Get in UsuarioService.addUsuario" );
        //endregion

        try
        {
            entity = UsuarioMapper.mapDtoToEntity( userDto );
            command = CommandFactory.createCreateUsuarioCommand( entity );
            command.execute();
            response = UsuarioMapper.mapEntityToDto( command.getReturnParam() );
            _logger.info( "Response addUsuario: {} ", response );
        }
        catch ( Exception e )
        {
            _logger.error("error {} adding usuario: {}", e.getMessage(), e.getCause());
            throw new WebApplicationException( Response.status( Response.Status.INTERNAL_SERVER_ERROR ).
                    entity( e ).build() );
        }
        finally
        {
            if (command != null)
                command.closeHandlerSession();
        }

        _logger.debug( "Leaving UserService.addUser" );
        return response;
    }
}
