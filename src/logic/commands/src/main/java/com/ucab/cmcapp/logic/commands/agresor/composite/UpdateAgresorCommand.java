package com.ucab.cmcapp.logic.commands.agresor.composite;

import com.ucab.cmcapp.common.entities.Agresor;
import com.ucab.cmcapp.logic.commands.Command;
import com.ucab.cmcapp.logic.commands.CommandFactory;
import com.ucab.cmcapp.logic.commands.agresor.atomic.ModifyAgresorCommand;
import com.ucab.cmcapp.persistence.DBHandler;

public class UpdateAgresorCommand extends Command<Agresor> {

    private Agresor _Usuario_Agresor;
    private Agresor _result;
    private ModifyAgresorCommand _modify_Usuario_AgresorCommand;

    public UpdateAgresorCommand(Agresor Usuario_Agresor) {
        _Usuario_Agresor = Usuario_Agresor;
        setHandler(new DBHandler());
    }

    @Override
    public void execute() {
        try {
            getHandler().beginTransaction();
            _modify_Usuario_AgresorCommand = CommandFactory.createModifyAgresorCommand(_Usuario_Agresor, getHandler());
            _modify_Usuario_AgresorCommand.execute();
            _result = _modify_Usuario_AgresorCommand.getReturnParam();
            getHandler().finishTransaction();
            getHandler().closeSession();
        } catch (Exception e) {
            getHandler().rollbackTransaction();
            getHandler().closeSession();
            throw e;
        }
    }

    @Override
    public Agresor getReturnParam() {
        return _result;
    }

    @Override
    public void closeHandlerSession() {
        getHandler().closeSession();
    }

}
