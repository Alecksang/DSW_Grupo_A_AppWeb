package com.ucab.cmcapp.logic.commands.sentencia.atomic;

import com.ucab.cmcapp.common.entities.Sentencia;
import com.ucab.cmcapp.logic.commands.Command;
import com.ucab.cmcapp.persistence.DBHandler;
import com.ucab.cmcapp.persistence.DaoFactory;
import com.ucab.cmcapp.persistence.dao.SentenciaDao;

import java.util.List;

public class GetSentenciaByListCommand extends Command<Sentencia> {

    private List<Sentencia> _result;
    private SentenciaDao _dao;

    public GetSentenciaByListCommand(DBHandler handler) {
        //region Instrumentation DEBUG
        //endregion

        setHandler(handler);
        _dao = DaoFactory.createSentenciaDao(getHandler());

        //region Instrumentation DEBUG
        //endregion
    }

    @Override
    public void execute() {
        //region Instrumentation DEBUG
        //endregion
        try {
            _result = _dao.findAll(Sentencia.class);
        }catch(NullPointerException e){

        }
        //region Instrumentation DEBUG
        //endregion
    }

    @Override
    public List <Sentencia> getReturnParam() {
        return _result;
    }

    @Override
    public void closeHandlerSession() {
        getHandler().closeSession();
    }

    public void setDao(SentenciaDao relacionVADao) {

    }
}
