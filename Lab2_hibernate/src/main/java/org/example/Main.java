package org.example;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.example.entity.Student;

import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory
            ("pu1-mysql-masterapp");

    public static void main(String[] args) {
        //insertStudent();
        //getStudentById();
        //getAllStudents();
        //getStudentByGpa();
        //updateGpaById();
        //updateYobById();
        //getStudentByConditions("man", 8.0);
        //removeStudent("CSE2025004");
    }

    //xóa 1 sinh viên (DML)
    public static void removeStudent(String id) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Student student = em.find(Student.class, id);
        em.remove(student);
        em.getTransaction().commit();
        em.close();
    }

    //cập nhật điểm dựa trên id (DML: phải có transaction)
    public static void updateGpaById() {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Student student = em.find(Student.class, "CSE2025001");
        student.setGpa(10.0); //cập nhật cho bạn levi 8.6 -> 10.0
        em.getTransaction().commit();
        em.close();
    }

    //cập nhật năm sinh dựa trên id (DML: phải có transaction)
    public static void updateYobById() {

        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Student student = em.find(Student.class, "CSE2025002");
        student.setYob(2003);
        em.getTransaction().commit();
        em.close();

    }

    //tìm kiếm sinh viên theo điều kiện được truyền vào (pName, pGpa)
    public static void getStudentByConditions(String Name, double Gpa) {
        EntityManager em = emf.createEntityManager();
        List<Student> student = em.createQuery("SELECT s from Student s WHERE s.name like :pName and s.gpa > :pGpa").setParameter("pName", "%" + Name + "%").setParameter("pGpa", Gpa).getResultList();
        System.out.println(student.size() + " students found");
        student.forEach(System.out::println);
        em.close();
    }

    //hàm tìm sinh viên dựa trên điều kiện gpa
    public static void getStudentByGpa() {
        EntityManager em = emf.createEntityManager();
        List<Student> student = em.createQuery("SELECT s from Student s WHERE s.gpa > 8.5", Student.class).getResultList();
        System.out.println(student.size() + " students found");
        student.forEach(System.out::println);
        em.close();
    }

    //hàm thực thi câu lệnh tìm 1 sinh viên thông qua mã sinh viên
    public static void getStudentById() {

        EntityManager em = emf.createEntityManager();
        Student std = em.find(Student.class, "CSE2025001");
        if (std != null) {
            System.out.println("Student found: " +  std.toString());
        } else {
            System.out.println("Student not found");
        }
    }

    public static void getAllStudents() {
        EntityManager em = emf.createEntityManager();
        /* khi viết truy vấn select thì có thể dùng các loại cú pháp sql sau:
           - sql thuần
           - sql dc chỉnh sửa bởi hibernate
           - jpql: lệnh truy vấn theo kiểu OOP
         */
        List<Student> stds = em.createQuery("select s from Student s", Student.class).getResultList();
        System.out.println("The list of all students found: " + stds.size());
        for (Student std : stds) {
            System.out.println(std.toString());
        }

    }

    //định nghĩa các hàm CRUD
    public static void insertStudent() {

        //1. Gọi người quản lý việc tương tác database
        EntityManager em = emf.createEntityManager();

        //2. Chuẩn bị database để insert
        Student st1 = new Student("CSE2025001", "Levi Ackerman", 2000, 8.6);
        Student st2 = new Student("CSE2025002", "Hana", 2001, 9.2);
        Student st3 = new Student("CSE2025003", "Janie", 1998, 8.1);
        Student st4 = new Student("CSE2025004", "James", 1999, 9.5);
        //3. Người quản lý thực hiện việc insert
        /*khi thực thi các câu lệnh sqp dạng DML (data manipulation language):
              làm thay đổi data thì bắt buộc phải đặt trong 1 transaction để đảm bảo
              tính ACID (atomy, consistency, isolation, durability)
              một là thực thi câu lệnh từ đầu đến cuối, còn ngược lại không
              làm gì cả, rollback */
        em.getTransaction().begin();
        //em.persist(st1); //ghi xuong database nhưng chưa thưc hiện ghi
        //em.persist(st2);
        //em.persist(st3);
        em.persist(st4);
        em.getTransaction().commit(); //đã ghi xuống database, không thành công thì hủy (rollback)
        em.close(); //cho anh quản lý nghỉ việc
    }
}