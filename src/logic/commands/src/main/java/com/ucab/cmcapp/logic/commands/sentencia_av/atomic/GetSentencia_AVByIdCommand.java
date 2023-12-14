package com.ucab.cmcapp.logic.commands.sentencia_av.atomic;

import com.ucab.cmcapp.common.entities.Sentencia_AV;
import com.ucab.cmcapp.logic.commands.Command;
import com.ucab.cmcapp.persistence.DBHandler;
import com.ucab.cmcapp.persistence.DaoFactory;
import com.ucab.cmcapp.persistence.dao.Sentencia_AVDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GetSentencia_AVByIdCommand extends Command<Sentencia_AV> {
    private static Logger _logger = LoggerFactory.getLogger(GetSentencia_AVByIdCommand.class);
    private long _userId;
    private Sentencia_AV _result;
    private Sentencia_AVDao _dao;

    public GetSentencia_AVByIdCommand(DBHandler handler, long userId) {
        //region Instrumentation DEBUG
        _logger.debug(String.format("Get in GetSentencia_AVByIdCommand.ctor: parameter {%s}", userId));
        //endregion

        _userId = userId;
        setHandler(handler);
        _dao = DaoFactory.createSentencia_AVDao(getHandler());

        //region Instrumentation DEBUG
        _logger.debug(String.format("Leaving GetSentencia_AVByIdCommand.ctor: attribute {%s}", userId));
        //endregion
    }

    @Override
    public void execute() {
        //region Instrumentation DEBUG
        _logger.debug("Get in  GetSentencia_AVByIdCommand.execute");
        //endregion
        _result = _dao.find(_userId, Sentencia_AV.class);
        //region Instrumentation DEBUG
        _logger.debug("Leaving  GetSentencia_AVByIdCommand.execute");
        //endregion
    }

    @Override
    public Sentencia_AV getReturnParam() {
        return _result;
    }

    @Override
    public void closeHandlerSession() {
        getHandler().closeSession();
    }
}