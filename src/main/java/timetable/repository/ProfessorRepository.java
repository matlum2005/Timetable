package timetable.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import timetable.entity.Professor;

public interface ProfessorRepository extends JpaRepository<Professor, Long> {
}
