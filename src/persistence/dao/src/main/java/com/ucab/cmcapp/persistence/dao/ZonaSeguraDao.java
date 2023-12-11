package com.ucab.cmcapp.persistence.dao;
//recordar agregar este import
//import com.ucab.cmcapp.common.entities.Posicion;
import com.ucab.cmcapp.common.entities.ZonaSegura;
import com.ucab.cmcapp.persistence.DBHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;


public class ZonaSeguraDao extends BaseDao<ZonaSegura>
{
    private static Logger _logger = LoggerFactory.getLogger( ZonaSeguraDao.class );
    private EntityManager _em;
    private CriteriaBuilder _builder;


    public ZonaSeguraDao()
    {
        super();
    }

    public ZonaSeguraDao(DBHandler handler )
    {
        super( handler );

        _em = getDBHandler().getSession();
        _builder = _em.getCriteriaBuilder();
    }

}