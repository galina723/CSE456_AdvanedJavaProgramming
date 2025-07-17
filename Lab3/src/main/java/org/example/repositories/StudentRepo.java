package org.example.repositories;

import jakarta.persistence.*;
import org.example.entity.Student;
import org.example.infras.javaUtil;

import java.util.List;

public class StudentRepo {

    public static void saveStudent(Student student) {
        EntityManager em = javaUtil.getEntityManager();
        em.getTransaction().begin();
        em.persist(student);
        em.getTransaction().commit();
        em.close();
    }
    public static void updateStudent(Student student) {
        EntityManager em = javaUtil.getEntityManager();
        em.getTransaction().begin();
        em.merge(student);
        em.getTransaction().commit();
        em.close();
    }
    public static void deleteStudent(Student student) {
        EntityManager em = javaUtil.getEntityManager();
        em.getTransaction().begin();
        Student managedStudent = em.find(Student.class, student.getStudentId());
        if (managedStudent != null) {
            em.remove(managedStudent);
        }
        em.getTransaction().commit();
        em.close();
    }
    public static Student findStudentById(int id) {
        EntityManager em = javaUtil.getEntityManager();
        return em.find(Student.class, id);
    }
    public static List<Student> findAll(){
        EntityManager em = javaUtil.getEntityManager();
        return em.createQuery("SELECT s FROM Student s", Student.class).getResultList();
    }

}
