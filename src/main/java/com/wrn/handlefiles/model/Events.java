package com.wrn.handlefiles.model;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;


@Entity
public class Events implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID id;
	
	@Column
	private Integer year;
	
	@Column
	private String trimester;
	
	@Column
	private String month;
	
	@Column
	private Integer	day;
	
	@Column
	private String guiche;
	
	@Column
	private LocalDateTime hour;
	
	@Column
	private LocalDateTime hourAgLocal;
	
	@Column
	private String code;
	
	@Column
	private String priority;
	
	@Column
	private String answer;
	
	@Column
	private String section;
	
	@Column
	private String password;
	
	@Column
	private String service;
	
	@Column
	private String eventType;
	
	@Column
	private String attendants;	
	
	@Column
	private String activities;	
	
	@Column
	private String avaliation;	
	
	@Column
	private String category;

	public Events() {
	}

	public Events(Row row) {
		this.year = convertIngerValue(row.getCell(0));
		this.trimester = convertStringValue(row.getCell(1));
		this.month = convertStringValue(row.getCell(2));
		this.day = convertIngerValue(row.getCell(3));
		this.guiche = convertStringValue(row.getCell(4));
		this.hour = getDataTime(row.getCell(5));
		this.hourAgLocal = getDataTime(row.getCell(6));
		this.code = convertStringValue(row.getCell(7));
		this.priority = convertStringValue(row.getCell(8));
		this.answer = convertStringValue(row.getCell(9));
		this.section = convertStringValue(row.getCell(10));
		this.password = convertStringValue(row.getCell(11));
		this.service = convertStringValue(row.getCell(12));
		this.eventType = convertStringValue(row.getCell(12));
		this.attendants = convertStringValue(row.getCell(14));
		this.activities = convertStringValue(row.getCell(15));
		this.avaliation = convertStringValue(row.getCell(16));
		this.category = convertStringValue(row.getCell(17));
	}

	private Integer convertIngerValue(Cell cell) {
		String valueString = convertStringValue(cell);
		return valueString.equals("") ? 0 : Double.valueOf(valueString).intValue();
	}
	
	private String convertStringValue(Cell cell) {
		return cell != null ? cell.toString() : "";
	}

	private LocalDateTime getDataTime(Cell cell) {
		if(cell == null) {
			return null;
		}
		String date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(cell.getDateCellValue());
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		return LocalDateTime.parse(date, formatter);
	}
}
