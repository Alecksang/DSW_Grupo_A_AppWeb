package com.ucab.cmcapp.logic.commands;

import com.ucab.cmcapp.common.entities.*;
import com.ucab.cmcapp.logic.commands.UserType.atomic.AddUserTypeCommand;
import com.ucab.cmcapp.logic.commands.UserType.atomic.DeleteUserTypeByIdCommand;
import com.ucab.cmcapp.logic.commands.UserType.atomic.GetUserTypeByIdCommand;
import com.ucab.cmcapp.logic.commands.UserType.atomic.UpdateUserTypeByIdCommand;
import com.ucab.cmcapp.logic.commands.UserType.composite.CreateUserTypeCommand;
import com.ucab.cmcapp.logic.commands.UserType.composite.DeleteUserTypeCommand;
import com.ucab.cmcapp.logic.commands.UserType.composite.GetUserTypeCommand;
import com.ucab.cmcapp.logic.commands.UserType.composite.UpdateUserTypeCommand;
import com.ucab.cmcapp.logic.commands.admin.atomic.*;
import com.ucab.cmcapp.logic.commands.admin.composite.*;
import com.ucab.cmcapp.logic.commands.agresor.atomic.AddAgresorCommand;
import com.ucab.cmcapp.logic.commands.agresor.atomic.GetAgresorByIdCommand;
import com.ucab.cmcapp.logic.commands.agresor.atomic.GetAgresorByListCommand;
import com.ucab.cmcapp.logic.commands.agresor.atomic.ModifyAgresorCommand;
import com.ucab.cmcapp.logic.commands.agresor.composite.CreateAgresorCommand;
import com.ucab.cmcapp.logic.commands.agresor.composite.GetAgresorCommand;
import com.ucab.cmcapp.logic.commands.agresor.composite.GetAllAgresorCommand;
import com.ucab.cmcapp.logic.commands.agresor.composite.UpdateAgresorCommand;
import com.ucab.cmcapp.logic.commands.alerta.atomic.*;
import com.ucab.cmcapp.logic.commands.alerta.composite.CreateAlertaCommand;
import com.ucab.cmcapp.logic.commands.alerta.composite.DeleteAlertaCommand;
import com.ucab.cmcapp.logic.commands.alerta.composite.GetAlertaCommand;
import com.ucab.cmcapp.logic.commands.alerta.composite.UpdateAlertaCommand;
import com.ucab.cmcapp.logic.commands.conexion.atomic.*;
import com.ucab.cmcapp.logic.commands.conexion.composite.*;
import com.ucab.cmcapp.logic.commands.coordenada.atomic.*;
import com.ucab.cmcapp.logic.commands.coordenada.composite.*;
import com.ucab.cmcapp.logic.commands.sentencia.atomic.*;
import com.ucab.cmcapp.logic.commands.sentencia.composite.*;
import com.ucab.cmcapp.logic.commands.user.atomic.AddUserCommand;
import com.ucab.cmcapp.logic.commands.user.atomic.GetUserByIdCommand;
import com.ucab.cmcapp.logic.commands.user.composite.CreateUserCommand;
import com.ucab.cmcapp.logic.commands.user.composite.GetUserCommand;
import com.ucab.cmcapp.logic.commands.user.atomic.GetUserByEmailCommand;
import com.ucab.cmcapp.logic.commands.usuario.atomic.*;
import com.ucab.cmcapp.logic.commands.usuario.composite.*;
import com.ucab.cmcapp.logic.commands.victima.atomic.AddVictimaCommand;
import com.ucab.cmcapp.logic.commands.victima.atomic.GetVictimaByIdCommand;
import com.ucab.cmcapp.logic.commands.victima.atomic.GetVictimaByListCommand;
import com.ucab.cmcapp.logic.commands.victima.atomic.ModifyVictimaCommand;
import com.ucab.cmcapp.logic.commands.victima.composite.CreateVictimaCommand;
import com.ucab.cmcapp.logic.commands.victima.composite.GetAllVictimaCommand;
import com.ucab.cmcapp.logic.commands.victima.composite.GetVictimaCommand;
import com.ucab.cmcapp.logic.commands.victima.composite.UpdateVictimaCommand;
import com.ucab.cmcapp.logic.commands.zonasegura.atomic.*;
import com.ucab.cmcapp.logic.commands.zonasegura.composite.*;
import com.ucab.cmcapp.persistence.DBHandler;

