package com.example.springsocial.controller;

import com.example.springsocial.model.images;
import com.example.springsocial.repository.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.sql.Date;

@RestController
public class ImageController {

    @Autowired
    ImageRepository imageRepository;

    @PostMapping("/uploadFile")
    public ResponseEntity<String> handleFileUpload(@RequestParam("file")MultipartFile file){
        return ResponseEntity.ok().body("File received successfully");
    }

    @PostMapping("/uploadJson")
    public  ResponseEntity<String> handleJsonInput(@RequestBody images json){
        return ResponseEntity.ok().body(json.getId()+json.getFileName());
    }

    @PostMapping("/upload")
    public ResponseEntity<String> handleJsonAndMultipartInput(@RequestPart(value = "data", required = false) images upload, @RequestPart("file") MultipartFile file) throws IOException {
        byte[] imageBytes = file.getBytes();
        String fileName = file.getOriginalFilename();
        images upload1 = new images();
        upload1.setExtension(fileName.substring(fileName.lastIndexOf(".")+1));
        upload1.setFileName(fileName);
        upload1.setUserId(1L);
        upload1.setCreatedAt(new Date(2023,10,20));
        upload1.setImage(imageBytes);
        upload1.setItemId(upload.getId());
        imageRepository.save(upload1);
        return ResponseEntity.status(HttpStatus.CREATED).body("Document was uploaded successfully!!");
    }


}
