package timetable.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import timetable.entity.Exam;

public interface ExamRepository extends JpaRepository<Exam, Long> {
}
