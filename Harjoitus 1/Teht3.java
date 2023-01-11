
// SCANNER
import java.util.Scanner;

// MAIN CLASS
class Teht3 {
    // HETU NUMEERINEN TARKISTUS
    static boolean daytimeValid(final String hetu) {

        try {
            int num = Integer.parseInt(hetu);
            int numPVM = num / 100;
            int days = numPVM / 100;
            int month = numPVM % 100;
            if (days <= 31 && days >= 0 && month >= 0 && month <= 12) {
                return true;
            } else {
                return false;
            }
        } catch (NumberFormatException exception) {
            return false;
        }
    }

    // YKSILÖMERKKI TARKISTUS
    static boolean checkIndividualNum(final String hetu) {
        try {
            int num = Integer.parseInt(hetu);
            return true;
        } catch (NumberFormatException exception) {
            return false;
        }
    }

    // TARKISTUS METHODI
    static boolean checkIdNumber(final String hetu) {
        if (hetu.length() < 11) {
            return false;
        } else {
            return true;

        }
    }

    // TULOSTUS METHODI
    static void printBirthdate(final String hetu) {

        String pv = hetu.substring(0, 2);
        String month = hetu.substring(2, 4);
        String yr = hetu.substring(4, 6);
        char merkki = hetu.charAt(6);

        if (merkki == '+') {
            System.out.print(String.format("%s.%s.18%s", pv, month, yr));
        } else if (merkki == '-') {
            System.out.print(String.format("%s.%s.19%s", pv, month, yr));
        } else if (merkki == 'A' || merkki == 'a') {
            System.out.print(String.format("%s.%s.20%s", pv, month, yr));
        } else {
            System.out.print("Tarkistusmerkki ei ole valid");
        }

    }

    // PÄÄOHJELMA
    public static void main(final String[] args) {
        // Scanner
        Scanner scanner = new Scanner(System.in);

        System.out.print("Anna henkilötunnus: ");
        String hetu = scanner.nextLine();
        String individualNum = hetu.substring(7, 10);
        String pvmNum = hetu.substring(0, 6);
        // TARKISTAA PITUUDEN
        if (checkIdNumber(hetu)) {
            // TATKISTAA KELPUUDET
            if (checkIndividualNum(individualNum) && daytimeValid(pvmNum)) {
                printBirthdate(hetu);
            } else {
                System.out.print("Virhe henkilötunnuksessa");
            }
        } else {
            System.out.println("Virhe henkilötunnuksessa");
        }
    }
}
