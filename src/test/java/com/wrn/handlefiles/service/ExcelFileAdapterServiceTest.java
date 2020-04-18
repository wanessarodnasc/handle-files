package com.wrn.handlefiles.service;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.wrn.handlefiles.service.imp.ExcelFileAdapterServiceImp;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ExcelFileAdapterServiceTest {
	
	@Autowired
	private ExcelFileAdapterServiceImp service;

	@Test
	void testExcelFileReader() {
		String excelFilePath = "C:\\Users\\wanes\\workspace\\handle-files\\src\\main\\resources\\static\\DadosSetembro2019.xlsx";
		Long readed = service.processExcelFile(excelFilePath);
		assertTrue(readed > 2999);
	}
}
