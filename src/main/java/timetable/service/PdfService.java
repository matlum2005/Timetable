package timetable.service;

import java.io.ByteArrayOutputStream;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itextpdf.kernel.colors.ColorConstants;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.properties.TextAlignment;
import com.itextpdf.layout.properties.UnitValue;

import timetable.entity.Exam;
import timetable.entity.TimetableEntry;

@Service
public class PdfService {

    @Autowired
    private TimetableService timetableService;

    public byte[] generateTimetablePdf(String collegeName, String address, String department, String semester, String year) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PdfWriter writer = new PdfWriter(baos);
        PdfDocument pdfDoc = new PdfDocument(writer);
        Document document = new Document(pdfDoc);

        // Add college name with color
        Paragraph collegeNamePara = new Paragraph(collegeName)
                .setTextAlignment(TextAlignment.CENTER)
                .setFontSize(24)
                .setFontColor(ColorConstants.BLUE)
                .setBold();
        document.add(collegeNamePara);

        // Add address
        Paragraph addressPara = new Paragraph(address)
                .setTextAlignment(TextAlignment.CENTER)
                .setFontSize(14)
                .setFontColor(ColorConstants.DARK_GRAY);
        document.add(addressPara);

        // Add department
        Paragraph departmentPara = new Paragraph("Department of " + department)
                .setTextAlignment(TextAlignment.CENTER)
                .setFontSize(16)
                .setFontColor(ColorConstants.BLUE);
        document.add(departmentPara);

        // Add course and semester
        Paragraph courseSemester = new Paragraph("Course: B.Tech, Semester: " + semester + ", Year: " + year)
                .setTextAlignment(TextAlignment.CENTER)
                .setFontSize(14)
                .setFontColor(ColorConstants.DARK_GRAY);
        document.add(courseSemester);

        // Add title with color
        Paragraph title = new Paragraph("Timetable")
                .setTextAlignment(TextAlignment.CENTER)
                .setFontSize(18)
                .setFontColor(ColorConstants.RED)
                .setBold();
        document.add(title);

        // Add more space
        document.add(new Paragraph("\n\n"));

        // Create table with wider columns and colors
        float[] columnWidths = {2, 2, 2, 2, 2, 1.5f, 2}; // Adjust widths for better spacing
        Table table = new Table(columnWidths);
        table.setWidth(UnitValue.createPercentValue(100));

        // Header cells with background color
        table.addHeaderCell(new Cell().add(new Paragraph("Course")).setBackgroundColor(ColorConstants.CYAN).setBold());
        table.addHeaderCell(new Cell().add(new Paragraph("Professor")).setBackgroundColor(ColorConstants.CYAN).setBold());
        table.addHeaderCell(new Cell().add(new Paragraph("Room")).setBackgroundColor(ColorConstants.CYAN).setBold());
        table.addHeaderCell(new Cell().add(new Paragraph("Program")).setBackgroundColor(ColorConstants.CYAN).setBold());
        table.addHeaderCell(new Cell().add(new Paragraph("Section")).setBackgroundColor(ColorConstants.CYAN).setBold());
        table.addHeaderCell(new Cell().add(new Paragraph("Day")).setBackgroundColor(ColorConstants.CYAN).setBold());
        table.addHeaderCell(new Cell().add(new Paragraph("Time")).setBackgroundColor(ColorConstants.CYAN).setBold());

        List<TimetableEntry> entries = timetableService.getAllTimetableEntries();
        for (TimetableEntry entry : entries) {
            table.addCell(entry.getCourse().getName());
            table.addCell(entry.getProfessor().getName());
            table.addCell(entry.getRoom().getName());
            table.addCell(entry.getProgram() != null ? entry.getProgram().getName() : "");
            table.addCell(entry.getSection() != null ? entry.getSection().getName() : "");
            table.addCell(entry.getTimeslot().getDayOfWeek());
            String startTime = entry.getTimeslot().getStartTime().toString().substring(0, 5);
            String endTime = entry.getTimeslot().getEndTime().toString().substring(0, 5);
            table.addCell(startTime + " - " + endTime);
        }

        document.add(table);
        document.close();

