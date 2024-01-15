package com.ucab.cmcapp.implementation;

import com.ucab.cmcapp.common.entities.Alerta;
import com.ucab.cmcapp.common.entities.Sentencia;
import com.ucab.cmcapp.common.entities.User;
import com.ucab.cmcapp.common.entities.Usuario;
import com.ucab.cmcapp.common.util.CustomResponse;
import com.ucab.cmcapp.logic.commands.CommandFactory;
import com.ucab.cmcapp.logic.commands.sentencia.atomic.GetSentenciaByUsuariosCommand;
import com.ucab.cmcapp.logic.commands.sentencia.composite.*;
import com.ucab.cmcapp.logic.commands.user.atomic.GetUserByEmailCommand;
import com.ucab.cmcapp.logic.commands.user.composite.CreateUserCommand;
import com.ucab.cmcapp.logic.commands.user.composite.GetUserCommand;
import com.ucab.cmcapp.logic.commands.usuario.atomic.GetUsuarioByIdCommand;
import com.ucab.cmcapp.logic.commands.usuario.composite.DeleteUsuarioCommand;
import com.ucab.cmcapp.logic.commands.usuario.composite.UpdateUsuarioCommand;
import com.ucab.cmcapp.logic.dtos.SentenciaDto;
import com.ucab.cmcapp.logic.dtos.UserDto;
import com.ucab.cmcapp.logic.dtos.UsuarioDto;
import com.ucab.cmcapp.logic.mappers.*;
import com.ucab.cmcapp.persistence.DBHandler;
import com.ucab.cmcapp.persistence.dao.AlertaDao;
import com.ucab.cmcapp.persistence.dao.SentenciaDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import java.util.List;

import static com.ucab.cmcapp.logic.commands.CommandFactory.createGetUsuarioByIdCommand;


@Path( "/sentencia" )
@Produces( MediaType.APPLICATION_JSON )
@Consumes( MediaType.APPLICATION_JSON )
public class SentenciaService extends BaseService
{
    private static Logger _logger = LoggerFactory.getLogger( SentenciaService.class );

    @GET
    @Path( "/{IdAlej}" )
    public Response getDistanciaAlejamiento(@PathParam( "IdAlej" ) long distanciaId )
    {
        Sentencia entity;
        SentenciaDto response;
        GetSentenciaCommand command = null;
        //region Instrumentation DEBUG
        _logger.debug( "Get in SentenciaService.getSentencia" );
        //endregion

        try
        {
            entity = SentenciaMapper.mapDtoToEntity( distanciaId );
            command = CommandFactory.createGetSentenciaCommand( entity );
            command.execute();
            if(command.getReturnParam() != null){
                response = SentenciaMapper.mapEntityToDto(command.getReturnParam());
            }else{
                return Response.status(Response.Status.OK).entity(new CustomResponse<>("No se puede Buscar por " + distanciaId)).build();
            }
        }
        catch ( Exception e )
        {
            return Response.status(Response.Status.OK).entity(new CustomResponse<>("Error en Distancia" + distanciaId)).build();

        }
        finally
        {
            if (command != null)
                command.closeHandlerSession();
        }

        _logger.debug( "Leaving SentenciaService.getSentencia" );
        return Response.status(Response.Status.OK).entity(new CustomResponse<>(response,"Busqueda por Id Distancia: " + distanciaId)).build();
    }


    @GET
    @Path("/todos")
    public Response getAllRelacion() {
        List<SentenciaDto> responseDTO = null;
        GetAllSentenciaCommand command = null;

        try {
            command = CommandFactory.createGetAllSentenciaCommand();
            command.execute();
            responseDTO = SentenciaMapper.mapEntityListToDtoList(command.getReturnParam());

            if (responseDTO.size() == 0) {
                return Response.status(Response.Status.OK).entity(new CustomResponse<>("La base de datos esta vacia ")).build();
            }

        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new CustomResponse<>(e, "Error interno al ejecutar la ruta todas las victimas: " + e.getMessage())).build();
        } finally {
            if (command != null)
                command.closeHandlerSession();
        }

