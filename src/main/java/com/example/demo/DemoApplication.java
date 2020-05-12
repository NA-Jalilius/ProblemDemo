package com.example.demo;

import com.example.demo.dao.ActionRepository;
import com.example.demo.entities.Action;
import com.example.demo.entities.Upload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDateTime;
import java.util.ArrayList;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

    @Autowired
    private ActionRepository actionRepository;

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Override
    public void run(String... args) {
        Upload upload = new Upload();
        upload.setFileName("NAME");
        upload.setFileSize(100L);
        upload.setFileType("TYPE");



        Action action = new Action();
        action.setLabelAction("SOME LABEL");
        action.setDateCreation(LocalDateTime.now());
        action.setUploads(new ArrayList<>(){{ add(upload); }});
        action.setIdAction(actionRepository.getNextValFromIdActionSeq());
        actionRepository.save(action);
    }

}
