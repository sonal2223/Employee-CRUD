package com.example.gtt.controller;

import com.example.gtt.entity.Attendance;
import com.example.gtt.service.AttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/attendance")
public class AttendanceController {

    @Autowired
    private AttendanceService attendanceService;

    // ✅ CREATE
    @PostMapping
    public ResponseEntity<Attendance> markAttendance(@RequestBody Map<String, String> request) {

        Long employeeId = Long.parseLong(request.get("employeeId"));
        LocalDate date = LocalDate.parse(request.get("date"));
        String status = request.get("status");

        return ResponseEntity.ok(
                attendanceService.markAttendance(employeeId, date, status)
        );
    }

    // ✅ READ
    @GetMapping("/employee/{employeeId}")
    public ResponseEntity<List<Attendance>> getAttendanceByEmployee(
            @PathVariable Long employeeId) {

        return ResponseEntity.ok(
                attendanceService.getAttendanceByEmployee(employeeId)
        );
    }

    // ✅ UPDATE
    @PutMapping
    public ResponseEntity<Attendance> updateAttendance(@RequestBody Map<String, String> request) {

        Long employeeId = Long.parseLong(request.get("employeeId"));
        LocalDate date = LocalDate.parse(request.get("date"));
        String status = request.get("status");

        return ResponseEntity.ok(
                attendanceService.updateAttendance(employeeId, date, status)
        );
    }

    // ✅ DELETE
    @DeleteMapping
    public ResponseEntity<String> deleteAttendance(@RequestBody Map<String, String> request) {

        Long employeeId = Long.parseLong(request.get("employeeId"));
        LocalDate date = LocalDate.parse(request.get("date"));

        attendanceService.deleteAttendance(employeeId, date);
        return ResponseEntity.ok("Attendance deleted successfully");
    }
}
