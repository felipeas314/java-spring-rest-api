package br.com.labs.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.labs.model.Music;

public interface MusicRepository extends JpaRepository<Music, Integer> {

}
