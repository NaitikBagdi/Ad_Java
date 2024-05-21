package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor

@Entity
@Table(name = "student")
public class Student {

	@Id
	@javax.persistence.GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int studentId;

	@Column(name = "student_name")
	private String studentName;

	@Column(name = "address")
	private String address;

	@Column(name = "pincode")
	private int pincode;

	public Student(String studentName, String address, int pincode) {
		super();
		this.studentName = studentName;
		this.address = address;
		this.pincode = pincode;
	}

	
}
