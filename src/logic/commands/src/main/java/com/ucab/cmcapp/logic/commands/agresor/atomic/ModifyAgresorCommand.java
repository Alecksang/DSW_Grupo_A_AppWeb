package com.ucab.cmcapp.logic.commands.agresor.atomic;

import com.ucab.cmcapp.common.entities.Agresor;
import com.ucab.cmcapp.logic.commands.Command;
import com.ucab.cmcapp.persistence.DBHandler;
import com.ucab.cmcapp.persistence.DaoFactory;
import com.ucab.cmcapp.persistence.dao.AgresorDao;

public class ModifyAgresorCommand extends Command<Agresor> {

    private Agresor _Usuario_Agresor;
    private AgresorDao _dao;

    public ModifyAgresorCommand(Agresor Usuario_Agresor, DBHandler handler) {
        setHandler(handler);
        _Usuario_Agresor = Usuario_Agresor;
        _dao = DaoFactory.createAgresorDao(getHandler());
    }

    @Override
    public void execute() {
        _Usuario_Agresor = _dao.update(_Usuario_Agresor);
    }

    @Override
    public Agresor getReturnParam() {
        return _Usuario_Agresor;
    }

    @Override
    public void closeHandlerSession() {
        getHandler().closeSession();
    }
}