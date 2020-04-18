package com.wrn.handlefiles.model;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "events")
public class Events implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	private String id;
	
	private Integer year;
	
	private String trimester;
	
	private String month;
	
	private Integer	day;
	
	private String guiche;
	
	private LocalDateTime hour;
	
	private LocalDateTime hourAgLocal;
	
	private String code;
	
	private String priority;
	
	private String answer;
	
	private String section;
	
	private String password;
	
	private String service;
	
	private String eventType;
	
	private String attendants;	
	
	private String activities;	
	
	private String avaliation;	
	
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
		this.id = password.concat(code).concat(hour.toString());
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

	public String getId() {
		return id;
	}

	public Integer getYear() {
		return year;
	}

	public String getTrimester() {
		return trimester;
	}

	public String getMonth() {
		return month;
	}

	public Integer getDay() {
		return day;
	}

	public String getGuiche() {
		return guiche;
	}

	public LocalDateTime getHour() {
		return hour;
	}

	public LocalDateTime getHourAgLocal() {
		return hourAgLocal;
	}

	public String getCode() {
		return code;
	}

	public String getPriority() {
		return priority;
	}

	public String getAnswer() {
		return answer;
	}

	public String getSection() {
		return section;
	}

	public String getPassword() {
		return password;
	}

	public String getService() {
		return service;
	}

	public String getEventType() {
		return eventType;
	}

	public String getAttendants() {
		return attendants;
	}

	public String getActivities() {
		return activities;
	}

	public String getAvaliation() {
		return avaliation;
	}

	public String getCategory() {
		return category;
	}
}
