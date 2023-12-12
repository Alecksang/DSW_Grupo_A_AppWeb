package com.ucab.cmcapp.logic.commands.zonasegura.atomic;

import com.ucab.cmcapp.common.entities.ZonaSegura;
import com.ucab.cmcapp.logic.commands.Command;
import com.ucab.cmcapp.persistence.DBHandler;
import com.ucab.cmcapp.persistence.DaoFactory;
import com.ucab.cmcapp.persistence.dao.ZonaSeguraDao;

import java.util.List;

public class GetAllZonaSeguraByUsuarioIdCommand extends Command<ZonaSegura> {

    private List<ZonaSegura> _result;
    private ZonaSeguraDao _dao;

    public GetAllZonaSeguraByUsuarioIdCommand(DBHandler handler) {
        setHandler(handler);
        _dao = DaoFactory.createZonaSeguraDao(getHandler());
    }

    @Override
    public void execute() {
        _result = _dao.findAll(ZonaSegura.class);
    }

    @Override
    public List<ZonaSegura> getReturnParam() {
        return _result;
    }

    @Override
    public void closeHandlerSession() {
        getHandler().closeSession();
    }

}