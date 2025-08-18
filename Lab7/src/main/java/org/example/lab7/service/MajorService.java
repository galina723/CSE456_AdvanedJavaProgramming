package org.example.lab7.service;
import org.example.lab7.model.Major;
import org.example.lab7.repository.MajorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MajorService {
    @Autowired
    private MajorRepo mr;

    public void saveMajor(Major major){
        mr.save(major);
    }

    public List<Major> getMajorList(){
        return mr.findAll();
    }
}

