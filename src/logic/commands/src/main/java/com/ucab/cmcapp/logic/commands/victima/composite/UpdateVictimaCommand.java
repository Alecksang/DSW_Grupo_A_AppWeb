package com.ucab.cmcapp.logic.commands.victima.composite;
import com.ucab.cmcapp.common.entities.Victima;
import com.ucab.cmcapp.logic.commands.Command;
import com.ucab.cmcapp.logic.commands.CommandFactory;
import com.ucab.cmcapp.logic.commands.victima.atomic.ModifyVictimaCommand;
import com.ucab.cmcapp.persistence.DBHandler;

public class UpdateVictimaCommand extends Command<Victima> {

    private Victima _Usuario_Victima;
    private Victima _result;
    private ModifyVictimaCommand _modifyUsuario_VictimaCommand;

    public UpdateVictimaCommand(Victima Usuario_Victima) {
        _Usuario_Victima = Usuario_Victima;
        setHandler(new DBHandler());
    }

    @Override
    public void execute() {
        try {
            getHandler().beginTransaction();
            _modifyUsuario_VictimaCommand = CommandFactory.createModifyVictimaCommand(_Usuario_Victima, getHandler());
            _modifyUsuario_VictimaCommand.execute();
            _result = _modifyUsuario_VictimaCommand.getReturnParam();
            getHandler().finishTransaction();
            getHandler().closeSession();
        } catch (Exception e) {
            getHandler().rollbackTransaction();
            getHandler().closeSession();
            throw e;
        }
    }

    @Override
    public Victima getReturnParam() {
        return _result;
    }

    @Override
    public void closeHandlerSession() {
        getHandler().closeSession();
    }

}
