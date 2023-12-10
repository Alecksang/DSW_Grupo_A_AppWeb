package com.ucab.cmcapp.logic.commands.agresor.atomic;

import com.ucab.cmcapp.common.entities.Agresor;
import com.ucab.cmcapp.logic.commands.Command;
import com.ucab.cmcapp.persistence.DBHandler;
import com.ucab.cmcapp.persistence.DaoFactory;
import com.ucab.cmcapp.persistence.dao.AgresorDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AddAgresorCommand extends Command<Agresor> {
    private static Logger _logger = LoggerFactory.getLogger(AddAgresorCommand.class);
    private Agresor _agresor;
    private AgresorDao _dao;

    public AddAgresorCommand(Agresor Usuario_Agresor, DBHandler handler) {
        //region Instrumentation DEBUG
        _logger.debug(String.format("Get in AddAgresorCommand.ctor: parameter {%s}",
                Usuario_Agresor.toString()));
        setHandler(handler);
        _agresor = Usuario_Agresor;
        _dao = DaoFactory.createAgresorDao(getHandler());


        //region Instrumentation DEBUG
        _logger.debug(String.format("Leaving AddAgresorCommand.ctor: attribute {%s}",
                _agresor.toString()));
        //endregion
    }

    public AddAgresorCommand(Agresor Usuario_Agresor) {
        //region Instrumentation DEBUG
        _logger.debug(String.format("Get in AddAgresorCommand.ctor: parameter {%s}",
                Usuario_Agresor.toString()));
        _agresor = Usuario_Agresor;
        setHandler(new DBHandler());
        _dao = DaoFactory.createAgresorDao(getHandler());


        //region Instrumentation DEBUG
        _logger.debug(String.format("Leaving AddAgresorCommand.ctor: attribute {%s}",
                _agresor.toString()));
        //endregion
    }

    @Override
    public void execute() {
        //region Instrumentation DEBUG
        _logger.debug("Get in  AddAgresorCommand.execute");
        //endregion

        _agresor = _dao.insert(_agresor);

        //region Instrumentation DEBUG
        _logger.debug("Get in  AddAgresorCommand.execute");
        //endregion
    }

    @Override
    public Agresor getReturnParam() {
        return _agresor;
    }

    @Override
    public void closeHandlerSession() {
        getHandler().closeSession();
    }
}
