package com.ucab.cmcapp.logic.commands.sentencia.composite;


import com.ucab.cmcapp.common.entities.Sentencia;
import com.ucab.cmcapp.logic.commands.Command;
import com.ucab.cmcapp.logic.commands.CommandFactory;
import com.ucab.cmcapp.logic.commands.sentencia.atomic.GetSentenciaByListCommand;
import com.ucab.cmcapp.logic.commands.sentencia.composite.GetSentenciaCommand;
import com.ucab.cmcapp.persistence.DBHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class GetAllSentenciaCommand extends Command <Sentencia> {
    private static Logger _logger = LoggerFactory.getLogger(GetSentenciaCommand.class);
    private List<Sentencia> _Relacion_VA;

    public GetAllSentenciaCommand() {
        //region Instrumentation DEBUG

        setHandler(new DBHandler());

        //endregion
    }

    @Override
    public void execute() {
        try {
            GetSentenciaByListCommand getRelacion_VAByListCommand = CommandFactory.createGetSentenciaByListCommand(getHandler());
            getRelacion_VAByListCommand.execute();
            _Relacion_VA = getRelacion_VAByListCommand.getReturnParam();
        } catch (Exception e) {
            getHandler().rollbackTransaction();
            getHandler().closeSession();
            throw e;
        }
    }

    @Override
    public List <Sentencia> getReturnParam() {
        return _Relacion_VA;
    }

    @Override
    public void closeHandlerSession() {
        getHandler().closeSession();
    }
}
