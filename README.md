# Timetable Management System

A comprehensive web-based application for managing academic timetables, built with Spring Boot and modern web technologies. Designed specifically for educational institutions to streamline scheduling, course management, and resource allocation.

## 🎓 About

This Timetable Management System is developed for Sunderdeep Engineering College to efficiently manage academic schedules, including courses, professors, rooms, time slots, programs, sections, and exam schedules. The system provides both a RESTful API for backend operations and a user-friendly web interface for easy management.

## ✨ Features

### Core Functionality
- **Course Management**: Add, edit, and organize courses with detailed information
- **Professor Scheduling**: Manage professor information and assignments
- **Room Allocation**: Optimize classroom usage with capacity tracking
- **Time Slot Management**: Create flexible scheduling for different days
- **Program & Section Organization**: Organize students by academic programs and sections
- **Exam Schedule Management**: Handle examination timetables separately
- **Timetable Entry Management**: Create and manage complete timetable entries

### Advanced Features
- **PDF Generation**: Generate professional PDF timetables and exam schedules
- **Customizable Branding**: Include college name, address, department, semester, and year in PDFs
- **RESTful API**: Complete API for all CRUD operations
- **Web Dashboard**: User-friendly interface built with Bootstrap
- **Dark/Light Theme**: Modern UI with theme switching capability
- **Responsive Design**: Works seamlessly on desktop and mobile devices

## 🛠️ Tech Stack

### Backend
- **Java 17**: Modern Java runtime
- **Spring Boot 3.1.0**: Framework for building the application
- **Spring Web**: RESTful web services
- **Spring Data JPA**: Data persistence and ORM
- **H2 Database**: In-memory database for development
- **Maven**: Dependency management and build tool

### Frontend
- **HTML5/CSS3**: Modern web standards
- **Bootstrap 5.3.0**: Responsive UI framework
- **JavaScript**: Client-side interactivity
- **Thymeleaf**: Server-side templating (for future enhancements)

### Additional Libraries
- **iText PDF**: PDF generation for timetables and exam schedules
- **Font Awesome**: Icons and visual elements

## 🚀 Getting Started

### Prerequisites
- Java 17 or higher
- Maven 3.6+ (or use the included Maven wrapper)
- Git

### Installation

1. **Clone the repository**
   ```bash
   git clone https://github.com/matlum2005/Timetable.git
   cd timetable-management-system
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
   - Web Interface: http://localhost:8080
   - API Documentation: http://localhost:8080/api/timetable

## 📖 API Documentation

The system provides a comprehensive REST API for all operations:

### Base URL
```
http://localhost:8080/api/timetable
```

### Endpoints

#### Courses
- `GET /courses` - Get all courses
- `POST /courses` - Create a new course

#### Professors
- `GET /professors` - Get all professors
- `POST /professors` - Create a new professor

#### Rooms
- `GET /rooms` - Get all rooms
- `POST /rooms` - Create a new room

#### Timeslots
- `GET /timeslots` - Get all timeslots
- `POST /timeslots` - Create a new timeslot

#### Timetable Entries
- `GET /entries` - Get all timetable entries
- `POST /entries` - Create a new timetable entry

#### Programs
- `GET /programs` - Get all programs
- `POST /programs` - Create a new program

#### Sections
- `GET /sections` - Get all sections
- `POST /sections` - Create a new section

#### Exams
- `GET /exams` - Get all exams
- `POST /exams` - Create a new exam

#### PDF Generation
- `GET /pdf?collegeName={name}&address={address}&department={dept}&semester={sem}&year={year}` - Generate timetable PDF
- `GET /exam-pdf?collegeName={name}&address={address}&department={dept}&semester={sem}&year={year}` - Generate exam schedule PDF

### Sample API Usage

```bash
# Get all courses
curl http://localhost:8080/api/timetable/courses

# Create a new course
curl -X POST http://localhost:8080/api/timetable/courses \
  -H "Content-Type: application/json" \
  -d '{"name":"Data Structures","code":"CS201","credits":4}'

# Generate PDF with custom parameters
curl "http://localhost:8080/api/timetable/pdf?collegeName=Sunderdeep%20Engineering%20College&address=Dasna%2C%20Ghaziabad&department=Computer%20Science&semester=5th&year=3rd" \
  --output timetable.pdf
