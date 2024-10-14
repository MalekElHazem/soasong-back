package com.example.soasong.entities;


import org.springframework.data.rest.core.config.Projection;

@Projection(name = "nomSong", types = { Song.class })
public interface SongProjection {
	public String getNomSong();
}
