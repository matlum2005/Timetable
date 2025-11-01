package timetable.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import timetable.entity.Room;

public interface RoomRepository extends JpaRepository<Room, Long> {
}
