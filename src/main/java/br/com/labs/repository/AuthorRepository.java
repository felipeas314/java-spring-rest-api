package br.com.labs.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.labs.model.Author;

public interface AuthorRepository extends JpaRepository<Author, Integer> {

	
	  @Query("select a from Author a left join fetch a.musics music where a.email = ?1")
	  Author listAuthorWithMusic(String email);
	  
	  @Query("select a from Author a")
	  Page<Author> findAllAuthors(Pageable pageable);
	 
}
