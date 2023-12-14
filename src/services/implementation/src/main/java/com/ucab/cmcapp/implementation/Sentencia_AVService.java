package com.ucab.cmcapp.implementation;

import com.ucab.cmcapp.common.entities.Sentencia_AV;
import com.ucab.cmcapp.common.util.CustomResponse;
import com.ucab.cmcapp.logic.commands.CommandFactory;
import com.ucab.cmcapp.logic.commands.sentencia_av.composite.*;
import com.ucab.cmcapp.logic.dtos.Sentencia_AVDto;
import com.ucab.cmcapp.logic.mappers.Sentencia_AVMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/sentencia_av")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class Sentencia_AVService extends BaseService {
    private static Logger _logger = LoggerFactory.getLogger(Sentencia_AVService.class);

    @GET
    @Path("/{id}")
    public Response getSentencia_AV(@PathParam("id") long Sentencia_AVId) {
        Sentencia_AV entity;
        Sentencia_AVDto responseDTO = null;
        GetSentencia_AVCommand command = null;

        try {
            entity = Sentencia_AVMapper.mapDtoToEntity(Sentencia_AVId);
            command = CommandFactory.createGetSentencia_AVCommand(entity);
            command.execute();

            if (command.getReturnParam() != null)
                responseDTO = Sentencia_AVMapper.mapEntityToDto(command.getReturnParam());
            else
                return Response.status(Response.Status.OK).entity(new CustomResponse<>("El ID " + Sentencia_AVId + " de la Sentencia_AV no existe en la BBDD ")).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new CustomResponse<>(e, "Error interno en la ruta ID " + e.getMessage())).build();
        } finally {
            if (command != null)
                command.closeHandlerSession();
        }

        return Response.status(Response.Status.OK).entity(new CustomResponse<>(responseDTO, "El ID " + Sentencia_AVId + " de la Sentencia_AV ha sido encontrado correctamente")).build();
    }

    @GET
    @Path("/todos")
    public Response getAllSentencia_AV() {
        List <Sentencia_AVDto> responseDTO = null;
        GetAllSentencia_AVCommand command = null;

        try {
            command = CommandFactory.createGetAllSentencia_AVCommand();
            command.execute();
            responseDTO = Sentencia_AVMapper.mapEntityListToDtoList(command.getReturnParam());

            if (responseDTO.size() == 0) {
                return Response.status(Response.Status.OK).entity(new CustomResponse<>("La base de datos esta vacia ")).build();
            }

        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new CustomResponse<>(e, "Error interno al ejecutar la ruta todas las victimas: " + e.getMessage())).build();
        } finally {
            if (command != null)
                command.closeHandlerSession();
        }

        return Response.status(Response.Status.OK).entity(new CustomResponse<>(responseDTO, "Todos las sentencias se han obtenido correctamente")).build();
    }

    @POST
    public Response addSentencia_AV(Sentencia_AVDto Sentencia_AVUsuarioDto) {
        Sentencia_AV entity;
        Sentencia_AVDto responseDTO = null;
        CreateSentencia_AVCommand command = null;

        try {
            entity = Sentencia_AVMapper.mapDtoToEntity(Sentencia_AVUsuarioDto);
            command = CommandFactory.createCreateSentencia_AVCommand(entity);
            command.execute();
            responseDTO = Sentencia_AVMapper.mapEntityToDto(command.getReturnParam());
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new CustomResponse<>("Error interno al momento de registrar una victima", e.getMessage())).build();
        } finally {
            if (command != null)
                command.closeHandlerSession();
        }

        return Response.status(Response.Status.OK).entity(new CustomResponse<>(responseDTO, "La Sentencia_AV ha sido creado correctamente")).build();
    }

    /*
    @DELETE
    @Path("/{id}")
    public Response deleteSentencia_AV(@PathParam("id") long Sentencia_AVId) {
        Sentencia_AV entity;
        Sentencia_AVDto responseDTO = null;
        DeleteSentencia_AVCommand command = null;

        try {
            entity = Sentencia_AVMapper.mapDtoToEntity(Sentencia_AVId);
            command = CommandFactory.createDeleteSentencia_AVCommand(entity);
            command.execute();

            if (command.getReturnParam() != null)
                responseDTO = Sentencia_AVMapper.mapEntityToDto(command.getReturnParam());
            else
                return Response.status(Response.Status.OK).entity(new CustomResponse<>("No se pudo eliminar la Sentencia_AV con ese ID")).build();


        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new CustomResponse<>("Error interno al momento de eliminar una victima", e.getMessage())).build();
        } finally {
            if (command != null)
                command.closeHandlerSession();
        }

        return Response.status(Response.Status.OK).entity(new CustomResponse<>(responseDTO, "La Sentencia_AV ha sido eliminado correctamente")).build();
    }
    */

    @PUT
    public Response updateSentencia_AV(Sentencia_AVDto usuarioSentencia_AVDto) {
        Sentencia_AV entity;
        Sentencia_AVDto responseDTO = null;
        UpdateSentencia_AVCommand command = null;
        try {
            entity = Sentencia_AVMapper.mapDtoToEntity(usuarioSentencia_AVDto);
            command = CommandFactory.createUpdateSentencia_AVCommand(entity);
            command.execute();
            if (command.getReturnParam() != null)
                responseDTO = Sentencia_AVMapper.mapEntityToDto(command.getReturnParam());
            else
                return Response.status(Response.Status.OK).entity(new CustomResponse<>("No se pudo editar el ID: " + usuarioSentencia_AVDto.getId()) + " debido a que no existe en la base de datos").build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new CustomResponse<>("Error interno al actualizar la Sentencia_AV victima-atacante: " + e.getMessage())).build();
        } finally {
            if (command != null)
                command.closeHandlerSession();
        }
        return Response.status(Response.Status.OK).entity(new CustomResponse<>(responseDTO, "La Sentencia_AV con el ID " + usuarioSentencia_AVDto.getId() + " se actualizo correctamente")).build();
    }
}
