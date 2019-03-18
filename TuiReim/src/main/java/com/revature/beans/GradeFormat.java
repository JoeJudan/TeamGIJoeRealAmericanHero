package com.revature.beans;

public class GradeFormat {

	private int gradeId;
	private String eventtype;
	private String grade;
	private String decision;
	
	public int getGradeId() {
		return gradeId;
	}
	public void setGradeId(int gradeId) {
		this.gradeId = gradeId;
	}
	public String getEventtype() {
		return eventtype;
	}
	public void setEventtype(String eventtype) {
		this.eventtype = eventtype;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getDecision() {
		return decision;
	}
	public void setDecision(String decision) {
		this.decision = decision;
	}
	public GradeFormat() {
		super();
		// TODO Auto-generated constructor stub
	}
	public GradeFormat(int gradeId, String eventtype, String grade, String decision) {
		super();
		this.gradeId = gradeId;
		this.eventtype = eventtype;
		this.grade = grade;
		this.decision = decision;
	}
	
	
	
}