        return baos.toByteArray();
    }

    public byte[] generateExamPdf(String collegeName, String address, String department, String semester, String year) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PdfWriter writer = new PdfWriter(baos);
        PdfDocument pdfDoc = new PdfDocument(writer);
        Document document = new Document(pdfDoc);

        // Add college name with color
        Paragraph collegeNamePara = new Paragraph(collegeName)
                .setTextAlignment(TextAlignment.CENTER)
                .setFontSize(24)
                .setFontColor(ColorConstants.BLUE)
                .setBold();
        document.add(collegeNamePara);

        // Add address
        Paragraph addressPara = new Paragraph(address)
                .setTextAlignment(TextAlignment.CENTER)
                .setFontSize(14)
                .setFontColor(ColorConstants.DARK_GRAY);
        document.add(addressPara);

        // Add title with color
        Paragraph title = new Paragraph("Exam Schedule")
                .setTextAlignment(TextAlignment.CENTER)
                .setFontSize(18)
                .setFontColor(ColorConstants.RED)
                .setBold();
        document.add(title);

        // Add department
        Paragraph departmentPara = new Paragraph("Department of " + department)
                .setTextAlignment(TextAlignment.CENTER)
                .setFontSize(16)
                .setFontColor(ColorConstants.BLUE);
        document.add(departmentPara);

        // Add course and semester
        Paragraph courseSemester = new Paragraph("Course: B.Tech, Semester: " + semester + ", Year: " + year)
                .setTextAlignment(TextAlignment.CENTER)
                .setFontSize(14)
                .setFontColor(ColorConstants.DARK_GRAY);
        document.add(courseSemester);

        // Add current date
        java.time.LocalDate currentDate = java.time.LocalDate.now();
        Paragraph date = new Paragraph("Date: " + currentDate.toString())
                .setTextAlignment(TextAlignment.CENTER)
                .setFontSize(12)
                .setFontColor(ColorConstants.DARK_GRAY);
        document.add(date);

        // Add more space
        document.add(new Paragraph("\n\n"));

        // Create exam table
        float[] examColumnWidths = {2, 2, 2, 2, 2, 2, 2, 3}; // Adjust widths for 8 columns
        Table examTable = new Table(examColumnWidths);
        examTable.setWidth(UnitValue.createPercentValue(100));

        // Exam header cells
        examTable.addHeaderCell(new Cell().add(new Paragraph("Course")).setBackgroundColor(ColorConstants.GREEN).setBold());
        examTable.addHeaderCell(new Cell().add(new Paragraph("Program")).setBackgroundColor(ColorConstants.GREEN).setBold());
        examTable.addHeaderCell(new Cell().add(new Paragraph("Section")).setBackgroundColor(ColorConstants.GREEN).setBold());
        examTable.addHeaderCell(new Cell().add(new Paragraph("Date")).setBackgroundColor(ColorConstants.GREEN).setBold());
        examTable.addHeaderCell(new Cell().add(new Paragraph("Timeslot")).setBackgroundColor(ColorConstants.GREEN).setBold());
        examTable.addHeaderCell(new Cell().add(new Paragraph("Room")).setBackgroundColor(ColorConstants.GREEN).setBold());
        examTable.addHeaderCell(new Cell().add(new Paragraph("Lecture")).setBackgroundColor(ColorConstants.GREEN).setBold());
        examTable.addHeaderCell(new Cell().add(new Paragraph("Seating Plan")).setBackgroundColor(ColorConstants.GREEN).setBold());

        List<Exam> exams = timetableService.getAllExams();
        for (Exam exam : exams) {
            examTable.addCell(exam.getCourse().getName());
            examTable.addCell(exam.getProgram().getName());
            examTable.addCell(exam.getSection().getName());
            examTable.addCell(exam.getDate().toString());
            String startTime = exam.getTimeslot().getStartTime().toString().substring(0, 5);
            String endTime = exam.getTimeslot().getEndTime().toString().substring(0, 5);
            examTable.addCell(exam.getTimeslot().getDayOfWeek() + " " + startTime + "-" + endTime);
            examTable.addCell(exam.getRoom().getName());
            examTable.addCell(""); // Placeholder for Lecture column
            examTable.addCell(exam.getSeatingPlan());
        }

        document.add(examTable);
        document.close();

        return baos.toByteArray();
    }
}
