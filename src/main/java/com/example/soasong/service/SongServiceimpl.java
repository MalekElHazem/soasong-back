package com.example.soasong.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import com.example.soasong.entities.Genre;
import com.example.soasong.entities.Song;
import com.example.soasong.repos.ImageRepository;
import com.example.soasong.repos.SongRepository;

@Service
public class SongServiceimpl implements SongService{
	
	@Autowired
    private SongRepository songRepository;
	
	@Autowired
	ImageRepository imageRepository;

	//@PreAuthorize("hasAuthority('ADMIN')")
	@Override
	public Song saveSong(Song s) {
		return songRepository.save(s); 
	}
/*
	@Override	
	public Song updateSong(Song s) {
		return songRepository.save(s);
	}*/

	@Override
	public Song updateSong(Song s) {
		//Long oldSongImageId = this.getSong(s.getIdSong()).getImage().getIdImage();
		//Long newSongImageId = s.getImage().getIdImage();
		Song prodUpdated = songRepository.save(s);
		//if (oldSongImageId != newSongImageId) //si l'image a été modifiée
			//imageRepository.deleteById(oldSongImageId);
			return prodUpdated;
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
