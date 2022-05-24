package com.pinguin.issuetracker.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pinguin.issuetracker.entity.Developer;

/**
 * @author Chakraborty, Ayan
 */
@Repository
public interface DeveloperDao extends JpaRepository<Developer, Long> {

}
