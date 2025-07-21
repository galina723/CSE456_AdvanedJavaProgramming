package org.example.infras;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class javaUtil {
    private static final EntityManagerFactory emf;
    static {
        try {
            emf = Persistence.createEntityManagerFactory("pu1-mysql-masterapp");
        } catch (Exception e) {
            System.out.println("Cannot connect to database.");
            throw new RuntimeException(e);
        }
    }
    private javaUtil() {}
    public static EntityManager getEntity() {
        return emf.createEntityManager();
    }
}
