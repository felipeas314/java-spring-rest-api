package br.com.labs.controller;

import java.net.URI;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.labs.dto.ResponseDTO;
import br.com.labs.model.Music;
import br.com.labs.service.MusicService;

@RestController
@RequestMapping("/musics")
public class MusicController {

	private MusicService musicService;

	public MusicController(MusicService musicService) {
		this.musicService = musicService;
	}

	@PostMapping
	public ResponseEntity<?> create(@RequestBody Music music){
		musicService.create(music);
		
		ResponseDTO<Music> response = new ResponseDTO<>(music, "201", "Musica criada com sucesso");
		
		URI location = ServletUriComponentsBuilder.fromCurrentContextPath().path("/{id}").buildAndExpand(music.getId()).toUri();
		
		
		return ResponseEntity.created(location).body(response);
	}
}
