package com.ucab.cmcapp.persistence.dao;

import com.ucab.cmcapp.common.entities.Victima;
import com.ucab.cmcapp.persistence.DBHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
public class VictimaDao extends BaseDao<Victima> {
    private static Logger _logger = LoggerFactory.getLogger(VictimaDao.class);
    private EntityManager _em;
    private CriteriaBuilder _builder;


    public VictimaDao() {
        super();
    }

    public VictimaDao(DBHandler handler) {
        super(handler);

        _em = getDBHandler().getSession();
        _builder = _em.getCriteriaBuilder();
    }
}
