package com.care.file.service;

import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartHttpServletRequest;

public interface FileService {
	public String IMAGE_REPO = "c:/spring/image_repo";
	public void fileProcess(MultipartHttpServletRequest mul);
	public void getImages(Model model);

}
