package com.example.advancedCrudDemo;

import com.example.advancedCrudDemo.dao.InstructorDao;
import com.example.advancedCrudDemo.entity.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class AdvancedCrudDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(AdvancedCrudDemoApplication.class, args);
	}
	@Bean
	CommandLineRunner commandLineRunner(InstructorDao dao){
		return runner->{
//			saveInstructor(dao);
//			System.out.println(getInstructors(dao));
//			System.out.println(	getInstructorById(1 , dao));
//			deleteInstructor(1,dao);
//			System.out.println(getInstructorDetailsById(1, dao));
//			deleteInstructorDetails(dao);
//			createInstructorWithCourse(dao);
//			getInstructorByJoinFetch(dao);
//			deleteCourse(dao);
//			saveCourse(dao);
//			getCourseByCourseId(dao);
//			saveCourseWithStudents(dao);
			getCourseAndStudents(dao);
		};
	}

	private void getCourseAndStudents(InstructorDao dao) {
		int id = 10;
		System.out.println("Getting Course #"+id);
		Course course= dao.findCourseAndStudentById(id);
		System.out.println("Course Name: "+course.getTitle());
		System.out.println("Students: "+course.getStudentList());
	}

	private void saveCourseWithStudents(InstructorDao dao) {
		System.out.println("Saving Students...");
		Course course = new Course("Pac Man Game");
		course.addStudent(new Student("Ahmed" , "Mohamed", "ahmed@gmal.com"));
		course.addStudent(new Student("Mohamed" , "Ali", "mohamed@gmal.com"));
		course.addStudent(new Student("Chad" , "paul", "Chad@love2code.com"));
		dao.save(course);
		System.out.println("Done");

	}

	private void getCourseByCourseId(InstructorDao dao) {
		int id = 10;
		System.out.println("Getting Course #"+id);
		System.out.println(dao.getCourseById(id));
	}

	private void saveCourse(InstructorDao dao) {
		System.out.println("Saving Course");
		Course course = new Course("PacMan Game");
		course.add(new Review("Great course...Loved It"));
		course.add(new Review("WOW that's awesome...Loved It"));
		course.add(new Review("Thanks!"));
		dao.save(course);
		System.out.println("Done");
	}

	private void deleteCourse(InstructorDao dao) {
		int id = 10;
		System.out.println("Deleting Course #"+id);
		dao.deleteCourseById(id);
		System.out.println("Done");
	}

	private void getInstructorByJoinFetch(InstructorDao dao) {
		System.out.println("Getting Instructor Using Join Fetch...");
		System.out.println("Instructor #2");
		Instructor instructor = dao.findInstructorByJoinFetch(2);
		System.out.println(instructor);
	}

	private void createInstructorWithCourse(InstructorDao dao) {
		System.out.println("Creating Instructor...");
		InstructorDetails details = new InstructorDetails(
				"http://www.youtube.com",
				"Reading!"
		);
		Instructor instructor = new Instructor(
				"Mohamed",
				"Ali",
				"mohamed@gmail.com"
		);
		instructor.setInstructorDetails(details);
		Course tempCourse1 = new Course("Spring Core");
		Course tempCourse2 = new Course("Spring Security");
		Course tempCourse3 = new Course("Spring MVC Thymeleaf");
		instructor.add(tempCourse1);
		instructor.add(tempCourse2);
		instructor.add(tempCourse3);
		System.out.println("Done!!");
		dao.save(instructor);
	}

	private void deleteInstructorDetails(InstructorDao dao) {
		System.out.println("Deleting Instructor Detail...");
		dao.deleteInstructorDetailById(3);
		System.out.println("Done!");
	}

	private InstructorDetails getInstructorDetailsById(int id , InstructorDao dao){
		System.out.println("Getting Instructor Details #"+id);
		System.out.println("Instructor: "+dao.findInstructorDetailsById(id).getInstructor());
		return dao.findInstructorDetailsById(id);
	}
	private void deleteInstructor(int i, InstructorDao dao) {
		System.out.println("Delete Instructor #"+i);
		dao.deleteInstructorById(i);
	}

	private Instructor getInstructorById(int i , InstructorDao dao) {
		System.out.println("Getting Instructor #"+i);
		Instructor tempInstructor = dao.getInstructorById(i);
		List<Course> courses= dao.findCourseByInstructorId(i);
		tempInstructor.setCourseList(courses);
		return tempInstructor;
	}

	private List<Instructor> getInstructors(InstructorDao dao) {
		System.out.println("Getting All Instructors...");
		List<Instructor> instructorList = dao.getAllInstructor();
		for(Instructor instructor : instructorList){
			instructor.setCourseList(dao.findCourseByInstructorId(instructor.getId()));
		}
		return instructorList;
	}

	private void saveInstructor(InstructorDao dao) {
		System.out.println("Waiting For Save...");
		Instructor instructor = new Instructor(
				"Mohamed" , "Ali" , "mohamed@gmail.com");
		InstructorDetails instructorDetails = new InstructorDetails(
				"http://www.luv2code.com/youtube",
				"Reading"
		);
		instructor.setInstructorDetails(instructorDetails);
		dao.save(instructor);
		System.out.println("Saving Success.");
	}
}