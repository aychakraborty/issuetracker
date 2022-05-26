package com.pinguin.issuetracker.handler;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pinguin.issuetracker.dao.DeveloperDao;
import com.pinguin.issuetracker.entity.Developer;

/**
 * @author Chakraborty, Ayan
 */
@Service
public class DeveloperHandler {

	@Autowired
	DeveloperDao developerDao;

	public List<Developer> getListOfDevelopers() {
		return developerDao.findAll();
	}

	public Developer addDeveloper(Developer developer) {
		// Save new developer
		return developerDao.save(new Developer(developer.getName()));
	}

	public Developer updateDeveloper(long id, Developer developer) {
		Optional<Developer> devData = developerDao.findById(id);
		Developer existingDev = null;
		if (devData.isPresent()) {
			// Update existing developer
			existingDev = devData.get();
			existingDev.setName(developer.getName());
			developerDao.save(existingDev);
		} else {
			throw new RuntimeException("Developer Does Not Exist.");
		}
		return existingDev;
	}

	public void deleteDeveloper(long id) {
		Optional<Developer> dev = developerDao.findById(id);
		if (!dev.isPresent()) {
			throw new RuntimeException("Developer Does Not Exist.");
		}
		developerDao.deleteById(id);
	}

	public void deleteAllDevelopers() {
		developerDao.deleteAll();
	}
}
