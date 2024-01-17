package com.ucab.cmcapp.logic.commands.conexion.composite;

import com.ucab.cmcapp.common.entities.Conexion;
import com.ucab.cmcapp.logic.commands.Command;
import com.ucab.cmcapp.logic.commands.CommandFactory;
import com.ucab.cmcapp.logic.commands.conexion.atomic.EraseConexionCommand;
import com.ucab.cmcapp.persistence.DBHandler;

public class DeleteConexionCommand extends Command<Conexion> {

    private Conexion _Historico_Usuario;
    private Conexion _result;

    private EraseConexionCommand _eraseHistorico_UsuarioCommand;

    public DeleteConexionCommand(Conexion Historico_Usuario) {
        _Historico_Usuario = Historico_Usuario;
        setHandler(new DBHandler());
    }

    @Override
    public void execute() {
        try {
            getHandler().beginTransaction();
            _eraseHistorico_UsuarioCommand = CommandFactory.createEraseConexionCommand(_Historico_Usuario, getHandler());
            _eraseHistorico_UsuarioCommand.execute();
            _result = _eraseHistorico_UsuarioCommand.getReturnParam();
            getHandler().finishTransaction();
            getHandler().closeSession();
        } catch (Exception e) {
            getHandler().rollbackTransaction();
            getHandler().closeSession();
            throw e;
        }
    }

    @Override
    public Conexion getReturnParam() {
        return _result;
    }

    @Override
    public void closeHandlerSession() {
        getHandler().closeSession();
    }

    public void setEraseConexionCommand(EraseConexionCommand eraseHistoricoCommand) {

    }
}

