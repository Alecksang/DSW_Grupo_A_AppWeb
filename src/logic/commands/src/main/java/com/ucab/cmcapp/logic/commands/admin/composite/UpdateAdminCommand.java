package com.ucab.cmcapp.logic.commands.admin.composite;

import com.ucab.cmcapp.common.entities.Admin;
import com.ucab.cmcapp.logic.commands.Command;
import com.ucab.cmcapp.logic.commands.CommandFactory;
import com.ucab.cmcapp.logic.commands.admin.atomic.ModifyAdminCommand;
import com.ucab.cmcapp.persistence.DBHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UpdateAdminCommand extends Command<Admin> {

    private Admin _Admin;
    private Admin _result;
    private ModifyAdminCommand _modifyAdminCommand;

    private static Logger _logger = LoggerFactory.getLogger(CreateAdminCommand.class);

    public UpdateAdminCommand(Admin Admin) {
        _Admin = Admin;
        setHandler(new DBHandler());
    }

    @Override
    public void execute() {

        _logger.debug("Entrando en UpdateAdminCommand.execute");

        try {
            getHandler().beginTransaction();
            _modifyAdminCommand = CommandFactory.createModifyAdminCommand(_Admin, getHandler());
            _modifyAdminCommand.execute();
            _result = _modifyAdminCommand.getReturnParam();
            getHandler().finishTransaction();
            getHandler().closeSession();
        } catch (Exception e) {
            getHandler().rollbackTransaction();
            getHandler().closeSession();
            throw e;
        }

        _logger.debug("Entrando en UpdateAdminCommand.execute");
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
