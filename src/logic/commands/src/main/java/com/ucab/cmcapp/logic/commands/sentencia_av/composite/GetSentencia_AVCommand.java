package com.ucab.cmcapp.logic.commands.sentencia_av.composite;


import com.ucab.cmcapp.common.entities.Sentencia_AV;
import com.ucab.cmcapp.logic.commands.Command;
import com.ucab.cmcapp.logic.commands.CommandFactory;
import com.ucab.cmcapp.logic.commands.sentencia_av.atomic.GetSentencia_AVByIdCommand;
import com.ucab.cmcapp.persistence.DBHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GetSentencia_AVCommand extends Command<Sentencia_AV> {
    private static Logger _logger = LoggerFactory.getLogger(GetSentencia_AVCommand.class);
    private Sentencia_AV _Sentencia_AV;
    long _id;

    public GetSentencia_AVCommand(Sentencia_AV Sentencia_AV) {
        //region Instrumentation DEBUG
        _logger.debug(String.format("Get in GetSentencia_AVCommand.ctor: parameter {%s}",
                Sentencia_AV.toString()));
        _id = Sentencia_AV.get_id();
        _Sentencia_AV = Sentencia_AV;
        setHandler(new DBHandler());

        //region Instrumentation DEBUG
        _logger.debug(String.format("Leaving GetSentencia_AVCommand.ctor: attribute {%s}",
                _Sentencia_AV.toString()));
        //endregion
    }

    @Override
    public void execute() {
        try {
            GetSentencia_AVByIdCommand getSentencia_AVByIdCommand = CommandFactory.createGetSentencia_AVByIdCommand(getHandler(), _id);
            getSentencia_AVByIdCommand.execute();
            _Sentencia_AV = getSentencia_AVByIdCommand.getReturnParam();
        } catch (Exception e) {
            getHandler().rollbackTransaction();
            getHandler().closeSession();
            throw e;
        }
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
