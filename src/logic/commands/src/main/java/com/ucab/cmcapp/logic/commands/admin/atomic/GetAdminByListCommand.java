package com.ucab.cmcapp.logic.commands.admin.atomic;

import com.ucab.cmcapp.common.entities.Admin;
import com.ucab.cmcapp.logic.commands.Command;
import com.ucab.cmcapp.persistence.DBHandler;
import com.ucab.cmcapp.persistence.DaoFactory;
import com.ucab.cmcapp.persistence.dao.AdminDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class GetAdminByListCommand extends Command<Admin> {

    private static Logger _logger = LoggerFactory.getLogger(GetAdminByIdCommand.class);

    private List<Admin> _result;
    private AdminDao _dao;

    public GetAdminByListCommand(DBHandler handler) {
        setHandler(handler);
        _dao = DaoFactory.createAdminDao(getHandler());
    }

    @Override
    public void execute() {
        //region Instrumentation DEBUG
        _logger.debug("Tomando de GetAdminByListCommand.execute");
        //endregion
        _result = _dao.findAll(Admin.class);
        //region Instrumentation DEBUG
        _logger.debug("Dejando GetAdminByListCommand.execute");
        //endregion
    }

    @Override
    public List <Admin> getReturnParam() {
        return _result;
    }

    @Override
    public void closeHandlerSession() {
        getHandler().closeSession();
    }
}
