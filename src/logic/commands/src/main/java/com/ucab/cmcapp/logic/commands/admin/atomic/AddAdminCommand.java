package com.ucab.cmcapp.logic.commands.admin.atomic;

import com.ucab.cmcapp.common.entities.Admin;
import com.ucab.cmcapp.logic.commands.Command;
import com.ucab.cmcapp.persistence.DBHandler;
import com.ucab.cmcapp.persistence.DaoFactory;
import com.ucab.cmcapp.persistence.dao.AdminDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AddAdminCommand extends Command<Admin> {
    private static Logger _logger = LoggerFactory.getLogger(AddAdminCommand.class);
    private Admin _Admin;
    private AdminDao _dao;

    public AddAdminCommand(Admin Admin, DBHandler handler) {
        //region Instrumentation DEBUG

        _logger.debug(String.format("Tomar de AddAdminCommand.ctor: parameter {%s}",
                Admin.toString()));
        setHandler(handler);
        _Admin = Admin;
        _dao = DaoFactory.createAdminDao(getHandler());


        //region Instrumentation DEBUG
        _logger.debug(String.format("Dejando AddAdminCommand.ctor: attribute {%s}",
                _Admin.toString()));
        //endregion
    }

    public AddAdminCommand(Admin Admin) {
        //region Instrumentation DEBUG
        _logger.debug(String.format("Tomando de AddAdminCommand.ctor: parameter {%s}",
                Admin.toString()));
        _Admin = Admin;
        setHandler(new DBHandler());
        _dao = DaoFactory.createAdminDao(getHandler());


        //region Instrumentation DEBUG
        _logger.debug(String.format("Dejando AddAdminCommand.ctor: attribute {%s}",
                _Admin.toString()));
        //endregion
    }

    @Override
    public void execute() {
        //region Instrumentation DEBUG
        _logger.debug("Tomando de  AddAdminCommand.execute");
        //endregion

        _Admin = _dao.insert(_Admin);

        //region Instrumentation DEBUG
        _logger.debug("Dejando de  AddAdminCommand.execute");
        //endregion
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
