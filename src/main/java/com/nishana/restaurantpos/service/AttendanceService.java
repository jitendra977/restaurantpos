package com.nishana.restaurantpos.service;

import com.nishana.restaurantpos.model.Attendance;
import com.nishana.restaurantpos.repository.AttendanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class AttendanceService {

    @Autowired
    private AttendanceRepository attendanceRepository;

    public List<Attendance> getAllAttendanceRecords() {
        return attendanceRepository.findAll();
    }

    public Attendance createAttendance(Attendance attendance) {
        attendance.setCheckIn(LocalDateTime.now());  // Set the check-in time
        return attendanceRepository.save(attendance);
    }

    public List<Attendance> getAttendanceByUserId(Long userId) {
        return attendanceRepository.findByUser_UserId(userId);
    }

    public Attendance checkoutUser(Long userId) {
        // Find the last attendance record for the user
        List<Attendance> attendances = attendanceRepository.findByUser_UserId(userId);
        if (!attendances.isEmpty()) {
            Attendance latestAttendance = attendances.get(attendances.size() - 1);
            latestAttendance.setCheckOut(LocalDateTime.now());  // Set the checkout time
            return attendanceRepository.save(latestAttendance);
        }
        return null;  // Handle the case where no attendance record exists
    }
}