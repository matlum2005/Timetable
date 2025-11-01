package timetable.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import timetable.entity.Timeslot;

public interface TimeslotRepository extends JpaRepository<Timeslot, Long> {
}
