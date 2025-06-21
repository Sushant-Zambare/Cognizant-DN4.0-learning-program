package factories;

import documents.ConcreteWordDocument;
import documents.WordDocument;

public class WordDocumentFactory extends DocumentFactory{
    @Override
    public WordDocument createDocument() {
        ConcreteWordDocument wordDocument = new ConcreteWordDocument();
        return wordDocument;
    }
}
