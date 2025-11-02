# Timetable Management System

A comprehensive web-based application for managing academic timetables, built with Spring Boot and modern web technologies. This system allows educational institutions to efficiently organize courses, professors, rooms, time slots, and generate professional PDF timetables and exam schedules.

## 🌟 Features

### Core Functionality
- **Course Management**: Add, view, and organize courses with unique codes
- **Professor Management**: Manage professor information and department assignments
- **Room Allocation**: Track classroom capacities and availability
- **Time Slot Management**: Create flexible scheduling with days and time ranges
- **Program & Section Organization**: Structure students by academic programs and sections
- **Timetable Creation**: Build comprehensive timetables linking all entities
- **Exam Scheduling**: Schedule exams with seating plans and room assignments

### Advanced Features
- **PDF Generation**: Generate professional timetables and exam schedules with custom branding
- **Responsive Design**: Modern, mobile-friendly interface with dark/light theme toggle
- **RESTful API**: Complete backend API for all operations
- **Real-time Updates**: Dynamic frontend updates without page refreshes
- **Data Persistence**: H2 in-memory database with JPA integration

## 🛠️ Technology Stack

### Backend
- **Java 17**
- **Spring Boot 3.1.0**
- **Spring Data JPA** - Data persistence
- **Spring Web** - REST API development
- **H2 Database** - In-memory database
- **iText 7.2.5** - PDF generation
- **Thymeleaf** - Server-side templating

### Frontend
- **HTML5/CSS3** - Modern web standards
- **Bootstrap 5.3.0** - Responsive UI framework
- **Font Awesome 6.0.0** - Icon library
- **Google Fonts (Poppins)** - Typography
- **Vanilla JavaScript** - Client-side logic
- **Fetch API** - HTTP requests

## 📁 Project Structure

```
timetable-management-system/
├── src/
│   └── main/
│       ├── java/
│       │   └── timetable/
│       │       ├── TimetableManagementApplication.java
│       │       ├── controller/
│       │       │   └── TimetableController.java
│       │       ├── entity/
│       │       │   ├── Course.java
│       │       │   ├── Exam.java
│       │       │   ├── Professor.java
│       │       │   ├── Program.java
│       │       │   ├── Room.java
│       │       │   ├── Section.java
│       │       │   ├── Timeslot.java
│       │       │   └── TimetableEntry.java
│       │       ├── repository/
│       │       │   ├── CourseRepository.java
│       │       │   ├── ExamRepository.java
│       │       │   ├── ProfessorRepository.java
│       │       │   ├── ProgramRepository.java
│       │       │   ├── RoomRepository.java
│       │       │   ├── SectionRepository.java
│       │       │   ├── TimeslotRepository.java
│       │       │   └── TimetableEntryRepository.java
│       │       └── service/
│       │           ├── PdfService.java
│       │           └── TimetableService.java
│       └── resources/
│           ├── static/
│           │   ├── index.html
│           │   ├── dashboard.html
│           │   └── app.js
│           ├── templates/
│           └── application.properties
├── pom.xml
├── README.md
├── TODO.md
└── index.html (landing page)
```

## 🚀 Getting Started

### Prerequisites
- **Java 17** or higher
- **Maven 3.6+** (or use Maven wrapper included)
- **Git** for version control

### Installation & Setup

1. **Clone the repository**
   ```bash
   git clone https://github.com/matlum2005/Timetable.git
   cd Timetable
   ```

2. **Build the project**
   ```bash
   mvn clean install
   ```

3. **Run the application**
   ```bash
   mvn spring-boot:run
   ```

4. **Access the application**
   - Landing Page: http://localhost:8080/index.html
   - Dashboard: http://localhost:8080/src/main/resources/static/dashboard.html
   - H2 Console: http://localhost:8080/h2-console
     - JDBC URL: `jdbc:h2:mem:timetable_db`
     - Username: `sa`
     - Password: (leave empty)

## 📖 API Documentation

### Base URL
```
http://localhost:8080/api/timetable
```

### Endpoints

#### Courses
- `GET /courses` - Get all courses
- `POST /courses` - Create a new course
  ```json
  {
    "name": "Data Structures",
    "code": "CS201"
  }
  ```

#### Professors
- `GET /professors` - Get all professors
- `POST /professors` - Create a new professor
  ```json
  {
    "name": "Dr. John Smith",
    "department": "Computer Science"
  }
  ```

