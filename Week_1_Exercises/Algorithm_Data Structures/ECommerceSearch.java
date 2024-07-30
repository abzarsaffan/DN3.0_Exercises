package com.mycompany.week1;


import java.util.Arrays;
import java.util.Scanner;

class Product implements Comparable<Product> {
    private int productId;
    private String productName;
    private String category;

    public Product(int productId, String productName, String category) {
        this.productId = productId;
        this.productName = productName;
        this.category = category;
    }

    public int getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public String getCategory() {
        return category;
    }

    @Override
    public int compareTo(Product other) {
        return Integer.compare(this.productId, other.productId);
    }

    @Override
    public String toString() {
        return "Product [ID=" + productId + ", Name=" + productName + ", Category=" + category + "]";
    }
}

/**
 *
 * @author shuva
 */
public class ECommerceSearch {
    private Product[] products;

    public ECommerceSearch(Product[] products) {
        this.products = products;
    }

    // Linear search implementation
    public Product linearSearch(int productId) {
        for (Product product : products) {
            if (product.getProductId() == productId) {
                return product;
            }
        }
        return null;
    }

    // Binary search implementation
    public Product binarySearch(int productId) {
        int left = 0;
        int right = products.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (products[mid].getProductId() == productId) {
                return products[mid];
            }

            if (products[mid].getProductId() < productId) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return null;
    }

    public static void main(String[] args) {
        Product[] products = {
            new Product(3, "Laptop", "Electronics"),
            new Product(1, "Book", "Books"),
            new Product(2, "Phone", "Electronics"),
            new Product(4, "Headphones", "Accessories")
        };

        ECommerceSearch search = new ECommerceSearch(products);

        // Sort the array for binary search
        Arrays.sort(products);

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter Product ID to search: ");
        int productId = scanner.nextInt();

        // Linear search
        Product resultLinear = search.linearSearch(productId);
        System.out.println("Linear Search Result: " + (resultLinear != null ? resultLinear : "Product not found"));

        // Binary search
        Product resultBinary = search.binarySearch(productId);
        System.out.println("Binary Search Result: " + (resultBinary != null ? resultBinary : "Product not found"));

        scanner.close();
    }
}
