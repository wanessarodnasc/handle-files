package com.wrn.handlefiles.service.imp;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wrn.handlefiles.model.Events;
import com.wrn.handlefiles.repositoty.EventsRepository;
import com.wrn.handlefiles.service.ExcelFileAdapterService;

@Service
public class ExcelFileAdapterServiceImp implements ExcelFileAdapterService{
	
	@Autowired
	private EventsRepository repository;

	@Override
	public Long processExcelFile(String excelFilePath) {
		Long quantity = 0L;
		File file = new File(excelFilePath);
		try (Workbook workbook = new XSSFWorkbook(new FileInputStream(file))) {
			Sheet firstSheet = workbook.getSheetAt(0);
			Iterator<Row> rowIterator = firstSheet.iterator();
			rowIterator.next();
			while (rowIterator.hasNext()) {
				Row nextRow = rowIterator.next();
				Events events = new Events(nextRow);
				repository.save(events);
				quantity ++;
			}
		} catch (IOException ex1) {
			return quantity;
		}
		return quantity;
	}
}
