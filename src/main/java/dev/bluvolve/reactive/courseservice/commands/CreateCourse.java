package dev.bluvolve.reactive.courseservice.commands;

import lombok.Data;

@Data
public class CreateCourse {
    private String title;
    private String description;
}
