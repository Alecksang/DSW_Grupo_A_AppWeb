package com.ucab.cmcapp.implementation;

import com.ucab.cmcapp.common.entities.Usuario;
import com.ucab.cmcapp.common.util.CustomResponse;
import com.ucab.cmcapp.logic.commands.CommandFactory;
import com.ucab.cmcapp.logic.commands.usuario.atomic.GetUsuarioByUsernameCommand;
import com.ucab.cmcapp.logic.commands.usuario.composite.*;
import com.ucab.cmcapp.logic.dtos.UsuarioDto;
import com.ucab.cmcapp.logic.mappers.UsuarioMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/usuario")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UsuarioService extends BaseService {
    private static Logger _logger = LoggerFactory.getLogger(UsuarioService.class);

    @GET
    @Path( "/{id}" )
    public Response getUsuario(@PathParam( "id" ) long userId )
    {
        Usuario entity;
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
            if(command.getReturnParam() != null){
                response = UsuarioMapper.mapEntityToDto(command.getReturnParam());
            }else{
                return Response.status(Response.Status.OK).entity(new CustomResponse<>("No se puede Buscar por " + userId)).build();
            }
        }
        catch ( Exception e )
        {
            return Response.status(Response.Status.OK).entity(new CustomResponse<>("Error en Usuario " + userId)).build();

        }
        finally
        {
            if (command != null)
                command.closeHandlerSession();
        }

        _logger.debug( "Leaving UsuarioService.getUsuario" );
        return Response.status(Response.Status.OK).entity(new CustomResponse<>(response,"Busqueda por Id Usuario: " + userId)).build();
    }

    @GET
    @Path("/findAll")
    public Response getAllUsuario() {
        List <UsuarioDto> responseDTO = null;
        GetAllUsuarioCommand command = null;

        try {
            command = CommandFactory.createGetAllUsuarioCommand();
            command.execute();
            responseDTO = UsuarioMapper.mapEntityListToDtoList(command.getReturnParam());

            if (responseDTO.isEmpty()) {
                return Response.status(Response.Status.OK).entity(new CustomResponse<>("La base de datos esta vacia")).build();
            }

        }
        catch (Exception e) {

            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new CustomResponse<>(e, "Error interno al ejecutar la ruta todos: " + e.getMessage())).build();
        }

        finally {
            if (command != null)
                command.closeHandlerSession();
        }

        return Response.status(Response.Status.OK).entity(new CustomResponse<>(responseDTO, "Los usuarios se han obtenido correctamente")).build();
    }

    @GET
    @Path("username/{username}")
    public Response getUsuarioByUsername(@PathParam("username") String username) {
        Usuario entity;
        UsuarioDto responseDTO = null;
        GetUsuarioByUsernameCommand command = null;

        try {
            entity = UsuarioMapper.mapDtoToEntityUsername(username);
            command = CommandFactory.createGetUsuarioByUsernameCommand(entity);
            command.execute();

            if (command.getReturnParam() != null)
                responseDTO = UsuarioMapper.mapEntityToDto(command.getReturnParam());
            else
                return Response.status(Response.Status.OK).entity(new CustomResponse<>("El usuario con Username " + username + " no existen en la BBDD")).build();
        }

        catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new CustomResponse<>("Error interno en la ruta alias: " + e.getMessage())).build();
        }

        finally {
            if (command != null)
                command.closeHandlerSession();
        }

        return Response.status(Response.Status.OK).entity(new CustomResponse<>(responseDTO, "EL usuario con el alias " + username + " ha sido encontrado exitosamente")).build();
    }


    @POST
    public Response addUsuario(UsuarioDto usuarioDto) {
        Usuario entity;
        UsuarioDto responseDTO = null;
        CreateUsuarioCommand command = null;

        try {
            entity = UsuarioMapper.mapDtoToEntity(usuarioDto);
            command = CommandFactory.createCreateUsuarioCommand(entity);
            command.execute();
            responseDTO = UsuarioMapper.mapEntityToDto(command.getReturnParam());
        }
        catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new CustomResponse<>("Error interno al momento de crear un usuario", e.getMessage())).build();
        }
        finally {
            if (command != null)
                command.closeHandlerSession();
        }

        return Response.status(Response.Status.OK).entity(new CustomResponse<>(responseDTO, "El usuario ha sido creado correctamente")).build();
    }



    @DELETE
    @Path("/{id}")
    public Response deleteUsuario(@PathParam("id") long userId) {
        Usuario entity;
        UsuarioDto responseDTO = null;
        DeleteUsuarioCommand command = null;

        try {
            entity = UsuarioMapper.mapDtoToEntity(userId);
            command = CommandFactory.createDeleteUsuarioCommand(entity);
            command.execute();

            if (command.getReturnParam() != null)
                responseDTO = UsuarioMapper.mapEntityToDto(command.getReturnParam());
            else
                return Response.status(Response.Status.OK).entity(new CustomResponse<>("No se pudo eliminar el usuario con ese ID")).build();


        }
        
        catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new CustomResponse<>("Error interno al momento de crear un usuario", e.getMessage())).build();
        }

        finally {
            if (command != null)
                command.closeHandlerSession();
        }

        return Response.status(Response.Status.OK).entity(new CustomResponse<>(responseDTO, "El usuario ha sido eliminado correctamente")).build();
    }


    @PUT
    public Response updateUsuario(UsuarioDto usuarioDto) {
        Usuario entity;
        UsuarioDto responseDTO = null;
        UpdateUsuarioCommand command = null;
        try {
            entity = UsuarioMapper.mapDtoToEntity(usuarioDto);
            command = CommandFactory.createUpdateUsuarioCommand(entity);
            command.execute();
            if (command.getReturnParam() != null)
                responseDTO = UsuarioMapper.mapEntityToDto(command.getReturnParam());
            else
                return Response.status(Response.Status.OK).entity(new CustomResponse<>("No se pudo editar el ID: " + usuarioDto.getId()) + " debido a que no existe en la base de datos").build();
        }
        catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new CustomResponse<>("Error interno al actualizar el usuario: " + e.getMessage())).build();
        }
        finally {
            if (command != null)
                command.closeHandlerSession();
        }
        return Response.status(Response.Status.OK).entity(new CustomResponse<>(responseDTO, "El usuario con el ID " + usuarioDto.getId() + " se actualizo correctamente")).build();
    }
}
