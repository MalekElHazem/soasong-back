package com.example.soasong.restcontrollers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.soasong.entities.Song;
import com.example.soasong.service.SongService;


@RestController
@RequestMapping("/api")
@CrossOrigin
public class SongRESTController {
	
	@Autowired
	SongService songService;
	
	@RequestMapping(method = RequestMethod.GET)
	public List<Song> getAllSongs() {
		return songService.getAllSongs();
	}
	
	@RequestMapping(value="/{id}",method = RequestMethod.GET)
	public Song getSongById(@PathVariable("id") Long id) {
		return songService.getSong(id);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public Song createSong(@RequestBody Song song) {
		return songService.saveSong(song);
	}
	
	@RequestMapping(method = RequestMethod.PUT)
	public Song updateSong(@RequestBody Song song) {
		return songService.updateSong(song);
	}
	
	@RequestMapping(value="/{id}",method = RequestMethod.DELETE)
	public void deleteSong(@PathVariable("id") Long id)
	{
		songService.deleteSongById(id);
	}
	
	@RequestMapping(value="/songen/{idGenre}",method = RequestMethod.GET)
	public List<Song> getSongsByGenreId(@PathVariable("idGenre") Long idGenre) {
		return songService.findByGenreIdGenre(idGenre);
	}
	
	@RequestMapping(value="/songsByName/{nom}",method = RequestMethod.GET)
	public List<Song> findByNomSongContains(@PathVariable("nom") String nom) {
		return songService.findByNomSongContains(nom);
	}
}
