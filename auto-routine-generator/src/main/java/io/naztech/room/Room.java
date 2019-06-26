package io.naztech.room;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="TM3_Room")
public class Room {
	
	@Id
	private int id;
	private int capacity;
	
	public Room() {
		
	}

	public int getId() {
		return id;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
}
	
	
	
