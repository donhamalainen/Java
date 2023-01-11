
// Scanneria tarvitaan kysymään nimi
import java.util.Scanner;

class Teht1 {

    // PÄÄOHJELMA
    public static void main(String[] args) {
        // Luodaan/tuodaan scanneri osaksi ohjelmaa
        Scanner lukija = new Scanner(System.in);
        System.out.println("Tervehdys siellä!");

        // Kysytään nimi ja sukunimi
        System.out.print("Anna etunimesi > ");
        String nimi = lukija.nextLine();

        System.out.print("Anna sukunimesi > ");
        String sukunimi = lukija.nextLine();

        System.out.println("Tervetuloa Java-ohjelmoinnin maailmaan" + " " + nimi + " " + sukunimi);

        System.out.println("Paina Enter lopettaaksesi ohjelma.");
        lukija.nextLine();
        lukija.close();

    }
}
