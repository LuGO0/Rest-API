package com.project.restapi.repository;

import com.project.restapi.entities.Note;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotesRepository extends JpaRepository <Note, Long> {

}
