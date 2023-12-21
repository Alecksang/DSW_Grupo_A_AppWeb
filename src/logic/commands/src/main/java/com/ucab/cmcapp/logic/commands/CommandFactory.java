package com.ucab.cmcapp.logic.commands;

import com.ucab.cmcapp.common.entities.*;
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
import com.ucab.cmcapp.logic.commands.alerta.atomic.AddAlertaCommand;
import com.ucab.cmcapp.logic.commands.alerta.atomic.GetAlertaByIdCommand;
import com.ucab.cmcapp.logic.commands.alerta.atomic.GetAlertaByTipoCommand;
import com.ucab.cmcapp.logic.commands.alerta.composite.CreateAlertaCommand;
import com.ucab.cmcapp.logic.commands.alerta.composite.GetAlertaCommand;
import com.ucab.cmcapp.logic.commands.coordenada.atomic.*;
import com.ucab.cmcapp.logic.commands.coordenada.composite.*;
import com.ucab.cmcapp.logic.commands.sentencia_av.atomic.*;
import com.ucab.cmcapp.logic.commands.sentencia_av.composite.*;
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

    //GET

    public static GetUsuarioCommand createGetUsuarioCommand(Usuario user)
    {
        return new GetUsuarioCommand(user);
    }
    public static GetUsuarioByUsernameCommand createGetUsuarioByUsernameCommand(Usuario user)
    {
        return new GetUsuarioByUsernameCommand(user);
    }
    public static GetUsuarioByUsernameCommand createGetUsuarioByUsernameCommand(Usuario user, DBHandler handler)
    {
        return new GetUsuarioByUsernameCommand(user, handler);
    }
    public static GetUsuarioByIdCommand createGetUsuarioByIdCommand (DBHandler handler, long userId )
    {
        return new GetUsuarioByIdCommand(handler, userId);
    }
    public static GetAllUsuarioCommand createGetAllUsuarioCommand(){
        return new GetAllUsuarioCommand();
    }
    public static GetUsuarioByListCommand createGetUsuarioByListCommand(DBHandler handler) {
        return new GetUsuarioByListCommand(handler);
    }

    //POST USUARIO
    public static AddUsuarioCommand createAddUsuarioCommand(Usuario usuario, DBHandler handler) {
        return new AddUsuarioCommand(usuario, handler);
    }

    public static CreateUsuarioCommand createCreateUsuarioCommand(Usuario usuario) {
        return new CreateUsuarioCommand(usuario);
    }

    //DELETE USUARIO

    public static DeleteUsuarioCommand createDeleteUsuarioCommand(Usuario usuario) {
        return new DeleteUsuarioCommand(usuario);
    }

    public static DeleteUsuarioByIdCommand createDeleteUsuarioByIdCommand(Usuario usuario, DBHandler handler) {
        return new DeleteUsuarioByIdCommand (usuario, handler);
    }

    //UPDATE USUARIO
    public static UpdateUsuarioCommand createUpdateUsuarioCommand(Usuario usuario){
        return new UpdateUsuarioCommand(usuario);
    }
    public static ModifyUsuarioCommand createModifyUsuarioCommand(Usuario usuario, DBHandler handler){
        return new ModifyUsuarioCommand(usuario, handler);
    }

//VICTIMA

    //POST
    public static AddVictimaCommand createAddVictimaCommand(Victima usuarioVictima, DBHandler handler) {
        return new AddVictimaCommand(usuarioVictima, handler);
    }
    public static CreateVictimaCommand createCreateVictimaCommand(Victima usuarioVictima) {
        return new CreateVictimaCommand(usuarioVictima);
    }

    //GET
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

    //PUT
    public static UpdateVictimaCommand createUpdateVictimaCommand(Victima usuarioVictima){
        return new UpdateVictimaCommand(usuarioVictima);
    }
    public static ModifyVictimaCommand createModifyVictimaCommand(Victima usuarioVictima, DBHandler handler){
        return new ModifyVictimaCommand(usuarioVictima, handler);
    }

//AGRESOR

    //POST
    public static AddAgresorCommand createAddAgresorCommand(Agresor usuarioAgresor, DBHandler handler) {
        return new AddAgresorCommand(usuarioAgresor, handler);
    }
    public static CreateAgresorCommand createCreateAgresorCommand(Agresor agresor)
    {
        return new CreateAgresorCommand(agresor);
    }

    //GET
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

    //PUT
    public static UpdateAgresorCommand createUpdateAgresorCommand(Agresor usuarioAgresor){
        return new UpdateAgresorCommand(usuarioAgresor);
    }

    public static ModifyAgresorCommand createModifyAgresorCommand(Agresor usuarioAgresor, DBHandler handler){
        return new ModifyAgresorCommand(usuarioAgresor, handler);
    }


