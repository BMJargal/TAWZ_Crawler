/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tawz_crawler;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import javax.swing.JTable;
import java.io.FileNotFoundException;
import javax.swing.table.DefaultTableModel;

/**
 * Utility class for generating PDF documents from a JTable. Uses iTextPDF
 * library for PDF generation.
 *
 * @author BMJargal
 * @since 1.0
 */
public class pdf
{

    /**
     * Prints the content of a JTable to a PDF file.
     *
     * @param table The JTable to be printed to PDF.
     * @throws FileNotFoundException If the specified file is not found.
     */
    public static void printer(JTable table) throws FileNotFoundException
    {
        // File path for the generated PDF
        String path = "TableData.pdf";

        // Initialize PdfWriter, PdfDocument, and Document objects
        PdfWriter pdfWriter = new PdfWriter(path);
        PdfDocument pdfDocument = new PdfDocument(pdfWriter);
        Document document = new Document(pdfDocument);

        // Get the model of the provided JTable
        DefaultTableModel model = (DefaultTableModel) table.getModel();

        // Create an iTextPDF Table with the number of columns equal to the column count of the JTable
        Table pdfTable = new Table(model.getColumnCount());

        // Add column names to the PDF table
        for (int col = 0; col < model.getColumnCount(); col++)
        {
            pdfTable.addCell(new Paragraph(model.getColumnName(col)));
        }

        // Populate the PDF table with cell values from the JTable
        for (int row = 0; row < model.getRowCount(); row++)
        {
            for (int col = 0; col < model.getColumnCount(); col++)
            {
                Object cellValue = model.getValueAt(row, col);
                pdfTable.addCell(cellValue.toString());
            }
        }

        // Add the PDF table to the document and close the document
        document.add(pdfTable);
        document.close();
    }
}
