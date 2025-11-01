package timetable.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class TimetableEntry {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    private Course course;

    @ManyToOne(fetch = FetchType.EAGER)
    private Professor professor;

    @ManyToOne(fetch = FetchType.EAGER)
    private Room room;

    @ManyToOne(fetch = FetchType.EAGER)
    private Timeslot timeslot;

    @ManyToOne(fetch = FetchType.EAGER)
    private Program program;

    @ManyToOne(fetch = FetchType.EAGER)
    private Section section;

    // Constructors, getters, setters
    public TimetableEntry() {}

    public TimetableEntry(Course course, Professor professor, Room room, Timeslot timeslot, Program program, Section section) {
        this.course = course;
        this.professor = professor;
        this.room = room;
        this.timeslot = timeslot;
        this.program = program;
        this.section = section;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public Timeslot getTimeslot() {
        return timeslot;
    }

    public void setTimeslot(Timeslot timeslot) {
        this.timeslot = timeslot;
    }

    public Program getProgram() {
        return program;
    }

    public void setProgram(Program program) {
        this.program = program;
    }

    public Section getSection() {
        return section;
    }

    public void setSection(Section section) {
        this.section = section;
    }
}
