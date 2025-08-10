package org.example.demo.config;

import jakarta.annotation.PostConstruct;
import org.example.demo.entity.Major;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class initMajor {
    private List<Major> majors;
    @PostConstruct
    public void initMajor(){
        majors = new ArrayList<>();
        majors.add(new Major(1, "CIT", "Software Engineeing"));
        majors.add(new Major(2, "BUS", "Business Administrator"));
        majors.add(new Major(3, "NUR", "Nursing"));
    }
    public List<Major> getMajors(){
        return majors;
    }
    public void setMajors(List<Major> majors){
        this.majors = majors;
    }
}
