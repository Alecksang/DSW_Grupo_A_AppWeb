package com.ucab.cmcapp.logic.commands.zonasegura.atomic;

import com.ucab.cmcapp.common.entities.ZonaSegura;
import com.ucab.cmcapp.logic.commands.Command;
import com.ucab.cmcapp.persistence.DBHandler;
import com.ucab.cmcapp.persistence.DaoFactory;
import com.ucab.cmcapp.persistence.dao.ZonaSeguraDao;

import java.util.List;

public class GetZonaSeguraByListCommand extends Command<ZonaSegura> {

    private List<ZonaSegura> _result;
    private ZonaSeguraDao _dao;

    public GetZonaSeguraByListCommand(DBHandler handler) {
        //region Instrumentation DEBUG
        //endregion

        setHandler(handler);
        _dao = DaoFactory.createZonaSeguraDao(getHandler());

        //region Instrumentation DEBUG
        //endregion
    }

    @Override
    public void execute() {
        //region Instrumentation DEBUG
        //endregion
        _result = _dao.findAll(ZonaSegura.class);
        //region Instrumentation DEBUG
        //endregion
    }

    @Override
    public List <ZonaSegura> getReturnParam() {
        return _result;
    }

    @Override
    public void closeHandlerSession() {
        getHandler().closeSession();
    }
}
