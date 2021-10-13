package org.egitim.spring.model.servi̇ce;

import org.springframework.stereotype.Service;

/**
 * işlemleri gerçekleştirecek facade sınıf için contract
 */
@Service
public interface IOrderServiceFacade {
    boolean placeOrder(int productId);
}
