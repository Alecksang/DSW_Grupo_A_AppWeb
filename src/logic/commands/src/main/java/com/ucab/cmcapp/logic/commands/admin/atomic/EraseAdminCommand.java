package com.ucab.cmcapp.logic.commands.admin.atomic;

import com.ucab.cmcapp.common.entities.Admin;
import com.ucab.cmcapp.logic.commands.Command;
import com.ucab.cmcapp.persistence.DBHandler;
import com.ucab.cmcapp.persistence.DaoFactory;
import com.ucab.cmcapp.persistence.dao.AdminDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EraseAdminCommand extends Command<Admin> {

    private Admin _Administrador;
    private AdminDao _dao;

    private static Logger _logger = LoggerFactory.getLogger(AddAdminCommand.class);

    public EraseAdminCommand(Admin Administrador, DBHandler handler) {

        _logger.debug(String.format("Tomar de EraseAdminCommand.ctor: parameter {%s}",
                Administrador.toString()));

        setHandler(handler);
        _Administrador = Administrador;
        _dao = DaoFactory.createAdminDao(getHandler());

        _logger.debug(String.format("Dejando EraseAdminCommand.ctor: attribute {%s}",
                _Administrador.toString()));
    }

    @Override
    public void execute() {

        _logger.debug("Tomando de  EraseAdminCommand.execute");

        _Administrador = _dao.delete(_Administrador);

        _logger.debug("Dejando de  EraseAdminCommand.execute");
    }

    @Override
    public Admin getReturnParam() {
        return _Administrador;
    }

    @Override
    public void closeHandlerSession() {
        getHandler().closeSession();
    }

}
