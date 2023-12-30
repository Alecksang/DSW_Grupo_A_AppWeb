package com.ucab.cmcapp.persistence.dao;


import com.ucab.cmcapp.common.EntityFactory;
import com.ucab.cmcapp.common.entities.*;
import com.ucab.cmcapp.common.exceptions.CupraException;
import com.ucab.cmcapp.persistence.DBHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;


public class SentenciaDao extends BaseDao<Sentencia>
{
    private static Logger _logger = LoggerFactory.getLogger( SentenciaDao.class );
    private EntityManager _em;
    private CriteriaBuilder _builder;


    public SentenciaDao()
    {
        super();
    }

    public SentenciaDao( DBHandler handler )
    {
        super( handler );

        _em = getDBHandler().getSession();
        _builder = _em.getCriteriaBuilder();
    }

    public Sentencia getSentenciaByUsuarios(long Victima_id, long Agresor_id) {
        Sentencia result = EntityFactory.createSentencia();
        _logger.debug(String.format("Get in DistanciaAlejamientoDao.getDistanciaAlejamientoByUsuarios: parameters (Victima_id: %d, Agresor_id: %d)", Victima_id, Agresor_id));
        try {
            CriteriaQuery<Sentencia> query = _builder.createQuery(Sentencia.class);
            Root<Sentencia> root = query.from(Sentencia.class);

            query.select(root);
            query.where(_builder.and(
                    _builder.equal(root.get("_victima"), Victima_id),
                    _builder.equal(root.get("_agresor"), Agresor_id)
            ));

            result = _em.createQuery(query).getSingleResult();
        } catch (NoResultException e) {
            _logger.error(String.format("Error SentenciaDao.getDistanciaAlejamientoByUsuarios: No Result {%s}", e.getMessage()));
        } catch (Exception e) {
            _logger.error(String.format("Error SentenciaDao.getSentenciaByUsuarios: {%s}", e.getMessage()));
            throw new CupraException(e.getMessage());
        }
        //region Instrumentation
        _logger.debug(String.format("Leaving SentenciaDao.getSentenciaByUsuarios: result {%s}", result));
        //endregion

        return result;
    }


}
