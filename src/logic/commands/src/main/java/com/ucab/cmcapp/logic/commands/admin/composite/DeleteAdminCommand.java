package com.ucab.cmcapp.logic.commands.admin.composite;

import com.ucab.cmcapp.common.entities.Admin;
import com.ucab.cmcapp.logic.commands.Command;
import com.ucab.cmcapp.logic.commands.CommandFactory;
import com.ucab.cmcapp.logic.commands.admin.atomic.EraseAdminCommand;
import com.ucab.cmcapp.persistence.DBHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DeleteAdminCommand extends Command<Admin> {

    private Admin _Administrador;
    private Admin _result;

    private static Logger _logger = LoggerFactory.getLogger(CreateAdminCommand.class);

    private EraseAdminCommand _eraseAdministradorCommand;

    public DeleteAdminCommand(Admin Administrador) {



        //region Instrumentation DEBUG
        _logger.debug("Entrando en DeleteAdminCommand.ctor");
        //endregion

        _Administrador = Administrador;
        setHandler(new DBHandler());
    }

    @Override
    public void execute() {

        _logger.debug("Entrando en DeleteAdminCommand.execute");

        try {
            getHandler().beginTransaction();
            _eraseAdministradorCommand = CommandFactory.createEraseAdminCommand(_Administrador, getHandler());
            _eraseAdministradorCommand.execute();
            _result = _eraseAdministradorCommand.getReturnParam();
            getHandler().finishTransaction();
            getHandler().closeSession();
        } catch (Exception e) {
            getHandler().rollbackTransaction();
            getHandler().closeSession();
            throw e;
        }

        _logger.debug("Dejando en DeleteAdministradorCommand.execute");
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
