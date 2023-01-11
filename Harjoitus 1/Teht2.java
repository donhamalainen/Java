
// SCANNER 
import java.util.Scanner;

// MAIN CLASS
class Teht2 {
    // PÄÄOHJELMA
    public static void main(String[] args) {
        // Tuodaan scanneri
        Scanner lukija = new Scanner(System.in);
        int pienin = Integer.MAX_VALUE, suurin = Integer.MIN_VALUE, lukumaara = 0, keskiarvo = 0, num, summa = 0;

        System.out.println("Syöttämällä negatiivisen tai 0, niin ohjelma lopetetaan ");
        while (true) {
            System.out.print("Syötä kokonaisluku > ");
            num = lukija.nextInt();
            if (num <= 0) {
                break;
            } else {
                lukumaara += 1;
                summa += num;
                if (suurin < num) {
                    suurin = num;
                    System.out.println("Suurempi");
                }
                if (num < pienin) {
                    pienin = num;
                    System.out.println("Pienempi");
                }
            }
        } // WHILE END
        keskiarvo = summa / lukumaara;
        System.out.println("\nOhjelmaan annetut arvot olivat:");
        System.out.print("Keskiarvo: " + keskiarvo + " " + "\nSumma: " + summa + "\nlukumaara: " + lukumaara
                + "\npienin: " + pienin + "\nsuurin: " + suurin);
    }
}