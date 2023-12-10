package com.ucab.cmcapp.logic.commands.agresor.composite;

import com.ucab.cmcapp.common.entities.Agresor;
import com.ucab.cmcapp.logic.commands.Command;
import com.ucab.cmcapp.logic.commands.CommandFactory;
import com.ucab.cmcapp.logic.commands.agresor.atomic.GetAgresorByListCommand;
import com.ucab.cmcapp.persistence.DBHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class GetAllAgresorCommand extends Command <Agresor> {
    private static Logger _logger = LoggerFactory.getLogger(GetAgresorCommand.class);
    private List<Agresor> _Usuario_Agresor;

    public GetAllAgresorCommand() {
        //region Instrumentation DEBUG

        setHandler(new DBHandler());

        //endregion
    }

    @Override
    public void execute() {
        try {
            GetAgresorByListCommand getAgresorByListCommand = CommandFactory.createGetAgresorByListCommand(getHandler());
            getAgresorByListCommand.execute();
            _Usuario_Agresor = getAgresorByListCommand.getReturnParam();
        } catch (Exception e) {
            getHandler().rollbackTransaction();
            getHandler().closeSession();
            throw e;
        }
    }

    @Override
    public List <Agresor> getReturnParam() {
        return _Usuario_Agresor;
    }

    @Override
    public void closeHandlerSession() {
        getHandler().closeSession();
    }
}
