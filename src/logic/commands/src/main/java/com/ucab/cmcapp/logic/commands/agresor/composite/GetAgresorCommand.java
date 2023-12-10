package com.ucab.cmcapp.logic.commands.agresor.composite;

import com.ucab.cmcapp.common.entities.Agresor;
import com.ucab.cmcapp.logic.commands.Command;
import com.ucab.cmcapp.logic.commands.CommandFactory;
import com.ucab.cmcapp.logic.commands.agresor.atomic.GetAgresorByIdCommand;
import com.ucab.cmcapp.persistence.DBHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GetAgresorCommand extends Command<Agresor> {
    private static Logger _logger = LoggerFactory.getLogger(GetAgresorCommand.class);
    private Agresor _Usuario_Agresor;
    long _id;

    public GetAgresorCommand(Agresor Usuario_Agresor) {
        //region Instrumentation DEBUG
        _logger.debug(String.format("Get in GetAgresorCommand.ctor: parameter {%s}",
                Usuario_Agresor.toString()));
        _id = Usuario_Agresor.get_id();
        _Usuario_Agresor = Usuario_Agresor;
        setHandler(new DBHandler());

        //region Instrumentation DEBUG
        _logger.debug(String.format("Leaving GetAgresorCommand.ctor: attribute {%s}",
                _Usuario_Agresor.toString()));
        //endregion
    }

    @Override
    public void execute() {
        try {
            GetAgresorByIdCommand getAgresorByIdCommand = CommandFactory.createGetAgresorByIdCommand(getHandler(), _id);
            getAgresorByIdCommand.execute();
            _Usuario_Agresor = getAgresorByIdCommand.getReturnParam();
        } catch (Exception e) {
            getHandler().rollbackTransaction();
            getHandler().closeSession();
            throw e;
        }
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
