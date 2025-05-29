package com.nt.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.entity.Attendance;
import com.nt.repository.IAttendanceRepository;

@Service
public class AttendanceMgmtServiceImpl implements IAttendanceMgmtService {

	@Autowired
	private IAttendanceRepository attendanceRepo;

	@Override
	public List<Attendance> showAllRecords() {
		return attendanceRepo.findAll();
	}

	@Override
	public String markAttendance(Attendance attendance) {
		attendance.setCreatedBy(System.getProperty("user.name"));
		int idVal = attendanceRepo.save(attendance).getId();
		return "Attendance marked with ID " + idVal;
	}

	@Override
	public Attendance fetchAttendanceById(int id) {
		return attendanceRepo.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid Attendance ID"));
	}

	@Override
	public String editAttendance(Attendance attendance) {
		Optional<Attendance> opt = attendanceRepo.findById(attendance.getId());
		if(opt.isPresent()) {
			Attendance oldAtt = opt.get();
			attendance.setUpdateCount(oldAtt.getUpdateCount());
			attendance.setUpdatedBy(System.getProperty("user.name"));
			attendanceRepo.save(attendance);
			return "Attendance ID " + attendance.getId() + " updated successfully";
		}
		return "Attendance ID " + attendance.getId() + " not found";
	}

	@Override
	public String deleteAttendance(int id) {
		Optional<Attendance> opt = attendanceRepo.findById(id);
		if(opt.isPresent()) {
			attendanceRepo.deleteById(id);
			return "Attendance ID " + id + " deleted successfully";
		}
		return "Attendance record not found";
	}
}
