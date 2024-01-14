package com.ucab.cmcapp.persistence.dao;
//recordar agregar este import
//import com.ucab.cmcapp.common.entities.Posicion;
import com.ucab.cmcapp.common.entities.UserType;
import com.ucab.cmcapp.common.entities.Usuario;
import com.ucab.cmcapp.common.entities.ZonaSegura;
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

    public List<ZonaSegura> getZonaByVictimaId(Usuario _id) {
        List<ZonaSegura> results;
        try {
            CriteriaQuery<ZonaSegura> query = _builder.createQuery(ZonaSegura.class);
            Root<ZonaSegura> root = query.from(ZonaSegura.class);

            query.select(root);
            query.where(_builder.equal(root.get("_usuario"), _id));

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