import java.util.*;
import java.util.stream.*;
import java.util.function.*;
import java.util.Map.Entry;

public class ProductStreamProcessor {
    public static void main(String[] args) {
        List<Product> products = Arrays.asList(
            new Product("iPhone", "Electronics", 999.99),
            new Product("Samsung TV", "Electronics", 1299.49),
            new Product("T-shirt", "Clothing", 29.99),
            new Product("Jeans", "Clothing", 59.99),
            new Product("Blender", "Home Appliances", 149.99),
            new Product("Vacuum Cleaner", "Home Appliances", 199.99),
            new Product("Laptop", "Electronics", 1499.99)
        );

        // 1. Group products by category
        System.out.println("🔹 Products Grouped by Category:");
        Map<String, List<Product>> groupedByCategory = products.stream()
                .collect(Collectors.groupingBy(Product::getCategory));

        groupedByCategory.forEach((category, productList) -> {
            System.out.println(category + ": " + productList);
        });

        // 2. Most expensive product in each category
        System.out.println("\n🔹 Most Expensive Product in Each Category:");
        Map<String, Optional<Product>> maxByCategory = products.stream()
                .collect(Collectors.groupingBy(
                        Product::getCategory,
                        Collectors.maxBy(Comparator.comparingDouble(Product::getPrice))
                ));

        maxByCategory.forEach((category, product) -> {
            System.out.println(category + ": " + product.orElse(null));
        });

        // 3. Average price of all products
        double averagePrice = products.stream()
                .mapToDouble(Product::getPrice)
                .average()
                .orElse(0.0);

        System.out.printf("\n🔹 Average Price of All Products: $%.2f\n", averagePrice);
    }
}
