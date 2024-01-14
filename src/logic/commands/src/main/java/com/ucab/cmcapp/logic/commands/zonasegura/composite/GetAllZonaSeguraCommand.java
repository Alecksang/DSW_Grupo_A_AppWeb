package com.ucab.cmcapp.logic.commands.zonasegura.composite;

import com.ucab.cmcapp.common.entities.ZonaSegura;
import com.ucab.cmcapp.common.entities.ZonaSegura;
import com.ucab.cmcapp.logic.commands.Command;
import com.ucab.cmcapp.logic.commands.CommandFactory;
import com.ucab.cmcapp.logic.commands.zonasegura.atomic.GetZonaSeguraByListCommand;
import com.ucab.cmcapp.logic.commands.zonasegura.atomic.GetZonaSeguraByListCommand;
import com.ucab.cmcapp.persistence.DBHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class GetAllZonaSeguraCommand extends Command <ZonaSegura> {
    private static Logger _logger = LoggerFactory.getLogger(GetZonaSeguraCommand.class);
    private List<ZonaSegura> _Zona_Segura;

    public GetAllZonaSeguraCommand() {
        //region Instrumentation DEBUG

        setHandler(new DBHandler());

        //endregion
    }

    @Override
    public void execute() {
        try {
            GetZonaSeguraByListCommand getZonaSeguraByListCommand = CommandFactory.createGetZona_SeguraByListCommand(getHandler());
            getZonaSeguraByListCommand.execute();
            _Zona_Segura = getZonaSeguraByListCommand.getReturnParam();
        } catch (Exception e) {
            getHandler().rollbackTransaction();
            getHandler().closeSession();
            throw e;
        }
    }

    @Override
    public List <ZonaSegura> getReturnParam() {
        return _Zona_Segura;
    }

    @Override
    public void closeHandlerSession() {
        getHandler().closeSession();
    }
}