package com.example.demo.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Patient")
public class Patient {

	
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private long id;
		@Column(name = "first_name")
		private String fname;
		@Column(name = "last_name")
		private String lname;
		@Column(name = "email_id")
		private String emailId;
		@Column(name = "mobile")
		private String mobile;
		@Column(name = "Date_of_Birth")
		private String dob;
		@Column(name = "blood_group")
		private String bloodgroup;
		@Column(name = "address")
		private String address;
		public Patient(String fname, String lname, String emailId, String mobile, String dob, String bloodgroup,
				String address) {
			super();
			this.fname = fname;
			this.lname = lname;
			this.emailId = emailId;
			this.mobile = mobile;
			this.dob = dob;
			this.bloodgroup = bloodgroup;
			this.address = address;
		}

		public Patient() {
			
		}

		public long getId() {
			return id;
		}

		public void setId(long id) {
			this.id = id;
		}

		public String getFname() {
			return fname;
		}

		public void setFname(String fname) {
			this.fname = fname;
		}

		public String getLname() {
			return lname;
		}

		public void setLname(String lname) {
			this.lname = lname;
		}

		public String getEmailId() {
			return emailId;
		}

		public void setEmailId(String emailId) {
			this.emailId = emailId;
		}

		public String getMobile() {
			return mobile;
		}

		public void setMobile(String mobile) {
			this.mobile = mobile;
		}

		public String getDob() {
			return dob;
		}

		public void setDob(String dob) {
			this.dob = dob;
		}

		public String getBloodgroup() {
			return bloodgroup;
		}

		public void setBloodgroup(String bloodgroup) {
			this.bloodgroup = bloodgroup;
		}

		public String getAddress() {
			return address;
		}

		public void setAddress(String address) {
			this.address = address;
		}

		

		
		

}
