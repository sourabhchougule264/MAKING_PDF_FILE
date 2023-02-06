package com.cg.hims.scor.controller;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cg.hims.scor.entity.EmployeeDetails;
import com.cg.hims.scor.export.pdfFileCreater;
import com.itextpdf.text.DocumentException;


@Controller
public class DownloadPDF {

	@RequestMapping("/")
    public String index() {
        return "index";
    }
	
	@GetMapping("/download/EmployeeDetails.pdf")
    public void downloadCsv(HttpServletResponse response) throws IOException, DocumentException {
        response.setContentType("application/octet-stream");
        response.setHeader("Content-Disposition", "attachment; filename=EmployeeDetails.pdf");
        ByteArrayInputStream stream = pdfFileCreater.contactListToPdfFile(testInfo());
        IOUtils.copy(stream, response.getOutputStream());
    }
	
	private List<EmployeeDetails> testInfo(){
    	List<EmployeeDetails> empinfo = new ArrayList<EmployeeDetails>();
    	empinfo.add(new EmployeeDetails(101,"Sahstranshu","Dubey","dubeysah@gmail.com"));
    	empinfo.add(new EmployeeDetails(102, "Dakshta", "Metkari", "metkariDaksh@gmail.com"));
    	empinfo.add(new EmployeeDetails(103, "Vrinda", "Nagar", "nagarvrin@gmail.com"));
    	empinfo.add(new EmployeeDetails(104, "Amol", "Bidwe", "bidweamo@gmail.com"));
    	empinfo.add(new EmployeeDetails(105, "Suraj", "Suryavanshi", "suryavanshisurj@gmail.com"));
    	return empinfo;
    }
	
}
