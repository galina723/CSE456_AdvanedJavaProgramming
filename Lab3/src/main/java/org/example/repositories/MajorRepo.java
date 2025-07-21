package org.example.repositories;

import jakarta.persistence.EntityManager;
import org.example.entity.Major;
import org.example.infras.javaUtil;

import java.util.List;

public class MajorRepo {

    public static void saveMajor(Major major){
        EntityManager em = javaUtil.getEntity();
        em.getTransaction().begin();
        em.persist(major);
        em.getTransaction().commit();
        em.close();
    }

    public static void updateMajor(Major major) {
        EntityManager em = javaUtil.getEntity();
        em.getTransaction().begin();
        em.merge(major);
        em.getTransaction().commit();
        em.close();
    }
    public static void deleteMajor(Major major) {
        EntityManager em = javaUtil.getEntity();
        em.getTransaction().begin();
        Major managedMajor = em.find(Major.class, major.getMajorId());
        if (managedMajor != null) {
            em.remove(managedMajor);
        }
        em.getTransaction().commit();
        em.close();
    }
    public static Major findMajorById(String id) {
        EntityManager em = javaUtil.getEntity();
        return em.find(Major.class, id);
    }
    public static List<Major> findAll(){
        EntityManager em = javaUtil.getEntity();
        return em.createQuery("SELECT s FROM Major s", Major.class).getResultList();
    }
}
