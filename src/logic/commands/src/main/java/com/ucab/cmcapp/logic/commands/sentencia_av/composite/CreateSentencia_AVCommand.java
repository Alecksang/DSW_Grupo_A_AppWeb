package com.ucab.cmcapp.logic.commands.sentencia_av.composite;


import com.ucab.cmcapp.common.entities.Sentencia_AV;
import com.ucab.cmcapp.logic.commands.Command;
import com.ucab.cmcapp.logic.commands.CommandFactory;
import com.ucab.cmcapp.logic.commands.sentencia_av.atomic.AddSentencia_AVCommand;
import com.ucab.cmcapp.persistence.DBHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CreateSentencia_AVCommand extends Command<Sentencia_AV> {
    private static Logger _logger = LoggerFactory.getLogger(CreateSentencia_AVCommand.class);
    private Sentencia_AV _Sentencia_AV;
    private Sentencia_AV _result;
    private AddSentencia_AVCommand _addSentencia_AVCommand;

    public CreateSentencia_AVCommand(Sentencia_AV Sentencia_AV) {
        //region Instrumentation DEBUG
        _logger.debug("Entering CreateSentencia_AVCommand.ctor");
        //endregion

        _Sentencia_AV = Sentencia_AV;
        setHandler(new DBHandler());

        //region Instrumentation DEBUG
        _logger.debug("Leaving CreateSentencia_AVCommand.ctor");
        //endregion
    }

    @Override
    public void execute() {
        //region Instrumentation DEBUG
        _logger.debug("Entering CreateSentencia_AVCommand.execute");
        //endregion

        try {
            getHandler().beginTransaction();
            _addSentencia_AVCommand = CommandFactory.createAddSentencia_AVCommand(_Sentencia_AV, getHandler());
            _addSentencia_AVCommand.execute();
            _result = _addSentencia_AVCommand.getReturnParam();
            getHandler().finishTransaction();
            getHandler().closeSession();
        } catch (Exception e) {
            getHandler().rollbackTransaction();
            getHandler().closeSession();
            throw e;
        }
        //region Instrumentation DEBUG
        _logger.debug("Leaving CreateSentencia_AVCommand.execute");
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