public class CommandFactory
{

    public static GetUserCommand createGetUserCommand(User user)
    {
        return new GetUserCommand(user);
    }

    public static GetUserByEmailCommand createGetUserByEmailCommand(User user)
    {
        return new GetUserByEmailCommand(user);
    }

    public static GetUserByEmailCommand createGetUserByEmailCommand(User user, DBHandler handler)
    {
        return new GetUserByEmailCommand(user, handler);
    }

    public static GetUserByIdCommand createGetUserByIdCommand (DBHandler handler, long userId )
    {
        return new GetUserByIdCommand(handler, userId);
    }

    public static AddUserCommand createAddUserCommand(User user, DBHandler handler)
    {
        return new AddUserCommand(user, handler);
    }

    public static AddUserCommand createAddUserCommand(User user)
    {
        return new AddUserCommand(user);
    }

    public static CreateUserCommand createCreateUserCommand(User user)
    {
        return new CreateUserCommand(user);
    }
  
  
    //USUARIO


    public static GetUsuarioCommand createGetUsuarioCommand(Usuario user)
    {
        return new GetUsuarioCommand(user);
    }

    public static GetAllUsuarioCommand createGetAllUsuarioCommand()
    {
        return new GetAllUsuarioCommand();
    }

    public static GetAllUsuarioByIdCommand createGetAllUsuarioByIdCommand (DBHandler handler )
    {
        return new GetAllUsuarioByIdCommand(handler);
    }



    public static GetUsuarioByUsernameCommand createGetUsuarioByUsernameCommand(Usuario user)
    {
        return new GetUsuarioByUsernameCommand(user);
    }

    public static GetUsuarioByUsernameCommand createGetUsuarioByUsernameCommand(Usuario user, DBHandler handler)
    {
        return new GetUsuarioByUsernameCommand(user, handler);
    }

    public static DeleteUsuarioByIdCommand createDeleteUsuarioByIdCommand(Usuario user, DBHandler handler)
    {
        return new DeleteUsuarioByIdCommand(user, handler);
    }

    public static DeleteUsuarioByIdCommand createDeleteUsuarioByIdCommand(Usuario user)
    {
        return new DeleteUsuarioByIdCommand(user);
    }

    public static DeleteUsuarioCommand createDeleteUsuarioCommand(Usuario user)
    {
        return new DeleteUsuarioCommand(user);
    }

    public static UpdateUsuarioByIdCommand createUpdateUsuarioByIdCommand(Usuario user, DBHandler handler)
    {
        return new UpdateUsuarioByIdCommand(user, handler);
    }

    public static UpdateUsuarioByIdCommand createUpdateUsuarioByIdCommand(Usuario user)
    {
        return new UpdateUsuarioByIdCommand(user);
    }

    public static UpdateUsuarioCommand createUpdateUsuarioCommand(Usuario user)
    {
        return new UpdateUsuarioCommand(user);
    }


    public static GetUsuarioByIdCommand createGetUsuarioByIdCommand (DBHandler handler, long userId )
    {
        return new GetUsuarioByIdCommand(handler, userId);
    }


    public static AddUsuarioCommand createAddUsuarioCommand(Usuario user, DBHandler handler)
    {
        return new AddUsuarioCommand(user, handler);
    }

    public static AddUsuarioCommand createAddUsuarioCommand(Usuario user)
    {
        return new AddUsuarioCommand(user);
    }

    public static CreateUsuarioCommand createCreateUsuarioCommand(Usuario user)
    {
        return new CreateUsuarioCommand(user);
    }

//VICTIMA

    //POST VICTIMA
    public static AddVictimaCommand createAddVictimaCommand(Victima usuarioVictima, DBHandler handler) {
        return new AddVictimaCommand(usuarioVictima, handler);
    }
    public static CreateVictimaCommand createCreateVictimaCommand(Victima usuarioVictima) {
        return new CreateVictimaCommand(usuarioVictima);
    }

    //GET VICTIMA
    public static GetVictimaCommand createGetVictimaCommand(Victima usuarioVictima) {
        return new GetVictimaCommand(usuarioVictima);
    }

    public static GetVictimaByIdCommand createGetVictimaByIdCommand(DBHandler handler, long victimaId) {
        return new GetVictimaByIdCommand(handler, victimaId);
    }

