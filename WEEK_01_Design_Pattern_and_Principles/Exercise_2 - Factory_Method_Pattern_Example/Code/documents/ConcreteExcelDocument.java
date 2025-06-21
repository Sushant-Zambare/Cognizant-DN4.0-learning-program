package documents;

public class ConcreteExcelDocument implements ExcelDocument{
    @Override
    public void createExcelDocument() {
        System.out.println("Excel document created");
    }
}
