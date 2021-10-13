package org.egitim.spring.model.repository.base;

import org.egitim.spring.model.data.base.BaseEntity;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

/**
 * Repository üzerinde yapılacak işlemler için contract.
 * @param <T> BaseEntity' den kalıtım alan sınıflar için kullanılabilir
 */
@Repository
public interface IBaseRepository<T extends BaseEntity> {
    List<T> selectEntityList(String entityName);
}
