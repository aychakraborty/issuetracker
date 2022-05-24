package com.pinguin.issuetracker.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pinguin.issuetracker.entity.Bug;

/**
 * @author Chakraborty, Ayan
 */
@Repository
public interface BugDao extends JpaRepository<Bug, Long> {

}
