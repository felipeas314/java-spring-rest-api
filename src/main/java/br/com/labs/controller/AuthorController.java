package br.com.labs.controller;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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

	private AuthorService authorService;

	public AuthorController(AuthorService authorService) {
		this.authorService = authorService;
	}

	@PostMapping
	public ResponseEntity<?> save(@RequestBody @Valid Author author) {
		authorService.save(author);

		ResponseDTO<Author> response = new ResponseDTO<>(author, "201", "Author adicionado com sucesso");

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(author.getId())
				.toUri();

		return ResponseEntity.created(location).body(response);
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> findById(@PathVariable(name = "id", required = true) Integer id) {
		
		Author author = authorService.findById(id);
		ResponseDTO<Author> response = new ResponseDTO<>(author,"200","OK");
		
		return ResponseEntity.ok(response);
	}

	@PutMapping("/{id}")
	public ResponseEntity<?> update(@PathVariable(name="id", required = true) Integer id,@RequestBody Author author){
		author = authorService.update(id, author);
	
		ResponseDTO<Author> response = new ResponseDTO<>(author,"200","Author update");
		
		return ResponseEntity.ok(response);
	}
}
