package io.naztech.batch;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BatchService {
	@Autowired
	private BatchRepository repo;
	
	public List<Batch> listAll(){
		return repo.findAll();
	}
	
	public void save(Batch batch) {
		repo.save(batch);	
	}
	
	public Batch get(int id) {
		return repo.findById(id).get();
	}
	
	public void delete(int id) {
		repo.deleteById(id);
	}
}