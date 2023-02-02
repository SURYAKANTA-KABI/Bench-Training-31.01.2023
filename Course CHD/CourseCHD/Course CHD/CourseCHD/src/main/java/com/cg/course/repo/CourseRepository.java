package com.cg.course.repo;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.cg.course.entity.Course;

public interface CourseRepository extends MongoRepository<Course, Long>{



	void deleteById(Optional<Course> entity);


}
