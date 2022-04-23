package com.care.file.service;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.care.file.dto.FileDTO;
import com.care.file.mybatis.FileMapper;

@Service
public class FileServiceImpl implements FileService{
   @Autowired
   FileMapper fm;
   @Override
   public void fileProcess(MultipartHttpServletRequest mul) {
      FileDTO dto = new FileDTO();
      dto.setId(mul.getParameter("id"));
      dto.setName(mul.getParameter("name"));
      
      MultipartFile file = mul.getFile("file");
      if(!file.isEmpty()) {
         SimpleDateFormat format = 
            new SimpleDateFormat("yyyyMMddHHmmss-");
         Calendar calendar = Calendar.getInstance();
         String time = format.format(calendar.getTime());
         String sysFileName;
         sysFileName = time + file.getOriginalFilename();
         //20220423104110-test.jpg
         dto.setImageName(sysFileName);
         File saveFile = 
               new File(IMAGE_REPO+"/"+sysFileName);
         try {
            file.transferTo(saveFile);
         } catch (Exception e) {
            e.printStackTrace();
         }
      }
      else {
         dto.setImageName("nan");
      }
      fm.saveData(dto);
   }
   public void getImages(Model model) {
	   model.addAttribute("list", fm.getImages());
   }
}


	
	
