package com.ucab.cmcapp.logic.commands.agresor.composite;

import com.ucab.cmcapp.common.entities.Agresor;
import com.ucab.cmcapp.logic.commands.Command;
import com.ucab.cmcapp.logic.commands.CommandFactory;
import com.ucab.cmcapp.logic.commands.agresor.atomic.AddAgresorCommand;
import com.ucab.cmcapp.persistence.DBHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CreateAgresorCommand extends Command<Agresor> {
    private static Logger _logger = LoggerFactory.getLogger(CreateAgresorCommand.class);
    private Agresor _agresor;
    private Agresor _result;
    private AddAgresorCommand _add_agresorCommand;

    public CreateAgresorCommand(Agresor Usuario_Agresor) {
        //region Instrumentation DEBUG
        _logger.debug("Entering CreateAgresorCommand.ctor");
        //endregion

        _agresor = Usuario_Agresor;
        setHandler(new DBHandler());

        //region Instrumentation DEBUG
        _logger.debug("Leaving CreateAgresorCommand.ctor");
        //endregion
    }

    @Override
    public void execute() {
        //region Instrumentation DEBUG
        _logger.debug("Entering CreateAgresorCommand.execute");
        //endregion

        try {
            getHandler().beginTransaction();
            _add_agresorCommand = CommandFactory.createAddAgresorCommand(_agresor, getHandler());
            _add_agresorCommand.execute();
            _result = _add_agresorCommand.getReturnParam();
            getHandler().finishTransaction();
            getHandler().closeSession();
        } catch (Exception e) {
            getHandler().rollbackTransaction();
            getHandler().closeSession();
            throw e;
        }
        //region Instrumentation DEBUG
        _logger.debug("Leaving CreateAgresorCommand.execute");
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

