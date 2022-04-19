package com.project.restapi.repository;

import com.project.restapi.entities.Note;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotesRepository extends JpaRepository <Note, Long> {

	/**
	 * Spring data Gives us JPA repository implementation
	 * Which delegates the commonly used queries implementation to hibernate.
	 * It handles all the session and transaction management for us.
	 *
	 * Spring data is an abstraction over Hibernate to access the DB
	 *
	 * NotesRepository -> JpaRepository -> PagingAndSortingRepository -> CrudRepository -> Repository
	 *
	 */
}
