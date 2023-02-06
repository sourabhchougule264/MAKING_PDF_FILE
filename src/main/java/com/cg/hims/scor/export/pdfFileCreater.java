package com.cg.hims.scor.export;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.List;

import com.cg.hims.scor.entity.EmployeeDetails;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

public class pdfFileCreater {

	

	public static ByteArrayInputStream contactListToPdfFile(List<EmployeeDetails> empInfo) throws DocumentException {
		
		Document document=new Document(PageSize.A4);
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		
		PdfWriter pdfWriter = PdfWriter.getInstance(document, outputStream);
	    FontFamily fontFamily = FontFamily.HELVETICA;
/***************************************************************************************************/	    
	    Font fontHeader= new Font(fontFamily,26,Font.BOLD);
	    fontHeader.setColor(BaseColor.WHITE);
/***************************************************************************************************/
	    Font fontTableHeader = new Font(fontFamily,16,Font.BOLD);
	    fontTableHeader.setColor(BaseColor.WHITE);
/****************************************************************************************************/
	    Font fonttableContent = new Font(fontFamily,12,Font.NORMAL);
	    fonttableContent.setColor(BaseColor.BLACK);
/****************************************************************************************************/	    
	    document.setPageSize(PageSize.A4.rotate());
	    document.setMargins(50, 45, 25, 25);
	    document.setMarginMirroring(false);
	    Rectangle rect = new Rectangle(30, 30, 550, 800);
	    pdfWriter.setBoxSize("art", rect);
	   
	    document.open();
	    
	 // PARAGRAPH ADDING IN DOCUMENT
	    float[] title_widths = {280f,280f};
        PdfPTable table1 = new PdfPTable(title_widths);
        PdfPCell cellh = new PdfPCell(new Phrase("EMPLOYEE DETAILS",fontHeader));
        cellh.setBackgroundColor(BaseColor.GRAY);
        cellh.setBorder(Rectangle.BOX);
        cellh.setHorizontalAlignment(Element.ALIGN_CENTER);
        cellh.setVerticalAlignment(Element.ALIGN_CENTER);
        table1.addCell(cellh);
        
        PdfPCell cellk = new PdfPCell(new Phrase("CAPGEMINI INDIA\nSCOR ANTARES PROJECT\nPUNE OFFICE\nTALAWADE",fontTableHeader));
        cellk.setBackgroundColor(BaseColor.GRAY);
        cellk.setBorder(Rectangle.BOX);
        cellk.setHorizontalAlignment(Element.ALIGN_CENTER);
        cellk.setVerticalAlignment(Element.ALIGN_CENTER);
        table1.addCell(cellk);
        
        document.add(table1);
       
	// PARAGRAPH ADDING FOR BLANK SPACE
	   document.add(new Paragraph("\n"));
        
        
	//TABLE ADDING IN DOCUMENTS FROM LIST<OBJECTS>
	    float[] header_columnWidths = {2f,2f,2f,4f};
	    PdfPTable table = new PdfPTable(header_columnWidths);
	    table.setWidthPercentage(100);
	    
	    String[] headerData = {"EmpID","First Name","Last Name","Email"};
	    
	    for(int i=0;i<headerData.length;i++)
	    {
	    	PdfPCell cell = new PdfPCell(new Phrase(headerData[i],fontTableHeader));
	    	cell.setHorizontalAlignment(Element.ALIGN_CENTER);
	    	cell.setVerticalAlignment(Element.ALIGN_CENTER);
	    	cell.setBackgroundColor(BaseColor.BLUE);
	    	table.addCell(cell);
	    }
	    
	    for(EmployeeDetails emp : empInfo)
	    {
	    	PdfPCell cell1=new PdfPCell(new Paragraph(String.valueOf(emp.getEmployeeId()),fonttableContent));	    	
	    	cell1.setBackgroundColor(BaseColor.GRAY);
	    	table.addCell(cell1);
	    	PdfPCell cell2 = new PdfPCell(new Phrase(emp.getEmpFirstName(),fonttableContent));
	    	cell2.setBackgroundColor(BaseColor.CYAN);
	    	table.addCell(cell2);
	    	PdfPCell cell3 = new PdfPCell(new Phrase(emp.getEmpLastName(),fonttableContent));
	    	cell3.setBackgroundColor(BaseColor.GRAY);
	    	table.addCell(cell3);
	    	PdfPCell cell4 = new PdfPCell(new Phrase(emp.getEmpMail(),fonttableContent));
	    	cell4.setBackgroundColor(BaseColor.MAGENTA);
	    	table.addCell(cell4);
	    	
	    }
	    document.add(table);
	    document.close();
	    pdfWriter.close();
	    
	    return new ByteArrayInputStream(outputStream.toByteArray());
		
	}
}
