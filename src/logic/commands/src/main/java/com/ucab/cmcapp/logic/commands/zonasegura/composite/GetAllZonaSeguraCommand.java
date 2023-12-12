package com.ucab.cmcapp.logic.commands.zonasegura.composite;

import com.ucab.cmcapp.common.entities.ZonaSegura;
import com.ucab.cmcapp.logic.commands.Command;
import com.ucab.cmcapp.logic.commands.CommandFactory;
import com.ucab.cmcapp.logic.commands.zonasegura.atomic.GetAllZonaSeguraByUsuarioIdCommand;
import com.ucab.cmcapp.persistence.DBHandler;

import java.util.List;

public class GetAllZonaSeguraCommand extends Command<ZonaSegura> {

    private List<ZonaSegura> _ZonaSegura;
    private GetAllZonaSeguraByUsuarioIdCommand _getAllZonaSeguraListCommand;

    public GetAllZonaSeguraCommand() {
        setHandler(new DBHandler());
    }

    @Override
    public void execute() {
        try {
            _getAllZonaSeguraListCommand = CommandFactory.createGetAllZonaSeguraByUsuarioIdCommand(getHandler());
            _getAllZonaSeguraListCommand.execute();
            _ZonaSegura = _getAllZonaSeguraListCommand.getReturnParam();
        } catch (Exception e) {
            getHandler().rollbackTransaction();
            getHandler().closeSession();
            throw e;
        }
    }

    @Override
    public List<ZonaSegura> getReturnParam() {
        return _ZonaSegura;
    }

    @Override
    public void closeHandlerSession() {
        getHandler().closeSession();
    }

}
