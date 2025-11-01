package timetable.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class Exam {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;

    @ManyToOne
    @JoinColumn(name = "program_id")
    private Program program;

    @ManyToOne
    @JoinColumn(name = "section_id")
    private Section section;

    private LocalDate date;

    @ManyToOne
    @JoinColumn(name = "timeslot_id")
    private Timeslot timeslot;

    @ManyToOne
    @JoinColumn(name = "room_id")
    private Room room;

    @Column(length = 1000)
    private String seatingPlan;

    // Constructors
    public Exam() {}

    public Exam(Course course, Program program, Section section, LocalDate date, Timeslot timeslot, Room room, String seatingPlan) {
        this.course = course;
        this.program = program;
        this.section = section;
        this.date = date;
        this.timeslot = timeslot;
        this.room = room;
        this.seatingPlan = seatingPlan;
    }

    // Getters and Setters
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

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Timeslot getTimeslot() {
        return timeslot;
    }

    public void setTimeslot(Timeslot timeslot) {
        this.timeslot = timeslot;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public String getSeatingPlan() {
        return seatingPlan;
    }

    public void setSeatingPlan(String seatingPlan) {
        this.seatingPlan = seatingPlan;
    }
}
