package org.zf.web.rpc;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.zf.web.bean.XMLSimple;
import org.zf.web.bean.XmlSonClass;

@Controller
@RequestMapping(value="/ui")
public class UiTestController {
	@RequestMapping(value="/views_index")
	public String skipToViewsIndex(){
		System.out.println("views_index==============================views_index");
		return "index";
		
	}
	@RequestMapping(value="/upload")
	public String uploadFile(MultipartFile file){
		System.out.println("upload==============================upload");
		try {
			FileUtils.writeByteArrayToFile(new File("d:/upload/"+file.getOriginalFilename()) , file.getBytes());
		return "ok";
		} catch (IOException e) {
			e.printStackTrace();
			return "index";
		}
		
		
	}


}
