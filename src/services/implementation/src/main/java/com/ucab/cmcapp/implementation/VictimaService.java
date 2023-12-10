package com.ucab.cmcapp.implementation;

import com.ucab.cmcapp.common.entities.Victima;
import com.ucab.cmcapp.common.util.CustomResponse;
import com.ucab.cmcapp.logic.commands.CommandFactory;
import com.ucab.cmcapp.logic.commands.victima.composite.*;
import com.ucab.cmcapp.logic.dtos.VictimaDto;
import com.ucab.cmcapp.logic.mappers.VictimaMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/victima")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class VictimaService extends BaseService {
    private static Logger _logger = LoggerFactory.getLogger(VictimaService.class);

    @GET
    @Path("/{id}")
    public Response getVictima(@PathParam("id") long victimaId) {
        Victima entity;
        VictimaDto responseDTO = null;
        GetVictimaCommand command = null;

        try {
            entity = VictimaMapper.mapDtoToEntity(victimaId);
            command = CommandFactory.createGetVictimaCommand(entity);
            command.execute();

            if (command.getReturnParam() != null)
                responseDTO = VictimaMapper.mapEntityToDto(command.getReturnParam());
            else
                return Response.status(Response.Status.OK).entity(new CustomResponse<>("El ID " + victimaId + " de la victima no existe en la BBDD ")).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new CustomResponse<>(e, "Error interno en la ruta ID " + e.getMessage())).build();
        } finally {
            if (command != null)
                command.closeHandlerSession();
        }

        return Response.status(Response.Status.OK).entity(new CustomResponse<>(responseDTO, "El ID " + victimaId + " de la victima ha sido encontrado correctamente")).build();
    }

    @GET
    @Path("/todos")
    public Response getAllVictima() {
        List <VictimaDto> responseDTO = null;
        GetAllVictimaCommand command = null;

        try {
            command = CommandFactory.createGetAllVictimaCommand();
            command.execute();
            responseDTO = VictimaMapper.mapEntityListToDtoList(command.getReturnParam());

            if (responseDTO.size() == 0) {
                return Response.status(Response.Status.OK).entity(new CustomResponse<>("La base de datos esta vacia ")).build();
            }

        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new CustomResponse<>(e, "Error interno al ejecutar la ruta todas las victimas: " + e.getMessage())).build();
        } finally {
            if (command != null)
                command.closeHandlerSession();
        }

        return Response.status(Response.Status.OK).entity(new CustomResponse<>(responseDTO, "Todos las victimas se han obtenido correctamente")).build();
    }

    @POST
    public Response addVictima(VictimaDto historicoUsuarioDto) {
        Victima entity;
        VictimaDto responseDTO = null;
        CreateVictimaCommand command = null;

        try {
            entity = VictimaMapper.mapDtoToEntity(historicoUsuarioDto);
            command = CommandFactory.createCreateVictimaCommand(entity);
            command.execute();
            responseDTO = VictimaMapper.mapEntityToDto(command.getReturnParam());
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new CustomResponse<>("Error interno al momento de registrar una victima", e.getMessage())).build();
        } finally {
            if (command != null)
                command.closeHandlerSession();
        }

        return Response.status(Response.Status.OK).entity(new CustomResponse<>(responseDTO, "La victima ha sido creado correctamente")).build();
    }

    /*@DELETE
    @Path("/{id}")
    public Response deleteVictima(@PathParam("id") long victimaId) {
        Victima entity;
        VictimaDto responseDTO = null;
        DeleteVictimaCommand command = null;

        try {
            entity = VictimaMapper.mapDtoToEntity(victimaId);
            command = CommandFactory.createDeleteVictimaCommand(entity);
            command.execute();

            if (command.getReturnParam() != null)
                responseDTO = VictimaMapper.mapEntityToDto(command.getReturnParam());
            else
                return Response.status(Response.Status.OK).entity(new CustomResponse<>("No se pudo eliminar la victima con ese ID")).build();


        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new CustomResponse<>("Error interno al momento de eliminar una victima", e.getMessage())).build();
        } finally {
            if (command != null)
                command.closeHandlerSession();
        }

        return Response.status(Response.Status.OK).entity(new CustomResponse<>(responseDTO, "La victima ha sido eliminado correctamente")).build();
    }*/

    @PUT
    public Response updateVictima(VictimaDto usuarioVictimaDto) {
        Victima entity;
        VictimaDto responseDTO = null;
        UpdateVictimaCommand command = null;
        try {
            entity = VictimaMapper.mapDtoToEntity(usuarioVictimaDto);
            command = CommandFactory.createUpdateVictimaCommand(entity);
            command.execute();
            if (command.getReturnParam() != null)
                responseDTO = VictimaMapper.mapEntityToDto(command.getReturnParam());
            else
                return Response.status(Response.Status.OK).entity(new CustomResponse<>("No se pudo editar el ID: " + usuarioVictimaDto.getId()) + " debido a que no existe en la base de datos").build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new CustomResponse<>("Error interno al actualizar la victima: " + e.getMessage())).build();
        } finally {
            if (command != null)
                command.closeHandlerSession();
        }
        return Response.status(Response.Status.OK).entity(new CustomResponse<>(responseDTO, "La victima con el ID " + usuarioVictimaDto.getId() + " se actualizo correctamente")).build();
    }
}
