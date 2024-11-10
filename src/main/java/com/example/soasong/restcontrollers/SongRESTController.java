package com.example.soasong.restcontrollers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
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
    
    @RequestMapping(path="all", method = RequestMethod.GET)
    public List<Song> getAllSongs() {
        return songService.getAllSongs();
    }
    
    @RequestMapping(value="/getbyid/{id}",method = RequestMethod.GET)
    public Song getSongById(@PathVariable("id") Long id) {
        return songService.getSong(id);
    }
    
    @RequestMapping(path="/addsong",method = RequestMethod.POST)
    @PreAuthorize("hasAuthority('ADMIN')")
    public Song createSong(@RequestBody Song song) {
        return songService.saveSong(song);
    }
    
    // Added path variable version for more explicit updates
    @RequestMapping(value="/updatesong/{id}",method = RequestMethod.PUT)
    public Song updateSongWithId(@PathVariable("id") Long id, @RequestBody Song song) {
        song.setIdSong(id);  // Assuming setId exists
        return songService.updateSong(song);
    }
    
    // Modified to include null check like OeuvreRESTController
    @RequestMapping(path="/updatesong",method = RequestMethod.PUT)
    public Song updateSong(@RequestBody Song song) {
        if (song.getIdSong() == null) {  // Assuming getId exists
            throw new IllegalArgumentException("ID du song manquant");
        }
        return songService.updateSong(song);
    }
    
    @RequestMapping(value="/delsong/{id}",method = RequestMethod.DELETE)
    public void deleteSong(@PathVariable("id") Long id) {
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
