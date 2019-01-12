package com.marcos.sc.resource;

import java.io.IOException;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.zxing.WriterException;
import com.marcos.sc.entity.Pessoa;
import com.marcos.sc.negocio.service.QRCodeGenerator;

@RestController
@RequestMapping(value="/qrcode")
public class QrCodeReource {
	
	private static final String QR_CODE_IMAGE_PATH = "./MyQRCode.png";
	
	@PostMapping
	public String geradorQRCode(@RequestBody Pessoa qrcode) {
		String jsonText = qrcode.toString();
		
		try {
			QRCodeGenerator.generateQRCodeImage(jsonText, 350, 350, QR_CODE_IMAGE_PATH);
		} catch (WriterException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "QRCode Gerado com sucesso " + QR_CODE_IMAGE_PATH;
	}

}
