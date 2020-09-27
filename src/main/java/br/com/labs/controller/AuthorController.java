package br.com.labs.controller;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.labs.dto.ResponseDTO;
import br.com.labs.model.Author;
import br.com.labs.service.AuthorService;

@RestController
@RequestMapping("/authors")
public class AuthorController {

	private AuthorService authoService;

	public AuthorController(AuthorService authoService) {
		this.authoService = authoService;
	}

	@PostMapping
	public ResponseEntity<?> save(@RequestBody @Valid Author author){
		authoService.save(author);

		ResponseDTO<Author> response = new ResponseDTO<>(author,"201","Author adicionado com sucesso");
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(author.getId()).toUri();
		
		return ResponseEntity.created(location).body(response);
	}
	
	
}
