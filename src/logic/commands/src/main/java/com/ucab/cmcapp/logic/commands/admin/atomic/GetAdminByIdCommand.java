package com.ucab.cmcapp.logic.commands.admin.atomic;

import com.ucab.cmcapp.common.entities.Admin;
import com.ucab.cmcapp.logic.commands.Command;
import com.ucab.cmcapp.persistence.DBHandler;
import com.ucab.cmcapp.persistence.DaoFactory;
import com.ucab.cmcapp.persistence.dao.AdminDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GetAdminByIdCommand extends Command<Admin> {
    private static Logger _logger = LoggerFactory.getLogger(GetAdminByIdCommand.class);
    private long _adminId;
    private Admin _result;
    private AdminDao _dao;

    public GetAdminByIdCommand(DBHandler handler, long adminId) {
        //region Instrumentation DEBUG
        _logger.debug(String.format("Tomar de GetAdminByIdCommand.ctor: parameter {%s}", adminId));
        //endregion

        _adminId = adminId;
        setHandler(handler);
        _dao = DaoFactory.createAdminDao(getHandler());

        //region Instrumentation DEBUG
        _logger.debug(String.format("Dejando GetAdminByIdCommand.ctor: attribute {%s}", adminId));
        //endregion
    }

    @Override
    public void execute() {
        //region Instrumentation DEBUG
        _logger.debug("Tomando de  GetAdminByIdCommand.execute");
        //endregion
        _result = _dao.find(_adminId, Admin.class);
        //region Instrumentation DEBUG
        _logger.debug("Dejando GetAdminByIdCommand.execute");
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
