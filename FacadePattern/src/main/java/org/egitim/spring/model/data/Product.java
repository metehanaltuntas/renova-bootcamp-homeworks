package org.egitim.spring.model.data;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * ürün sınıfı. basit anlamda sadece id ve isim tutuyor ama proje içerisinde herhangi bir ürün kaydı tutulmadı
 */
@Component
@Scope("prototype")
public class Product {
    public int productId;
    public String name;

    public Product() {
    }

}