        return Response.status(Response.Status.OK).entity(new CustomResponse<>(responseDTO, "Todos las relaciones victima-atacante se han obtenida correctamente")).build();
    }
    @POST
    @Path("/insert")
    public Response addSentencia( SentenciaDto distanciaDto )
    {
        Sentencia entity;
        SentenciaDto response;
        CreateSentenciaCommand command = null;
        //region Instrumentation DEBUG
        _logger.debug( "Get in SentenciaService.addSentencia" );
        //endregion

        try
        {
            entity = SentenciaMapper.mapDtoToEntityInsert( distanciaDto );
            command = CommandFactory.createCreateSentenciaCommand( entity );
            command.execute();
            if(command.getReturnParam() != null){
                response = SentenciaMapper.mapEntityToDto(command.getReturnParam());
            }else{
                return Response.status(Response.Status.OK).entity(new CustomResponse<>("No se puede Insertar la sentencia " + distanciaDto.getId())).build();
            }
        }
        catch ( Exception e )
        {
            return Response.status(Response.Status.OK).entity(new CustomResponse<>("Error en Sentencia " + distanciaDto.getId())).build();

        }
        finally
        {
            if (command != null)
                command.closeHandlerSession();
        }

        _logger.debug( "Leaving SentenciaService.addSentencia" );
        return Response.status(Response.Status.OK).entity(new CustomResponse<>(response,"Insertado: " + distanciaDto.getId())).build();
    }

    @DELETE
    @Path("/delete")
    public Response deleteSentencia( SentenciaDto userDto )
    {
        Sentencia entity;
        SentenciaDto response;
        DeleteSentenciaCommand command = null;
        //region Instrumentation DEBUG
        _logger.debug( "Get in SentenciaService.deleteSentencia" );
        //endregion

        try
        {
            entity = SentenciaMapper.mapDtoToEntity( userDto );
            command = CommandFactory.createDeleteSentenciaCommand( entity );
            command.execute();
            if(command.getReturnParam() != null){
                response = SentenciaMapper.mapEntityToDto(command.getReturnParam());
            }else{
                return Response.status(Response.Status.OK).entity(new CustomResponse<>("No se puede eliminar " + userDto.getId())).build();
            }
        }
        catch ( Exception e )
        {
            return Response.status(Response.Status.OK).entity(new CustomResponse<>("Error en Distancia " + userDto.getId())).build();

        }
        finally
        {
            if (command != null)
                command.closeHandlerSession();
        }

        _logger.debug( "Leaving SentenciaService.deleteSentencia" );
        return Response.status(Response.Status.OK).entity(new CustomResponse<>(response,"Eliminado: " + userDto.getId())).build();
    }

    @PUT
    @Path("/update")
    public Response updateSentencia( SentenciaDto userDto )
    {
        Sentencia entity;
        SentenciaDto response;
        UpdateSentenciaCommand command = null;
        SentenciaDao base = new SentenciaDao();

        //region Instrumentation DEBUG
        _logger.debug( "Get in SentenciaService.deleteSentencia" );
        //endregion

        try
        {
            if (base.find(userDto.getId(), Sentencia.class) == null){
                return Response.status(Response.Status.OK).entity(new CustomResponse<>("No se encuentra el Objeto registrado " + userDto.getId())).build();

            }
            entity = SentenciaMapper.mapDtoToEntity( userDto );
            command = CommandFactory.createUpdateSentenciaCommand( entity );
            command.execute();

            if(command.getReturnParam() != null){
                response = SentenciaMapper.mapEntityToDto(command.getReturnParam());
            }else{
                return Response.status(Response.Status.OK).entity(new CustomResponse<>("No se puede editar " + userDto.getId())).build();
            }
        }
        catch ( Exception e )
        {
            return Response.status(Response.Status.OK).entity(new CustomResponse<>("Error en Distancia " + userDto.getId())).build();

        }
        finally
        {
            if (command != null)
                command.closeHandlerSession();
        }

        _logger.debug( "Leaving SentenciaService.deleteSentencia" );
        return Response.status(Response.Status.OK).entity(new CustomResponse<>(response,"Editado: " + userDto.getId())).build();
    }

}