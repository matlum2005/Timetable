const API_BASE = 'http://localhost:8080/api/timetable';

function formatTime(timeString) {
    // Assuming timeString is in HH:MM:SS format, slice to HH:MM
    return timeString.slice(0, 5);
}

function showSection(sectionName) {
    const sections = document.querySelectorAll('.section');
    sections.forEach(section => section.style.display = 'none');
    document.getElementById(sectionName + '-section').style.display = 'block';
    loadData(sectionName);
}

function loadData(section) {
    switch(section) {
        case 'courses':
            loadCourses();
            break;
        case 'professors':
            loadProfessors();
            break;
        case 'rooms':
            loadRooms();
            break;
        case 'timeslots':
            loadTimeslots();
            break;
        case 'programs':
            loadPrograms();
            break;
        case 'sections':
            loadSections();
            break;
        case 'exams':
            loadExams();
            loadExamDropdowns();
            break;
        case 'timetable':
            loadTimetableEntries();
            loadDropdowns();
            break;
    }
}

function loadCourses() {
    fetch(`${API_BASE}/courses`)
        .then(response => response.json())
        .then(data => {
            const tbody = document.querySelector('#courses-table tbody');
            tbody.innerHTML = '';
            data.forEach(course => {
                tbody.innerHTML += `
                    <tr>
                        <td>${course.id}</td>
                        <td>${course.name}</td>
                        <td>${course.code}</td>
                    </tr>
                `;
            });
        });
}

function loadProfessors() {
    fetch(`${API_BASE}/professors`)
        .then(response => response.json())
        .then(data => {
            const tbody = document.querySelector('#professors-table tbody');
            tbody.innerHTML = '';
            data.forEach(professor => {
                tbody.innerHTML += `
                    <tr>
                        <td>${professor.id}</td>
                        <td>${professor.name}</td>
                        <td>${professor.department}</td>
                    </tr>
                `;
            });
        });
}

function loadRooms() {
    fetch(`${API_BASE}/rooms`)
        .then(response => response.json())
        .then(data => {
            const tbody = document.querySelector('#rooms-table tbody');
            tbody.innerHTML = '';
            data.forEach(room => {
                tbody.innerHTML += `
                    <tr>
                        <td>${room.id}</td>
                        <td>${room.name}</td>
                        <td>${room.capacity}</td>
                    </tr>
                `;
            });
        });
}

function loadTimeslots() {
    fetch(`${API_BASE}/timeslots`)
        .then(response => response.json())
        .then(data => {
            const tbody = document.querySelector('#timeslots-table tbody');
            tbody.innerHTML = '';
            data.forEach(timeslot => {
                tbody.innerHTML += `
                    <tr>
                        <td>${timeslot.id}</td>
                        <td>${timeslot.dayOfWeek}</td>
                        <td>${formatTime(timeslot.startTime)}</td>
                        <td>${formatTime(timeslot.endTime)}</td>
                    </tr>
                `;
            });
        });
}

function loadPrograms() {
    fetch(`${API_BASE}/programs`)
        .then(response => response.json())
        .then(data => {
            const tbody = document.querySelector('#programs-table tbody');
            tbody.innerHTML = '';
            data.forEach(program => {
                tbody.innerHTML += `
                    <tr>
                        <td>${program.id}</td>
                        <td>${program.name}</td>
                    </tr>
                `;
            });
        });
}

function loadSections() {
    fetch(`${API_BASE}/sections`)
        .then(response => response.json())
        .then(data => {
            const tbody = document.querySelector('#sections-table tbody');
            tbody.innerHTML = '';
            data.forEach(section => {
                tbody.innerHTML += `
                    <tr>
                        <td>${section.id}</td>
                        <td>${section.name}</td>
                    </tr>
                `;
            });
        });
}

function loadExams() {
    fetch(`${API_BASE}/exams`)
        .then(response => response.json())
        .then(data => {
            const tbody = document.querySelector('#exams-table tbody');
            tbody.innerHTML = '';
            data.forEach(exam => {
                tbody.innerHTML += `
                    <tr>
                        <td>${exam.id}</td>
                        <td>${exam.course.name}</td>
                        <td>${exam.program.name}</td>
                        <td>${exam.section.name}</td>
                        <td>${exam.date}</td>
                        <td>${exam.timeslot.dayOfWeek} ${formatTime(exam.timeslot.startTime)}-${formatTime(exam.timeslot.endTime)}</td>
                        <td>${exam.room.name}</td>
                        <td>${exam.seatingPlan}</td>
                    </tr>
                `;
            });
        });
}

function loadTimetableEntries() {
    fetch(`${API_BASE}/entries`)
        .then(response => response.json())
        .then(data => {
            const tbody = document.querySelector('#timetable-table tbody');
            tbody.innerHTML = '';
            data.forEach(entry => {
                tbody.innerHTML += `
                    <tr>
                        <td>${entry.id}</td>
                        <td>${entry.course.name}</td>
                        <td>${entry.professor.name}</td>
                        <td>${entry.room.name}</td>
                        <td>${entry.program ? entry.program.name : ''}</td>
                        <td>${entry.section ? entry.section.name : ''}</td>
                        <td>${entry.timeslot.dayOfWeek}</td>
                        <td>${formatTime(entry.timeslot.startTime)} - ${formatTime(entry.timeslot.endTime)}</td>
                    </tr>
                `;
            });
        });
}

