package org.example.services;

import org.example.entity.School;
import org.example.repositories.SchoolRepo;

import java.util.List;

public class SChoolService {
    public void createSchool(School school){
        SchoolRepo.saveSchool(school);
    }
    public void updateSchool(School school){
        SchoolRepo.updateSchool(school);
    }
    public void deleteSchool(School school){
        SchoolRepo.deleteSchool(school);
    }
    public School getSchoolById(String id){
        return SchoolRepo.findSchoolById(id);
    }
    public List<School> getAllSchools(){
        return SchoolRepo.findAll();
    }
}
