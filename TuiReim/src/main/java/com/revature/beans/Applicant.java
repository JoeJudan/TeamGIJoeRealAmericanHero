package com.revature.beans;

public class Applicant {
	
	int applicationId;
	String firstName;
	String lastName;
	String location;
	String description;
	double amount;
	String appDate;
    String eventType;
    String eventTime;
    String gradeFormat;
    String grade;
    int approvallevel;
	String status;
    String reason;
    int eidNumber;
    
    
	public int getApprovallevel() {
		return approvallevel;
	}


	public void setApprovallevel(int approvallevel) {
		this.approvallevel = approvallevel;
	}


    
    public String getGrade() {
		return grade;
	}


	public void setGrade(String grade) {
		this.grade = grade;
	}
  
    
	public int getEidNumber() {
		return eidNumber;
	}


	public void setEidNumber(int eidNumber) {
		this.eidNumber = eidNumber;
	}


	public Applicant() {
		super();
		// TODO Auto-generated constructor stub
	}


	public String getLocation() {
		return location;
	}


	public void setLocation(String location) {
		this.location = location;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public String getAppDate() {
		return appDate;
	}


	public void setAppDate(String appDate) {
		this.appDate = appDate;
	}


	

	public int getApplicationId() {
		return applicationId;
	}



	public void setApplicationId(int applicationId) {
		this.applicationId = applicationId;
	}



	public String getFirstName() {
		return firstName;
	}



	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}



	public String getLastName() {
		return lastName;
	}



	public void setLastName(String lastName) {
		this.lastName = lastName;
	}



	public double getAmount() {
		return amount;
	}



	public void setAmount(double amount) {
		this.amount = amount;
	}



	public String getEventType() {
		return eventType;
	}



	public void setEventType(String eventType) {
		this.eventType = eventType;
	}



	public String getEventTime() {
		return eventTime;
	}



	public void setEventTime(String eventTime) {
		this.eventTime = eventTime;
	}



	public String getGradeFormat() {
		return gradeFormat;
	}



	public void setGradeFormat(String gradeFormat) {
		this.gradeFormat = gradeFormat;
	}



	public String getStatus() {
		return status;
	}



	public void setStatus(String status) {
		this.status = status;
	}



	public String getReason() {
		return reason;
	}



	public void setReason(String reason) {
		this.reason = reason;
	}


	@Override
	public String toString() {
		return "Applicant [applicationId=" + applicationId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", location=" + location + ", description=" + description + ", amount=" + amount + ", appDate="
				+ appDate + ", eventType=" + eventType + ", eventTime=" + eventTime + ", gradeFormat=" + gradeFormat
				+ ", grade=" + grade + ", approvallevel=" + approvallevel + ", status=" + status + ", reason=" + reason
				+ ", eidNumber=" + eidNumber + "]";
	}

	public Applicant(String firstName, String lastName, String location, String description,
			double amount, String eventType, String eventTime, int eidNumber) {
		this(0, firstName, lastName, location, description, amount, "tbd", eventType, eventTime, "tbd", "awaiting_grade",  0, "pending",  "tbd", eidNumber);
	}//call this one
	
	public Applicant(int applicationId, String firstName, String lastName, String location, String description,
			double amount, String appDate, String eventType, String eventTime, String gradeFormat, String grade,
			int approvallevel, String status, String reason, int eidNumber) {
		super();
		this.applicationId = applicationId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.location = location;
		this.description = description;
		this.amount = amount;
		this.appDate = appDate;
		this.eventType = eventType;
		this.eventTime = eventTime;
		this.gradeFormat = gradeFormat;
		this.grade = grade;
		this.approvallevel = approvallevel;
		this.status = status;
		this.reason = reason;
		this.eidNumber = eidNumber;
	}




	
    
    
}
