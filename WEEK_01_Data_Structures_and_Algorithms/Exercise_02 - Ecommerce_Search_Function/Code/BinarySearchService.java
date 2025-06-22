import java.util.Arrays;

public class BinarySearchService implements SearchService{
    private final Product[] sortedProducts;

    public BinarySearchService(Product[] sortedProducts) {
        this.sortedProducts = sortedProducts;
    }

    @Override
    public Product searchById(int productId) {
        int left = 0;
        int right = sortedProducts.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            Product midProduct = sortedProducts[mid];

            if (midProduct.getProductId() == productId) {
                return midProduct;
            } else if (midProduct.getProductId() < productId) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return null;
    }
}
