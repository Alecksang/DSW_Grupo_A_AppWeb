package com.ucab.cmcapp.implementation;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ucab.cmcapp.common.entities.Alerta;
import com.ucab.cmcapp.common.entities.ZonaSegura;
import com.ucab.cmcapp.common.util.CustomResponse;
import com.ucab.cmcapp.logic.commands.CommandFactory;
import com.ucab.cmcapp.logic.commands.zonasegura.atomic.GetAllZonaSeguraByUsuarioIdCommand;
import com.ucab.cmcapp.logic.commands.zonasegura.composite.*;
import com.ucab.cmcapp.logic.dtos.ZonaSeguraDto;
import com.ucab.cmcapp.logic.mappers.AlertaMapper;
import com.ucab.cmcapp.logic.mappers.ZonaSeguraMapper;
import com.ucab.cmcapp.persistence.dao.ZonaSeguraDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path( "/zonas" )
@Produces( MediaType.APPLICATION_JSON )
@Consumes( MediaType.APPLICATION_JSON )
public class ZonaSeguraService extends BaseService
{
    private static Logger _logger = LoggerFactory.getLogger( ZonaSeguraService.class );

    @GET
    @Path( "/{id}" )
    public Response getZonaSegura(@PathParam( "id" ) long userId )
    {
        ZonaSegura entity;
        ZonaSeguraDto response;
        GetZonaSeguraCommand command = null;
        //region Instrumentation DEBUG
        _logger.debug( "Get in ZonaSeguraService.getZonaSegura" );
        //endregion

        try
        {
            entity = ZonaSeguraMapper.mapDtoToEntity( userId );
            command = CommandFactory.createGetZonaSeguraCommand( entity );
            command.execute();
            if(command.getReturnParam() != null){
                response = ZonaSeguraMapper.mapEntityToDto(command.getReturnParam());
            }else{
                return Response.status(Response.Status.OK).entity(new CustomResponse<>("No se puede Buscar por " + userId)).build();
            }
        }
        catch ( Exception e )
        {
            return Response.status(Response.Status.OK).entity(new CustomResponse<>("Error en Zona Seguridad " + userId)).build();

        }
        finally
        {
            if (command != null)
                command.closeHandlerSession();
        }

        _logger.debug( "Leaving ZonaSeguraService.getZonaSeguridad" );
        return Response.status(Response.Status.OK).entity(new CustomResponse<>(response,"Busqueda por Id Zona Segura: " + userId)).build();
    }


    @GET
    @Path( "/findAll" )
    public Response getAllZonaSeguridad()
    {
        List<ZonaSeguraDto> response;
        GetAllZonaSeguraCommand command = null;
        //region Instrumentation DEBUG
        _logger.debug( "Get in ZonaSeguridadService.getZonaSeguridad" );
        //endregion

        try
        {
            command = CommandFactory.createGetAllZonaSeguraCommand();
            command.execute();
            if(command.getReturnParam() != null){
                response = ZonaSeguraMapper.mapListEntityToDto(command.getReturnParam());
            }else{
                return Response.status(Response.Status.OK).entity(new CustomResponse<>("No se puede Buscar por " )).build();
            }
        }
        catch ( Exception e )
        {
            return Response.status(Response.Status.OK).entity(new CustomResponse<>("Error en ZonaSeguridad ")).build();

        }
        finally
        {
            if (command != null)
                command.closeHandlerSession();
        }

        _logger.debug( "Leaving ZonaSeguridadService.getZonaSeguridad" );
        return Response.status(Response.Status.OK).entity(new CustomResponse<>(response,"Busqueda por Id ZonaSeguridad: " )).build();
    }

    //endpoint para obtener las zonas de seguridad de un usuario

    //endpoint para obtener las zonas de seguridad de un usuario
    @GET
    @Path("victima/{victima_id}")
    public Response getAllZonasByUsuarioId(@PathParam("victima_id") long victimaId) {
        ZonaSegura entity;
        List<ZonaSeguraDto> responseDTO = null;
        GetAllZonaSeguraByUsuarioIdCommand command = null;

        try {
            entity = ZonaSeguraMapper.mapDtoToEntityUsuarioId(victimaId);
            command = CommandFactory.createGetAllZonaSeguraByUsuarioIdCommand(entity);
            command.execute();

            if (command.getReturnParam() != null)
                responseDTO = ZonaSeguraMapper.mapEntityListToDtoList(command.getReturnParam());
            else
                return Response.status(Response.Status.OK).entity(new CustomResponse<>("No hay zona segura asociada al ID " + victimaId + " de la victima")).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new CustomResponse<>("Error interno al momento de ejecutar la ruta id usuario" + e.getMessage())).build();
        } finally {
            if (command != null)
                command.closeHandlerSession();
        }

