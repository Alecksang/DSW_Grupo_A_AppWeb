package com.ucab.cmcapp.persistence.dao;

import com.ucab.cmcapp.common.EntityFactory;
import com.ucab.cmcapp.common.entities.Conexion;
import com.ucab.cmcapp.common.entities.Usuario;
import com.ucab.cmcapp.common.exceptions.CupraException;
import com.ucab.cmcapp.persistence.DBHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;


public class ConexionDao extends BaseDao<Conexion> {
    private static Logger _logger = LoggerFactory.getLogger(ConexionDao.class);
    private EntityManager _em;
    private CriteriaBuilder _builder;


    public ConexionDao() {
        super();
    }

    public ConexionDao(DBHandler handler) {
        super(handler);

        _em = getDBHandler().getSession();
        _builder = _em.getCriteriaBuilder();
    }

    public List<Conexion> getAllConexionByUserId(Usuario userId) {
        List<Conexion> results;
        try {
            CriteriaQuery<Conexion> query = _builder.createQuery(Conexion.class);
            Root<Conexion> root = query.from(Conexion.class);

            query.select(root);
            query.where(_builder.equal(root.get("_usuario"), userId));

            results = _em.createQuery(query).getResultList();

            if (results.isEmpty()) // Retornar null en lugar de []
                return null;

        } catch (NoResultException e) {
            //return Collections.emptyList();  // En caso de que quieras retornar []
            return null;
        } catch (Exception e) {
            throw new CupraException(e.getMessage());
        }

        return results;
    }
}
