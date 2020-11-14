package br.com.labs.service;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
	
	public Author findById(Integer id) {
		Author author = authorRepository.listAuthorWithMusic("felipe@felipe.com");
		System.out.println(author.toString());
		return author;
	}
	
	public Author update(Integer id,Author author) {
		
		return authorRepository.findById(id).map(a -> {
			
			a.setEmail(author.getEmail());
			a.setName(author.getName());

			return a;
		}).orElseThrow();
	}
	
	public Page<Author> find(Pageable pageable){
		
		return authorRepository.findAll(pageable);
	}
}
