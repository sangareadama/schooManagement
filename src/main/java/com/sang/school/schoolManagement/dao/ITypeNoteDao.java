package com.sang.school.schoolManagement.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sang.school.schoolManagement.domain.TypeNote;

public interface ITypeNoteDao extends JpaRepository<TypeNote, Long> {

}
