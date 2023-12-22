package com.ucab.cmcapp.logic.commands.admin.composite;

import com.ucab.cmcapp.common.entities.Admin;
import com.ucab.cmcapp.logic.commands.Command;
import com.ucab.cmcapp.logic.commands.CommandFactory;
import com.ucab.cmcapp.logic.commands.admin.atomic.GetAdminByListCommand;
import com.ucab.cmcapp.logic.commands.admin.composite.GetAdminCommand;
import com.ucab.cmcapp.persistence.DBHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class GetAllAdminCommand extends Command <Admin> {
    private static Logger _logger = LoggerFactory.getLogger(GetAdminCommand.class);
    private List<Admin> _Admin;

    public GetAllAdminCommand() {
        //region Instrumentation DEBUG

        setHandler(new DBHandler());

        //endregion
    }

    @Override
    public void execute() {

        _logger.debug("Entrando en GetAllAdminCommand.execute");

        try {
            GetAdminByListCommand getAdminByListCommand = CommandFactory.createGetAdminByListCommand(getHandler());
            getAdminByListCommand.execute();
            _Admin = getAdminByListCommand.getReturnParam();
        } catch (Exception e) {
            getHandler().rollbackTransaction();
            getHandler().closeSession();
            throw e;
        }

        _logger.debug("Dejando en GetAllAdminCommand.execute");
    }

    @Override
    public List <Admin> getReturnParam() {
        return _Admin;
    }

    @Override
    public void closeHandlerSession() {
        getHandler().closeSession();
    }
}
