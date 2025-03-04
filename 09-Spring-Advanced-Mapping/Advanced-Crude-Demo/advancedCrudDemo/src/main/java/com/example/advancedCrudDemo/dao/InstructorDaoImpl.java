package com.example.advancedCrudDemo.dao;

import com.example.advancedCrudDemo.entity.Course;
import com.example.advancedCrudDemo.entity.Instructor;
import com.example.advancedCrudDemo.entity.InstructorDetails;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Repository
public class InstructorDaoImpl implements InstructorDao{
    EntityManager entityManager;
    @Autowired
    InstructorDaoImpl(EntityManager entityManager){
        this.entityManager = entityManager;
    }
    @Override
    @Transactional
    public void save(Instructor instructor) {
        entityManager.persist(instructor);
    }

    @Override
    public List<Instructor> getAllInstructor() {
        var query = entityManager.createQuery("From Instructor" , Instructor.class);
        return query.getResultList();
    }

    @Override
    public Instructor getInstructorById(int id) {
        return entityManager.find(Instructor.class , id);
    }

    @Override
    @Transactional
    public void deleteInstructorById(int id) {
        Instructor instructor = entityManager.find(Instructor.class , id);
        List<Course> courseList = instructor.getCourseList();

        for(Course tempCourse: courseList){
            tempCourse.setInstructor(null);
        }
        entityManager.remove(instructor);
    }

    @Override
    public InstructorDetails findInstructorDetailsById(int id) {
        return entityManager.find(InstructorDetails.class , id);
    }

    @Override
    @Transactional
    public void deleteInstructorDetailById(int id) {
        InstructorDetails instructorDetails =findInstructorDetailsById(id);
        instructorDetails.getInstructor().setInstructorDetails(null);
        entityManager.remove(instructorDetails);
    }

    @Override
    public List<Course> findCourseByInstructorId(int id) {
        var query = entityManager.createQuery("from Course where instructor.id = :data" , Course.class);
        query.setParameter("data" , id);
        return query.getResultList();
    }

    @Override
    public Instructor findInstructorByJoinFetch(int id) {
        TypedQuery<Instructor> query = entityManager.createQuery(
                                            "select i from Instructor i "
                                                +"JOIN FETCH i.courseList "
                                                +"WHERE i.id = :data",Instructor.class);
        query.setParameter("data" , id);
        return query.getSingleResult();
    }

    @Override
    @Transactional
    public void updateInstructor(Instructor instructor) {
        entityManager.merge(instructor);
    }

    @Override
    @Transactional
    public void deleteCourseById(int id) {
        Course course = entityManager.find(Course.class , id);

        entityManager.remove(course);
    }

    @Override
    @Transactional
    public void save(Course course) {
        entityManager.persist(course);
    }

    @Override
    public Course getCourseById(int id) {
        TypedQuery<Course> query = entityManager.createQuery("SELECT c FROM Course c " +
                                                                "JOIN FETCH c.reviewList " +
                                                                "WHERE c.id= :data" , Course.class);
        query.setParameter("data" , id);
        return query.getSingleResult();
    }

    @Override
    public Course findCourseAndStudentById(int id) {
        TypedQuery<Course> query = entityManager.createQuery("SELECT c FROM Course c " +
                                                                "JOIN FETCH c.studentList " +
                                                                "WHERE c.id= :data" , Course.class);
        query.setParameter("data" , id);
        return query.getSingleResult();
    }
}