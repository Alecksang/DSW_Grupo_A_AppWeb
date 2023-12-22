package com.ucab.cmcapp.logic.commands.admin.atomic;

import com.ucab.cmcapp.common.entities.Admin;
import com.ucab.cmcapp.logic.commands.Command;
import com.ucab.cmcapp.persistence.DBHandler;
import com.ucab.cmcapp.persistence.DaoFactory;
import com.ucab.cmcapp.persistence.dao.AdminDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GetAdminByUsernameCommand extends Command<Admin> {

    private Admin _Admin;
    private AdminDao _dao;

    private static Logger _logger = LoggerFactory.getLogger(AddAdminCommand.class);

    public GetAdminByUsernameCommand(Admin Admin) {

        _logger.debug(String.format("Tomar de GetAdminCommand.ctor: parameter {%s}",
                Admin.toString()));

        _Admin = Admin;
        setHandler(new DBHandler());
        _dao = DaoFactory.createAdminDao(getHandler());

        _logger.debug(String.format("Dejando de GetAdminCommand.ctor: parameter {%s}",
                Admin.toString()));
    }

    @Override
    public void execute() {

        _logger.debug("Tomando de  GetAdminCommand.execute");

        _Admin = _dao.getAdminByUsername(_Admin.get_username());

        _logger.debug("Dejando de  GetAdminCommand.execute");
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
