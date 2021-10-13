package org.egitim.spring.model.repository.base;

import org.egitim.spring.model.data.base.BaseEntity;
import org.egitim.spring.utility.HibernateUtility;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

/**
 * IBaseRepository implementasyonu
 */

@Repository
public class BaseRepository<T extends BaseEntity> implements IBaseRepository<T> {

    protected Session getSession() {
        return HibernateUtility.getSessionFactory().openSession();
    }

    @Override
    public List<T> selectEntityList(String entityName) {
        return getSession().createQuery("FROM " + entityName).list();
    }

}
