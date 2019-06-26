package io.naztech.routine;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoutineService {
	@Autowired
	private RoutineRepository repo;
	
	public List<Routine> listAll(){
		return repo.findAll();
	}
	
	public void save(Routine routine) {
		repo.save(routine);	
	}
	
	public Routine get(int id) {
		return repo.findById(id).get();
	}
	
	public void delete(int id) {
		repo.deleteById(id);
	}
}
