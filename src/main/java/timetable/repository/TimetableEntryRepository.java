package timetable.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import timetable.entity.TimetableEntry;

public interface TimetableEntryRepository extends JpaRepository<TimetableEntry, Long> {
}
