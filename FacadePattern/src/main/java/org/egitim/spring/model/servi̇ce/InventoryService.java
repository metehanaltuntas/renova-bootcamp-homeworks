package org.egitim.spring.model.servi̇ce;

import org.egitim.spring.model.data.Product;
import org.springframework.stereotype.Service;

@Service
public class InventoryService {
    public boolean isAvailable(Product product){
        /* ürünün var olup olmadığının(o ana kullanılabilir olup olmadığını) kontrolü*/
        return true;
    }
}