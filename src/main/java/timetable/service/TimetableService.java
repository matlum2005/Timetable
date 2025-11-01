package timetable.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import timetable.entity.*;
import timetable.repository.*;

import java.util.List;

@Service
public class TimetableService {

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private ProfessorRepository professorRepository;

    @Autowired
    private RoomRepository roomRepository;

    @Autowired
    private TimeslotRepository timeslotRepository;

    @Autowired
    private TimetableEntryRepository timetableEntryRepository;

    @Autowired
    private ProgramRepository programRepository;

    @Autowired
    private SectionRepository sectionRepository;

    @Autowired
    private ExamRepository examRepository;

    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    public Course saveCourse(Course course) {
        return courseRepository.save(course);
    }

    public List<Professor> getAllProfessors() {
        return professorRepository.findAll();
    }

    public Professor saveProfessor(Professor professor) {
        return professorRepository.save(professor);
    }

    public List<Room> getAllRooms() {
        return roomRepository.findAll();
    }

    public Room saveRoom(Room room) {
        return roomRepository.save(room);
    }

    public List<Timeslot> getAllTimeslots() {
        return timeslotRepository.findAll();
    }

    public Timeslot saveTimeslot(Timeslot timeslot) {
        return timeslotRepository.save(timeslot);
    }

    public List<TimetableEntry> getAllTimetableEntries() {
        return timetableEntryRepository.findAll();
    }

    public TimetableEntry saveTimetableEntry(TimetableEntry entry) {
        return timetableEntryRepository.save(entry);
    }

    public List<Program> getAllPrograms() {
        return programRepository.findAll();
    }

    public Program saveProgram(Program program) {
        return programRepository.save(program);
    }

    public List<Section> getAllSections() {
        return sectionRepository.findAll();
    }

    public Section saveSection(Section section) {
        return sectionRepository.save(section);
    }

    public List<Exam> getAllExams() {
        return examRepository.findAll();
    }

    public Exam saveExam(Exam exam) {
        return examRepository.save(exam);
    }
}
