package com.ucab.cmcapp.implementation;

import com.ucab.cmcapp.common.entities.Admin;
import com.ucab.cmcapp.common.util.CustomResponse;
import com.ucab.cmcapp.logic.commands.CommandFactory;
import com.ucab.cmcapp.logic.commands.admin.atomic.GetAdminByUsernameCommand;
import com.ucab.cmcapp.logic.commands.admin.atomic.GetAdminByCorreoCommand;
import com.ucab.cmcapp.logic.commands.admin.composite.*;
import com.ucab.cmcapp.logic.dtos.AdminDto;
import com.ucab.cmcapp.logic.mappers.AdminMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/admin")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class AdminService extends BaseService {
    private static Logger _logger = LoggerFactory.getLogger(AdminService.class);

    //creando los servicios
    @GET
    @Path("/{id}")
    public Response getAdmin(@PathParam("id") long adminId) {
        Admin entity;
        AdminDto responseDTO = null;
        GetAdminCommand command = null;

        _logger.debug( "Tomando de AdminService.getAdmin" );

        try {
            entity = AdminMapper.mapDtoToEntity(adminId);
            command = CommandFactory.createGetAdminCommand(entity);
            command.execute();

            if (command.getReturnParam() != null)
                responseDTO = AdminMapper.mapEntityToDto(command.getReturnParam());
            else
                return Response.status(Response.Status.OK).entity(new CustomResponse<>("El ID " + adminId + " de Admin no existe en la Base de Datos ")).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new CustomResponse<>(e, "Error interno en la ruta ID " + e.getMessage())).build();
        } finally {
            if (command != null)
                command.closeHandlerSession();
        }

        _logger.debug( "Dejando AdminService.getAdmin" );

        return Response.status(Response.Status.OK).entity(new CustomResponse<>(responseDTO, "El ID " + adminId + " del Admin ha sido encontrado exitosamente")).build();
    }

    @GET
    @Path("/todos")
    public Response getAllAdmin() {
        List <AdminDto> responseDTO = null;
        GetAllAdminCommand command = null;

        _logger.debug( "Tomando de AdminService.getAllAdmin" );

        try {
            command = CommandFactory.createGetAllAdminCommand();
            command.execute();
            responseDTO = AdminMapper.mapEntityListToDtoList(command.getReturnParam());

            if (responseDTO.size() == 0) {
                return Response.status(Response.Status.OK).entity(new CustomResponse<>("La base de datos esta vacia")).build();
            }

        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new CustomResponse<>(e, "Error interno al ejecutar la ruta todos: " + e.getMessage())).build();
        } finally {
            if (command != null)
                command.closeHandlerSession();
        }

        _logger.debug( "Dejando AdminService.getAllAdmin" );

        return Response.status(Response.Status.OK).entity(new CustomResponse<>(responseDTO, "Los Admin se han obtenido exitosamente")).build();
    }


    @GET
    @Path("correo/{correo}")
    public Response getAdminByCorreo(@PathParam("correo") String correo) {
        Admin entity;
        AdminDto responseDTO = null;
        GetAdminByCorreoCommand command = null;

        _logger.debug( "Tomando de AdminService.getAdminbyCorreo" );

        try {
            entity = AdminMapper.mapDtoToEntityCorreo(correo);
            command = CommandFactory.createGetAdminByCorreoCommand(entity);
            command.execute();

            if (command.getReturnParam() != null)
                responseDTO = AdminMapper.mapEntityToDto(command.getReturnParam());
            else
                return Response.status(Response.Status.OK).entity(new CustomResponse<>("El correo " + correo + " no ha sido encontrado en la BBDD")).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new CustomResponse<>("Error interno al obtener el correo: " + e.getMessage())).build();
        } finally {
            if (command != null)
                command.closeHandlerSession();
        }

        _logger.debug( "Dejando AdminService.getAdminbyCorreo" );

        return Response.status(Response.Status.OK).entity(new CustomResponse<>(responseDTO, "EL correo " + correo + " del Admin ha sido encontrado exitosamente")).build();
    }

    @GET
    @Path("username/{username}")
    public Response getAdminByUsername(@PathParam("username") String username) {
        Admin entity;
        AdminDto responseDTO = null;
        GetAdminByUsernameCommand command = null;

        _logger.debug( "Tomando de AdminService.getAdminbyUsername" );

        try {
            entity = AdminMapper.mapDtoToEntityUsername(username);
            command = CommandFactory.createGetAdminByUsernameCommand(entity);
            command.execute();

            if (command.getReturnParam() != null)
                responseDTO = AdminMapper.mapEntityToDto(command.getReturnParam());
            else
                return Response.status(Response.Status.OK).entity(new CustomResponse<>("El Admin con el username " + username + " no existen en la BBDD")).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new CustomResponse<>("Error interno en la ruta username: " + e.getMessage())).build();
        } finally {
            if (command != null)
                command.closeHandlerSession();
        }

        _logger.debug( "Dejando AdminService.getAdminbyUsername" );

        return Response.status(Response.Status.OK).entity(new CustomResponse<>(responseDTO, "EL Admin con el username " + username + " ha sido encontrado exitosamente")).build();
    }


    @POST
    public Response addAdmin(AdminDto AdminDto) {
        Admin entity;
        AdminDto responseDTO = null;
        CreateAdminCommand command = null;

        _logger.debug( "Tomando de AdminService.addAdmin" );

        try {
            entity = AdminMapper.mapDtoToEntity(AdminDto);
            command = CommandFactory.createCreateAdminCommand(entity);
            command.execute();
            responseDTO = AdminMapper.mapEntityToDto(command.getReturnParam());
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new CustomResponse<>("Error interno al momento de crear un Admin", e.getMessage())).build();
        } finally {
            if (command != null)
                command.closeHandlerSession();
        }

        _logger.debug( "Dejando AdminService.addAdmin" );

        return Response.status(Response.Status.OK).entity(new CustomResponse<>(responseDTO, "El Admin ha sido creado exitosamente")).build();
    }



    @DELETE
    @Path("/{id}")
    public Response deleteAdmin(@PathParam("id") long adminId) {
        Admin entity;
        AdminDto responseDTO = null;
        DeleteAdminCommand command = null;

        _logger.debug( "Tomando de AdminService.deleteAdmin" );

        try {
            entity = AdminMapper.mapDtoToEntity(adminId);
            command = CommandFactory.createDeleteAdminCommand(entity);
            command.execute();

            if (command.getReturnParam() != null)
                responseDTO = AdminMapper.mapEntityToDto(command.getReturnParam());
            else
                return Response.status(Response.Status.OK).entity(new CustomResponse<>("No se pudo eliminar el Admin con ese ID")).build();


        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new CustomResponse<>("Error interno al momento de eliminar un Admin", e.getMessage())).build();
        } finally {
            if (command != null)
                command.closeHandlerSession();
        }

        _logger.debug( "Dejando AdminService.deleteAdmin" );

        return Response.status(Response.Status.OK).entity(new CustomResponse<>(responseDTO, "El Admin ha sido eliminado exitosamente")).build();
    }


    @PUT
    public Response updateAdmin(AdminDto AdminDto) {
        Admin entity;
        AdminDto responseDTO = null;
        UpdateAdminCommand command = null;

        _logger.debug( "Tomando de AdminService.updateAdmin" );

        try {
            entity = AdminMapper.mapDtoToEntity(AdminDto);
            command = CommandFactory.createUpdateAdminCommand(entity);
            command.execute();
            if (command.getReturnParam() != null)
                responseDTO = AdminMapper.mapEntityToDto(command.getReturnParam());
            else
                return Response.status(Response.Status.OK).entity(new CustomResponse<>("No se pudo editar el ID: " + AdminDto.getId()) + " debido a que no existe en la base de datos").build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new CustomResponse<>("Error interno al actualizar el Admin: " + e.getMessage())).build();
        } finally {
            if (command != null)
                command.closeHandlerSession();
        }

        _logger.debug( "Dejando AdminService.updateAdmin" );

        return Response.status(Response.Status.OK).entity(new CustomResponse<>(responseDTO, "El Admin con el ID " + AdminDto.getId() + " se actualizo exitosamente")).build();
    }
}
