package com.pratik.audiogram.models;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AudioFileRepository extends JpaRepository<AudioFile, Long> {

	 AudioFile findByName(String name);

	 List<AudioFile> findByDescriptionContaining(String description);
}