```

## 🎨 User Interface

The web interface provides:
- **Landing Page**: Professional homepage with feature overview
- **Dashboard**: Interactive management interface
- **Theme Support**: Light and dark mode switching
- **Responsive Design**: Optimized for all screen sizes

## 📊 Database Schema

The system uses the following main entities:
- **Course**: Course details and information
- **Professor**: Faculty member information
- **Room**: Classroom and facility details
- **Timeslot**: Time scheduling information
- **TimetableEntry**: Complete schedule entries linking courses, professors, rooms, and times
- **Program**: Academic program information
- **Section**: Student group organization
- **Exam**: Examination schedule details

## 🔧 Configuration

Key configuration files:
- `application.properties`: Spring Boot configuration
- `pom.xml`: Maven dependencies and build configuration

## 🤝 Contributing

1. Fork the repository
2. Create a feature branch (`git checkout -b feature/AmazingFeature`)
3. Commit your changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

## 📝 License

This project is licensed under the MIT License - see the LICENSE file for details.

## 📞 Contact

Sunderdeep Engineering College
- Location: Dasna, Ghaziabad
- Project Repository: https://github.com/matlum2005/Timetable

## 🙏 Acknowledgments

- Built with Spring Boot framework
- UI powered by Bootstrap
- Icons by Font Awesome
- PDF generation by iText
=======
# Timetable Management System

A comprehensive web-based application for managing academic timetables, built with Spring Boot and modern web technologies. Designed specifically for educational institutions to streamline scheduling, course management, and resource allocation.

## 🎓 About

This Timetable Management System is developed for Sunderdeep Engineering College to efficiently manage academic schedules, including courses, professors, rooms, time slots, programs, sections, and exam schedules. The system provides both a RESTful API for backend operations and a user-friendly web interface for easy management.

## ✨ Features

### Core Functionality
- **Course Management**: Add, edit, and organize courses with detailed information
- **Professor Scheduling**: Manage professor information and assignments
- **Room Allocation**: Optimize classroom usage with capacity tracking
- **Time Slot Management**: Create flexible scheduling for different days
- **Program & Section Organization**: Organize students by academic programs and sections
- **Exam Schedule Management**: Handle examination timetables separately
- **Timetable Entry Management**: Create and manage complete timetable entries

### Advanced Features
- **PDF Generation**: Generate professional PDF timetables and exam schedules
- **Customizable Branding**: Include college name, address, department, semester, and year in PDFs
- **RESTful API**: Complete API for all CRUD operations
- **Web Dashboard**: User-friendly interface built with Bootstrap
- **Dark/Light Theme**: Modern UI with theme switching capability
- **Responsive Design**: Works seamlessly on desktop and mobile devices

## 🛠️ Tech Stack

### Backend
- **Java 17**: Modern Java runtime
- **Spring Boot 3.1.0**: Framework for building the application
- **Spring Web**: RESTful web services
- **Spring Data JPA**: Data persistence and ORM
- **H2 Database**: In-memory database for development
- **Maven**: Dependency management and build tool

### Frontend
- **HTML5/CSS3**: Modern web standards
- **Bootstrap 5.3.0**: Responsive UI framework
- **JavaScript**: Client-side interactivity
- **Thymeleaf**: Server-side templating (for future enhancements)

### Additional Libraries
- **iText PDF**: PDF generation for timetables and exam schedules
- **Font Awesome**: Icons and visual elements

## 🚀 Getting Started

### Prerequisites
- Java 17 or higher
- Maven 3.6+ (or use the included Maven wrapper)
- Git

### Installation

1. **Clone the repository**
   ```bash
   git clone https://github.com/matlum2005/Timetable.git
   cd timetable-management-system
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
   - Web Interface: http://localhost:8080
   - API Documentation: http://localhost:8080/api/timetable

## 📖 API Documentation

The system provides a comprehensive REST API for all operations:

### Base URL
```
http://localhost:8080/api/timetable
```

### Endpoints

#### Courses
- `GET /courses` - Get all courses
- `POST /courses` - Create a new course

#### Professors
- `GET /professors` - Get all professors
- `POST /professors` - Create a new professor

#### Rooms
- `GET /rooms` - Get all rooms
- `POST /rooms` - Create a new room

#### Timeslots
- `GET /timeslots` - Get all timeslots
- `POST /timeslots` - Create a new timeslot

#### Timetable Entries
- `GET /entries` - Get all timetable entries
- `POST /entries` - Create a new timetable entry

#### Programs
- `GET /programs` - Get all programs
- `POST /programs` - Create a new program

#### Sections
- `GET /sections` - Get all sections
- `POST /sections` - Create a new section

#### Exams
- `GET /exams` - Get all exams
- `POST /exams` - Create a new exam

#### PDF Generation
- `GET /pdf?collegeName={name}&address={address}&department={dept}&semester={sem}&year={year}` - Generate timetable PDF
- `GET /exam-pdf?collegeName={name}&address={address}&department={dept}&semester={sem}&year={year}` - Generate exam schedule PDF

### Sample API Usage

```bash
# Get all courses
curl http://localhost:8080/api/timetable/courses

# Create a new course
curl -X POST http://localhost:8080/api/timetable/courses \
  -H "Content-Type: application/json" \
  -d '{"name":"Data Structures","code":"CS201","credits":4}'

# Generate PDF with custom parameters
curl "http://localhost:8080/api/timetable/pdf?collegeName=Sunderdeep%20Engineering%20College&address=Dasna%2C%20Ghaziabad&department=Computer%20Science&semester=5th&year=3rd" \
  --output timetable.pdf
```

## 🎨 User Interface

The web interface provides:
- **Landing Page**: Professional homepage with feature overview
- **Dashboard**: Interactive management interface
- **Theme Support**: Light and dark mode switching
- **Responsive Design**: Optimized for all screen sizes

## 📊 Database Schema

The system uses the following main entities:
- **Course**: Course details and information
- **Professor**: Faculty member information
- **Room**: Classroom and facility details
- **Timeslot**: Time scheduling information
- **TimetableEntry**: Complete schedule entries linking courses, professors, rooms, and times
- **Program**: Academic program information
- **Section**: Student group organization
- **Exam**: Examination schedule details

## 🔧 Configuration

Key configuration files:
- `application.properties`: Spring Boot configuration
- `pom.xml`: Maven dependencies and build configuration

## 🤝 Contributing

1. Fork the repository
2. Create a feature branch (`git checkout -b feature/AmazingFeature`)
3. Commit your changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

## 📝 License

This project is licensed under the MIT License - see the LICENSE file for details.

## 📞 Contact

Sunderdeep Engineering College
- Location: Dasna, Ghaziabad
- Project Repository: https://github.com/matlum2005/Timetable

## 🙏 Acknowledgments

- Built with Spring Boot framework
- UI powered by Bootstrap
- Icons by Font Awesome
- PDF generation by iText
=======
# Timetable
>>>>>>> e89ddee9e9ff423ac05cde56c17a4b0ad1df74bc
