package com.ucab.cmcapp.persistence.dao;

import com.ucab.cmcapp.common.EntityFactory;
import com.ucab.cmcapp.common.entities.Admin;
import com.ucab.cmcapp.common.exceptions.CupraException;
import com.ucab.cmcapp.persistence.DBHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;


public class AdminDao extends BaseDao<Admin> {
    private static Logger _logger = LoggerFactory.getLogger(AdminDao.class);
    private EntityManager _em;
    private CriteriaBuilder _builder;


    public AdminDao() {
        super();
    }

    public AdminDao(DBHandler handler) {
        super(handler);

        _em = getDBHandler().getSession();
        _builder = _em.getCriteriaBuilder();
    }

    public Admin getAdminByCorreo(String correo) {
        Admin result = EntityFactory.createAdmin();
        _logger.debug(String.format("tomando de AdminDao.getUsuarioByCorreo: parametro {%s}", correo));
        try {
            CriteriaQuery<Admin> query = _builder.createQuery(Admin.class);
            Root<Admin> root = query.from(Admin.class);

            query.select(root);
            query.where(_builder.equal(root.get("_correo"), correo));

            result = _em.createQuery(query).getSingleResult();
        } catch (NoResultException e) {
            _logger.error(String.format("Error AdminDao.getUsuarioByCorreo: No Result {%s}", e.getMessage()));
            return null;
        } catch (Exception e) {
            _logger.error(String.format("Error AdminDao.getUsuarioByCorreo: {%s}", e.getMessage()));
            throw new CupraException(e.getMessage());
        }
        //region Instrumentation
        _logger.debug(String.format("Dejando AdminDao.getUsuarioByCorreo: result {%s}", result));
        //endregion

        return result;
    }

    public Admin getAdminByUsername(String username) {
        Admin result = EntityFactory.createAdmin();
        try {
            CriteriaQuery<Admin> query = _builder.createQuery(Admin.class);
            Root<Admin> root = query.from(Admin.class);

            query.select(root);
            query.where(_builder.equal(root.get("_username"), username));

            result = _em.createQuery(query).getSingleResult();
        } catch (NoResultException e) {
            return null;
        } catch (Exception e) {
            throw new CupraException(e.getMessage());
        }

        return result;
    }

}
