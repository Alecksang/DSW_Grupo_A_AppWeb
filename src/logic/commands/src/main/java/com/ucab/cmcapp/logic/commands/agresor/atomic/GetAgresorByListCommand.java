package com.ucab.cmcapp.logic.commands.agresor.atomic;

import com.ucab.cmcapp.common.entities.Agresor;
import com.ucab.cmcapp.logic.commands.Command;
import com.ucab.cmcapp.persistence.DBHandler;
import com.ucab.cmcapp.persistence.DaoFactory;
import com.ucab.cmcapp.persistence.dao.AgresorDao;

import java.util.List;

public class GetAgresorByListCommand extends Command<Agresor> {

    private List<Agresor> _result;
    private AgresorDao _dao;

    public GetAgresorByListCommand(DBHandler handler) {
        //region Instrumentation DEBUG
        //endregion

        setHandler(handler);
        _dao = DaoFactory.createAgresorDao(getHandler());

        //region Instrumentation DEBUG
        //endregion
    }

    @Override
    public void execute() {
        //region Instrumentation DEBUG
        //endregion
        _result = _dao.findAll(Agresor.class);
        //region Instrumentation DEBUG
        //endregion
    }

    @Override
    public List <Agresor> getReturnParam() {
        return _result;
    }

    @Override
    public void closeHandlerSession() {
        getHandler().closeSession();
    }
}
