package com.ucab.cmcapp.logic.commands;

import com.ucab.cmcapp.common.entities.Alerta;
import com.ucab.cmcapp.common.entities.User;
import com.ucab.cmcapp.common.entities.Usuarios;
import com.ucab.cmcapp.common.entities.Victima;
import com.ucab.cmcapp.logic.commands.alerta.atomic.AddAlertaCommand;
import com.ucab.cmcapp.logic.commands.alerta.atomic.GetAlertaByIdCommand;
import com.ucab.cmcapp.logic.commands.alerta.atomic.GetAlertaByTipoCommand;
import com.ucab.cmcapp.logic.commands.alerta.composite.CreateAlertaCommand;
import com.ucab.cmcapp.logic.commands.alerta.composite.GetAlertaCommand;
import com.ucab.cmcapp.logic.commands.user.atomic.AddUserCommand;
import com.ucab.cmcapp.logic.commands.user.atomic.GetUserByIdCommand;
import com.ucab.cmcapp.logic.commands.user.composite.CreateUserCommand;
import com.ucab.cmcapp.logic.commands.user.composite.GetUserCommand;
import com.ucab.cmcapp.logic.commands.user.atomic.GetUserByEmailCommand;
import com.ucab.cmcapp.logic.commands.usuario.atomic.AddUsuarioCommand;
import com.ucab.cmcapp.logic.commands.usuario.atomic.GetUsuarioByIdCommand;
import com.ucab.cmcapp.logic.commands.usuario.atomic.GetUsuarioByUsernameCommand;
import com.ucab.cmcapp.logic.commands.usuario.composite.CreateUsuarioCommand;
import com.ucab.cmcapp.logic.commands.usuario.composite.GetUsuarioCommand;
import com.ucab.cmcapp.logic.commands.victima.atomic.AddVictimaCommand;
import com.ucab.cmcapp.logic.commands.victima.atomic.GetVictimaByIdCommand;
import com.ucab.cmcapp.logic.commands.victima.atomic.GetVictimaByListCommand;
import com.ucab.cmcapp.logic.commands.victima.atomic.ModifyVictimaCommand;
import com.ucab.cmcapp.logic.commands.victima.composite.CreateVictimaCommand;
import com.ucab.cmcapp.logic.commands.victima.composite.GetAllVictimaCommand;
import com.ucab.cmcapp.logic.commands.victima.composite.GetVictimaCommand;
import com.ucab.cmcapp.logic.commands.victima.composite.UpdateVictimaCommand;
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
    //Usuario

    public static GetUsuarioCommand createGetUsuarioCommand(Usuarios user)
    {
        return new GetUsuarioCommand(user);
    }
    public static GetUsuarioByUsernameCommand createGetUsuarioByUsernameCommand(Usuarios user)
    {
        return new GetUsuarioByUsernameCommand(user);
    }
    public static GetUsuarioByUsernameCommand createGetUsuarioByUsernameCommand(Usuarios user, DBHandler handler)
    {
        return new GetUsuarioByUsernameCommand(user, handler);
    }
    public static GetUsuarioByIdCommand createGetUsuarioByIdCommand (DBHandler handler, long userId )
    {
        return new GetUsuarioByIdCommand(handler, userId);
    }
    public static AddUsuarioCommand createAddUsuarioCommand(Usuarios user, DBHandler handler)
    {
        return new AddUsuarioCommand(user, handler);
    }
    public static AddUsuarioCommand createAddUsuarioCommand(Usuarios user)
    {
        return new AddUsuarioCommand(user);
    }
    public static CreateUsuarioCommand createCreateUsuarioCommand(Usuarios user)
    {
        return new CreateUsuarioCommand(user);
    }
//Victima
    public static AddVictimaCommand createAddVictimaCommand(Victima usuarioVictima, DBHandler handler) {
        return new AddVictimaCommand(usuarioVictima, handler);
    }
    public static CreateVictimaCommand createCreateVictimaCommand(Victima usuarioVictima) {
        return new CreateVictimaCommand(usuarioVictima);
    }
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
    public static UpdateVictimaCommand createUpdateVictimaCommand(Victima usuarioVictima){
        return new UpdateVictimaCommand(usuarioVictima);
    }
    public static ModifyVictimaCommand createModifyVictimaCommand(Victima usuarioVictima, DBHandler handler){
        return new ModifyVictimaCommand(usuarioVictima, handler);
    }


//Alerta
    public static GetAlertaCommand createGetAlertaCommand(Alerta alerta)
    {
        return new GetAlertaCommand(alerta);
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
    public static GetAlertaByTipoCommand createGetAlertaByTipoCommand(Alerta alerta)
    {
        return new GetAlertaByTipoCommand(alerta);
    }

    public static GetAlertaByTipoCommand createGetAlertaByTipoCommand(Alerta alerta, DBHandler handler)
    {
        return new GetAlertaByTipoCommand(alerta, handler);
    }



}
