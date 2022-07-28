package com.sang.school.schoolManagement.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sang.school.schoolManagement.domain.Cycle;

public interface ICycleDao  extends JpaRepository<Cycle, Long>{

}
