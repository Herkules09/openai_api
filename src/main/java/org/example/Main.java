package org.example;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws URISyntaxException, IOException {

       Scanner scanner= new Scanner(System.in);

        while(true){
            System.out.println("\n--------------------------------------");

            System.out.println("1. Show products");
            System.out.println("2. Add product");
            System.out.println("3. Delete product");
            System.out.println("4. Give me three ideas for breakfast");
            System.out.println("5. Give me three ideas for dinner");
            System.out.println("6. Give me examples of products that contains my component like (vitamin A,B12, protein,sugar)");
            System.out.println("7. Show me how many calories have my product (in 100 g of product)");
            System.out.println("8. End");
            System.out.println();
            System.out.println("Choose option: ");

            int choice =Integer.parseInt(scanner.nextLine());
            ProductManager productManager= new ProductManager();
            ChatGPTHelper chatGPTHelper = new ChatGPTHelper();
            switch (choice){
                case 1->{
                    System.out.println("Products: ");
                    productManager.getAllProducts().forEach(System.out::println);
                }


                case 2->{
                    System.out.println("Which product you want to add?");
                    String product=scanner.nextLine();
                    productManager.addProduct(product);
                }

                case 3->{
                    System.out.println("Which product you want to delete?");
                    String product=scanner.nextLine();
                    productManager.deleteProduct(product);
                }

                case 4->{
                    System.out.println("The ideas for breakfast:");
                    String breakfastIdea= chatGPTHelper.getBreakfastIdea(productManager.getAllProducts());
                    System.out.println(breakfastIdea);
                }

                case 5->{
                    System.out.println("The ideas for lunch:");
                    String lunchIdea= chatGPTHelper.getLunchIdea(productManager.getAllProducts());
                    System.out.println(lunchIdea);
                }
                case 6->{
                    System.out.println("Which component you want to have in products?");
                    String component=scanner.nextLine();
                    String products=chatGPTHelper.getExamplesProductsWith(component);
                    System.out.println(products);

                }
                case 7-> {
                    System.out.println("Enter product");
                    String product = scanner.nextLine();
                    String calories = chatGPTHelper.getCaloriesOfProduct(product);
                    System.out.println(calories);
                }
                case 8->{
                    System.out.println("Good bye! ");
                    System.exit(0);
                }

            }
        }

    }
}