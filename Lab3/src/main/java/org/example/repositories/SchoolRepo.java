package org.example.repositories;

import jakarta.persistence.EntityManager;
import org.example.entity.School;
import org.example.infras.javaUtil;

import java.util.List;

public class SchoolRepo {
    public static void saveSchool(School school){
        EntityManager em = javaUtil.getEntity();
        em.getTransaction().begin();
        em.persist(school);
        em.getTransaction().commit();
        em.close();
    }
    public static void updateSchool(School school) {
        EntityManager em = javaUtil.getEntity();
        em.getTransaction().begin();
        em.merge(school);
        em.getTransaction().commit();
        em.close();
    }
    public static void deleteSchool(School school) {
        EntityManager em = javaUtil.getEntity();
        em.getTransaction().begin();
        School managedSchool = em.find(School.class, school.getSchoolId());
        if (managedSchool != null) {
            em.remove(managedSchool);
        }
        em.getTransaction().commit();
        em.close();
    }
    public static School findSchoolById(String id) {
        EntityManager em = javaUtil.getEntity();
        return em.find(School.class, id);
    }
    public static List<School> findAll(){
        EntityManager em = javaUtil.getEntity();
        return em.createQuery("SELECT s FROM School s", School.class).getResultList();
    }
}
