package com.sang.school.schoolManagement.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sang.school.schoolManagement.domain.Genre;

public interface IGenreDao extends JpaRepository<Genre, Long>{

}
