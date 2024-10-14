package com.example.soasong.repos;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.example.soasong.entities.Genre;
import com.example.soasong.entities.Song;


@RepositoryRestResource(path = "rest")
public interface SongRepository extends JpaRepository<Song, Long> {
	
	List<Song> findByNomSong(String nom);
	List<Song> findByNomSongContains(String nom); 

	
	/*@Query("select s from Song s where s.nomSong like %?1 and s.nomArtist like %?2")
    List<Song> findByNomArtist(String nom, String artist);*/
	
	@Query("select s from Song s where s.nomSong like %:nom% and s.nomArtist like %:artist%")
	List<Song> findByNomArtist(@Param("nom") String nom, @Param("artist") String artist);

	@Query("select s from Song s where s.genre = ?1")
	List<Song> findByGenre (Genre genre);
	
	List<Song> findByGenreIdGenre(Long id);
	
	List<Song> findByOrderByNomSongAsc();
	
	@Query("select s from Song s order by s.nomSong ASC, s.nomArtist DESC")
	List<Song> trierSongsNomArtist();




}
