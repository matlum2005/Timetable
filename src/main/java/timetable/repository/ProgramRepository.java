package timetable.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import timetable.entity.Program;

public interface ProgramRepository extends JpaRepository<Program, Long> {
}
