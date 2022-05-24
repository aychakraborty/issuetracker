package com.pinguin.issuetracker.dto;

import java.util.List;

import com.pinguin.issuetracker.entity.Bug;
import com.pinguin.issuetracker.entity.Story;

/**
 * @author Chakraborty, Ayan
 */
public class PlanDto {

	private List<DeveloperDto> devList;
	private List<Story> plannedStoryList;
	private List<Story> backlogStoryList;
	private List<Story> completedStoryList;
	private List<Bug> bugList;

	/**
	 * @return the devList
	 */
	public List<DeveloperDto> getDevList() {
		return devList;
	}

	/**
	 * @param devList the devList to set
	 */
	public void setDevList(List<DeveloperDto> devList) {
		this.devList = devList;
	}

	/**
	 * @return the plannedStoryList
	 */
	public List<Story> getPlannedStoryList() {
		return plannedStoryList;
	}

	/**
	 * @param plannedStoryList the plannedStoryList to set
	 */
	public void setPlannedStoryList(List<Story> plannedStoryList) {
		this.plannedStoryList = plannedStoryList;
	}

	/**
	 * @return the backlogStoryList
	 */
	public List<Story> getBacklogStoryList() {
		return backlogStoryList;
	}

	/**
	 * @param backlogStoryList the backlogStoryList to set
	 */
	public void setBacklogStoryList(List<Story> backlogStoryList) {
		this.backlogStoryList = backlogStoryList;
	}

	/**
	 * @return the completedStoryList
	 */
	public List<Story> getCompletedStoryList() {
		return completedStoryList;
	}

	/**
	 * @param completedStoryList the completedStoryList to set
	 */
	public void setCompletedStoryList(List<Story> completedStoryList) {
		this.completedStoryList = completedStoryList;
	}

	/**
	 * @return the bugList
	 */
	public List<Bug> getBugList() {
		return bugList;
	}

	/**
	 * @param bugList the bugList to set
	 */
	public void setBugList(List<Bug> bugList) {
		this.bugList = bugList;
	}

}