    public static GetAllVictimaCommand createGetAllVictimaCommand(){
        return new GetAllVictimaCommand();
    }

    public static GetVictimaByListCommand createGetVictimaByListCommand(DBHandler handler) {
        return new GetVictimaByListCommand(handler);
    }

    //PUT VICTIMA
    public static UpdateVictimaCommand createUpdateVictimaCommand(Victima usuarioVictima){
        return new UpdateVictimaCommand(usuarioVictima);
    }
    public static ModifyVictimaCommand createModifyVictimaCommand(Victima usuarioVictima, DBHandler handler){
        return new ModifyVictimaCommand(usuarioVictima, handler);
    }

//AGRESOR//

    //POST AGRESOR
    public static AddAgresorCommand createAddAgresorCommand(Agresor usuarioAgresor, DBHandler handler) {
        return new AddAgresorCommand(usuarioAgresor, handler);
    }
    public static CreateAgresorCommand createCreateAgresorCommand(Agresor agresor)
    {
        return new CreateAgresorCommand(agresor);
    }

    //GET AGRESOR
    public static GetAgresorCommand createGetAgresorCommand(Agresor usuarioAgresor) {
        return new GetAgresorCommand(usuarioAgresor);
    }

    public static GetAgresorByIdCommand createGetAgresorByIdCommand(DBHandler handler, long agresorId) {
        return new GetAgresorByIdCommand(handler, agresorId);
    }

    public static GetAllAgresorCommand createGetAllAgresorCommand(){
        return new GetAllAgresorCommand();
    }

    public static GetAgresorByListCommand createGetAgresorByListCommand(DBHandler handler) {
        return new GetAgresorByListCommand(handler);
    }

    //PUT AGRESOR
    public static UpdateAgresorCommand createUpdateAgresorCommand(Agresor usuarioAgresor){
        return new UpdateAgresorCommand(usuarioAgresor);
    }

    public static ModifyAgresorCommand createModifyAgresorCommand(Agresor usuarioAgresor, DBHandler handler){
        return new ModifyAgresorCommand(usuarioAgresor, handler);
    }


//ALERTA//
//Alerta
public static GetAlertaCommand createGetAlertaCommand(Alerta alerta)
{
    return new GetAlertaCommand(alerta);
}

    public static GetAlertaByTipoAlertaCommand createGetAlertaByTipoAlertaCommand(Alerta alerta)
    {
        return new GetAlertaByTipoAlertaCommand(alerta);
    }

    public static GetAlertaByTipoAlertaCommand createGetAlertaByTipoAlertaCommand(Alerta alerta, DBHandler handler)
    {
        return new GetAlertaByTipoAlertaCommand(alerta, handler);
    }

    public static GetAlertaByIdCommand createGetAlertaByIdCommand (DBHandler handler, long alertaId )
    {
        return new GetAlertaByIdCommand(handler, alertaId);
    }

    public static AddAlertaCommand createAddAlertaCommand(Alerta alerta, DBHandler handler)
    {
        return new AddAlertaCommand(alerta, handler);
    }

    public static AddAlertaCommand createAddAlertaCommand(Alerta alerta)
    {
        return new AddAlertaCommand(alerta);
    }

    public static CreateAlertaCommand createCreateAlertaCommand(Alerta alerta)
    {
        return new CreateAlertaCommand(alerta);
    }

//DELETE ALERTA

    public static DeleteAlertaByIdCommand createDeleteAlertaByIdCommand(Alerta user, DBHandler handler)
    {
        return new DeleteAlertaByIdCommand(user, handler);
    }

    public static DeleteAlertaByIdCommand createDeleteAlertaByIdCommand(Alerta user)
    {
        return new DeleteAlertaByIdCommand(user);
    }

    public static DeleteAlertaCommand createDeleteAlertaCommand(Alerta user)
    {
        return new DeleteAlertaCommand(user);
    }

    public static UpdateAlertaByIdCommand createUpdateAlertaByIdCommand(Alerta user, DBHandler handler)
    {
        return new UpdateAlertaByIdCommand(user, handler);
    }

    public static UpdateAlertaByIdCommand createUpdateAlertaByIdCommand(Alerta user)
    {
        return new UpdateAlertaByIdCommand(user);
    }

