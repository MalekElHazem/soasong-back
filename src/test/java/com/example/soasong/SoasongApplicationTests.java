package com.example.soasong;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.soasong.entities.Genre;
import com.example.soasong.entities.Song;
import com.example.soasong.repos.SongRepository;
import java.util.Date;
import java.util.List;

@SpringBootTest
class SoasongApplicationTests {

	@Autowired
	private SongRepository songRepository;
	@Test
	public void testCreateSong() {
		Song sng = new Song("The Art of Peer Pressure", "Kendrick Lamar", new Date());
		songRepository.save(sng);
	}

	@Test
    public void testFindSong() {
        Song s = songRepository.findById(1L).get();
        System.out.println(s);
    }
	
	@Test
    public void testUpdateSong() {
        Song s = songRepository.findById(1L).get();
        s.setNomArtist("Frank");
		songRepository.save(s);
		
        System.out.println(s);
    }
	
	@Test
    public void testDeleteSong() {
        songRepository.deleteById(1L);
    }
	
	@Test
    public void testFindAllSong() {
		List<Song> songs = songRepository.findAll();
        for (Song s:songs)
            System.out.println(s);
    }
	
	
	@Test
	public void testFindByNomProduit()
	{
		List<Song> songs = songRepository.findByNomSong("My Way");
		for (Song s : songs)
		{
			System.out.println(s);
		}
	}
	
	@Test
	public void testFindByNomProduitContains()
	{
		List<Song> songs = songRepository.findByNomSongContains("W");
		for (Song s : songs)
		{
			System.out.println(s);
		}
	}
	
	
	@Test
	public void testfindByNomArtist()
	{
		List<Song> songs = songRepository.findByNomArtist("My", "Frank");
		for (Song s : songs)
		{
			System.out.println(s);
		}
	}
	
	@Test
	public void testfindByGenre()
	{
		Genre gen = new Genre();
		gen.setIdGenre(1L);
		List<Song> songs = songRepository.findByGenre(gen);
		for (Song s : songs)
		{
			System.out.println(s);
		}
	}
	
	
	@Test
	public void testfindByCategorieIdCat()
	{
		List<Song> songs = songRepository.findByGenreIdGenre(2L);
		for (Song s : songs)
		{
			System.out.println(s);
		}
	}
	
	
	@Test
	public void testfindByOrderByNomSongAsc()
	{
		List<Song> songs = songRepository.findByOrderByNomSongAsc();
		for (Song s : songs)
		{
			System.out.println(s);
		}	
	}
	
	@Test
	public void testTrierProduitsNomsPrix()
	{
		List<Song> songs = songRepository.trierSongsNomArtist();
		for (Song s : songs)
		{
			System.out.println(s);
		}
	}
	
}
