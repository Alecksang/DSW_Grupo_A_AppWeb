package com.ucab.cmcapp.logic.commands.victima.atomic;
import com.ucab.cmcapp.common.entities.Victima;
import com.ucab.cmcapp.logic.commands.Command;
import com.ucab.cmcapp.persistence.DBHandler;
import com.ucab.cmcapp.persistence.DaoFactory;
import com.ucab.cmcapp.persistence.dao.VictimaDao;
public class ModifyVictimaCommand extends Command<Victima> {

    private Victima _victima;
    private VictimaDao _dao;

    public ModifyVictimaCommand(Victima Usuario_Victima, DBHandler handler) {
        setHandler(handler);
        _victima = Usuario_Victima;
        _dao = DaoFactory.createVictimaDao(getHandler());
    }

    @Override
    public void execute() {
        _victima = _dao.update(_victima);
    }

    @Override
    public Victima getReturnParam() {
        return _victima;
    }

    @Override
    public void closeHandlerSession() {
        getHandler().closeSession();
    }
}