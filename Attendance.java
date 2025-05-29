package com.nt.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="JPA_ATTENDANCE")
@Data
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
public class Attendance {
	@Id
	@SequenceGenerator(name="gen1", sequenceName="ATTENDANCE_SEQ", initialValue=1000, allocationSize=1)
	@GeneratedValue(generator="gen1", strategy=GenerationType.SEQUENCE)
	private Integer id;

	@Column(length=30)
	@NonNull
	private String employeeName;

	@Column(length=30)
	@NonNull
	private String department;

	@NonNull
	private LocalDateTime attendanceDate;

	@Column(length=15)
	@NonNull
	private String status;  // Present / Absent / Leave

	@CreationTimestamp
	@Column(updatable=false)
	private LocalDateTime createDate;

	@UpdateTimestamp
	@Column(insertable=false)
	private LocalDateTime updateDate;

	@Version
	private Integer updateCount;

	@Column(length=20, updatable=false)
	private String createdBy;

	@Column(length=20, insertable=false)
	private String updatedBy;
}
