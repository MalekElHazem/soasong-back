package com.example.soasong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import com.example.soasong.entities.Genre;
import com.example.soasong.entities.Song;

@SpringBootApplication
public class SoasongApplication implements CommandLineRunner {
   
   @Autowired
   private RepositoryRestConfiguration repositoryRestConfiguration;
   
   public SoasongApplication() {
   }

   public static void main(String[] args) {
      SpringApplication.run(SoasongApplication.class, args);
   }

   public void run(String... args) throws Exception {
      this.repositoryRestConfiguration.exposeIdsFor(new Class[]{Song.class, Genre.class});
   }
}