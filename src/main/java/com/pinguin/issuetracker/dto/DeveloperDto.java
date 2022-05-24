package com.pinguin.issuetracker.dto;

/**
 * @author Chakraborty, Ayan
 */
public class DeveloperDto {

	private long id;
	private String name;
	private Integer pointsPicked;

	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the pointsPicked
	 */
	public Integer getPointsPicked() {
		return pointsPicked;
	}

	/**
	 * @param pointsPicked the pointsPicked to set
	 */
	public void setPointsPicked(Integer pointsPicked) {
		this.pointsPicked = pointsPicked;
	}

}
