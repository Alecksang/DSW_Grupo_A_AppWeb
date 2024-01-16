package com.ucab.cmcapp.implementation;

import com.ucab.cmcapp.common.entities.*;
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
import com.ucab.cmcapp.logic.commands.zonasegura.atomic.GetAllZonaSeguraByUsuarioIdCommand;
import com.ucab.cmcapp.logic.dtos.SentenciaDto;
import com.ucab.cmcapp.logic.dtos.UserDto;
import com.ucab.cmcapp.logic.dtos.UsuarioDto;
import com.ucab.cmcapp.logic.dtos.ZonaSeguraDto;
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

    @GET
    @Path( "/usuario/{id}" )
    public Response getSentenciaByIdUsuario(@PathParam( "id" ) long distanciaId )
    {
        List<SentenciaDto> response;
        GetSentenciaUsuariosCommand command = null;
        _logger.debug( "Get in SentenciaService.getSentenciaUsuario" );

        try
        {
            _logger.debug("Creating GetSentenciaUsuariosCommand with IdUsuario: " + distanciaId);
            command = CommandFactory.createGetSentenciaUsuariosCommand(distanciaId);
            _logger.debug("Executing GetDistanciaAlejamientoUsuariosCommand");
            command.execute();
            if(command.getReturnParam() != null){
                _logger.debug("Mapping entities to DTOs");
                response = SentenciaMapper.mapListEntityToDto(command.getReturnParam());
            }else{
                _logger.debug("No entities found for IdUsuario: " + distanciaId);
                return Response.status(Response.Status.OK).entity(new CustomResponse<>("No se puede Buscar por " + distanciaId)).build();
            }
        }
        catch ( Exception e )
        {
            _logger.debug(String.format("error: %s", e));
            _logger.error("An error occurred", e);
            return Response.status(Response.Status.OK).entity(new CustomResponse<>("Error en Sentencia" + distanciaId)).build();
        }

        finally
        {
            if (command != null)
                command.closeHandlerSession();
        }

        _logger.debug( "Leaving SentenciaService.getSentenciaUsuario" );
        return Response.status(Response.Status.OK).entity(new CustomResponse<>(response,"Busqueda por Id Usuario: " + distanciaId)).build();
    }

    //intento2
//    @GET
//    @Path("victima/{victima_id}")
//    public Response getAllSentenciaByUsuarioId(@PathParam("victima_id") long victimaId) {
//        Sentencia entity;
//        List<SentenciaDto> responseDTO = null;
//        GetAllSentenciaByUsuariosCommand command = null;
//
//        try {
//            entity = SentenciaMapper.mapDtoToEntityUsuarioId(victimaId);
//            command = CommandFactory.createGetAllSentenciaByUsuarioCommand(entity);
//            command.execute();
//
//            if (command.getReturnParam() != null)
//                responseDTO = ZonaSeguraMapper.mapEntityListToDtoList(command.getReturnParam());
//            else
//                return Response.status(Response.Status.OK).entity(new CustomResponse<>("No hay zona segura asociada al ID " + victimaId + " de la victima")).build();
//        } catch (Exception e) {
//            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new CustomResponse<>("Error interno al momento de ejecutar la ruta id usuario" + e.getMessage())).build();
//        } finally {
//            if (command != null)
//                command.closeHandlerSession();
//        }
//
//        return Response.status(Response.Status.OK).entity(new CustomResponse<>(responseDTO, "La zonas seguras de la victima con el ID " + victimaId + " se han obtenido correctamente")).build();
//    }
    //metodo que devuelve la DistanciaAlejamiento de un Usuario
    public long getDistanciaAlejamientoUsuarioAgresorId(long distanciaId )
    {
        List<SentenciaDto> response;
        GetSentenciaUsuariosCommand command = null;
        _logger.debug( "Get in DistanciaAlejamientoService.getDistanciaAlejamientoUsuario" );
        long id;

        try
        {
            command = CommandFactory.createGetSentenciaUsuariosCommand(distanciaId);
            command.execute();
            if(command.getReturnParam() != null){
                response = SentenciaMapper.mapListEntityToDto(command.getReturnParam());
                id = response.get(0).get_agresor().getId();
            }else{
                return 0;            }
        }
        catch ( Exception e )
        {
            return 0;
        }

        finally
        {
            if (command != null)
                command.closeHandlerSession();
        }


        _logger.debug( "Leaving SentenciaService.getSentenciaUsuario" );
        return id;
    }

    //metodo para buscar el Id de la victima de una DistanciaAlejamiento
    public long getDistanciaAlejamientoUsuarioVictimaId(long distanciaId )
    {
        List<SentenciaDto> response;
        GetSentenciaUsuariosCommand command = null;
        _logger.debug( "Get in SentenciaService.getSentenciaUsuario" );
        long id;

        try
        {
            command = CommandFactory.createGetSentenciaUsuariosCommand(distanciaId);
            command.execute();
            if(command.getReturnParam() != null){
                response = SentenciaMapper.mapListEntityToDto(command.getReturnParam());
                id = response.get(0).get_victima().getId();
            }else{
                return 0;            }
        }
        catch ( Exception e )
        {
            return 0;
        }

        finally
        {
            if (command != null)
                command.closeHandlerSession();
        }


        _logger.debug( "Leaving SentenciaService.getSentenciaUsuario" );
        return id;
    }


    //metodo para buscar el Id del Agresor de una DistanciaAlejamiento
    public float getDistanciaAlejamientoUsuarioDistanciaMin(long distanciaId )
    {
        List<SentenciaDto> response;
        GetSentenciaUsuariosCommand command = null;
        _logger.debug( "Get in SentenciaService.getSentenciaUsuario" );
        float distanciaMin;

        try
        {
            command = CommandFactory.createGetSentenciaUsuariosCommand(distanciaId);
            command.execute();
            if(command.getReturnParam() != null){
                response = SentenciaMapper.mapListEntityToDto(command.getReturnParam());
                distanciaMin = response.get(0).get_distanciaMinima();
            }else{
                return 0;            }
        }
        catch ( Exception e )
        {
            return 0;
        }

        finally
        {
            if (command != null)
                command.closeHandlerSession();
        }


        _logger.debug( "Leaving SentenciaService.getSentenciaUsuario" );
        return distanciaMin;
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