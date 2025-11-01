package timetable.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import timetable.entity.Section;

public interface SectionRepository extends JpaRepository<Section, Long> {
}