    public static UpdateAlertaCommand createUpdateAlertaCommand(Alerta user)
    {
        return new UpdateAlertaCommand(user);
    }

//ZONA SEGURA//

    //GET ZONA SEGURA
    public static GetZonaSeguraCommand createGetZonaSeguraCommand(ZonaSegura ZonaSegura)
    {
        return new GetZonaSeguraCommand(ZonaSegura);
    }


    public static GetZonaSeguraByIdCommand createGetZonaSeguraByIdCommand (DBHandler handler, long ZonaSeguraId )
    {
        return new GetZonaSeguraByIdCommand(handler, ZonaSeguraId);
    }

    public static GetAllZonaSeguraCommand createGetAllZonaSeguraCommand()
    {
        return new GetAllZonaSeguraCommand();
    }


    public static GetAllZonaSeguraByUsuarioIdCommand createGetAllZonaSeguraByUsuarioIdCommand (DBHandler handler )
    {
        return new GetAllZonaSeguraByUsuarioIdCommand(handler);
    }

    //POST
    public static AddZonaSeguraCommand createAddZonaSeguraCommand(ZonaSegura ZonaSegura, DBHandler handler)
    {
        return new AddZonaSeguraCommand(ZonaSegura, handler);
    }

    public static AddZonaSeguraCommand createAddZonaSeguraCommand(ZonaSegura ZonaSegura)
    {
        return new AddZonaSeguraCommand(ZonaSegura);
    }

    public static CreateZonaSeguraCommand createCreateZonaSeguraCommand(ZonaSegura ZonaSegura)
    {
        return new CreateZonaSeguraCommand(ZonaSegura);
    }


    //DELETE ZONA SEGURA
    public static DeleteZonaSeguraByIdCommand createDeleteZonaSeguraByIdCommand(ZonaSegura user, DBHandler handler)
    {
        return new DeleteZonaSeguraByIdCommand(user, handler);
    }

    public static DeleteZonaSeguraByIdCommand createDeleteZonaSeguraByIdCommand(ZonaSegura user)
    {
        return new DeleteZonaSeguraByIdCommand(user);
    }

    public static DeleteZonaSeguraCommand createDeleteZonaSeguraCommand(ZonaSegura user)
    {
        return new DeleteZonaSeguraCommand(user);
    }


    //PUT ZONA SEGURA
    public static ModifyZonaSeguraByIdCommand createModifyZonaSeguraByIdCommand(ZonaSegura user, DBHandler handler)
    {
        return new ModifyZonaSeguraByIdCommand(user, handler);
    }

    public static ModifyZonaSeguraByIdCommand createModifyZonaSeguraByIdCommand(ZonaSegura user)
    {
        return new ModifyZonaSeguraByIdCommand(user);
    }

    public static UpdateZonaSeguraCommand createUpdateZonaSeguraCommand(ZonaSegura user)
    {
        return new UpdateZonaSeguraCommand(user);
    }


//COORDENADA//

    // GET COORDENADA
    public static GetCoordenadaCommand createGetCoordenadaCommand(Coordenada coordenada) {
        return new GetCoordenadaCommand(coordenada);
    }

    public static GetCoordenadaByIdCommand createGetCoordenadaByIdCommand(DBHandler handler, long coordenadaId) {
        return new GetCoordenadaByIdCommand(handler, coordenadaId);
    }

    public static GetAllCoordenadaCommand createGetAllCoordenadaCommand(){
        return new GetAllCoordenadaCommand();
    }

    public static GetCoordenadaByListCommand createGetCoordenadaByListCommand(DBHandler handler) {
        return new GetCoordenadaByListCommand(handler);
    }


    // POST/AGREGAR COORDENADA
    public static AddCoordenadaCommand createAddCoordenadaCommand(Coordenada coordenada, DBHandler handler) {
        return new AddCoordenadaCommand(coordenada, handler);
    }

    public static CreateCoordenadaCommand createCreateCoordenadaCommand(Coordenada coordenada) {
        return new CreateCoordenadaCommand(coordenada);
    }

    //DELETE COORDENADA

    public static DeleteCoordenadaCommand createDeleteCoordenadaCommand(Coordenada coordenada) {
        return new DeleteCoordenadaCommand(coordenada);
    }

    public static DeleteCoordenadaByIdCommand createDeleteCoordenadaByIdCommand(Coordenada coordenada, DBHandler handler) {
        return new DeleteCoordenadaByIdCommand(coordenada, handler);
    }

