package com.ucab.cmcapp.logic.commands.zonasegura.atomic;

import com.ucab.cmcapp.common.entities.ZonaSegura;
import com.ucab.cmcapp.logic.commands.Command;
import com.ucab.cmcapp.persistence.DBHandler;
import com.ucab.cmcapp.persistence.DaoFactory;
import com.ucab.cmcapp.persistence.dao.ZonaSeguraDao;

import java.util.List;

public class GetAllZonaSeguraByUsuarioIdCommand extends Command<ZonaSegura> {

    private ZonaSegura _zonaSegura;
    private List<ZonaSegura> _result;
    private ZonaSeguraDao _dao;

    public GetAllZonaSeguraByUsuarioIdCommand(ZonaSegura safeZone) {
        _zonaSegura = safeZone;
        setHandler(new DBHandler());
        _dao = DaoFactory.createZonaSeguraDao(getHandler());
    }

    @Override
    public void execute() {
        try {
            _result = _dao.getZonaByVictimaId(_zonaSegura.getUsuario());
        }catch (NullPointerException e){

        }
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