package com.marcos.sc.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.marcos.sc.component.Disco;

@CrossOrigin
@RestController
@RequestMapping(value="/api")
public class FotosResource {
	
	@Autowired
	private Disco disco;
	
	@PostMapping(value="/fotos")
	public void upload(@RequestParam MultipartFile foto) {
		disco.salvarFotos(foto);
	}

}
