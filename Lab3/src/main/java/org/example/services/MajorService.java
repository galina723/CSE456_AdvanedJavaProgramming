package org.example.services;

import jakarta.persistence.EntityManager;
import org.example.entity.Major;
import org.example.infras.javaUtil;
import org.example.repositories.MajorRepo;

import java.util.List;

public class MajorService {
    public void createMajor(Major major){
        MajorRepo.saveMajor(major);
    }
    public void updateMajor(Major major){
        MajorRepo.updateMajor(major);
    }
    public void deleteMajor(Major major){MajorRepo.deleteMajor(major);}
    public Major getMajor(String id){
        return MajorRepo.findMajorById(id);
    }
    public List<Major> getAllMajors(){
        return MajorRepo.findAll();
    }
}
