package com.santanu.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="SSA_STATES")

public class StatesEntity implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="STATE_ID")
	private Integer ssn;
	
	@Column(name="STATE_NAME")
	private String stateName;
}
