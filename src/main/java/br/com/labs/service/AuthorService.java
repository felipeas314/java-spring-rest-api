package br.com.labs.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.labs.model.Author;
import br.com.labs.repository.AuthorRepository;
import javassist.NotFoundException;

@Service
public class AuthorService {

	private AuthorRepository authorRepository;
	
	public AuthorService(AuthorRepository authorRepository) {
		this.authorRepository = authorRepository;
	}
	
	public Author save(Author author) {
		
		authorRepository.save(author);
		
		return author;
	}
	
	public Author findById(Integer id) {
		return authorRepository.findById(id).orElseThrow();
	}
	
	public Author update(Integer id,Author author) {
		
		return authorRepository.findById(id).map(a -> {
			
			a.setEmail(author.getEmail());
			a.setName(author.getName());

			return a;
		}).orElseThrow();
	}
}
