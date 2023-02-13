import java.util.Random;

public class RandTable {
   // attribuutit
   Random random = new Random();

   private int maxNum;
   private int[] taulukko;

   // konstruktorit eli muodostimet

   public RandTable(final int size, final int max) {
      taulukko = new int[size];
      for (int i = 0; i < size; i++) {
         maxNum = random.nextInt(max);
         taulukko[i] = maxNum;
         System.out.println(maxNum);
      }
   }

   // metodit
   public void nextNumber() {
      for (int k : taulukko) {
         System.out.print(k + "\n");
      }
   }
}