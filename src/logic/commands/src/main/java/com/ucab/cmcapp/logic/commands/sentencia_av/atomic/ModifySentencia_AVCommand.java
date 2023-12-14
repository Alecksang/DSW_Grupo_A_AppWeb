package com.ucab.cmcapp.logic.commands.sentencia_av.atomic;

import com.ucab.cmcapp.common.entities.Sentencia_AV;
import com.ucab.cmcapp.logic.commands.Command;
import com.ucab.cmcapp.persistence.DBHandler;
import com.ucab.cmcapp.persistence.DaoFactory;
import com.ucab.cmcapp.persistence.dao.Sentencia_AVDao;

public class ModifySentencia_AVCommand extends Command<Sentencia_AV> {

    private Sentencia_AV _Sentencia_AV;
    private Sentencia_AVDao _dao;

    public ModifySentencia_AVCommand(Sentencia_AV Sentencia_AV, DBHandler handler) {
        setHandler(handler);
        _Sentencia_AV = Sentencia_AV;
        _dao = DaoFactory.createSentencia_AVDao(getHandler());
    }

    @Override
    public void execute() {
        _Sentencia_AV = _dao.update(_Sentencia_AV);
    }

    @Override
    public Sentencia_AV getReturnParam() {
        return _Sentencia_AV;
    }

    @Override
    public void closeHandlerSession() {
        getHandler().closeSession();
    }
}