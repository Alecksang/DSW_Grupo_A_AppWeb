package com.ucab.cmcapp.persistence.dao;


import com.ucab.cmcapp.common.entities.Sentencia_AV;
import com.ucab.cmcapp.persistence.DBHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;


public class Sentencia_AVDao extends BaseDao<Sentencia_AV> {
    private static Logger _logger = LoggerFactory.getLogger(Sentencia_AVDao.class);
    private EntityManager _em;
    private CriteriaBuilder _builder;


    public Sentencia_AVDao() {
        super();
    }

    public Sentencia_AVDao(DBHandler handler) {
        super(handler);

        _em = getDBHandler().getSession();
        _builder = _em.getCriteriaBuilder();
    }
}
