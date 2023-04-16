package com.pratik.audiogram.services;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.pratik.audiogram.models.AudioFile;
import com.pratik.audiogram.models.AudioFileRepository;

import java.io.IOException;
import java.util.List;

@Service
public class AudioFileServiceImpl implements AudioFileService {

    @Autowired
    private AudioFileRepository audioFileRepository;

    @Override
    public AudioFile saveAudioFile(String title, String name, String description, MultipartFile file) throws IOException {
        AudioFile audioFile = new AudioFile(title, name, description, file.getBytes());
        return audioFileRepository.save(audioFile);
    }

    @Override
    public AudioFile getAudioFileById(Long id) {
        return audioFileRepository.findById(id).orElse(null);
    }

    @Override
    public List<AudioFile> getAllAudioFiles() {
        return audioFileRepository.findAll();
    }

    @Override
    public void deleteAudioFile(Long id) {
        audioFileRepository.deleteById(id);
    }

	@Override
	public AudioFile saveAudioFile(AudioFile audioFile) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<AudioFile> searchAudioFilesByDescription(String description) {
		// TODO Auto-generated method stub
		return null;
	}
}

