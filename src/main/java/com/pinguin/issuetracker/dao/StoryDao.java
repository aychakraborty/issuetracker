package com.pinguin.issuetracker.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pinguin.issuetracker.entity.Story;

/**
 * @author Chakraborty, Ayan
 */
@Repository
public interface StoryDao extends JpaRepository<Story, Long> {

}