//ALERTA

    //POST
    public static AddAlertaCommand createAddAlertaCommand(Alerta alerta, DBHandler handler)
    {
        return new AddAlertaCommand(alerta, handler);
    }
    public static CreateAlertaCommand createCreateAlertaCommand(Alerta alerta)
    {
        return new CreateAlertaCommand(alerta);
    }

    //GET
    public static GetAlertaCommand createGetAlertaCommand(Alerta alerta)
    {
        return new GetAlertaCommand(alerta);
    }

    public static GetAlertaByIdCommand createGetAlertaByIdCommand (DBHandler handler, long alertaId )
    {
        return new GetAlertaByIdCommand(handler, alertaId);
    }

    public static GetAlertaByTipoCommand createGetAlertaByTipoCommand(Alerta alerta)
    {
        return new GetAlertaByTipoCommand(alerta);
    }

    //ZONA SEGURA

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

    //COORDENADA
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

    // GET SENTENCIA_AV
    public static GetSentencia_AVCommand createGetSentencia_AVCommand(Sentencia_AV usuarioSentencia_AV) {
        return new GetSentencia_AVCommand(usuarioSentencia_AV);
    }

    public static GetSentencia_AVByIdCommand createGetSentencia_AVByIdCommand(DBHandler handler, long atacanteId) {
        return new GetSentencia_AVByIdCommand(handler, atacanteId);
    }

    public static GetAllSentencia_AVCommand createGetAllSentencia_AVCommand(){
        return new GetAllSentencia_AVCommand();
    }

    public static GetSentencia_AVByListCommand createGetSentencia_AVByListCommand(DBHandler handler) {
        return new GetSentencia_AVByListCommand(handler);
    }


    // POST/AGREGAR Sentencia_AV
    public static AddSentencia_AVCommand createAddSentencia_AVCommand(Sentencia_AV usuarioSentencia_AV, DBHandler handler) {
        return new AddSentencia_AVCommand(usuarioSentencia_AV, handler);
    }

    /*public static AddUsuarioCommand createAddUsuarioCommand(User user) {
        return new AddUsuarioCommand(user);
    }*/

    public static CreateSentencia_AVCommand createCreateSentencia_AVCommand(Sentencia_AV usuarioSentencia_AV) {
        return new CreateSentencia_AVCommand(usuarioSentencia_AV);
    }

    //DELETE Sentencia_AV

    /*
    public static DeleteSentencia_AVCommand createDeleteSentencia_AVCommand(Sentencia_AV usuarioSentencia_AV) {
        return new DeleteSentencia_AVCommand(usuarioSentencia_AV);
    }

    public static EraseSentencia_AVCommand createEraseSentencia_AVCommand(Sentencia_AV usuarioSentencia_AV, DBHandler handler) {
        return new EraseSentencia_AVCommand(usuarioSentencia_AV, handler);
    }
    */

    //UPDATE Sentencia_AV_VICTIMA-ATACANTE
    public static UpdateSentencia_AVCommand createUpdateSentencia_AVCommand(Sentencia_AV usuarioSentencia_AV){
        return new UpdateSentencia_AVCommand(usuarioSentencia_AV);
    }

    public static ModifySentencia_AVCommand createModifySentencia_AVCommand(Sentencia_AV usuarioSentencia_AV, DBHandler handler){
        return new ModifySentencia_AVCommand(usuarioSentencia_AV, handler);
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

    // public static DeleteAdminCommand createDeleteAdminCommand(Admin Admin) {
    //     return new DeleteAdminCommand(Admin);
    // }

    // public static EraseAdminCommand createEraseAdminCommand(Admin Admin, DBHandler handler) {
    //     return new EraseAdminCommand(Admin, handler);
    // }

    //UPDATE
    public static UpdateAdminCommand createUpdateAdminCommand(Admin Admin){
        return new UpdateAdminCommand(Admin);
    }

    public static ModifyAdminCommand createModifyAdminCommand(Admin Admin, DBHandler handler){
        return new ModifyAdminCommand(Admin, handler);
    }


}
