package com.pinguin.issuetracker.handler;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pinguin.issuetracker.dao.BugDao;
import com.pinguin.issuetracker.dao.DeveloperDao;
import com.pinguin.issuetracker.entity.Bug;
import com.pinguin.issuetracker.entity.Developer;
import com.pinguin.issuetracker.enums.Priority;
import com.pinguin.issuetracker.enums.Status;

/**
 * @author Chakraborty, Ayan
 */
@Service
public class BugHandler {

	@Autowired
	BugDao bugDao;

	@Autowired
	DeveloperDao developerDao;

	public Bug getBugByIssueId(long issueId) {
		Optional<Bug> bugData = bugDao.findById(issueId);
		if (bugData.isPresent()) {
			return bugData.get();
		}
		return null;
	}

	public List<Bug> getListOfBugs() {
		return bugDao.findAll();
	}

	public Bug addBug(Bug bug) {
		List<Developer> devList = developerDao.findAll();
		// Set Bug Create Date to Present Date
		bug.setCreateDt(LocalDate.now());
		// Check if Developers are present before assigning bug
		if (devList.isEmpty() && Objects.nonNull(bug.getDevName())) {
			throw new RuntimeException("No developers exist. Please add developers before assigning bugs.");
		}
		// Check if Developer's name is present in Developer table before assigning bug
		devList.forEach(dev -> {
			if (!dev.getName().equals(bug.getDevName())) {
				throw new RuntimeException("Developer Name Not Found.");
			}
		});
		// Set default priority & status
		if (Objects.nonNull(bug)) {
			if (Objects.isNull(bug.getPriority()))
				bug.setPriority(Priority.MINOR);
			if (Objects.isNull(bug.getStatus()))
				bug.setStatus(Status.NEW);
		}
		// Save bug
		return bugDao.save(new Bug(bug.getTitle(), bug.getDescription(), bug.getCreateDt(), bug.getDevName(),
				bug.getPriority(), bug.getStatus()));
	}

	public Bug updateBug(long issueId, Bug bug) {
		Optional<Bug> bugData = bugDao.findById(issueId);
		List<Developer> devList = developerDao.findAll();
		// Check if Developers are present before assigning bug
		if (devList.isEmpty() && Objects.nonNull(bug.getDevName())) {
			throw new RuntimeException("No developers exist. Please add developers before assigning bugs.");
		}
		// Check if Developer's name is present in Developer table before assigning bug
		devList.forEach(dev -> {
			if (!dev.getName().equals(bug.getDevName())) {
				throw new RuntimeException("Developer Name Not Found.");
			}
		});
		Bug existingBug = null;
		if (bugData.isPresent()) {
			existingBug = bugData.get();
			// Update existing bug with new data
			existingBug.setTitle(bug.getTitle());
			existingBug.setDescription(bug.getDescription());
			existingBug.setDevName(Objects.nonNull(bug.getDevName()) ? bug.getDevName() : existingBug.getDevName());
			existingBug.setCreateDt(Objects.nonNull(bug.getCreateDt()) ? bug.getCreateDt() : existingBug.getCreateDt());
			existingBug.setPriority(Objects.nonNull(bug.getCreateDt()) ? bug.getPriority() : existingBug.getPriority());
			existingBug.setStatus(Objects.nonNull(bug.getCreateDt()) ? bug.getStatus() : existingBug.getStatus());
			bugDao.save(existingBug);
		}
		return existingBug;
	}

	public void deleteBug(long issueId) {
		bugDao.deleteById(issueId);
	}

	public void deleteAllBugs() {
		bugDao.deleteAll();
	}

}
