package org.egitim.spring.model.service.base;

import org.egitim.spring.model.data.base.BaseEntity;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

/**
 * Repository' ye doğrudan erişim yerine service üzerinden erişim sağlanacak. Yapılacak işlemler için contract.
 * Print gibi işlemler repository' de yapılmasın diye buraya eklendi
 * @param <T>
 */
@Service
public interface IBaseService<T extends BaseEntity> {
    void printEntityList(Collection<T> entities);

    List<T> getEntityList(String entityName);
}
