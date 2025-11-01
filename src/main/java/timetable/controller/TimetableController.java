package timetable.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import timetable.entity.Course;
import timetable.entity.Exam;
import timetable.entity.Professor;
import timetable.entity.Program;
import timetable.entity.Room;
import timetable.entity.Section;
import timetable.entity.Timeslot;
import timetable.entity.TimetableEntry;
import timetable.service.PdfService;
import timetable.service.TimetableService;

@RestController
@RequestMapping("/api/timetable")
@CrossOrigin(origins = "*")
public class TimetableController {

    @Autowired
    private TimetableService timetableService;

    @Autowired
    private PdfService pdfService;

    @GetMapping("/courses")
    public List<Course> getCourses() {
        return timetableService.getAllCourses();
    }

    @PostMapping("/courses")
    public Course createCourse(@RequestBody Course course) {
        return timetableService.saveCourse(course);
    }

    @GetMapping("/professors")
    public List<Professor> getProfessors() {
        return timetableService.getAllProfessors();
    }

    @PostMapping("/professors")
    public Professor createProfessor(@RequestBody Professor professor) {
        return timetableService.saveProfessor(professor);
    }

    @GetMapping("/rooms")
    public List<Room> getRooms() {
        return timetableService.getAllRooms();
    }

    @PostMapping("/rooms")
    public Room createRoom(@RequestBody Room room) {
        return timetableService.saveRoom(room);
    }

    @GetMapping("/timeslots")
    public List<Timeslot> getTimeslots() {
        return timetableService.getAllTimeslots();
    }

    @PostMapping("/timeslots")
    public Timeslot createTimeslot(@RequestBody Timeslot timeslot) {
        return timetableService.saveTimeslot(timeslot);
    }

    @GetMapping("/entries")
    public List<TimetableEntry> getTimetableEntries() {
        return timetableService.getAllTimetableEntries();
    }

    @PostMapping("/entries")
    public TimetableEntry createTimetableEntry(@RequestBody TimetableEntry entry) {
        return timetableService.saveTimetableEntry(entry);
    }

    @GetMapping("/programs")
    public List<Program> getPrograms() {
        return timetableService.getAllPrograms();
    }

    @PostMapping("/programs")
    public Program createProgram(@RequestBody Program program) {
        return timetableService.saveProgram(program);
    }

    @GetMapping("/sections")
    public List<Section> getSections() {
        return timetableService.getAllSections();
    }

    @PostMapping("/sections")
    public Section createSection(@RequestBody Section section) {
        return timetableService.saveSection(section);
    }

    @GetMapping("/exams")
    public List<Exam> getExams() {
        return timetableService.getAllExams();
    }

    @PostMapping("/exams")
    public Exam createExam(@RequestBody Exam exam) {
        return timetableService.saveExam(exam);
    }

    @GetMapping("/pdf")
    public ResponseEntity<byte[]> generatePdf(
            @RequestParam(defaultValue = "Sunderdeep Engineering College") String collegeName,
            @RequestParam(defaultValue = "(Dasna, Ghaziabad)") String address,
            @RequestParam(defaultValue = "Computer Science and Engineering") String department,
            @RequestParam(defaultValue = "5th") String semester,
            @RequestParam(defaultValue = "3rd") String year) {
        byte[] pdfBytes = pdfService.generateTimetablePdf(collegeName, address, department, semester, year);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_PDF);
        headers.setContentDispositionFormData("attachment", "timetable.pdf");
        return ResponseEntity.ok().headers(headers).body(pdfBytes);
    }

    @GetMapping("/exam-pdf")
    public ResponseEntity<byte[]> generateExamPdf(
            @RequestParam(defaultValue = "Sunderdeep Engineering College") String collegeName,
            @RequestParam(defaultValue = "(Dasna, Ghaziabad)") String address,
            @RequestParam(defaultValue = "Computer Science and Engineering") String department,
            @RequestParam(defaultValue = "5th") String semester,
            @RequestParam(defaultValue = "3rd") String year) {
        byte[] pdfBytes = pdfService.generateExamPdf(collegeName, address, department, semester, year);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_PDF);
        headers.setContentDispositionFormData("attachment", "exam_schedule.pdf");
        return ResponseEntity.ok().headers(headers).body(pdfBytes);
    }
}
