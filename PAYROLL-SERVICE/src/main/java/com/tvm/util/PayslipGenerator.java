package com.tvm.util;

import com.lowagie.text.*;
import com.lowagie.text.pdf.PdfWriter;
import com.tvm.entity.Payroll;
import org.springframework.context.annotation.Configuration;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

@Configuration
public class PayslipGenerator {

    public static ByteArrayInputStream generatePayslip(Payroll payroll) {
        Document document = new Document();
        ByteArrayOutputStream out = new ByteArrayOutputStream();

        try {
            PdfWriter.getInstance(document, out);
            document.open();

            Font titleFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 16);
            Font normalFont = FontFactory.getFont(FontFactory.HELVETICA, 12);

            Paragraph title = new Paragraph("Employee Payslip", titleFont);
            title.setAlignment(Element.ALIGN_CENTER);
            document.add(title);
            document.add(Chunk.NEWLINE);

            document.add(new Paragraph("Employee ID: " + payroll.getEmployeeId(), normalFont));
            document.add(new Paragraph("Month: " + payroll.getMonth(), normalFont));
            document.add(new Paragraph("Year: " + payroll.getYear(), normalFont));
            document.add(new Paragraph("Basic Salary: ₹" + payroll.getBasicSalary(), normalFont));
            document.add(new Paragraph("Bonus: ₹" + payroll.getBonus(), normalFont));
            document.add(new Paragraph("Deductions: ₹" + payroll.getDeductions(), normalFont));
            document.add(new Paragraph("Net Pay: ₹" + payroll.getNetPay(), normalFont));

            document.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return new ByteArrayInputStream(out.toByteArray());

    }
//    public static ByteArrayInputStream generatePayslipPdf(Payroll payroll) {
//        // Sample dummy PDF generation logic (you can replace this with actual logic)
//        String content = "Payslip for Employee ID: " + payroll.getEmployeeId()
//                + "\nMonth: " + payroll.getMonth()
//                + "\nYear: " + payroll.getYear()
//                + "\nNet Pay: " + payroll.getNetPay();
//
//        return new ByteArrayInputStream(content.getBytes());
//}
}
