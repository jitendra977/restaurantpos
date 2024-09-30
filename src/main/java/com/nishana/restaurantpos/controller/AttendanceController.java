package com.nishana.restaurantpos.controller;

import com.nishana.restaurantpos.model.Attendance;
import com.nishana.restaurantpos.service.AttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/attendance")
public class AttendanceController {

    @Autowired
    private AttendanceService attendanceService;

    // Get all attendance records
    @GetMapping
    public List<Attendance> getAllAttendanceRecords() {
        return attendanceService.getAllAttendanceRecords();
    }

    // Create a new attendance (check-in)
    @PostMapping
    public Attendance createAttendance(@RequestBody Attendance attendance) {
        return attendanceService.createAttendance(attendance);
    }

    // Get attendance records by user ID
    @GetMapping("/user/{userId}")
    public List<Attendance> getAttendanceByUserId(@PathVariable Long userId) {
        return attendanceService.getAttendanceByUserId(userId);
    }

    // Update the attendance to mark a user's checkout
    @PutMapping("/checkout/{userId}")
    public Attendance checkoutUser(@PathVariable Long userId) {
        return attendanceService.checkoutUser(userId);
    }
}