package org.egitim.spring.model.service.base;

import org.egitim.spring.model.data.base.BaseEntity;
import org.egitim.spring.model.repository.base.IBaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

/**
 * IBaseService interface' inin implementasyonu. IBaseRepository' yi inject ederek repository' ye servis üzerinden erişiyoruz.
 * @param <T>
 */
@Service
public class BaseService<T extends BaseEntity> implements IBaseService<T> {

    @Autowired
    IBaseRepository iBaseRepository;

    @Override
    public List<T> getEntityList(String entityName) {
        return iBaseRepository.selectEntityList(entityName);
    }

    @Override
    public void printEntityList(Collection<T> entities) {
        System.out.println("KAYITLAR");
        for (BaseEntity entity : entities) {
            System.out.println(entity);
        }
    }
}
