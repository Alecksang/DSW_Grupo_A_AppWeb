package com.ucab.cmcapp.logic.commands.admin.atomic;

import com.ucab.cmcapp.common.entities.Admin;
import com.ucab.cmcapp.logic.commands.Command;
import com.ucab.cmcapp.persistence.DBHandler;
import com.ucab.cmcapp.persistence.DaoFactory;
import com.ucab.cmcapp.persistence.dao.AdminDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ModifyAdminCommand extends Command<Admin> {

    private Admin _Admin;
    private AdminDao _dao;

    private static Logger _logger = LoggerFactory.getLogger(AddAdminCommand.class);

    public ModifyAdminCommand(Admin Admin, DBHandler handler) {
        setHandler(handler);
        _Admin = Admin;
        _dao = DaoFactory.createAdminDao(getHandler());
    }

    @Override
    public void execute() {
        _Admin = _dao.update(_Admin);
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
