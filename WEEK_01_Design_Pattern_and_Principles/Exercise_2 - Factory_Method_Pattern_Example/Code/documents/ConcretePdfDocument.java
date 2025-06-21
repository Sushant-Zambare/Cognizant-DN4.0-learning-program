package documents;

public class ConcretePdfDocument implements PdfDocument{
    @Override
    public void createPdfDocument() {
        System.out.println("PDF document created");
    }
}
