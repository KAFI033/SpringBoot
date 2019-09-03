package io.naztech.batch;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="TM3_Batch")
public class Batch {
	@Id
	private int id;
	private String name;
	private int total_student;
	
	public Batch() {
		
	}
	
	
	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public int getTotal_student() {
		return total_student;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setTotal_student(int total_student) {
		this.total_student = total_student;
	}
	
	
	
	
	
	

}
