package com.ucab.cmcapp.implementation;


import com.ucab.cmcapp.common.entities.Conexion;
import com.ucab.cmcapp.common.util.CustomResponse;
import com.ucab.cmcapp.logic.commands.CommandFactory;
import com.ucab.cmcapp.logic.commands.conexion.atomic.*;
import com.ucab.cmcapp.logic.commands.conexion.composite.*;
import com.ucab.cmcapp.logic.dtos.ConexionDto;
import com.ucab.cmcapp.logic.mappers.ConexionMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/conexion")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ConexionService extends BaseService {
    private static Logger _logger = LoggerFactory.getLogger(ConexionService.class);

    @GET
    @Path("/{id}")
    public Response getConexion(@PathParam("id") long ConexionId) {
        Conexion entity;
        ConexionDto responseDTO = null;
        GetConexionCommand command = null;

        try {
            entity = ConexionMapper.mapDtoToEntity(ConexionId);
            command = CommandFactory.createGetConexionCommand(entity);
            command.execute();

            if (command.getReturnParam() != null)
                responseDTO = ConexionMapper.mapEntityToDto(command.getReturnParam());
            else
                return Response.status(Response.Status.OK).entity(new CustomResponse<>("El ID " + ConexionId + " de la Conexion no existe en la BBDD ")).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new CustomResponse<>(e, "Error interno en la ruta ID " + e.getMessage())).build();
        } finally {
            if (command != null)
                command.closeHandlerSession();
        }

        return Response.status(Response.Status.OK).entity(new CustomResponse<>(responseDTO, "El ID " + ConexionId + " de la Conexion ha sido encontrado correctamente")).build();
    }

    @GET
    @Path("/todos")
    public Response getAllConexion() {
        List <ConexionDto> responseDTO = null;
        GetAllConexionCommand command = null;

        try {
            command = CommandFactory.createGetAllConexionCommand();
            command.execute();
            responseDTO = ConexionMapper.mapEntityListToDtoList(command.getReturnParam());

            if (responseDTO.size() == 0) {
                return Response.status(Response.Status.OK).entity(new CustomResponse<>("La base de datos esta vacia ")).build();
            }

        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new CustomResponse<>(e, "Error interno al ejecutar la ruta todos: " + e.getMessage())).build();
        } finally {
            if (command != null)
                command.closeHandlerSession();
        }

        return Response.status(Response.Status.OK).entity(new CustomResponse<>(responseDTO, "Todos las Conexion se han obtenido correctamente")).build();
    }

    @GET
    @Path("usuario/{usuario_id}")
    public Response getAllConexionByUsuarioId(@PathParam("usuario_id") long usuarioId) {
        Conexion entity;
        List<ConexionDto> responseDTO = null;
        GetConexionByUsuarioIdCommand command = null;

        try {
            entity = ConexionMapper.mapDtoToEntityUsuarioId(usuarioId);
            command = CommandFactory.createGetConexionByUsuarioCommand(entity);
            command.execute();

            if (command.getReturnParam() != null)
                responseDTO = ConexionMapper.mapEntityListToDtoList(command.getReturnParam());
            else
                return Response.status(Response.Status.OK).entity(new CustomResponse<>("No hay Conexion asociado al ID " + usuarioId + "del usuario")).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new CustomResponse<>("Error interno al momento de ejecutar la ruta id usuario" + e.getMessage())).build();
        } finally {
            if (command != null)
                command.closeHandlerSession();
        }

        return Response.status(Response.Status.OK).entity(new CustomResponse<>(responseDTO, "La Conexion del usuario con el ID " + usuarioId + " se han obtenido correctamente")).build();
    }

    @POST
    public Response addConexion(ConexionDto ConexionDto) {
        Conexion entity;
        ConexionDto responseDTO = null;
        CreateConexionCommand command = null;

        try {
            entity = ConexionMapper.mapDtoToEntity(ConexionDto);
            command = CommandFactory.createCreateConexionCommand(entity);
            command.execute();
            responseDTO = ConexionMapper.mapEntityToDto(command.getReturnParam());
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new CustomResponse<>("Error interno al momento de registrar una Conexion", e.getMessage())).build();
        } finally {
            if (command != null)
                command.closeHandlerSession();
        }

        return Response.status(Response.Status.OK).entity(new CustomResponse<>(responseDTO, "La Conexion ha sido creada correctamente")).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteConexion(@PathParam("id") long historicoId) {
        Conexion entity;
        ConexionDto responseDTO = null;
        DeleteConexionCommand command = null;

        try {
            entity = ConexionMapper.mapDtoToEntity(historicoId);
            command = CommandFactory.createDeleteConexionCommand(entity);
            command.execute();

            if (command.getReturnParam() != null)
                responseDTO = ConexionMapper.mapEntityToDto(command.getReturnParam());
            else
                return Response.status(Response.Status.OK).entity(new CustomResponse<>("No se pudo eliminar el historico con ese ID")).build();


        }
        catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new CustomResponse<>("Error interno al momento de eliminar un usuario", e.getMessage())).build();
        } finally {
            if (command != null)
                command.closeHandlerSession();
        }

        return Response.status(Response.Status.OK).entity(new CustomResponse<>(responseDTO, "El historico ha sido eliminado correctamente")).build();
    }

    @PUT
    public Response updateConexion(ConexionDto ConexionDto) {
        Conexion entity;
        ConexionDto responseDTO = null;
        UpdateConexionCommand command = null;
        try {
            entity = ConexionMapper.mapDtoToEntity(ConexionDto);
            command = CommandFactory.createUpdateConexionCommand(entity);
            command.execute();
            if (command.getReturnParam() != null)
                responseDTO = ConexionMapper.mapEntityToDto(command.getReturnParam());
            else
                return Response.status(Response.Status.OK).entity(new CustomResponse<>("No se pudo editar el ID: " + ConexionDto.getId()) + " debido a que no existe en la base de datos").build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new CustomResponse<>("Error interno al actualizar la Conexion: " + e.getMessage())).build();
        } finally {
            if (command != null)
                command.closeHandlerSession();
        }
        return Response.status(Response.Status.OK).entity(new CustomResponse<>(responseDTO, "La Conexion con el ID " + ConexionDto.getId() + " se actualizo correctamente")).build();
    }
}
