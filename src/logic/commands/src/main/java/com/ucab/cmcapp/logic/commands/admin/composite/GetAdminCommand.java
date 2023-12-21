package com.ucab.cmcapp.logic.commands.admin.composite;

import com.ucab.cmcapp.common.entities.Admin;
import com.ucab.cmcapp.logic.commands.Command;
import com.ucab.cmcapp.logic.commands.CommandFactory;
import com.ucab.cmcapp.logic.commands.admin.atomic.GetAdminByIdCommand;
import com.ucab.cmcapp.persistence.DBHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GetAdminCommand extends Command<Admin> {
    private static Logger _logger = LoggerFactory.getLogger(GetAdminCommand.class);
    private Admin _Admin;
    long _id;

    public GetAdminCommand(Admin Admin) {
        //region Instrumentation DEBUG
        _logger.debug(String.format("Tomar de GetAdminCommand.ctor: parameter {%s}",
                Admin.toString()));
        _id = Admin.get_id();
        _Admin = Admin;
        setHandler(new DBHandler());

        //region Instrumentation DEBUG
        _logger.debug(String.format("Dejando GetAdminCommand.ctor: attribute {%s}",
                _Admin.toString()));
        //endregion
    }

    @Override
    public void execute() {

        _logger.debug("Entrando en GetAdminCommand.execute");

        try {
            GetAdminByIdCommand getAdminByIdCommand = CommandFactory.createGetAdminByIdCommand(getHandler(), _id);
            getAdminByIdCommand.execute();
            _Admin = getAdminByIdCommand.getReturnParam();
        } catch (Exception e) {
            getHandler().rollbackTransaction();
            getHandler().closeSession();
            throw e;
        }

        _logger.debug("Dejando el GetAdminCommand.execute");
    }

    @Override
    public Admin getReturnParam() {
        return _Admin;
    }

    @Override
    public void closeHandlerSession() {
        getHandler().closeSession();
    }
}
