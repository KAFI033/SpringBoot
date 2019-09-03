package io.naztech.routine;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="TM3_Routine")
public class Routine {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private int day;
	private String batchName;
	private String courseName;
	private String teacherName;
	private int period;
	private int room;
	private String combination;
	
	public Routine() {
		
	}

	public int getId() {
		return id;
	}

	public int getDay() {
		return day;
	}

	public String getBatchName() {
		return batchName;
	}

	public String getCourseName() {
		return courseName;
	}

	public String getTeacherName() {
		return teacherName;
	}

	public int getPeriod() {
		return period;
	}

	public int getRoom() {
		return room;
	}

	public String getCombination() {
		return combination;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setDay(int day) {
		this.day = day;
	}

	public void setBatchName(String batchName) {
		this.batchName = batchName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}

	public void setPeriod(int period) {
		this.period = period;
	}

	public void setRoom(int room) {
		this.room = room;
	}

	public void setCombination(String combination) {
		this.combination = combination;
	}

	@Override
	public String toString() {
		return "Routine [id=" + id + ", day=" + day + ", batchName=" + batchName + ", courseName=" + courseName
				+ ", teacherName=" + teacherName + ", period=" + period + ", room=" + room + ", combination="
				+ combination + "]";
	}
	
	

	
	
	
	
	
	

}

	
