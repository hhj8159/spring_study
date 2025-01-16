package com.hjham.club.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.hjham.club.entity.dto.AttachDto;
import com.hjham.club.service.S3Service;

import lombok.extern.log4j.Log4j2;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;


@RestController
@RequestMapping("/api/v1/file")
@Log4j2
public class FileController {
  @Autowired
  private S3Service s3Service;
  @Value("${aws.s3.region}")
  private String region;
  @Value("${aws.s3.bucket-name}")
  private String bucketName;

  @PostMapping("upload")
  public ResponseEntity<?> upload(@RequestParam("file") List<MultipartFile> files) {
    List<AttachDto> list = new ArrayList<>();    
    for(MultipartFile file : files){
      try {
        // Extract file details
        String origin = file.getOriginalFilename();
        String path = path();
        String uuid = UUID.randomUUID().toString();
        String ext = "";
        // if(origin == null) {
        //   continue;
        // }
        int idx = origin.lastIndexOf(".");
        if(idx > 0) {
          ext = origin.substring(idx+1);
        }

        String fileName = uuid + "." + ext;
        String key = "uploads/" + path + "/" + fileName; // Customize key structure if needed
        String mimeType = file.getContentType();
        byte[] content = file.getBytes();
  
        // Upload file to S3
  
        // s3 upload
        s3Service.uploadFile(key, content, mimeType);
  
        AttachDto dto = AttachDto.builder()
        .uuid(uuid)
        .origin(origin)
        .image(mimeType != null && mimeType.startsWith("iamge/"))
        .path(path)
        .size(file.getSize())
        .mime(mimeType)
        .fileName(fileName)
        .ext(ext)
        .url(String.format("https://%s.s3.%s.amazonaws.com/%s", bucketName, region, key))
        .build();
        list.add(dto);
        
      } catch (Exception e) {
        log.error(e.getMessage());
      }
    }
    // Return success response
    return ResponseEntity.ok().body(list); 
  }
  private String path() {
    return new SimpleDateFormat("yyyy/MM/dd").format(new Date());
  }

}