    //UPDATE COORDENADA
    public static UpdateCoordenadaCommand createUpdateCoordenadaCommand(Coordenada coordenada){
        return new UpdateCoordenadaCommand(coordenada);
    }

    public static ModifyCoordenadaCommand createModifyCoordenadaCommand(Coordenada coordenada, DBHandler handler){
        return new ModifyCoordenadaCommand(coordenada, handler);
    }

    // SENTENCIA

    // COMMAND DE SENTENCIA_AV

    public static GetSentenciaCommand createGetSentenciaCommand(Sentencia distancia)
    {
        return new GetSentenciaCommand(distancia);
    }

    public static GetSentenciaByUsuariosCommand createGetSentenciaByUsuariosCommand(Sentencia distancia)
    {
        return new GetSentenciaByUsuariosCommand(distancia);
    }

    public static GetSentenciaByUsuariosCommand createGetSentenciaByUsuariosCommand(Sentencia distancia, DBHandler handler)
    {
        return new GetSentenciaByUsuariosCommand(distancia, handler);
    }

    public static GetSentenciaByIdCommand createGetSentenciaByIdCommand (DBHandler handler, long distanciaId )
    {
        return new GetSentenciaByIdCommand(handler, distanciaId);
    }

    public static AddSentenciaCommand createAddSentenciaCommand(Sentencia distancia, DBHandler handler)
    {
        return new AddSentenciaCommand(distancia, handler);
    }

    public static AddSentenciaCommand createAddSentenciaCommand(Sentencia distancia)
    {
        return new AddSentenciaCommand(distancia);
    }

    public static CreateSentenciaCommand createCreateSentenciaCommand(Sentencia distancia)
    {
        return new CreateSentenciaCommand(distancia);
    }


    public static DeleteSentenciaByIdCommand createDeleteSentenciaByIdCommand(Sentencia user, DBHandler handler)
    {
        return new DeleteSentenciaByIdCommand(user, handler);
    }

    public static DeleteSentenciaByIdCommand createDeleteSentenciaByIdCommand(Sentencia user)
    {
        return new DeleteSentenciaByIdCommand(user);
    }

    public static DeleteSentenciaCommand createDeleteSentenciaCommand(Sentencia user)
    {
        return new DeleteSentenciaCommand(user);
    }

    public static UpdateSentenciaByIdCommand createUpdateSentenciaByIdCommand(Sentencia user, DBHandler handler)
    {
        return new UpdateSentenciaByIdCommand(user, handler);
    }

    public static UpdateSentenciaByIdCommand createUpdateSentenciaByIdCommand(Sentencia user)
    {
        return new UpdateSentenciaByIdCommand(user);
    }

    public static UpdateSentenciaCommand createUpdateSentenciaCommand(Sentencia user)
    {
        return new UpdateSentenciaCommand(user);
    }

//ADMIN

    //GET

    public static GetAdminCommand createGetAdminCommand(Admin Admin) {
        return new GetAdminCommand(Admin);
    }

    public static GetAdminByIdCommand createGetAdminByIdCommand(DBHandler handler, long adminId) {
        return new GetAdminByIdCommand(handler, adminId);
    }

    public static GetAdminByCorreoCommand createGetAdminByCorreoCommand(Admin Admin) {
        return new GetAdminByCorreoCommand(Admin);
    }

    public static GetAdminByUsernameCommand createGetAdminByUsernameCommand(Admin Admin){
        return new GetAdminByUsernameCommand(Admin);
    }

    public static GetAdminByListCommand createGetAdminByListCommand(DBHandler handler) {
        return new GetAdminByListCommand(handler);
    }

    public static GetAllAdminCommand createGetAllAdminCommand(){
        return new GetAllAdminCommand();
    }


    //POST

    public static AddAdminCommand createAddAdminCommand(Admin Admin, DBHandler handler) {
        return new AddAdminCommand(Admin, handler);
    }

    public static CreateAdminCommand createCreateAdminCommand(Admin Admin) {
        return new CreateAdminCommand(Admin);
    }

    //DELETE

    public static DeleteAdminCommand createDeleteAdminCommand(Admin administrador) {
        return new DeleteAdminCommand(administrador);
    }

