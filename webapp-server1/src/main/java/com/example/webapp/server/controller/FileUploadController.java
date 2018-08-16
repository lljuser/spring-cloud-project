package com.example.webapp.server.controller;

import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Controller
@RequestMapping(value = "/file")
public class FileUploadController {

    @RequestMapping(value = "/upload")
    public @ResponseBody String upload(@RequestParam(value = "file",required = true)MultipartFile file){
        byte[] bytes= new byte[0];
        try {
            bytes = file.getBytes();
            File fileToSave=new File(file.getOriginalFilename());
            FileCopyUtils.copy(bytes,fileToSave);
            return fileToSave.getAbsolutePath();
        } catch (IOException e) {
            e.printStackTrace();
            return "upload fail!";
        }


    }
}
