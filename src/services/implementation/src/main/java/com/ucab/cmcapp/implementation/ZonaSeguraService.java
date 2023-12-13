package com.ucab.cmcapp.implementation;

import com.ucab.cmcapp.common.entities.Alerta;
import com.ucab.cmcapp.common.entities.ZonaSegura;
import com.ucab.cmcapp.common.util.CustomResponse;
import com.ucab.cmcapp.logic.commands.CommandFactory;
import com.ucab.cmcapp.logic.commands.zonasegura.composite.CreateZonaSeguraCommand;
import com.ucab.cmcapp.logic.commands.zonasegura.composite.DeleteZonaSeguraCommand;
import com.ucab.cmcapp.logic.commands.zonasegura.composite.GetZonaSeguraCommand;
import com.ucab.cmcapp.logic.commands.zonasegura.composite.UpdateZonaSeguraCommand;
import com.ucab.cmcapp.logic.dtos.ZonaSeguraDto;
import com.ucab.cmcapp.logic.mappers.AlertaMapper;
import com.ucab.cmcapp.logic.mappers.ZonaSeguraMapper;
import com.ucab.cmcapp.persistence.dao.ZonaSeguraDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

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