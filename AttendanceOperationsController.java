package com.nt.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.nt.entity.Attendance;
import com.nt.service.IAttendanceMgmtService;

import jakarta.servlet.http.HttpSession;

@Controller
public class AttendanceOperationsController {
	
	@Autowired
	private IAttendanceMgmtService attendanceService;

	@GetMapping("/")
	public String showHomePage() {
		return "Welcome";
	}

	@GetMapping("/report")
	public String showReport(Map<String, Object> map) {
		List<Attendance> list = attendanceService.showAllRecords();
		map.put("listRecords", list);
		System.out.println("AttendanceOperationsController.showReport()");
		return "show_attendance_report";
	}

	@GetMapping("/mark")
	public String showFormForMarkAttendance(@ModelAttribute("attendance") Attendance attendance) {
		return "attendance_mark_form";
	}

	@PostMapping("/mark")
	public String markAttendance(@ModelAttribute("attendance") Attendance attendance, HttpSession ses) {
		String msg = attendanceService.markAttendance(attendance);
		ses.setAttribute("resultMsg", msg);
		return "redirect:report";
	}

	@GetMapping("/edit")
	public String editAttendanceForm(@ModelAttribute("attendance") Attendance attendance, @RequestParam("id") int id) {
		Attendance att = attendanceService.fetchAttendanceById(id);
		BeanUtils.copyProperties(att, attendance);
		return "attendance_edit_form";
	}

	@PostMapping("/edit")
	public String editAttendance(@ModelAttribute("attendance") Attendance attendance, RedirectAttributes attrs) {
		String msg = attendanceService.editAttendance(attendance);
		attrs.addFlashAttribute("resultMsg", msg);
		return "redirect:report";
	}

	@GetMapping("/delete")
	public String deleteAttendance(@RequestParam("id") int id, RedirectAttributes attrs) {
		String msg = attendanceService.deleteAttendance(id);
		attrs.addFlashAttribute("resultMsg", msg);
		return "redirect:report";
	}
}
