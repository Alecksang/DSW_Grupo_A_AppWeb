package com.ucab.cmcapp.persistence.dao;


import com.ucab.cmcapp.common.EntityFactory;
import com.ucab.cmcapp.common.entities.*;
import com.ucab.cmcapp.common.exceptions.CupraException;
import com.ucab.cmcapp.persistence.DBHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;


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

    public List<Sentencia> getSentenciaByUsuarios(long id) {
        List<Sentencia> result = null;
        _logger.debug(String.format("Get in SentenciaDao.getSentenciaByUsuarios: parameters ", id));
        try {
            CriteriaQuery<Sentencia> criteriaQuery = _builder.createQuery(Sentencia.class);
            Root<Sentencia> root = criteriaQuery.from(Sentencia.class);

            Query query = _em.createQuery("FROM Sentencia WHERE _victima.id = :idUsuario", Sentencia.class);
            query.setParameter("idUsuario", id);

            result = query.getResultList();

        } catch (NoResultException e) {
            _logger.error(String.format("Error SentenciaDao.getSentenciaByUsuarios: No Result {%s}", e.getMessage()));
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
