package com.ucab.cmcapp.logic.commands.sentencia_av.atomic;

import com.ucab.cmcapp.common.entities.Sentencia_AV;
import com.ucab.cmcapp.logic.commands.Command;
import com.ucab.cmcapp.persistence.DBHandler;
import com.ucab.cmcapp.persistence.DaoFactory;
import com.ucab.cmcapp.persistence.dao.Sentencia_AVDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AddSentencia_AVCommand extends Command<Sentencia_AV> {
    private static Logger _logger = LoggerFactory.getLogger(AddSentencia_AVCommand.class);
    private Sentencia_AV _Sentencia_AV;
    private Sentencia_AVDao _dao;

    public AddSentencia_AVCommand(Sentencia_AV Sentencia_AV, DBHandler handler) {
        //region Instrumentation DEBUG
        _logger.debug(String.format("Get in AddSentencia_AVCommand.ctor: parameter {%s}",
                Sentencia_AV.toString()));
        setHandler(handler);
        _Sentencia_AV = Sentencia_AV;
        _dao = DaoFactory.createSentencia_AVDao(getHandler());


        //region Instrumentation DEBUG
        _logger.debug(String.format("Leaving AddSentencia_AVCommand.ctor: attribute {%s}",
                _Sentencia_AV.toString()));
        //endregion
    }

    public AddSentencia_AVCommand(Sentencia_AV Sentencia_AV) {
        //region Instrumentation DEBUG
        _logger.debug(String.format("Get in AddSentencia_AVCommand.ctor: parameter {%s}",
                Sentencia_AV.toString()));
        _Sentencia_AV = Sentencia_AV;
        setHandler(new DBHandler());
        _dao = DaoFactory.createSentencia_AVDao(getHandler());


        //region Instrumentation DEBUG
        _logger.debug(String.format("Leaving AddSentencia_AVCommand.ctor: attribute {%s}",
                _Sentencia_AV.toString()));
        //endregion
    }

    @Override
    public void execute() {
        //region Instrumentation DEBUG
        _logger.debug("Get in  AddSentencia_AVCommand.execute");
        //endregion

        _Sentencia_AV = _dao.insert(_Sentencia_AV);

        //region Instrumentation DEBUG
        _logger.debug("Get in  AddSentencia_AVCommand.execute");
        //endregion
    }

    @Override
    public Sentencia_AV getReturnParam() {
        return _Sentencia_AV;
    }

    @Override
    public void closeHandlerSession() {
        getHandler().closeSession();
    }
}