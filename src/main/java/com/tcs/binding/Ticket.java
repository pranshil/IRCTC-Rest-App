package com.tcs.binding;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;

@Entity
@Data
@Table(name="TICKET")
public class Ticket {

	@Id
	@Column(name="PNR")
	private int pnr;
	
	@Column(name="NAME")
	private String name;
	
	@Column(name="LOCATION")
	private String location;
	
	@CreationTimestamp
	@Column(name="CREATE_DATE", updatable=false)
	private LocalDate createDate;
	
	@UpdateTimestamp
	@Column(name="UPDATE_DATE", insertable=true)
	private LocalDate updateDate;
	
	@Column(name="ACTIVE_SWITCH")
	private String activeSw;
}
