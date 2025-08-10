package org.example.demo.controller;

import org.example.demo.config.initMajor;
import org.example.demo.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Iterator;
import java.util.List;

@Controller
public class MajorController {
    private final initMajor im;
    @Autowired
    public MajorController(initMajor im) {
        this.im = im;
    }

    @GetMapping("/major-list")
    public String showMajorList(Model model) {
        List<Major> majors = im.getMajors();
        model.addAttribute("mj", majors);
        return "major-list";
    }

    @GetMapping("/major/edit/{id}")
    public String showEditMajor(@PathVariable("id") int id, Model model) {
        for (Major major : im.getMajors()) {
            if (major.getId() == id) {
                model.addAttribute("mj", major);
            }
        }

        return "major-form";
    }

    @PostMapping("/major/edit")
    public String saveMajor(@ModelAttribute("major") Major major, RedirectAttributes redirectAttributes){
        for (Major s : im.getMajors()) {
            if (s.getId() == (major.getId())) {
                s.setName(major.getName());
                s.setCode(major.getCode());
                break;
            }
        }
        redirectAttributes.addFlashAttribute("pmsg", "Save major successfully");
        redirectAttributes.addFlashAttribute("pid", major.getId());
        redirectAttributes.addFlashAttribute("pname", major.getName());
        redirectAttributes.addFlashAttribute("pcode", major.getCode());
        return "redirect:/major-list";
    }

    @GetMapping("/major/delete/{id}")
    public String deleteMajor(@PathVariable("id") int id, RedirectAttributes redirectAttributes){
        Iterator<Major> iterator = im.getMajors().iterator();
        while (iterator.hasNext()) {
            Major major = iterator.next();
            if (major.getId() == id) {
                iterator.remove();
                redirectAttributes.addFlashAttribute("pmsg", "Delete major successfully");
                break;
            }
        }
        redirectAttributes.addFlashAttribute("pid", id);
        return "redirect:/major-list";
    }

    @GetMapping("/major/create")
    public String showCreateMajorForm(Model model) {
        model.addAttribute("mj", new Major());
        return "major-form-create";
    }

    @PostMapping("/major/create")
    public String createMajor(@ModelAttribute("major") Major major, RedirectAttributes redirectAttributes) {
        im.getMajors().add(major);
        redirectAttributes.addFlashAttribute("pmsg", "Create major successfully");
        redirectAttributes.addFlashAttribute("pid", major.getId());
        redirectAttributes.addFlashAttribute("pname", major.getName());
        redirectAttributes.addFlashAttribute("pcode", major.getCode());

        return "redirect:/major-list";
    }
}
