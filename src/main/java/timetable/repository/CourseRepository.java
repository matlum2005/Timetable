package timetable.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import timetable.entity.Course;

public interface CourseRepository extends JpaRepository<Course, Long> {
}
