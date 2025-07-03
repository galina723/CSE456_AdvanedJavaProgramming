package org.example;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.entity.Course;
import org.example.entity.Student;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws JsonProcessingException {

        //tao moi vai sinh vien
        Student std1 = new Student("STD-01", "Nana", "Adam", 2000, 9.3);
        Student std2 = new Student("STD-02", "Nam", "Nguyen", 1999, 8.8);
        Student std3 = new Student("STD-03", "Ada", "Wong", 2001, 10.0);

        //tao moi vai mon mon
        Course c1 = new Course("CSE456", "Advanced Java Programming", 4, 60);
        Course c2 = new Course();
        c2.setIdCourse("CSE442");
        c2.setName("Dotnet Programming");
        c2.setCredits(4);
        c2.setHours(60);

        //show hang
        System.out.println("The list of students: ");
//        System.out.println("Student 1: " + std1.toString());
//        System.out.println("Student 2: " + std2.toString());
//        System.out.println("Student 3: " + std3.toString());
//        System.out.println("The list of course: ");
//        System.out.println("Course 1: " + c1.toString());
//        System.out.println("Course 2: " + c2.toString());

        //object to json
        ObjectMapper mapper = new ObjectMapper();
        String jstd1 = mapper.writeValueAsString(std1);
        String jstd2 = mapper.writeValueAsString(std2);
        String jstd3 = mapper.writeValueAsString(std3);
        //System.out.println("Student 1 dang JSON: " + jstd1);

        //json to object
        String jsonToObj = """
                {"id":"STD-04","firstName":"Nan Nan","lastName":"Ada","yearOfBirth":2002,"gpa":9.9}
                """;
        Student std4 = mapper.readValue(jsonToObj, Student.class);
        System.out.println("Student 4 dang object: " + std4);

    }
}