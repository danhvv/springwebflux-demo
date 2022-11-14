package dev.bluvolve.reactive.courseservice.controller;

import dev.bluvolve.reactive.courseservice.entity.Course;
import dev.bluvolve.reactive.courseservice.events.CourseCreated;
import dev.bluvolve.reactive.courseservice.processors.CourseCreatedEventProcessor;
import dev.bluvolve.reactive.courseservice.service.CourseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;

import java.net.URI;
import java.util.List;
import java.util.UUID;

@RestController
@Slf4j
public class CourseController {
    private final CourseService courseService;
    private final Flux<CourseCreated> events;

    public CourseController(CourseService courseService,
                            CourseCreatedEventProcessor processor) {

        this.courseService = courseService;
        this.events = Flux.create(processor).share();
    }

    @CrossOrigin
    @PostMapping("/course")
    ResponseEntity<UUID> addCourse(@RequestBody Course course){
        log.info("Create new course request received. [title: {}]", course.getTitle());
        try{
            this.courseService.createCourse(course);
            return ResponseEntity.created(URI.create("/course/" + course.getId().toString())).body(course.getId());
        }catch(Exception e){
            log.error(e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value = "/course/sse", produces = "text/event-stream;charset=UTF-8")
    public Flux<Course> stream() {
        log.info("Start listening to the course collection.");
        return this.events.map(event -> (Course) event.getSource());
    }

    @GetMapping(value = "/course", produces = "application/json")
    public ResponseEntity<List<Course>> get() {
        log.info("Fetch all courses.");
        try{
            return ResponseEntity.ok().body(this.courseService.getCourses());
        }catch(Exception e){
            log.error(e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
