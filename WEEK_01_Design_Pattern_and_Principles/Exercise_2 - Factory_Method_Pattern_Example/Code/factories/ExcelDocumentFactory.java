package factories;

import documents.ConcreteExcelDocument;
import documents.ExcelDocument;

public class ExcelDocumentFactory extends DocumentFactory{
    @Override
    public ExcelDocument createDocument() {
        ConcreteExcelDocument excelDocument = new ConcreteExcelDocument();
        return excelDocument;
    }
}
