import documents.*;
import factories.*;

public class FactoryMethodPatternExample {
    public static void main(String[] args) {

        DocumentFactory wordFactory = new WordDocumentFactory();
        WordDocument wordDoc = (WordDocument) wordFactory.createDocument();
        wordDoc.createWordDocument();

        DocumentFactory pdfFactory = new PdfDocumentFactory();
        PdfDocument pdfDoc = (PdfDocument) pdfFactory.createDocument();
        pdfDoc.createPdfDocument();

        DocumentFactory excelFactory = new ExcelDocumentFactory();
        ExcelDocument excelDoc = (ExcelDocument) excelFactory.createDocument();
        excelDoc.createExcelDocument();
    }
}
