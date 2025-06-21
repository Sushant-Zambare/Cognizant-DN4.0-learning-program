package documents;

public class ConcreteWordDocument implements WordDocument{
    @Override
    public void createWordDocument() {
        System.out.println("Word document created");
    }
}