function loadDropdowns() {
    // Load courses
    fetch(`${API_BASE}/courses`)
        .then(response => response.json())
        .then(data => {
            const select = document.getElementById('entry-course');
            select.innerHTML = '<option value="">Course</option>';
            data.forEach(course => {
                select.innerHTML += `<option value="${course.id}">${course.name}</option>`;
            });
        });

    // Load professors
    fetch(`${API_BASE}/professors`)
        .then(response => response.json())
        .then(data => {
            const select = document.getElementById('entry-professor');
            select.innerHTML = '<option value="">Professor</option>';
            data.forEach(professor => {
                select.innerHTML += `<option value="${professor.id}">${professor.name}</option>`;
            });
        });

    // Load rooms
    fetch(`${API_BASE}/rooms`)
        .then(response => response.json())
        .then(data => {
            const select = document.getElementById('entry-room');
            select.innerHTML = '<option value="">Room</option>';
            data.forEach(room => {
                select.innerHTML += `<option value="${room.id}">${room.name}</option>`;
            });
        });

    // Load timeslots
    fetch(`${API_BASE}/timeslots`)
        .then(response => response.json())
        .then(data => {
            const select = document.getElementById('entry-timeslot');
            select.innerHTML = '<option value="">Timeslot</option>';
            data.forEach(timeslot => {
                select.innerHTML += `<option value="${timeslot.id}">${timeslot.dayOfWeek} ${formatTime(timeslot.startTime)}-${formatTime(timeslot.endTime)}</option>`;
            });
        });

    // Load programs
    fetch(`${API_BASE}/programs`)
        .then(response => response.json())
        .then(data => {
            const select = document.getElementById('entry-program');
            select.innerHTML = '<option value="">Program</option>';
            data.forEach(program => {
                select.innerHTML += `<option value="${program.id}">${program.name}</option>`;
            });
        });

    // Load sections
    fetch(`${API_BASE}/sections`)
        .then(response => response.json())
        .then(data => {
            const select = document.getElementById('entry-section');
            select.innerHTML = '<option value="">Section</option>';
            data.forEach(section => {
                select.innerHTML += `<option value="${section.id}">${section.name}</option>`;
            });
        });
}

function loadExamDropdowns() {
    // Load courses
    fetch(`${API_BASE}/courses`)
        .then(response => response.json())
        .then(data => {
            const select = document.getElementById('exam-course');
            select.innerHTML = '<option value="">Course</option>';
            data.forEach(course => {
                select.innerHTML += `<option value="${course.id}">${course.name}</option>`;
            });
        });

    // Load programs
    fetch(`${API_BASE}/programs`)
        .then(response => response.json())
        .then(data => {
            const select = document.getElementById('exam-program');
            select.innerHTML = '<option value="">Program</option>';
            data.forEach(program => {
                select.innerHTML += `<option value="${program.id}">${program.name}</option>`;
            });
        });

    // Load sections
    fetch(`${API_BASE}/sections`)
        .then(response => response.json())
        .then(data => {
            const select = document.getElementById('exam-section');
            select.innerHTML = '<option value="">Section</option>';
            data.forEach(section => {
                select.innerHTML += `<option value="${section.id}">${section.name}</option>`;
            });
        });

    // Load timeslots
    fetch(`${API_BASE}/timeslots`)
        .then(response => response.json())
        .then(data => {
            const select = document.getElementById('exam-timeslot');
            select.innerHTML = '<option value="">Timeslot</option>';
            data.forEach(timeslot => {
                select.innerHTML += `<option value="${timeslot.id}">${timeslot.dayOfWeek} ${formatTime(timeslot.startTime)}-${formatTime(timeslot.endTime)}</option>`;
            });
        });

    // Load rooms
    fetch(`${API_BASE}/rooms`)
        .then(response => response.json())
        .then(data => {
            const select = document.getElementById('exam-room');
            select.innerHTML = '<option value="">Room</option>';
            data.forEach(room => {
                select.innerHTML += `<option value="${room.id}">${room.name}</option>`;
            });
        });
}

let currentPdfType = '';

function showPdfModal(type) {
    currentPdfType = type;
    const modal = new bootstrap.Modal(document.getElementById('pdfModal'));
    modal.show();
}

