package com.example.soasong.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.soasong.entities.Genre;
import com.example.soasong.entities.Song;
import com.example.soasong.repos.SongRepository;

@Service
public class SongServiceimpl implements SongService{
	
	@Autowired
    private SongRepository songRepository;

	@Override
	public Song saveSong(Song s) {
		return songRepository.save(s); 
	}

	@Override
	public Song updateSong(Song s) {
		return songRepository.save(s);
	}

	@Override
	public void deleteSong(Song s) {
		songRepository.delete(s);
		
	}

	@Override
	public void deleteSongById(Long id) {
		songRepository.deleteById(id);
		
	}

	@Override
	public Song getSong(Long id) {
		return songRepository.findById(id).get(); 
	}

	@Override
	public List<Song> getAllSongs() {
		return songRepository.findAll();
	}

	@Override
	public List<Song> findByNomSong(String nom) {
		return songRepository.findByNomSong(nom);
	}

	@Override
	public List<Song> findByNomSongContains(String nom) {
		return songRepository.findByNomSongContains(nom);
	}

	@Override
	public List<Song> findByNomArtist(String nom, Double prix) {
		return songRepository.findByNomArtist(nom, nom);
	}

	@Override
	public List<Song> findByGenre(Genre categorie) {
		return songRepository.findByGenre(categorie);
	}

	@Override
	public List<Song> findByGenreIdGenre(Long id) {
		return songRepository.findByGenreIdGenre(id);
	}

	@Override
	public List<Song> findByOrderByNomSongAsc() {
		return songRepository.findByOrderByNomSongAsc();
	}

	@Override
	public List<Song> trierSongsNomArtist() {
		return songRepository.trierSongsNomArtist();
	}

}
