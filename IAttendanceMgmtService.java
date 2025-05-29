package com.nt.service;

import java.util.List;
import com.nt.entity.Attendance;

public interface IAttendanceMgmtService {
	List<Attendance> showAllRecords();
	String markAttendance(Attendance attendance);
	Attendance fetchAttendanceById(int id);
	String editAttendance(Attendance attendance);
	String deleteAttendance(int id);
}
