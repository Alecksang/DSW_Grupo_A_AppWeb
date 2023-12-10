package com.ucab.cmcapp.logic.commands.victima.composite;

import com.ucab.cmcapp.common.entities.Victima;
import com.ucab.cmcapp.logic.commands.Command;
import com.ucab.cmcapp.logic.commands.CommandFactory;
import com.ucab.cmcapp.logic.commands.victima.atomic.GetVictimaByListCommand;
import com.ucab.cmcapp.persistence.DBHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class GetAllVictimaCommand extends Command <Victima> {
    private static Logger _logger = LoggerFactory.getLogger(GetVictimaCommand.class);
    private List<Victima> _Usuario_Victima;

    public GetAllVictimaCommand() {
        //region Instrumentation DEBUG

        setHandler(new DBHandler());

        //endregion
    }

    @Override
    public void execute() {
        try {
            GetVictimaByListCommand getVictimaByListCommand = CommandFactory.createGetVictimaByListCommand(getHandler());
            getVictimaByListCommand.execute();
            _Usuario_Victima = getVictimaByListCommand.getReturnParam();
        } catch (Exception e) {
            getHandler().rollbackTransaction();
            getHandler().closeSession();
            throw e;
        }
    }

    @Override
    public List <Victima> getReturnParam() {
        return _Usuario_Victima;
    }

    @Override
    public void closeHandlerSession() {
        getHandler().closeSession();
    }
}
