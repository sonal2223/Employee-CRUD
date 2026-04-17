package com.example.gtt.service;

import com.example.gtt.entity.Attendance;
import com.example.gtt.entity.Employee;
import com.example.gtt.repository.AttendanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class AttendanceService {

    @Autowired
    private AttendanceRepository attendanceRepository;

    @Autowired
    private EmployeeService employeeService;

    // ✅ CREATE
    public Attendance markAttendance(Long employeeId, LocalDate date, String status) {

        if (date.isAfter(LocalDate.now())) {
            throw new RuntimeException("Future date not allowed");
        }

        if (!status.equals("PRESENT") && !status.equals("ABSENT")) {
            throw new RuntimeException("Invalid status");
        }

        if (attendanceRepository.existsByEmployeeIdAndDate(employeeId, date)) {
            throw new RuntimeException("Attendance already marked for this day");
        }

        Employee employee = employeeService.getEmployeeById(employeeId);

        Attendance attendance = new Attendance();
        attendance.setEmployee(employee);
        attendance.setDate(date);
        attendance.setStatus(status);

        return attendanceRepository.save(attendance);
    }

    // ✅ READ
    public List<Attendance> getAttendanceByEmployee(Long employeeId) {
        return attendanceRepository.findByEmployeeId(employeeId);
    }

    // ✅ UPDATE
    public Attendance updateAttendance(Long employeeId, LocalDate date, String status) {

        Attendance attendance = attendanceRepository
                .findByEmployeeIdAndDate(employeeId, date)
                .orElseThrow(() -> new RuntimeException("Attendance not found"));

        attendance.setStatus(status);
        return attendanceRepository.save(attendance);
    }

    // ✅ DELETE
    public void deleteAttendance(Long employeeId, LocalDate date) {

        Attendance attendance = attendanceRepository
                .findByEmployeeIdAndDate(employeeId, date)
                .orElseThrow(() -> new RuntimeException("Attendance not found"));

        attendanceRepository.delete(attendance);
    }
}
