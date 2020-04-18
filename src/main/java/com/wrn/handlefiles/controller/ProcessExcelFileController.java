package com.wrn.handlefiles.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.wrn.handlefiles.service.imp.ExcelFileAdapterServiceImp;

@RestController
public class ProcessExcelFileController {
	
	@Autowired
	private ExcelFileAdapterServiceImp service;
	
	@GetMapping
	public ResponseEntity<Long> processFile(@RequestBody String path)  {
		Long processed = service.processExcelFile(path);
    	return ResponseEntity.ok().body(processed);
    }
}
