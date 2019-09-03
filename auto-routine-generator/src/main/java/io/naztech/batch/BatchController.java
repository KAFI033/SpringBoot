package io.naztech.batch;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class BatchController {
	
	@Autowired
	private BatchService service;
	
	@RequestMapping("/batch")
	public String viewHomepage(Model model) {
		List<Batch> listBatch = service.listAll();
		model.addAttribute("listBatch",listBatch);
		return "batch";
	}
	
	@RequestMapping("/batch/new")
	public String showNewBatchInfo(Model model) {
		List<Batch> listBatch = service.listAll();
		model.addAttribute("listBatch",listBatch);
		Batch batch = new Batch();
		model.addAttribute("batch", batch);
		return "new_batch";
	}
	
	@RequestMapping(value = "/batch/save", method = RequestMethod.POST)
	public String saveBatchInfo(@ModelAttribute("batch") Batch batch) {
		service.save(batch);
		return "redirect:/";
	}
	
	@RequestMapping("/batch/edit/{id}")
	public ModelAndView editBatchInfo(@PathVariable(name = "id") int id) {
		ModelAndView mav = new ModelAndView("edit_batch");
		Batch batch = service.get(id);
		mav.addObject("batch",batch);
		
		return mav;
	}
	
	@RequestMapping(value = "/batch/update", method = RequestMethod.POST)
	public String updateBatchInfo(@ModelAttribute("batch") Batch batch) {
		service.save(batch);
		return "redirect:/";
	}
	
	@RequestMapping("/batch/delete/{id}")
	public String deleteBatchInfo(@PathVariable(name = "id") int id) {
		service.delete(id);
		return "redirect:/";
	}

}
