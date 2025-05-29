package com.nt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.nt.entity.Attendance;

public interface IAttendanceRepository extends JpaRepository<Attendance, Integer> {

}
