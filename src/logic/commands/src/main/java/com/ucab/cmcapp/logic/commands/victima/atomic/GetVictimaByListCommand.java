package com.ucab.cmcapp.logic.commands.victima.atomic;

import com.ucab.cmcapp.common.entities.Victima;
import com.ucab.cmcapp.logic.commands.Command;
import com.ucab.cmcapp.persistence.DBHandler;
import com.ucab.cmcapp.persistence.DaoFactory;
import com.ucab.cmcapp.persistence.dao.VictimaDao;

import java.util.List;

public class GetVictimaByListCommand extends Command<Victima> {

    private List<Victima> _result;
    private VictimaDao _dao;

    public GetVictimaByListCommand(DBHandler handler) {
        //region Instrumentation DEBUG
        //endregion

        setHandler(handler);
        _dao = DaoFactory.createVictimaDao(getHandler());

        //region Instrumentation DEBUG
        //endregion
    }

    @Override
    public void execute() {
        //region Instrumentation DEBUG
        //endregion
        _result = _dao.findAll(Victima.class);
        //region Instrumentation DEBUG
        //endregion
    }

    @Override
    public List <Victima> getReturnParam() {
        return _result;
    }

    @Override
    public void closeHandlerSession() {
        getHandler().closeSession();
    }
}
