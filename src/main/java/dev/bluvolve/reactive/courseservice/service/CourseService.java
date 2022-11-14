package dev.bluvolve.reactive.courseservice.service;


import dev.bluvolve.reactive.courseservice.repository.ICourseRepository;
import dev.bluvolve.reactive.courseservice.events.CourseCreated;
import dev.bluvolve.reactive.courseservice.entity.Course;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class CourseService {

    private final ICourseRepository courseRepository;

    private final ApplicationEventPublisher publisher;

    @Autowired
    public CourseService(ICourseRepository courseRepository, ApplicationEventPublisher publisher) {
        this.courseRepository = courseRepository;
        this.publisher = publisher;
    }

    public Course createCourse(Course course)  {
        Course savedCourse = this.courseRepository.save(course);
        this.publisher.publishEvent(new CourseCreated(savedCourse));
        return savedCourse;
    }

    public List<Course> getCourses() {
        return this.courseRepository.findAll();
    }
}
