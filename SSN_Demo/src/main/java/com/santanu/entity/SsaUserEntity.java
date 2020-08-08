package com.santanu.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="SSA_USER_MASTER")
public class SsaUserEntity implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GenericGenerator(name = "IdGenerator",
    strategy = "com.santanu.generators.IdGenerator",
    parameters = {
        @Parameter(name = "sequence", value = "ssn_id_sequence")
    })
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "IdGenerator")
	@Column(name="SSN")
	private long ssn;
	
	@Column(name="FIRST_NAME")
	private String firstName;
	
	@Column(name="LAST_NAME")
	private String lastName;

	@Column(name="GENDER")
	private String gender;
	
	@Column(name="DOB")
	@DateTimeFormat(pattern = "yyyy-mm-dd")
	private Date dob;
	
	@Column(name="STATE_NAME")
	private String stateName;
	
	@CreationTimestamp
	@Temporal(TemporalType.DATE)
	@Column(name="CREATED_DATE",updatable = false)
	private Date createdDate;
	
	@UpdateTimestamp	
	@Temporal(TemporalType.DATE)
	@Column(name="UPDATED_DATE",insertable = false)
	private Date updatedDate;
}
