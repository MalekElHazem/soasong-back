package com.example.soasong.service;

import java.io.IOException;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;
import com.example.soasong.entities.Image;
public interface ImageService {
	 Image uplaodImage(MultipartFile file) throws IOException;
	 Image getImageDetails(Long id) throws IOException;
	 ResponseEntity<byte[]> getImage(Long id) throws IOException;
	 void deleteImage(Long id) ;
	 
	 
	 
	 Image uplaodImageSong(MultipartFile file,Long idSong) throws IOException;
	 List<Image> getImagesParSong(Long songId);

}