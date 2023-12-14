package com.ucab.cmcapp.logic.commands.sentencia_av.composite;


import com.ucab.cmcapp.common.entities.Sentencia_AV;
import com.ucab.cmcapp.logic.commands.Command;
import com.ucab.cmcapp.logic.commands.CommandFactory;
import com.ucab.cmcapp.logic.commands.sentencia_av.atomic.ModifySentencia_AVCommand;
import com.ucab.cmcapp.persistence.DBHandler;

public class UpdateSentencia_AVCommand extends Command<Sentencia_AV> {

    private Sentencia_AV _Sentencia_AV;
    private Sentencia_AV _result;
    private ModifySentencia_AVCommand _modifySentencia_AVCommand;

    public UpdateSentencia_AVCommand(Sentencia_AV Sentencia_AV) {
        _Sentencia_AV = Sentencia_AV;
        setHandler(new DBHandler());
    }

    @Override
    public void execute() {
        try {
            getHandler().beginTransaction();
            _modifySentencia_AVCommand = CommandFactory.createModifySentencia_AVCommand(_Sentencia_AV, getHandler());
            _modifySentencia_AVCommand.execute();
            _result = _modifySentencia_AVCommand.getReturnParam();
            getHandler().finishTransaction();
            getHandler().closeSession();
        } catch (Exception e) {
            getHandler().rollbackTransaction();
            getHandler().closeSession();
            throw e;
        }
    }

    @Override
    public Sentencia_AV getReturnParam() {
        return _result;
    }

    @Override
    public void closeHandlerSession() {
        getHandler().closeSession();
    }

}