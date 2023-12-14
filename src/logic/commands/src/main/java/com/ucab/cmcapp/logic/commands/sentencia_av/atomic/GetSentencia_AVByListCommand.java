package com.ucab.cmcapp.logic.commands.sentencia_av.atomic;

import com.ucab.cmcapp.common.entities.Sentencia_AV;
import com.ucab.cmcapp.logic.commands.Command;
import com.ucab.cmcapp.persistence.DBHandler;
import com.ucab.cmcapp.persistence.DaoFactory;
import com.ucab.cmcapp.persistence.dao.Sentencia_AVDao;

import java.util.List;

public class GetSentencia_AVByListCommand extends Command<Sentencia_AV> {

    private List<Sentencia_AV> _result;
    private Sentencia_AVDao _dao;

    public GetSentencia_AVByListCommand(DBHandler handler) {
        //region Instrumentation DEBUG
        //endregion

        setHandler(handler);
        _dao = DaoFactory.createSentencia_AVDao(getHandler());

        //region Instrumentation DEBUG
        //endregion
    }

    @Override
    public void execute() {
        //region Instrumentation DEBUG
        //endregion
        _result = _dao.findAll(Sentencia_AV.class);
        //region Instrumentation DEBUG
        //endregion
    }

    @Override
    public List <Sentencia_AV> getReturnParam() {
        return _result;
    }

    @Override
    public void closeHandlerSession() {
        getHandler().closeSession();
    }
}