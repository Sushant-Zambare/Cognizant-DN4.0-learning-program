package factories;

import documents.ConcretePdfDocument;
import documents.PdfDocument;

public class PdfDocumentFactory extends DocumentFactory{
    @Override
    public PdfDocument createDocument() {
        ConcretePdfDocument pdfDocument = new ConcretePdfDocument();
        return pdfDocument;
    }
}
