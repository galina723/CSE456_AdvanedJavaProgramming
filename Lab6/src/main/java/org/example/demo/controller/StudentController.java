package org.example.demo.controller;

import org.example.demo.config.initStudent;
import org.example.demo.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
//xử lý và trả về kết quả là 1 trang web html
//ứng với url sẽ có 1 hàm xử lý tương ứng
public class StudentController {

    //khởi tạo ds sinh viên
    private final initStudent is;

    @Autowired
    public StudentController(initStudent is) {
        this.is = is;
    }

    //hiển thị trang index
    @GetMapping("/")
    public String index() {
        return "index"; //index.html, không cần gõ .html vì đã khai báo suffix
    }

    //hiển thị danh sách sinh viên cho url localhost:8080/students
    @GetMapping("/student-list")
    public String showStudents(Model model) {
        /*
        sau khi xử lý sẽ trả về 1 trang html
        nếu kèm theo data thì bỏ trong obj Model (attributeName, attributeValue
        thymeleaf sẽ lấy data này thông qua attributeName
        attributeValue có thể là bất kì obj gì
         */
        List<Student> students = is.getStudents();
        model.addAttribute("std", students);
        return "student-list"; //chính là file student-list.html
    }

    @GetMapping("/student/edit/{id}")
    public String showEditStudent(@PathVariable("id") int id, Model model) {
        /* Các công việc cần làm:
        - Gửi kèm thông tin của sinh viên cần sửa
        - Trả về trang html có form
         */
        for (Student student : is.getStudents()) {
            if (student.getId() == id) {
                model.addAttribute("std", student);
            }
        }

        return "student-form"; //student-form.html
    }

//    @PostMapping("/student/edit/result")
//    public String saveStudent(@RequestParam("id") int id, @RequestParam("name") String name, @RequestParam("yob") int yob, @RequestParam("gpa") double gpa, Model model) {
//        /*
//        - Lấy thông tin từ form
//        - Hiển thị thông tin đó lên trang result
//         */
//
//        model.addAttribute("id", id);
//        model.addAttribute("name", name);
//        model.addAttribute("yob", yob);
//        model.addAttribute("gpa", gpa);
//
//        return "result";
//    }

    /* Khi xử lý form
    - sau khi xử lý và trả về trang html, nhưng url không đổi, vẫn là url của action form
    => nếu bấm f5 (refresh) thì sẽ gọi lại hàm xử lý lỗi này => lỗi resubmission form
    - trong trường hợp thêm mới data, với key tự động tăng thì sẽ bị duplicate dữ liệu
     */
    //phiên bản 2 sử dụng redirect để tránh lỗi
//    @PostMapping("/student/edit")
//    public String saveStudent(
//            @RequestParam("id") int id, @RequestParam("name") String name,
//            @RequestParam("yob") int yob, @RequestParam("gpa") double gpa, Model model,
//            RedirectAttributes redirectAttributes) {
//        /*
//        - Lấy thông tin từ form
//        - Hiển thị thông tin đó lên trang result
//         */
//        redirectAttributes.addFlashAttribute("msg", "Student updated successfully");
//        redirectAttributes.addFlashAttribute("id", id);
//        redirectAttributes.addFlashAttribute("name", name);
//        redirectAttributes.addFlashAttribute("yob", yob);
//        redirectAttributes.addFlashAttribute("gpa", gpa);
//
//        return "redirect:/student/edit/result"; //chuyển hướng url thành localhost:8080/student/edit/result.
//        //không phải là trang result.html nên phải có hàm xử lý url này
//
//    }

//    @GetMapping("student/edit/result")
//    public String showEditStudentResult(Model model) {
//        return "result"; //đây mới là trang result.html
//        //sẽ bị lỗi null vì không nhận được data từ model của bên Postmapping saveStudent
//        //xử lý bằng cách khi redirect bên saveStudent, gửi kèm thêm gói hàng RedirectAttribute. Nghĩa là trong hàm này
//        //có 2 loại dữ liệu:
//        // - model chính của nó
//        // - RedirectAttribute (redirectAt) được gửi kèm từ bên saveStudent
//    }

    //phiên bản 3
    @PostMapping("/student/edit")
    public String saveStudentt(
            @RequestParam("id") int id, @RequestParam("name") String name,
            @RequestParam("yob") int yob, @RequestParam("gpa") double gpa, Model model,
            RedirectAttributes redirectAttributes) {
        /*
        - Lấy thông tin từ form
        - Hiển thị thông tin đó lên trang result
         */
        redirectAttributes.addFlashAttribute("msg", "Student updated successfully");
        redirectAttributes.addFlashAttribute("pid", id);
        redirectAttributes.addFlashAttribute("pname", name);
        redirectAttributes.addFlashAttribute("pyob", yob);
        redirectAttributes.addFlashAttribute("pgpa", gpa);

        return "redirect:/student-list"; //chuyển hướng url thành localhost:8080/student/edit/result.
        //không phải là trang result.html nên phải có hàm xử lý url này

    }


}
