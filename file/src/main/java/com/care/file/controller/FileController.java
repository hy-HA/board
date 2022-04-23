package com.care.file.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

@Controller
public class FileController {
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
      
      System.out.println(id);
      System.out.println(name);
      System.out.println(originalName);
      
      return "redirect:form";
   }
}


