package com.ucab.cmcapp.logic.commands.conexion.atomic;

import com.ucab.cmcapp.common.entities.Conexion;
import com.ucab.cmcapp.logic.commands.Command;
import com.ucab.cmcapp.persistence.DBHandler;
import com.ucab.cmcapp.persistence.DaoFactory;
import com.ucab.cmcapp.persistence.dao.ConexionDao;

public class EraseConexionCommand extends Command<Conexion> {

    private Conexion _Historico_Usuario;
    private ConexionDao _dao;

    public EraseConexionCommand(Conexion Historico_Usuario, DBHandler handler) {
        setHandler(handler);
        _Historico_Usuario = Historico_Usuario;
        _dao = DaoFactory.createConexionDao(getHandler());
    }

    @Override
    public void execute() {
        try {
            _Historico_Usuario = _dao.delete(_Historico_Usuario);
        }catch(NullPointerException e){

        }
    }

    @Override
    public Conexion getReturnParam() {
        return _Historico_Usuario;
    }

    @Override
    public void closeHandlerSession() {
        getHandler().closeSession();
    }

    public void setConexion(Conexion result) {

    }

    public void setConexionDao(ConexionDao historicoUsuarioDao) {
    }
}
