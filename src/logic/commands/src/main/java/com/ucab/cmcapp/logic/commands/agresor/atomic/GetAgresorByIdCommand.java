package com.ucab.cmcapp.logic.commands.agresor.atomic;

import com.ucab.cmcapp.common.entities.Agresor;
import com.ucab.cmcapp.logic.commands.Command;
import com.ucab.cmcapp.persistence.DBHandler;
import com.ucab.cmcapp.persistence.DaoFactory;
import com.ucab.cmcapp.persistence.dao.AgresorDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GetAgresorByIdCommand extends Command<Agresor> {
    private static Logger _logger = LoggerFactory.getLogger(GetAgresorByIdCommand.class);
    private long _userId;
    private Agresor _result;
    private AgresorDao _dao;

    public GetAgresorByIdCommand(DBHandler handler, long userId) {
        //region Instrumentation DEBUG
        _logger.debug(String.format("Get in GetAgresorByIdCommand.ctor: parameter {%s}", userId));
        //endregion

        _userId = userId;
        setHandler(handler);
        _dao = DaoFactory.createAgresorDao(getHandler());

        //region Instrumentation DEBUG
        _logger.debug(String.format("Leaving GetAgresorByIdCommand.ctor: attribute {%s}", userId));
        //endregion
    }

    @Override
    public void execute() {
        //region Instrumentation DEBUG
        _logger.debug("Get in  GetAgresorByIdCommand.execute");
        //endregion
        _result = _dao.find(_userId, Agresor.class);
        //region Instrumentation DEBUG
        _logger.debug("Leaving  GetAgresorByIdCommand.execute");
        //endregion
    }

    @Override
    public Agresor getReturnParam() {
        return _result;
    }

    @Override
    public void closeHandlerSession() {
        getHandler().closeSession();
    }
}
