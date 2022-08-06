package com.sang.school.schoolManagement.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sang.school.schoolManagement.domain.Note;

public interface INoteDao extends JpaRepository<Note, Long> {
	 
	List<Note> findByEnseignantId(Long id);

}
