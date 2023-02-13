import java.io.*;
import java.util.Scanner;
import java.util.Locale;

public class H3T1_Main {

   private static Scanner lukija = new Scanner(System.in).useLocale(new Locale("us", "US")); // windows saattaa muuten
                                                                                             // vaatia desimaalipisteen
                                                                                             // sijaan desimaalipilkkua

   public static void main(String[] args) {
      ProductInfo prod = new ProductInfo("Kalja", 2.82, "Kalja on hyvää, ja tämä on seloste");
      prod.printProd();
   }

}