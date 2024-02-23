import java.io.*;
import java.util.Scanner;

// MAIN CLASS
class Main {
    public static void main(String[] args) {
        Scanner lukija = new Scanner(System.in);
        try {
            System.out.print("Anna taulukon koko > ");
            int n = lukija.nextInt();

            Product[] products = new Product[n];
            readProducts(products);
            printProducts(products);

        } catch (Exception e) {
            System.out.print("Syötteesi ei ollut kokonaisluku");
        }

    }

    static void printProducts(Product[] products) {
        for (int i = 0; i < products.length; i++) {
            System.out.println(
                    "\n" + (i + 1) + "." + "\nTuotteen nimi: " + products[i].getName() + "\nTuotteen hinta: "
                            + products[i].getPrice());
        }
    }

    static void readProducts(Product[] products) {
        Scanner lukija = new Scanner(System.in);

        for (int i = 0; i < products.length; i++) {
            System.out.print("\nAnna tuotteelle nimi > ");
            String name = lukija.nextLine();

            System.out.print("Anna tuotteelle hinta > ");
            double price = Double.parseDouble(lukija.nextLine());

            Product product = new Product(name, price);
            products[i] = product;
        }
    }
}

// PRODUCT CLASS
public class Product {
    // ATTRIBUTES
    private String name;
    private double price;

    // CONSTRUCTORS
    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    // METHODS
    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public void setName(String name) {
        if (name != null) {
            this.name = name;
        }

    }

    public void setPrice(double price) {
        if (price >= 0) {
            this.price = price;
        }
    }
}
