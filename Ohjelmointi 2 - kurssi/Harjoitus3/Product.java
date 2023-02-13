public class Product {

   // attribuutit
   private String name;
   private double price;

   // muodostimet
   public Product(final String name_par, final double price_par) {
      name = name_par;
      price = price_par;

      // System.out.println("Luotiin Product-olio, nimi: " + name + " hinta: "
      // +price);

   }

   // kopiomuodostin
   public Product(final Product p) {
      name = p.getName();
      price = p.getPrice();

      // System.out.println("Kloonattiin Product-olio, nimi: " + name + " hinta: "
      // +price);

   }

   // metodit

   public void setName(final String name_par) {
      name = name_par;
   }

   public void setPrice(final double price_par) {
      price = price_par;
   }

   public String getName() {
      return new String(name);
   }

   public double getPrice() {
      return price;
   }

}