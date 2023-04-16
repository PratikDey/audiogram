package com.pratik.audiogram.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.pratik.audiogram.models.AudioFile;
import com.pratik.audiogram.services.AudioFileService;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/audio-files")
public class AudioFileController {

    @Autowired
    private AudioFileService audioFileService;

    @GetMapping
    public List<AudioFile> getAllAudioFiles() {
        return audioFileService.getAllAudioFiles();
    }

    @GetMapping("/{id}")
    public ResponseEntity<AudioFile> getAudioFileById(@PathVariable Long id) {
        AudioFile audioFile = audioFileService.getAudioFileById(id);
        if (audioFile != null) {
            return ResponseEntity.ok(audioFile);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/")
    public ResponseEntity<String> uploadAudioFile(@RequestParam("title") String title,@RequestParam("name") String name,
                                                   @RequestParam("description") String description,
                                                   @RequestParam("audioFile") MultipartFile audioFile) {
        try {
            audioFileService.saveAudioFile(title, name, description, audioFile);
            return ResponseEntity.ok().body("Audio file uploaded successfully!");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error uploading audio file");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAudioFileById(@PathVariable Long id) {
        audioFileService.deleteAudioFile(id);
        return ResponseEntity.noContent().build();
    }
}

