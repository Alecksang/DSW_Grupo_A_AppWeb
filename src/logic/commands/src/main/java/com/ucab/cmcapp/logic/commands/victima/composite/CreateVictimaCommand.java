package com.ucab.cmcapp.logic.commands.victima.composite;
import com.ucab.cmcapp.common.entities.Victima;
import com.ucab.cmcapp.logic.commands.Command;
import com.ucab.cmcapp.logic.commands.CommandFactory;
import com.ucab.cmcapp.logic.commands.victima.atomic.AddVictimaCommand;
import com.ucab.cmcapp.persistence.DBHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
public class CreateVictimaCommand extends Command<Victima> {
    private static Logger _logger = LoggerFactory.getLogger(CreateVictimaCommand.class);
    private Victima _Victima;
    private Victima _result;
    private AddVictimaCommand _addVictimaCommand;

    public CreateVictimaCommand(Victima usuario_Victima) {
        //region Instrumentation DEBUG
        _logger.debug("Entering CreateVictimaCommand.ctor");
        //endregion

        _Victima = usuario_Victima;
        setHandler(new DBHandler());

        //region Instrumentation DEBUG
        _logger.debug("Leaving CreateVictimaCommand.ctor");
        //endregion
    }
    @Override
    public void execute() {
        //region Instrumentation DEBUG
        _logger.debug("Entering CreateUsuario_VictimaCommand.execute");
        //endregion

        try {
            getHandler().beginTransaction();
            _addVictimaCommand = CommandFactory.createAddVictimaCommand(_Victima, getHandler());
            _addVictimaCommand.execute();
            _result = _addVictimaCommand.getReturnParam();
            getHandler().finishTransaction();
            getHandler().closeSession();
        } catch (Exception e) {
            getHandler().rollbackTransaction();
            getHandler().closeSession();
            throw e;
        }
        //region Instrumentation DEBUG
        _logger.debug("Leaving CreateUsuario_VictimaCommand.execute");
        //endregion
    }

    @Override
    public Victima getReturnParam() {
        return _result;
    }

    @Override
    public void closeHandlerSession() {
        getHandler().closeSession();
    }
}
