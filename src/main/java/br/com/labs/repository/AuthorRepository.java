package br.com.labs.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.labs.model.Author;

public interface AuthorRepository extends JpaRepository<Author, Integer> {

}
