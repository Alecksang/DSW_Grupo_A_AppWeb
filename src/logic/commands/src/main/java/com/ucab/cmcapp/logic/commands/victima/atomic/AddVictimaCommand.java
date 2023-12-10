package com.ucab.cmcapp.logic.commands.victima.atomic;
import com.ucab.cmcapp.common.entities.Victima;
import com.ucab.cmcapp.logic.commands.Command;
import com.ucab.cmcapp.persistence.DBHandler;
import com.ucab.cmcapp.persistence.DaoFactory;
import com.ucab.cmcapp.persistence.dao.VictimaDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
public class AddVictimaCommand extends Command<Victima> {
    private static Logger _logger = LoggerFactory.getLogger(AddVictimaCommand.class);
    private Victima _Victima;
    private VictimaDao _dao;
    public AddVictimaCommand(Victima usuario_Victima, DBHandler handler) {
        //region Instrumentation DEBUG
        _logger.debug(String.format("Get in AddVictimaCommand.ctor: parameter {%s}",
                usuario_Victima.toString()));
        setHandler(handler);
        _Victima = usuario_Victima;
        _dao = DaoFactory.createVictimaDao(getHandler());


        //region Instrumentation DEBUG
        _logger.debug(String.format("Leaving AddVictimaCommand.ctor: attribute {%s}",
                _Victima.toString()));
        //endregion
    }
    public AddVictimaCommand(Victima usuario_Victima) {
        //region Instrumentation DEBUG
        _logger.debug(String.format("Get in AddVictimaCommand.ctor: parameter {%s}",
                usuario_Victima.toString()));
        _Victima = usuario_Victima;
        setHandler(new DBHandler());
        _dao = DaoFactory.createVictimaDao(getHandler());


        //region Instrumentation DEBUG
        _logger.debug(String.format("Leaving AddUsuario_VictimaCommand.ctor: attribute {%s}",
                _Victima.toString()));
        //endregion
    }
    @Override
    public void execute() {
        //region Instrumentation DEBUG
        _logger.debug("Get in  AddUsuario_VictimaCommand.execute");
        //endregion

       _Victima = _dao.insert(_Victima);

        //region Instrumentation DEBUG
        _logger.debug("Get in  AddVictimaCommand.execute");
        //endregion
    }

    @Override
    public Victima getReturnParam() {
        return _Victima;
    }

    @Override
    public void closeHandlerSession() {
        getHandler().closeSession();
    }
}
