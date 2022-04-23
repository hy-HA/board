package com.care.file.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.care.file.service.FileService;

@Controller
public class FileController {
	@Autowired
	FileService fs;
	
	@RequestMapping("form")
	public String form() {
		return "uploadForm";
	}
   @PostMapping("upload")
   public String upload(MultipartHttpServletRequest mul) {
      String id = mul.getParameter("id");
      String name = mul.getParameter("name");
      
      MultipartFile file = mul.getFile("file");
      String originalName = file.getOriginalFilename();
      
      //System.out.println(id);
      //System.out.println(name);
      //System.out.println(originalName);
      
      fs.fileProcess(mul);
      
      return "redirect:form";
   }
   @GetMapping("views")
   public String views(Model model) {
	   fs.getImages(model);
	   return "result";
   }
   @GetMapping("download")
   public void download(@RequestParam String file,
		   			HttpServletResponse response) throws Exception {
	   response.addHeader("Content-disposition", 
			   	"attachment; fileName="+file);
	   File fi = new File(FileService.IMAGE_REPO+"/"+file);
	   FileInputStream in = new FileInputStream(fi);
	   FileCopyUtils.copy(in, response.getOutputStream());
	   in.close();
   }
}


