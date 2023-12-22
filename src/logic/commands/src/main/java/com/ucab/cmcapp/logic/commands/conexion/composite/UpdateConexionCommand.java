package com.ucab.cmcapp.logic.commands.conexion.composite;

import com.ucab.cmcapp.common.entities.Conexion;
import com.ucab.cmcapp.logic.commands.Command;
import com.ucab.cmcapp.logic.commands.CommandFactory;
import com.ucab.cmcapp.logic.commands.conexion.atomic.ModifyConexionCommand;
import com.ucab.cmcapp.persistence.DBHandler;

public class UpdateConexionCommand extends Command<Conexion> {

    private Conexion _Conexion;
    private Conexion _result;
    private ModifyConexionCommand _modifyConexionCommand;

    public UpdateConexionCommand(Conexion Conexion) {
        _Conexion = Conexion;
        setHandler(new DBHandler());
    }

    @Override
    public void execute() {
        try {
            getHandler().beginTransaction();
            _modifyConexionCommand = CommandFactory.createModifyConexionCommand(_Conexion, getHandler());
            _modifyConexionCommand.execute();
            _result = _modifyConexionCommand.getReturnParam();
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

}
