package com.ucab.cmcapp.logic.commands.victima.atomic;
import com.ucab.cmcapp.common.entities.Victima;
import com.ucab.cmcapp.logic.commands.Command;
import com.ucab.cmcapp.persistence.DBHandler;
import com.ucab.cmcapp.persistence.DaoFactory;
import com.ucab.cmcapp.persistence.dao.VictimaDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GetVictimaByIdCommand extends Command<Victima> {
    private static Logger _logger = LoggerFactory.getLogger(GetVictimaByIdCommand.class);
    private long _victimaId;
    private Victima _result;
    private VictimaDao _dao;

    public GetVictimaByIdCommand(DBHandler handler, long userId) {
        //region Instrumentation DEBUG
        _logger.debug(String.format("Get in GetVictimaByIdCommand.ctor: parameter {%s}", userId));
        //endregion

        _victimaId = userId;
        setHandler(handler);
        _dao = DaoFactory.createVictimaDao(getHandler());

        //region Instrumentation DEBUG
        _logger.debug(String.format("Leaving GetVictimaByIdCommand.ctor: attribute {%s}", userId));
        //endregion
    }
    @Override
    public void execute() {
        //region Instrumentation DEBUG
        _logger.debug("Get in  GetUsuario_VictimaByIdCommand.execute");
        //endregion
        _result = _dao.find(_victimaId, Victima.class);
        //region Instrumentation DEBUG
        _logger.debug("Leaving  GetVictimaByIdCommand.execute");
        //endregion
    }
    @Override
    public  Victima getReturnParam() {
        return _result;
    }

    @Override
    public void closeHandlerSession() {
        getHandler().closeSession();
    }
}