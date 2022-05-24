package com.pinguin.issuetracker.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotEmpty;

import com.pinguin.issuetracker.enums.Status;

/**
 * @author Chakraborty, Ayan
 */
@Entity
public class Story {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@SequenceGenerator(initialValue = 1, name = "Story")
	private long issueId;
	@NotEmpty(message = "Title is Mandatory")
	private String title;
	@NotEmpty(message = "Description is Mandatory")
	private String description;
	private LocalDate createDt;
	private String devName;
	private Integer estPointVal;
	@Enumerated(EnumType.STRING)
	private Status status;

	public Story() {

	}

	public Story(String title, String description, LocalDate createDt, Integer estPointVal, Status status) {
		this.title = title;
		this.description = description;
		this.createDt = createDt;
		this.estPointVal = estPointVal;
		this.status = status;
	}

	/**
	 * @return the issueId
	 */
	public long getIssueId() {
		return issueId;
	}

	/**
	 * @param issueId the issueId to set
	 */
	public void setIssueId(long issueId) {
		this.issueId = issueId;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the createDt
	 */
	public LocalDate getCreateDt() {
		return createDt;
	}

	/**
	 * @param createDt the createDt to set
	 */
	public void setCreateDt(LocalDate createDt) {
		this.createDt = createDt;
	}

	/**
	 * @return the devName
	 */
	public String getDevName() {
		return devName;
	}

	/**
	 * @param devName the devName to set
	 */
	public void setDevName(String devName) {
		this.devName = devName;
	}

	/**
	 * @return the estPointVal
	 */
	public Integer getEstPointVal() {
		return estPointVal;
	}

	/**
	 * @param estPointVal the estPointVal to set
	 */
	public void setEstPointVal(Integer estPointVal) {
		this.estPointVal = estPointVal;
	}

	/**
	 * @return the status
	 */
	public Status getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(Status status) {
		this.status = status;
	}

}
