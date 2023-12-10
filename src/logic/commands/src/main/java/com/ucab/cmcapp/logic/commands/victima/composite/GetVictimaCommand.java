package com.ucab.cmcapp.logic.commands.victima.composite;
import com.ucab.cmcapp.common.entities.Victima;
import com.ucab.cmcapp.logic.commands.Command;
import com.ucab.cmcapp.logic.commands.CommandFactory;
import com.ucab.cmcapp.logic.commands.victima.atomic.GetVictimaByIdCommand;
import com.ucab.cmcapp.persistence.DBHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GetVictimaCommand extends Command<Victima> {
    private static Logger _logger = LoggerFactory.getLogger(GetVictimaCommand.class);
    private Victima _victima;
    long _id;

    public GetVictimaCommand(Victima Usuario_Victima) {
        //region Instrumentation DEBUG
        _logger.debug(String.format("Get in GetVictimaCommand.ctor: parameter {%s}",
                Usuario_Victima.toString()));
        _id = Usuario_Victima.get_id();
        _victima = Usuario_Victima;
        setHandler(new DBHandler());

        //region Instrumentation DEBUG
        _logger.debug(String.format("Leaving GetVictimaCommand.ctor: attribute {%s}",
                _victima.toString()));
        //endregion
    }

    @Override
    public void execute() {
        try {
            GetVictimaByIdCommand getVictimaByIdCommand = CommandFactory.createGetVictimaByIdCommand(getHandler(), _id);
            getVictimaByIdCommand.execute();
            _victima = getVictimaByIdCommand.getReturnParam();
        } catch (Exception e) {
            getHandler().rollbackTransaction();
            getHandler().closeSession();
            throw e;
        }
    }

    @Override
    public Victima getReturnParam() {
        return _victima;
    }

    @Override
    public void closeHandlerSession() {
        getHandler().closeSession();
    }
}

