package com.ucab.cmcapp.implementation;
import com.ucab.cmcapp.common.entities.Agresor;
import com.ucab.cmcapp.common.util.CustomResponse;
import com.ucab.cmcapp.logic.commands.CommandFactory;
import com.ucab.cmcapp.logic.commands.agresor.composite.*;
import com.ucab.cmcapp.logic.dtos.AgresorDto;
import com.ucab.cmcapp.logic.mappers.AgresorMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/agresor")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class AgresorService extends BaseService {
    private static Logger _logger = LoggerFactory.getLogger(AgresorService.class);

    @GET
    @Path("/{id}")
    public Response getAgresor(@PathParam("id") long agresorId) {
        Agresor entity;
        AgresorDto responseDTO = null;
        GetAgresorCommand command = null;

        try {
            entity = AgresorMapper.mapDtoToEntity(agresorId);
            command = CommandFactory.createGetAgresorCommand(entity);
            command.execute();

            if (command.getReturnParam() != null)
                responseDTO = AgresorMapper.mapEntityToDto(command.getReturnParam());
            else
                return Response.status(Response.Status.OK).entity(new CustomResponse<>("El ID " + agresorId + " del atacante no existe en la BBDD ")).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new CustomResponse<>(e, "Error interno en la ruta ID " + e.getMessage())).build();
        } finally {
            if (command != null)
                command.closeHandlerSession();
        }

        return Response.status(Response.Status.OK).entity(new CustomResponse<>(responseDTO, "El ID " + agresorId + " del atacante ha sido encontrado correctamente")).build();
    }

    @GET
    @Path("/todos")
    public Response getAllAtacante() {
        List <AgresorDto> responseDTO = null;
        GetAllAgresorCommand command = null;

        try {
            command = CommandFactory.createGetAllAgresorCommand();
            command.execute();
            responseDTO = AgresorMapper.mapEntityListToDtoList(command.getReturnParam());

            if (responseDTO.size() == 0) {
                return Response.status(Response.Status.OK).entity(new CustomResponse<>("La base de datos esta vacia ")).build();
            }

        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new CustomResponse<>(e, "Error interno al ejecutar la ruta todos: " + e.getMessage())).build();
        } finally {
            if (command != null)
                command.closeHandlerSession();
        }

        return Response.status(Response.Status.OK).entity(new CustomResponse<>(responseDTO, "Todos los atacantes se han obtenido correctamente")).build();
    }

    @POST
    public Response addAgresor(AgresorDto agresorDto) {
        Agresor entity;
        AgresorDto responseDTO = null;
        CreateAgresorCommand command = null;

        try {
            entity = AgresorMapper.mapDtoToEntity(agresorDto);
            command = CommandFactory.createCreateAgresorCommand(entity);
            command.execute();
            responseDTO = AgresorMapper.mapEntityToDto(command.getReturnParam());
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new CustomResponse<>("Error interno al momento de registrar un atacante", e.getMessage())).build();
        } finally {
            if (command != null)
                command.closeHandlerSession();
        }

        return Response.status(Response.Status.OK).entity(new CustomResponse<>(responseDTO, "El atacante ha sido creado correctamente")).build();
    }

   /* @DELETE
    @Path("/{id}")
    public Response deleteAtacante(@PathParam("id") long atacanteId) {
        Usuario_Atacante entity;
        Usuario_AtacanteDto responseDTO = null;
        DeleteAtacanteCommand command = null;

        try {
            entity = Usuario_AtacanteMapper.mapDtoToEntity(atacanteId);
            command = CommandFactory.createDeleteUsuario_AtacanteCommand(entity);
            command.execute();

            if (command.getReturnParam() != null)
                responseDTO = Usuario_AtacanteMapper.mapEntityToDto(command.getReturnParam());
            else
                return Response.status(Response.Status.OK).entity(new CustomResponse<>("No se pudo eliminar el atacante con ese ID")).build();


        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new CustomResponse<>("Error interno al momento de crear un atacante", e.getMessage())).build();
        } finally {
            if (command != null)
                command.closeHandlerSession();
        }

        return Response.status(Response.Status.OK).entity(new CustomResponse<>(responseDTO, "El atacante ha sido eliminado correctamente")).build();
    }*/

    @PUT
    public Response updateAgresor(AgresorDto agresorDto) {
        Agresor entity;
        AgresorDto responseDTO = null;
        UpdateAgresorCommand command = null;
        try {
            entity = AgresorMapper.mapDtoToEntity(agresorDto);
            command = CommandFactory.createUpdateAgresorCommand(entity);
            command.execute();
            if (command.getReturnParam() != null)
                responseDTO = AgresorMapper.mapEntityToDto(command.getReturnParam());
            else
                return Response.status(Response.Status.OK).entity(new CustomResponse<>("No se pudo editar el ID: " + agresorDto.getId()) + " debido a que no existe en la base de datos").build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new CustomResponse<>("Error interno al actualizar el atacante: " + e.getMessage())).build();
        } finally {
            if (command != null)
                command.closeHandlerSession();
        }
        return Response.status(Response.Status.OK).entity(new CustomResponse<>(responseDTO, "El atacante con el ID " + agresorDto.getId() + " se actualizo correctamente")).build();
    }
}
