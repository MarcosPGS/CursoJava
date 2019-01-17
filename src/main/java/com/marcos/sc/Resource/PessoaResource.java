
package com.marcos.sc.resource;

import com.google.zxing.WriterException;
import com.marcos.sc.entity.Pessoa;
import com.marcos.sc.exceptions.CPFDuplicadoException;
import com.marcos.sc.exceptions.ValidarCPFException;
import com.marcos.sc.negocio.service.PessoaService;
import com.marcos.sc.negocio.service.QRCodeGenerator;
import com.marcos.sc.repository.PessoaRepository;
import com.marcos.sc.util.ValidarCPF;

import org.omg.CORBA.OBJECT_NOT_EXIST;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

import static org.springframework.http.ResponseEntity.ok;

@CrossOrigin // serve para resolver o problema de domínio cruzado
@RestController // @RestController é uma versão especializada do controlador.
//Ele inclui as @Controller e @ResponseBody anotações e, como resultado, simplifica a implementação controlador:
@RequestMapping(value = "/api") // endpoint @RequestMapping - implementar o manipulador de URLs
public class PessoaResource {

	private static final String QR_CODE_IMAGE_PATH = "./MyQRCode.png";
	@Autowired // injeção de dependencia
	PessoaService pessoaService;

	@GetMapping("/pessoa") // endpoint
	public List<Pessoa> buscarPessoa() {
		return pessoaService.listarTodos();
	}

	@GetMapping("/pessoa/cpf/{cpf}") // endpoint
	public ResponseEntity<Pessoa> buscarCPF(@PathVariable String cpf) {
		Pessoa pessoaResultado = pessoaService.buscarCPF(cpf);
		if (pessoaResultado == null) {
			return ResponseEntity.ok(null);
		}
		return ResponseEntity.ok().body((pessoaResultado));
	}

	@GetMapping("/pessoa/ativo/{ativo}") // endpoint busca por pessoa ativa
	public ResponseEntity<Object> buscarPessoaAtiva(@PathVariable String ativo) {
		List<Pessoa> pessoaResultado = pessoaService.buscarAtivo(ativo);

		return ResponseEntity.ok(pessoaResultado);
	}

	@GetMapping("/pessoa/qrcode/{cpf}")
	public String buscarCPFQR(@RequestBody Pessoa pessoa) throws WriterException, IOException {
		String jsonText = pessoa.getCpf().toString();
		if(! ValidarCPF.cpfValido(pessoa.getCpf())) {			
			QRCodeGenerator.generateQRCodeImage(jsonText, 350, 350, QR_CODE_IMAGE_PATH);	
		}else {
			
		
		QRCodeGenerator.generateQRCodeImage(jsonText, 350, 350, QR_CODE_IMAGE_PATH);
		}
		return "QRCode Gerado com sucesso " + QR_CODE_IMAGE_PATH;
		

	}

	
	
	
	@GetMapping("/pessoa/buscacpf/{cpf}")
	public ResponseEntity<Object> consultarCpf(@PathVariable String cpf) {
		return pessoaService.consultarCpf(cpf);
	}

	@PostMapping("/pessoa")
	public ResponseEntity<Object> salvarPessoa(@RequestBody Pessoa pessoa) {

		try {
			return ResponseEntity.ok().body(pessoaService.salvarCompleto(pessoa));
		} catch (ValidarCPFException e) {
			return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
		} catch (CPFDuplicadoException e) {
			return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());

		}
	}

}
