package org.example.context;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class javaUtil {
    private static final EntityManagerFactory emf;
    static{
        try{
            emf = Persistence.createEntityManagerFactory("pu1-mysql-masterapp");
        }catch(Exception e){
            System.out.println("Cannot connect to db");
            throw new RuntimeException(e);
        }
    }

    public javaUtil(){};

    public static EntityManager getEntity(){
        return emf.createEntityManager();
    }
}
