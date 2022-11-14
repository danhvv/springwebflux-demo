package dev.bluvolve.reactive.courseservice.events;

import dev.bluvolve.reactive.courseservice.entity.Course;
import lombok.Getter;
import org.springframework.context.ApplicationEvent;

@Getter
public class CourseCreated extends ApplicationEvent {
    public CourseCreated(Course course) {
        super(course);
    }
}
