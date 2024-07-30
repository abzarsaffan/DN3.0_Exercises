/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.week1;

/**
 *
 * @author shuva
 */


import java.util.Arrays;
import java.util.Scanner;

class Book implements Comparable<Book> {
    private int bookId;
    private String title;
    private String author;

    public Book(int bookId, String title, String author) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
    }

    public int getBookId() {
        return bookId;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    @Override
    public int compareTo(Book other) {
        return this.title.compareTo(other.title);
    }

    @Override
    public String toString() {
        return "Book [ID=" + bookId + ", Title=" + title + ", Author=" + author + "]";
    }
}

class LibraryManagement {
    private Book[] books;
    private int count;

    public LibraryManagement(int size) {
        books = new Book[size];
        count = 0;
    }

    // Add a new book to the library
    public void addBook(Book book) {
        if (count < books.length) {
            books[count++] = book;
            System.out.println("Book added: " + book);
        } else {
            System.out.println("Library is full. Cannot add more books.");
        }
    }

    // Linear search to find a book by title
    public Book linearSearch(String title) {
        for (int i = 0; i < count; i++) {
            if (books[i].getTitle().equalsIgnoreCase(title)) {
                return books[i];
            }
        }
        return null;
    }

    // Binary search to find a book by title (Assuming the array is sorted)
    public Book binarySearch(String title) {
        int left = 0, right = count - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int cmp = books[mid].getTitle().compareToIgnoreCase(title);
            if (cmp == 0) {
                return books[mid];
            } else if (cmp < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return null;
    }

    // Display all books
    public void displayBooks() {
        for (int i = 0; i < count; i++) {
            System.out.println(books[i]);
        }
    }

    // Sort the books array by title
    public void sortBooks() {
        Arrays.sort(books, 0, count);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the size of the library: ");
        int size = scanner.nextInt();
        LibraryManagement library = new LibraryManagement(size);

        while (true) {
            System.out.println("\nLibrary Management System");
            System.out.println("1. Add Book");
            System.out.println("2. Linear Search by Title");
            System.out.println("3. Binary Search by Title");
            System.out.println("4. Display Books");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int option = scanner.nextInt();

            switch (option) {
                case 1:
                    System.out.print("Enter Book ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter Book Title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter Author: ");
                    String author = scanner.nextLine();
                    Book newBook = new Book(id, title, author);
                    library.addBook(newBook);
                    break;
                case 2:
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter Book Title to search (Linear Search): ");
                    String linearSearchTitle = scanner.nextLine();
                    Book foundBookLinear = library.linearSearch(linearSearchTitle);
                    System.out.println("Search Result: " + (foundBookLinear != null ? foundBookLinear : "Book not found"));
                    break;
                case 3:
                    scanner.nextLine(); // Consume newline
                    library.sortBooks(); // Ensure the array is sorted before binary search
                    System.out.print("Enter Book Title to search (Binary Search): ");
                    String binarySearchTitle = scanner.nextLine();
                    Book foundBookBinary = library.binarySearch(binarySearchTitle);
                    System.out.println("Search Result: " + (foundBookBinary != null ? foundBookBinary : "Book not found"));
                    break;
                case 4:
                    library.displayBooks();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}
