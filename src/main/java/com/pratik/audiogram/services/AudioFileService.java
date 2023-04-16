package com.pratik.audiogram.services;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.pratik.audiogram.models.AudioFile;


public interface AudioFileService {
    AudioFile saveAudioFile(AudioFile audioFile);
    AudioFile getAudioFileById(Long id);
    List<AudioFile> getAllAudioFiles();
    List<AudioFile> searchAudioFilesByDescription(String description);
	AudioFile saveAudioFile(String title, String name, String description, MultipartFile file) throws IOException;
	void deleteAudioFile(Long id);
}