#### Rooms
- `GET /rooms` - Get all rooms
- `POST /rooms` - Create a new room
  ```json
  {
    "name": "Room 101",
    "capacity": 50
  }
  ```

#### Timeslots
- `GET /timeslots` - Get all timeslots
- `POST /timeslots` - Create a new timeslot
  ```json
  {
    "dayOfWeek": "Monday",
    "startTime": "09:00:00",
    "endTime": "10:30:00"
  }
  ```

#### Programs
- `GET /programs` - Get all programs
- `POST /programs` - Create a new program
  ```json
  {
    "name": "B.Tech Computer Science"
  }
  ```

#### Sections
- `GET /sections` - Get all sections
- `POST /sections` - Create a new section
  ```json
  {
    "name": "Section A"
  }
  ```

#### Timetable Entries
- `GET /entries` - Get all timetable entries
- `POST /entries` - Create a new timetable entry
  ```json
  {
    "course": {"id": 1},
    "professor": {"id": 1},
    "room": {"id": 1},
    "timeslot": {"id": 1},
    "program": {"id": 1},
    "section": {"id": 1}
  }
  ```

#### Exams
- `GET /exams` - Get all exams
- `POST /exams` - Create a new exam
  ```json
  {
    "course": {"id": 1},
    "program": {"id": 1},
    "section": {"id": 1},
    "date": "2024-12-15",
    "timeslot": {"id": 1},
    "room": {"id": 1},
    "seatingPlan": "Row 1: Seats 1-10, Row 2: Seats 11-20"
  }
  ```

#### PDF Generation
- `GET /pdf?collegeName=...&address=...&department=...&semester=...&year=...` - Generate timetable PDF
- `GET /exam-pdf?collegeName=...&address=...&department=...&semester=...&year=...` - Generate exam schedule PDF

## 🎨 User Interface

### Landing Page (`index.html`)
- Modern hero section with animated elements
- Feature showcase with hover effects
- Dark/light theme toggle
- Responsive design for all devices
- Direct links to dashboard

### Dashboard (`dashboard.html`)
- Sidebar navigation for different modules
- Dynamic forms for data entry
- Real-time data tables
- PDF generation modal
- Bootstrap-based responsive layout

## 🗄️ Database Schema

The application uses JPA entities with the following relationships:

- **TimetableEntry**: Central entity linking Course, Professor, Room, Timeslot, Program, and Section
- **Exam**: Links Course, Program, Section, Timeslot, Room with additional date and seating plan
- All entities use auto-generated IDs with IDENTITY strategy
- H2 database with in-memory storage (data persists during application runtime)

## 🔧 Configuration

### Application Properties
```properties
spring.datasource.url=jdbc:h2:mem:timetable_db
spring.datasource.username=sa
spring.datasource.password=
spring.datasource.driver-class-name=org.h2.Driver
spring.jpa.hibernate.ddl-auto=create-drop
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.H2Dialect
spring.h2.console.enabled=true
spring.jpa.properties.hibernate.format_sql=true
server.port=8080
```

### Maven Dependencies
- Spring Boot Starter Web
- Spring Boot Starter Data JPA
- H2 Database
- iText PDF libraries
- Spring Boot Starter Thymeleaf
- Spring Boot Starter Test

## 🚀 Deployment

### Local Development
1. Ensure Java 17+ and Maven are installed
2. Clone repository
3. Run `mvn spring-boot:run`
4. Access at http://localhost:8080

### Production Deployment
1. Build JAR: `mvn clean package`
2. Run JAR: `java -jar target/timetable-management-0.0.1-SNAPSHOT.jar`
3. Configure external database (replace H2 with PostgreSQL/MySQL)
4. Set production properties

## 🤝 Contributing

1. Fork the repository
2. Create a feature branch (`git checkout -b feature/AmazingFeature`)
3. Commit changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

## 📝 License

This project is licensed under the MIT License - see the LICENSE file for details.

## 👥 Authors

- **matlum2005** - *Initial work* - [GitHub](https://github.com/matlum2005)

## 🙏 Acknowledgments

- Spring Boot team for the excellent framework
- Bootstrap team for the UI framework
- iText team for PDF generation capabilities
- Font Awesome for icons
- Google Fonts for typography

## 📞 Support

For support, email the repository owner or create an issue in the GitHub repository.

---

**Sunderdeep Engineering College**  
*Empowering education through innovative technology solutions*
