package com.ucab.cmcapp.logic.commands.sentencia_av.composite;


import com.ucab.cmcapp.common.entities.Sentencia_AV;
import com.ucab.cmcapp.logic.commands.Command;
import com.ucab.cmcapp.logic.commands.CommandFactory;
import com.ucab.cmcapp.logic.commands.sentencia_av.atomic.GetSentencia_AVByListCommand;
import com.ucab.cmcapp.logic.commands.sentencia_av.composite.GetSentencia_AVCommand;
import com.ucab.cmcapp.persistence.DBHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class GetAllSentencia_AVCommand extends Command <Sentencia_AV> {
    private static Logger _logger = LoggerFactory.getLogger(GetSentencia_AVCommand.class);
    private List<Sentencia_AV> _Sentencia_AV;

    public GetAllSentencia_AVCommand() {
        //region Instrumentation DEBUG

        setHandler(new DBHandler());

        //endregion
    }

    @Override
    public void execute() {
        try {
            GetSentencia_AVByListCommand getSentencia_AVByListCommand = CommandFactory.createGetSentencia_AVByListCommand(getHandler());
            getSentencia_AVByListCommand.execute();
            _Sentencia_AV = getSentencia_AVByListCommand.getReturnParam();
        } catch (Exception e) {
            getHandler().rollbackTransaction();
            getHandler().closeSession();
            throw e;
        }
    }

    @Override
    public List <Sentencia_AV> getReturnParam() {
        return _Sentencia_AV;
    }

    @Override
    public void closeHandlerSession() {
        getHandler().closeSession();
    }
}
