package com.cg.course.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.course.entity.Course;
import com.cg.course.repo.CourseRepository;

@Service
public class CourseServiceImpl implements CourseService{
	
	@Autowired
	private CourseRepository courseRepo;
	//List<Course> list;
	
	public CourseServiceImpl() {
//		list = new ArrayList<>();
//		list.add(new Course(1, "Java", "Java OOPS"));
//		list.add(new Course(2, "Python", "Django"));
    }
	
	@Override
	public List<Course> getCourses(){
		return courseRepo.findAll();
	}

	@Override
	public Optional<Course> getCourse(long courseId) {
		
//		Course c = null;
//		for (Course course : list) {
//			if (course.getId() == courseId) {
//				c = course;
//				break;
//			}
//		}
		return courseRepo.findById(courseId);
	}

	@Override
	public Course addCourse(Course course) {
//		list.add(course);
		courseRepo.save(course);
		return course;
	}

	@Override
	public Course updateCourse(Course course) {
//		list.forEach(e ->{
//			if(e.getId() == course.getId()) {
//				e.setTitle(course.getTitle());
//				e.setDescription(course.getDescription());
//		
//			}
//		});
		courseRepo.save(course);
		return course;
	}

	@Override
	public void deleteCourse(long parseLong) {
		//list = this.list.stream().filter(e->e.getId()!=parseLong).collect(Collectors.toList());
		Optional<Course> entity = courseRepo.findById(parseLong);
		courseRepo.deleteById(entity);
	}
}
