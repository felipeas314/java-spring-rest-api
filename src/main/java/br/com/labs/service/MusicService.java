package br.com.labs.service;

import org.springframework.stereotype.Service;

import br.com.labs.model.Music;
import br.com.labs.repository.MusicRepository;

@Service
public class MusicService {

	private MusicRepository musicRepository;
	
	public MusicService(MusicRepository musicRepository) {
		this.musicRepository = musicRepository;
	}
	
	public Music create(Music music) {
		
		musicRepository.save(music);
		
		return music;
	}
}
