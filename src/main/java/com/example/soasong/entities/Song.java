package com.example.soasong.entities;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Song {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idSong;
	
	private String nomSong;
	private String nomArtist;
	private Date releaseDate;
	
	@ManyToOne
	private Genre genre;
	
	
	public Genre getGenre() {
		return genre;
	}



	public void setGenre(Genre genre) {
		this.genre = genre;
	}



	public Song() {
		super();
	}
	
	
	public Song(String nomSong, String nomArtist, Date releaseDate) {
        this.nomSong = nomSong;
        this.nomArtist = nomArtist;
        this.releaseDate = releaseDate;
    }
	
	
	public Song(Long idSong, String nomSong, String nomArtist, Date releaseDate) {
		super();
		this.idSong = idSong;
		this.nomSong = nomSong;
		this.nomArtist = nomArtist;
		this.releaseDate = releaseDate;
	}



	public Long getIdSong() {
		return idSong;
	}
	public void setIdSong(Long idSong) {
		this.idSong = idSong;
	}
	public String getNomSong() {
		return nomSong;
	}
	public void setNomSong(String nomSong) {
		this.nomSong = nomSong;
	}
	public String getNomArtist() {
		return nomArtist;
	}
	public void setNomArtist(String nomArtist) {
		this.nomArtist = nomArtist;
	}
	public Date getReleaseDate() {
		return releaseDate;
	}
	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}



	@Override
	public String toString() {
		return "Song [idSong=" + idSong + ", nomSong=" + nomSong + ", nomArtist=" + nomArtist + ", releaseDate="
				+ releaseDate + "]";
	}
	

	
}
