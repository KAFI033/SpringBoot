package io.naztech.room;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoomService {
	@Autowired
	private RoomRepository repo;
	
	public List<Room> listAll(){
		return repo.findAll();
	}
	
	public void save(Room room) {
		repo.save(room);	
	}
	
	public Room get(int id) {
		return repo.findById(id).get();
	}
	
	public void delete(int id) {
		repo.deleteById(id);
	}
}
