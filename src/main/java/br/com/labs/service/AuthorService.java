package br.com.labs.service;

import org.springframework.stereotype.Service;

import br.com.labs.model.Author;
import br.com.labs.repository.AuthorRepository;

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
}