        return Response.status(Response.Status.OK).entity(new CustomResponse<>(responseDTO, "La zonas seguras de la victima con el ID " + victimaId + " se han obtenido correctamente")).build();
    }

    @POST
    @Path("/insert")
    public Response addZonaSeguridad( ZonaSeguraDto userDto )
    {
        ZonaSegura entity;
        ZonaSeguraDto response;
        CreateZonaSeguraCommand command = null;
        //region Instrumentation DEBUG
        _logger.debug( "Get in ZonaSeguraService.addZonaSegura" );
        //endregion

        try
        {
            entity = ZonaSeguraMapper.mapDtoToEntityInsert( userDto );
            command = CommandFactory.createCreateZonaSeguraCommand( entity );
            command.execute();
            if(command.getReturnParam() != null){
                response = ZonaSeguraMapper.mapEntityToDto(command.getReturnParam());
            }else{
                return Response.status(Response.Status.OK).entity(new CustomResponse<>("No se puede Insertar " + userDto.getId())).build();
            }
        }
        catch ( Exception e )
        {
            return Response.status(Response.Status.OK).entity(new CustomResponse<>("Error en Zona Segura " + userDto.getId())).build();

        }
        finally
        {
            if (command != null)
                command.closeHandlerSession();
        }

        _logger.debug( "Leaving ZonaSeguraService.addZonaSegura" );
        return Response.status(Response.Status.OK).entity(new CustomResponse<>(response,"Insertado: " + userDto.getId())).build();
    }

    @DELETE
    @Path("/delete")
    public Response deleteZonaSeguridad( ZonaSeguraDto userDto )
    {
        ZonaSegura entity;
        ZonaSeguraDto response;
        DeleteZonaSeguraCommand command = null;
        //region Instrumentation DEBUG
        _logger.debug( "Get in ZonaSeguraService.deleteZonaSegura" );
        //endregion

        try
        {
            entity = ZonaSeguraMapper.mapDtoToEntity( userDto );
            command = CommandFactory.createDeleteZonaSeguraCommand( entity );
            command.execute();
            if(command.getReturnParam() != null){
                response = ZonaSeguraMapper.mapEntityToDto(command.getReturnParam());
            }else{
                return Response.status(Response.Status.OK).entity(new CustomResponse<>("No se puede eliminar " + userDto.getId())).build();
            }
        }
        catch ( Exception e )
        {
            return Response.status(Response.Status.OK).entity(new CustomResponse<>("Error en Zona Seguridad " + userDto.getId())).build();

        }
        finally
        {
            if (command != null)
                command.closeHandlerSession();
        }

        _logger.debug( "Leaving ZonaSeguraService.deleteZonaSegura" );
        return Response.status(Response.Status.OK).entity(new CustomResponse<>(response,"Eliminado: " + userDto.getId())).build();
    }


    @PUT
    @Path("/update")
    public Response updateZonaSeguridad( ZonaSeguraDto userDto )
    {
        ZonaSegura entity;
        ZonaSeguraDto response;
        UpdateZonaSeguraCommand command = null;
        ZonaSeguraDao base = new ZonaSeguraDao();
        //region Instrumentation DEBUG
        _logger.debug( "Get in ZonaSeguraService.deleteZonaSegura" );
        //endregion

        try
        {
            if (base.find(userDto.getId(), ZonaSegura.class) == null){
                return Response.status(Response.Status.OK).entity(new CustomResponse<>("No se encuentra  registrado " + userDto.getId())).build();

            }
            entity = ZonaSeguraMapper.mapDtoToEntity( userDto );
            command = CommandFactory.createUpdateZonaSeguraCommand( entity );
            command.execute();
            if(command.getReturnParam() != null){
                response = ZonaSeguraMapper.mapEntityToDto(command.getReturnParam());
            }else{
                return Response.status(Response.Status.OK).entity(new CustomResponse<>("No se puede editar " + userDto.getId())).build();
            }
        }
        catch ( Exception e )
        {
            return Response.status(Response.Status.OK).entity(new CustomResponse<>("Error en Zona Seguridad " + userDto.getId())).build();

        }
        finally
        {
            if (command != null)
                command.closeHandlerSession();
        }

        _logger.debug( "Leaving ZonaSeguraService.deleteZonaSeguridad" );
        return Response.status(Response.Status.OK).entity(new CustomResponse<>(response,"Editado: " + userDto.getId())).build();
    }
}
