package dev.bluvolve.reactive.courseservice.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.Duration;
import java.time.OffsetDateTime;
import java.util.UUID;

@Entity
@Data
public class Course {
    @Id
    @GeneratedValue
    private UUID id;
    private String title;
}
