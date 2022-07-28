package com.sang.school.schoolManagement.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sang.school.schoolManagement.domain.Cours;

public interface ICoursDao extends JpaRepository<Cours, Long> {

}
