package com.ucab.cmcapp.logic.commands.admin.composite;

import com.ucab.cmcapp.common.entities.Admin;
import com.ucab.cmcapp.logic.commands.Command;
import com.ucab.cmcapp.logic.commands.CommandFactory;
import com.ucab.cmcapp.logic.commands.admin.atomic.AddAdminCommand;
import com.ucab.cmcapp.persistence.DBHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CreateAdminCommand extends Command<Admin> {
    private static Logger _logger = LoggerFactory.getLogger(CreateAdminCommand.class);
    private Admin _Admin;
    private Admin _result;
    private AddAdminCommand _addAdminCommand;

    public CreateAdminCommand(Admin Admin) {
        //region Instrumentation DEBUG
        _logger.debug("Entrando en CreateAdminCommand.ctor");
        //endregion

        _Admin = Admin;
        setHandler(new DBHandler());

        //region Instrumentation DEBUG
        _logger.debug("Dejando CreateAdminCommand.ctor");
        //endregion
    }

    @Override
    public void execute() {
        //region Instrumentation DEBUG
        _logger.debug("Entrando CreateAdminCommand.execute");
        //endregion

        try {
            getHandler().beginTransaction();
            _addAdminCommand = CommandFactory.createAddAdminCommand(_Admin, getHandler());
            _addAdminCommand.execute();
            _result = _addAdminCommand.getReturnParam();
            getHandler().finishTransaction();
            getHandler().closeSession();
        } catch (Exception e) {
            getHandler().rollbackTransaction();
            getHandler().closeSession();
            throw e;
        }
        //region Instrumentation DEBUG
        _logger.debug("Dejando de  CreateAdminCommand.execute");
        //endregion
    }

    @Override
    public Admin getReturnParam() {
        return _result;
    }

    @Override
    public void closeHandlerSession() {
        getHandler().closeSession();
    }
}
