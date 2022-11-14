package dev.bluvolve.reactive.courseservice.repository;

import dev.bluvolve.reactive.courseservice.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ICourseRepository extends JpaRepository<Course, UUID> {
    // add custom queries here
}
