package com.cg.course.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.cg.course.entity.Course;

@Service
public class CourseServiceImpl implements CourseService{
	
	List<Course> list;
	
	public CourseServiceImpl() {
		list = new ArrayList<>();
		list.add(new Course(1, "Java", "Java OOPS"));
		list.add(new Course(2, "Python", "Django"));
	}
	
	@Override
	public List<Course> getCourses(){
		return list;
	}

	@Override
	public Course getCourse(long courseId) {
		
		Course c = null;
		for (Course course : list) {
			if (course.getId() == courseId) {
				c = course;
				break;
			}
		}
		return c;
	}

	@Override
	public Course addCourse(Course course) {
		list.add(course);
		return course;
	}

	@Override
	public Course updateCourse(Course course) {
		list.forEach(e ->{
			if(e.getId() == course.getId()) {
				e.setTitle(course.getTitle());
				e.setDescription(course.getDescription());
		
			}
		});
		return course;
	}

	
}
