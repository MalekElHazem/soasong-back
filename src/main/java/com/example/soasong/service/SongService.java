package com.example.soasong.service;

import java.util.List;

import com.example.soasong.entities.Genre;
import com.example.soasong.entities.Song;

public interface SongService {
	Song saveSong(Song s);
	Song updateSong(Song s);
	void deleteSong(Song s);
	void deleteSongById(Long id);
	Song getSong(Long id);
	List<Song> getAllSongs();
	List<Song> findByNomSong(String nom);
	List<Song> findByNomSongContains(String nom);
	List<Song> findByNomArtist (String nom, Double prix);
	List<Song> findByGenre (Genre categorie);
	List<Song> findByGenreIdGenre(Long id);
	List<Song> findByOrderByNomSongAsc();
	List<Song> trierSongsNomArtist();

}
