package org.example.repository;

import jakarta.persistence.EntityManager;
import org.example.context.javaUtil;
import org.example.entity.Customer;
import org.springframework.stereotype.Repository;

@Repository
public class CustomerRepo {
    public static void addCustomer(Customer cus){
        EntityManager em = javaUtil.getEntity();
        em.getTransaction().begin();
        em.persist(cus);
        em.getTransaction().commit();;
        em.close();
    }
}
