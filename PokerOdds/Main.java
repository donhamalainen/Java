package PokerOdds;

import java.util.*;

public class Main {
    ////////////////////////////////
    // Main application
    ////////////////////////////////
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ConstantValues constants = new ConstantValues();

        // Määritellään maat ja arvot
        Map<Character, String> maat = new HashMap<>();
        maat.put('H', "Hertta");
        maat.put('R', "Ruutu");
        maat.put('P', "Pata");
        maat.put('S', "Risti");

        Map<Character, Integer> arvot = new HashMap<>();
        arvot.put('2', 2);
        arvot.put('3', 3);
        arvot.put('4', 4);
        arvot.put('5', 5);
        arvot.put('6', 6);
        arvot.put('7', 7);
        arvot.put('8', 8);
        arvot.put('9', 9);
        arvot.put('T', 10);
        arvot.put('J', 11);
        arvot.put('Q', 12);
        arvot.put('K', 13);
        arvot.put('A', 14);

        List<Card> kayttajanKortit = new ArrayList<>();
        while (kayttajanKortit.size() < 2) {
            try {
                System.out.println("\nMaat: \tHertta = H\n\tRisti = S\n\tRuutu = R\n\tPata = P");
                System.out.println("\nArvot: \t2, 3, 4, 5, 6, 7, 8, 9\n\tT, J, Q, K, A\n");
                System.out.print("Syötä kortti (esim. HA, R10): ");
                String cardInput = scanner.nextLine().toUpperCase();

                // Varmistetaan että syöte on kelvollinen
                if (cardInput.length() < 2 || cardInput.length() > 3) {
                    System.out.println("Virheellinen syöte. Yritä uudelleen");
                    continue;
                }
                char MAA = cardInput.charAt(0);
                char ARVO;

                if (cardInput.length() == 3) {
                    ARVO = 'T';
                } else {
                    ARVO = cardInput.charAt(1);
                }
                if (maat.containsKey(MAA) && arvot.containsKey(ARVO)) {
                    // int numeerinenArvo = arvot.get(ARVO);
                    kayttajanKortit.add(new Card(MAA, ARVO));
                } else {
                    System.out.println("Virheellinen kortin maa tai arvo. Yritä uudelleen.");
                }
            } catch (Exception e) {
                System.out.println("Virhe syötteen käsittelyssä. Yritä uudelleen");
            }
        }

        // Tulostetaan käyttäjän kortit (vain testausta varten)
        for (Card card : kayttajanKortit) {
            System.out.println(maat.get(card.getMAA()) + " " + card.getArvo());
        }

        while (true) {
            try {
                System.out.println("Kuinka monta muuta pelaajaa on pöydässä? ");
                int lukumaara = Integer.parseInt(scanner.nextLine().trim());
                if (lukumaara <= 0) {
                    System.out.println("Syötä kelvollinen määrä pelaajia. Vähintään yksi pelaaja");
                } else {
                    constants.setPelaajienlukumaara(lukumaara);
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Virheellinen syöte, Syötä kokonaisluku.");
            }
        }
    }
}