import java.util.Arrays;

public class LinearSearchService implements SearchService {
    private final Product[] products;

    public LinearSearchService(Product[] products) {
        this.products = products;
    }

    @Override
    public Product searchById(int productId) {
        return Arrays.stream(products)
                .filter(product -> product.getProductId() == productId)
                .findFirst()
                .orElse(null);
    }
}
