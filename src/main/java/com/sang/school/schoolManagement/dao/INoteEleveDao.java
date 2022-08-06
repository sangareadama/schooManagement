package com.sang.school.schoolManagement.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sang.school.schoolManagement.domain.NoteEleve;

public interface INoteEleveDao extends JpaRepository<NoteEleve, Long> {

	List<NoteEleve> findByNoteId(Long id);

}
