package com.ucab.cmcapp.persistence.dao;

import com.ucab.cmcapp.common.entities.Agresor;

import com.ucab.cmcapp.persistence.DBHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;


public class AgresorDao extends BaseDao<Agresor> {
    private static Logger _logger = LoggerFactory.getLogger(AgresorDao.class);
    private EntityManager _em;
    private CriteriaBuilder _builder;


    public AgresorDao() {
        super();
    }

    public AgresorDao(DBHandler handler) {
        super(handler);

        _em = getDBHandler().getSession();
        _builder = _em.getCriteriaBuilder();
    }
}