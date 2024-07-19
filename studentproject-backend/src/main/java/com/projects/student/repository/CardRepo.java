package com.projects.student.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projects.student.model.Card;



@Repository
public interface CardRepo extends JpaRepository<Card, Long>{

}