function generatePdf() {
    const collegeName = document.getElementById('college-name').value;
    const address = document.getElementById('address').value;
    const department = document.getElementById('department').value;
    const semester = document.getElementById('semester').value;
    const year = document.getElementById('year').value;

    const params = new URLSearchParams({
        collegeName,
        address,
        department,
        semester,
        year
    });

    fetch(`${API_BASE}/pdf?${params}`)
        .then(response => response.blob())
        .then(blob => {
            const url = window.URL.createObjectURL(blob);
            const a = document.createElement('a');
            a.href = url;
            a.download = 'timetable.pdf';
            document.body.appendChild(a);
            a.click();
            window.URL.revokeObjectURL(url);
            document.body.removeChild(a);
            const modal = bootstrap.Modal.getInstance(document.getElementById('pdfModal'));
            modal.hide();
        });
}

function generateExamPdf() {
    const collegeName = document.getElementById('college-name').value;
    const address = document.getElementById('address').value;
    const department = document.getElementById('department').value;
    const semester = document.getElementById('semester').value;
    const year = document.getElementById('year').value;

    const params = new URLSearchParams({
        collegeName,
        address,
        department,
        semester,
        year
    });

    fetch(`${API_BASE}/exam-pdf?${params}`)
        .then(response => response.blob())
        .then(blob => {
            const url = window.URL.createObjectURL(blob);
            const a = document.createElement('a');
            a.href = url;
            a.download = 'exam_schedule.pdf';
            document.body.appendChild(a);
            a.click();
            window.URL.revokeObjectURL(url);
            document.body.removeChild(a);
            const modal = bootstrap.Modal.getInstance(document.getElementById('pdfModal'));
            modal.hide();
        });
}

// Event listeners
document.getElementById('course-form').addEventListener('submit', function(e) {
    e.preventDefault();
    const name = document.getElementById('course-name').value;
    const code = document.getElementById('course-code').value;
    fetch(`${API_BASE}/courses`, {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify({ name, code })
    }).then(() => {
        loadCourses();
        this.reset();
    });
});

document.getElementById('professor-form').addEventListener('submit', function(e) {
    e.preventDefault();
    const name = document.getElementById('professor-name').value;
    const department = document.getElementById('professor-department').value;
    fetch(`${API_BASE}/professors`, {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify({ name, department })
    }).then(() => {
        loadProfessors();
        this.reset();
    });
});

document.getElementById('room-form').addEventListener('submit', function(e) {
    e.preventDefault();
    const name = document.getElementById('room-name').value;
    const capacity = document.getElementById('room-capacity').value;
    fetch(`${API_BASE}/rooms`, {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify({ name, capacity: parseInt(capacity) })
    }).then(() => {
        loadRooms();
        this.reset();
    });
});

document.getElementById('timeslot-form').addEventListener('submit', function(e) {
    e.preventDefault();
    const dayOfWeek = document.getElementById('timeslot-day').value;
    const startTime = document.getElementById('timeslot-start').value;
    const endTime = document.getElementById('timeslot-end').value;
    fetch(`${API_BASE}/timeslots`, {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify({ dayOfWeek, startTime, endTime })
    }).then(() => {
        loadTimeslots();
        this.reset();
    });
});

document.getElementById('program-form').addEventListener('submit', function(e) {
    e.preventDefault();
    const name = document.getElementById('program-name').value;
    fetch(`${API_BASE}/programs`, {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify({ name })
    }).then(() => {
        loadPrograms();
        this.reset();
    });
});

document.getElementById('section-form').addEventListener('submit', function(e) {
    e.preventDefault();
    const name = document.getElementById('section-name').value;
    fetch(`${API_BASE}/sections`, {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify({ name })
    }).then(() => {
        loadSections();
        this.reset();
    });
});

document.getElementById('timetable-form').addEventListener('submit', function(e) {
    e.preventDefault();
    const course = { id: document.getElementById('entry-course').value };
    const professor = { id: document.getElementById('entry-professor').value };
    const room = { id: document.getElementById('entry-room').value };
    const timeslot = { id: document.getElementById('entry-timeslot').value };
    const program = { id: document.getElementById('entry-program').value };
    const section = { id: document.getElementById('entry-section').value };
    fetch(`${API_BASE}/entries`, {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify({ course, professor, room, timeslot, program, section })
    }).then(() => {
        loadTimetableEntries();
        this.reset();
    });
});

document.getElementById('exam-form').addEventListener('submit', function(e) {
    e.preventDefault();
    const course = { id: document.getElementById('exam-course').value };
    const program = { id: document.getElementById('exam-program').value };
    const section = { id: document.getElementById('exam-section').value };
    const date = document.getElementById('exam-date').value;
    const timeslot = { id: document.getElementById('exam-timeslot').value };
    const room = { id: document.getElementById('exam-room').value };
    const seatingPlan = document.getElementById('exam-seating-plan').value;
    fetch(`${API_BASE}/exams`, {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify({ course, program, section, date, timeslot, room, seatingPlan })
    }).then(() => {
        loadExams();
        this.reset();
    });
});

document.getElementById('generate-pdf-btn').addEventListener('click', function() {
    if (currentPdfType === 'timetable') {
        generatePdf();
    } else if (currentPdfType === 'exam') {
        generateExamPdf();
    }
});

// Load initial data
document.addEventListener('DOMContentLoaded', function() {
    showSection('courses');
});