    public static EraseAdminCommand createEraseAdminCommand(Admin admin, DBHandler handler) {
        return new EraseAdminCommand(admin, handler);
    }

    //UPDATE
    public static UpdateAdminCommand createUpdateAdminCommand(Admin Admin){
        return new UpdateAdminCommand(Admin);
    }

    public static ModifyAdminCommand createModifyAdminCommand(Admin Admin, DBHandler handler){
        return new ModifyAdminCommand(Admin, handler);
    }


    //CONEXION

    // COMMAND DE Conexion

    // GET Conexion
    public static GetConexionCommand createGetConexionCommand(Conexion Conexion) {
        return new GetConexionCommand(Conexion);
    }

    public static GetConexionByIdCommand createGetConexionByIdCommand(DBHandler handler, long ConexionId) {
        return new GetConexionByIdCommand(handler, ConexionId);
    }

    public static GetAllConexionCommand createGetAllConexionCommand(){
        return new GetAllConexionCommand();
    }

    public static GetConexionByListCommand createGetConexionByListCommand(DBHandler handler) {
        return new GetConexionByListCommand(handler);
    }

    public static GetConexionByUsuarioIdCommand createGetConexionByUsuarioCommand(Conexion Conexion) {
        return new GetConexionByUsuarioIdCommand(Conexion);
    }


    // POST/AGREGAR Conexion
    public static AddConexionCommand createAddConexionCommand(Conexion Conexion, DBHandler handler) {
        return new AddConexionCommand(Conexion, handler);
    }

    /*public static AddUsuarioCommand createAddUsuarioCommand(User user) {
        return new AddUsuarioCommand(user);
    }*/

    public static CreateConexionCommand createCreateConexionCommand(Conexion Conexion) {
        return new CreateConexionCommand(Conexion);
    }

    //DELETE Conexion

//    public static DeleteConexionCommand createDeleteConexionCommand(Conexion Conexion) {
//        return new DeleteConexionCommand(Conexion);
//    }
//
//    public static EraseConexionCommand createEraseConexionCommand(Conexion Conexion, DBHandler handler) {
//        return new EraseConexionCommand(Conexion, handler);
//    }

    //UPDATE Conexion
    public static UpdateConexionCommand createUpdateConexionCommand(Conexion Conexion){
        return new UpdateConexionCommand(Conexion);
    }

    public static ModifyConexionCommand createModifyConexionCommand(Conexion Conexion, DBHandler handler){
        return new ModifyConexionCommand(Conexion, handler);
    }

    //UserType
    public static GetUserTypeCommand createGetUserTypeCommand(UserType UserType)
    {
        return new GetUserTypeCommand(UserType);
    }


    public static GetUserTypeByIdCommand createGetUserTypeByIdCommand (DBHandler handler, long UserTypeId )
    {
        return new GetUserTypeByIdCommand(handler, UserTypeId);
    }

    public static AddUserTypeCommand createAddUserTypeCommand(UserType UserType, DBHandler handler)
    {
        return new AddUserTypeCommand(UserType, handler);
    }

    public static AddUserTypeCommand createAddUserTypeCommand(UserType UserType)
    {
        return new AddUserTypeCommand(UserType);
    }

    public static CreateUserTypeCommand createCreateUserTypeCommand(UserType UserType)
    {
        return new CreateUserTypeCommand(UserType);
    }



    public static DeleteUserTypeByIdCommand createDeleteUserTypeByIdCommand(UserType user, DBHandler handler)
    {
        return new DeleteUserTypeByIdCommand(user, handler);
    }

    public static DeleteUserTypeByIdCommand createDeleteUserTypeByIdCommand(UserType user)
    {
        return new DeleteUserTypeByIdCommand(user);
    }

    public static DeleteUserTypeCommand createDeleteUserTypeCommand(UserType user)
    {
        return new DeleteUserTypeCommand(user);
    }

    public static UpdateUserTypeByIdCommand createUpdateUserTypeByIdCommand(UserType user, DBHandler handler)
    {
        return new UpdateUserTypeByIdCommand(user, handler);
    }

    public static UpdateUserTypeByIdCommand createUpdateUserTypeByIdCommand(UserType user)
    {
        return new UpdateUserTypeByIdCommand(user);
    }

    public static UpdateUserTypeCommand createUpdateUserTypeCommand(UserType user)
    {
        return new UpdateUserTypeCommand(user);
    }


}
