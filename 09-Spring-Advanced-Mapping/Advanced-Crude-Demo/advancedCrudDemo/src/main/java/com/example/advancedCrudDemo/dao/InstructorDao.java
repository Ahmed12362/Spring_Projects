package com.example.advancedCrudDemo.dao;

import com.example.advancedCrudDemo.entity.Course;
import com.example.advancedCrudDemo.entity.Instructor;
import com.example.advancedCrudDemo.entity.InstructorDetails;

import java.util.List;

public interface InstructorDao {
    void save(Instructor instructor);
    List<Instructor> getAllInstructor();
    Instructor getInstructorById(int id);
    void deleteInstructorById(int id);
    InstructorDetails findInstructorDetailsById(int id);
    void deleteInstructorDetailById(int id);
    List<Course> findCourseByInstructorId(int id);
    Instructor findInstructorByJoinFetch(int id);
    void updateInstructor(Instructor instructor);
    void deleteCourseById(int id);
    void save(Course course);
    Course getCourseById(int id);
    Course findCourseAndStudentById(int id);
}
