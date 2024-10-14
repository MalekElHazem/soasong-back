package com.example.soasong.entities;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Genre {
	
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idGenre;
	private String nomGenre;
	@Column(name = "des_genre", length = 2000) 
	private String desGenre;
	
	
	@JsonIgnore
	@OneToMany(mappedBy = "genre")
	private List<Song> songs;
	
	
	public List<Song> getSongs() {
		return songs;
	}

	public void setSongs(List<Song> songs) {
		this.songs = songs;
	}

	public Genre(Long idGenre, String nomGenre, String desGenre) {
		super();
		this.idGenre = idGenre;
		this.nomGenre = nomGenre;
		this.desGenre = desGenre;
	}
	
	public Long getIdGenre() {
		return idGenre;
	}
	public void setIdGenre(Long idGenre) {
		this.idGenre = idGenre;
	}
	public String getNomGenre() {
		return nomGenre;
	}
	public void setNomGenre(String nomGenre) {
		this.nomGenre = nomGenre;
	}
	public String getDesGenre() {
		return desGenre;
	}
	public void setDesGenre(String desGenre) {
		this.desGenre = desGenre;
	}
	
	
	@Override
	public String toString() {
		return "Genre [idGenre=" + idGenre + ", nomGenre=" + nomGenre + ", desGenre=" + desGenre + "]";
	}
	
	
	
}
