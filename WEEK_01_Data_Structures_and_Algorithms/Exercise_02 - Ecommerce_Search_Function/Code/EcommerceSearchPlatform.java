import java.util.Arrays;

public class EcommerceSearchPlatform {

    public static void sortProductsById(Product[] products) {
        for (int i = 1; i < products.length; i++) {
            Product key = products[i];
            int j = i - 1;

            while (j >= 0 && products[j].getProductId() > key.getProductId()) {
                products[j + 1] = products[j];
                j = j - 1;
            }
            products[j + 1] = key;
        }
    }

    public static void main(String[] args) {

        Product[] products = {
                new Product(1, "HP Victus", "Electronics"),
                new Product(5, "Samsung Galaxy A36 5G", "Electronics"),
                new Product(3, "US Polo Assn Off-White Shoes", "Footwear"),
                new Product(4, "Peter England T-Shirt", "Clothing"),
                new Product(2, "Boat Rockerz 510", "Wearables")
        };

        System.out.println("Performing Linear Search...");
        SearchService linearSearch = new LinearSearchService(products);
        Product linearResult = linearSearch.searchById(3);
        System.out.println("Linear Search Result: " + (linearResult != null ? linearResult : "Not found"));

        Product[] sortProducts = Arrays.copyOf(products, products.length);
        sortProductsById(sortProducts);

        System.out.println("Performing Binary Search...");
        SearchService binarySearch = new BinarySearchService(sortProducts);
        Product binaryResult = binarySearch.searchById(3);
        System.out.println("Binary Search Result: " + (binaryResult != null ? binaryResult : "Not found"));
    }
}
