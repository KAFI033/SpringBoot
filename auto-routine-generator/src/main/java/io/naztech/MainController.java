package io.naztech;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import io.naztech.batch.Batch;
import io.naztech.batch.BatchController;
import io.naztech.batch.BatchService;
import io.naztech.course.Course;
import io.naztech.course.CourseService;
import io.naztech.room.Room;
import io.naztech.room.RoomService;
import io.naztech.routine.Routine;
import io.naztech.routine.RoutineService;
import io.naztech.teacher.Teacher;
import io.naztech.teacher.TeacherService;

@Controller
public class MainController {

	@Autowired
	private BatchService batchService;
	@Autowired
	private CourseService courseService;
	@Autowired
	private TeacherService teacherService;
	@Autowired
	private RoomService roomService;
	@Autowired
	private RoutineService routineService;

	@RequestMapping("/")
	public String mainView() {
		return "index";
	}

	@RequestMapping(value = { "/addRoutine" }, method = RequestMethod.GET)
	public String getAll(Model model) {
		List<Batch> listBatch = batchService.listAll();
		model.addAttribute("listBatch", listBatch);
		List<Course> listCourse = courseService.listAll();
		model.addAttribute("listCourse", listCourse);
		List<Teacher> listTeacher = teacherService.listAll();
		model.addAttribute("listTeacher", listTeacher);
		Routine routine = new Routine();
		model.addAttribute("routine", routine);

		return "addRoutine";

	}
	
	@RequestMapping(value= {"/generateRoutine"}, method = RequestMethod.GET)
	public String generateRoutine(Model model) {
	/*
	* List<Batch> listBatch = batchService.listAll();
	* model.addAttribute("listBatch",listBatch); List<Course> listCourse =
	* courseService.listAll(); model.addAttribute("listCourse",listCourse);
	* List<Teacher> listTeacher = teacherService.listAll();
	* model.addAttribute("listTeacher",listTeacher); Routine routine = new
	* Routine(); model.addAttribute("routine",routine);
	*/

	List<Routine> listRoutine = routineService.listAll();
	model.addAttribute("listRoutine",listRoutine);

	return "generateRoutine";

	}
	

	// public void


	int temp=1;
	@RequestMapping(value = { "/save" }, method = RequestMethod.POST)
	public String saveRoutineInfo(@ModelAttribute("routine") Routine routine) {

		List<Batch> listBatch = batchService.listAll();
		List<Course> listCourse = courseService.listAll();
		List<Teacher> listTeacher = teacherService.listAll();
		List<Routine> listRoutine = routineService.listAll();
		List<Room> listRoom = roomService.listAll();
		
		for (int i = temp; i < 8; i++) {
			
			for (int j = 1; j < 6; j++) {

				for (int k = 1; k < 4; k++) {
					
					if(k==3) {
						 temp = temp+1;
					}
					
					String tmp;
					tmp = "" + i + j + k;
					routine.setCombination(tmp);
					routine.setDay(i);
					routine.setRoom(j);
					routine.setPeriod(k);
					boolean condition1 = coursePerBatch(listRoutine, routine);
					boolean condition2 = classPerTeacher(listRoutine, routine);
					boolean condition3 = roomCheck(listBatch, listRoom, routine);
					
					if (condition1 && condition2 && condition3 == true) {
						
						routineService.save(routine);
						return "redirect:/";
					}
					
					
				}
			}
		}


		return "/error";
	}
	

	// works for weekClass/batch also
	private boolean coursePerBatch(List<Routine> listRoutine, Routine string) {
		int count = 0;
		int count2 = 0;
		for (Routine list : listRoutine) {
			if (list.getBatchName() == string.getBatchName()) {
				count++;
			}
			if (list.getBatchName() == string.getBatchName() && list.getCourseName() == string.getCourseName()) {
				count2++;
			}

		}

		if (count < 2 && count2 == 0) {
			return true;
		}
		return false;
	}

	// works for class/day/batch also
	private boolean classPerTeacher(List<Routine> listRoutine, Routine routine) {

		for (Routine list : listRoutine) {
			if (list.getCombination().charAt(0) == routine.getCombination().charAt(0)) {
				if(list.getCombination().charAt(1) == routine.getCombination().charAt(1)) {
					if(list.getCombination().charAt(2) == routine.getCombination().charAt(2)) {
						return false;
					}
				}
				
			}
//			if (list.getCombination().charAt(1) == routine.getCombination().charAt(1)) {
//				return false;
//			}
//			if (list.getCombination().charAt(2) == routine.getCombination().charAt(2)) {
//				return false;
//			}
		}
		return true;
	}

	// room cpacity checking
	private boolean roomCheck(List<Batch> batch, List<Room> room, Routine routine) {
		int batchStudent = 0;
		int roomCapacity = 0;
		for (Batch b : batch) {
			if (routine.getBatchName() == b.getName()) {
				batchStudent = b.getTotal_student();
			}
		}
		for (Room r : room) {
			if (routine.getRoom() == r.getId()) {
				roomCapacity = r.getCapacity();
			}
		}
		if (batchStudent < roomCapacity) {
			return true;
		}

		return false;
	}

}
