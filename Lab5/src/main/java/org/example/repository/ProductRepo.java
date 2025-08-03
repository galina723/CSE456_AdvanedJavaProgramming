package org.example.repository;

import jakarta.persistence.EntityManager;
import org.example.context.javaUtil;
import org.example.entity.Product;
import org.springframework.stereotype.Repository;

@Repository
public class ProductRepo {
    public static void addProduct(Product prod){
        EntityManager em = javaUtil.getEntity();
        em.getTransaction().begin();
        em.persist(prod);
        em.getTransaction().commit();;
        em.close();
    }
}