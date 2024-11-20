package com.example.soasong.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.soasong.entities.Image;

public interface ImageRepository extends JpaRepository<Image , Long> {
}