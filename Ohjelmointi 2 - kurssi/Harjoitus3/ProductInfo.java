
public class ProductInfo {

   // attribuutit
   private String selostus;
   private Product product;

   // konstruktorit eli muodostimet
   public ProductInfo(String name, double price) {

   }

   public ProductInfo(String name, double price, String selostus) {
      this.product = new Product(name, price);
      this.selostus = selostus;
   }
   // metodit

   public String getSelostus() {
      return selostus;
   }

   public void setSelostus(String selostus) {
      this.selostus = selostus;
   }

   public Product getProduct() {
      return product;
   }

   public void setProduct(Product product) {
      this.product = product;
   }

   public void printProd() {
      System.out.println("Tuotteen nimi: " + product.getName());
      System.out.println("Tuotteen hinta: " + product.getPrice());
      System.out.println("Tuotteen selostus: " + selostus);
   }
}
