package com.wrn.handlefiles.service.imp;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Logger;

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
	
	private static final Logger LOGGIN = Logger.getLogger(ExcelFileAdapterServiceImp.class.getName());
	
	@Autowired
	private EventsRepository repository;

	@Override
	public Long processExcelFile(String excelFilePath) {
		LOGGIN.info("Starting process " + LocalDateTime.now());
		Long quantity = 0L;
		File file = new File(excelFilePath);
		try (Workbook workbook = new XSSFWorkbook(new FileInputStream(file))) {
			Sheet firstSheet = workbook.getSheetAt(0);
			Iterator<Row> rowIterator = firstSheet.iterator();
			rowIterator.next();
			List<Events> eventsList = new ArrayList<>();
			while (rowIterator.hasNext()) {
				eventsList.add(new Events(rowIterator.next()));
				if(eventsList.size() > 10000) {
					repository.saveAll(eventsList);
					eventsList = new ArrayList<>();
				}
				quantity ++;
			}
			if(eventsList.size() > 1) {
				repository.saveAll(eventsList);
			}
			LOGGIN.info("End process " + LocalDateTime.now());
		} catch (IOException ex1) {
			return quantity;
		}
		return quantity;
	}
}
