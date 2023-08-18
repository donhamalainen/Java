import java.util.concurrent.ThreadLocalRandom;

/* Tässä vapaaehtoisessa lähtötasotestissä tein Wu-Tang nimigeneraattorin */

// MAIN
public class Main {
    private static final String[] firstNames = {
            "Mystic", "Shadow", "Iron", "Raging",
            "Silent", "Golden", "Furious", "Ancient",
            "Thunder", "Majestic"
    };
    private static final String[] secondNames = {
            "Dragon", "Tiger", "Fist", "Monk",
            "Warrior", "Sword", "Phoenix", "Storm",
            "Flame", "Master"
    };
    private static final String[] peoplesNames = {
            "Anna Johnson",
            "Erik Smith",
            "Olivia Davis",
            "Liam Brown",
            "Sophia Wilson",
            "Mason Miller",
            "Ava Taylor",
            "Noah Clark",
            "Isabella White",
            "Lucas E",
            "Mia Lewis",
            "Alexander H"
    };
    private static String[] luodutNimet = new String[12];
    private static int luotujenMaara = 0;

    public static String generateName() {
        int first = ThreadLocalRandom.current().nextInt(0, firstNames.length);
        int second = ThreadLocalRandom.current().nextInt(0, secondNames.length);
        String name = firstNames[first] + " " + secondNames[second];
        for (int i = 0; i < luotujenMaara; i++) {
            if (luodutNimet[i].equals(name)) {
                return generateName();
            }
        }
        luodutNimet[luotujenMaara] = name;
        luotujenMaara++;
        return name;
    }

    public static void main(String[] args) {
        System.out.println("Wu-Tang name generator for programmers\n--------------------------------------");
        System.out.format("- The generator can produce %s unique names\n", firstNames.length * secondNames.length);
        for (int i = 0; i < 12; i++) {
            System.out.format("%3d. %-15s a.k.a. %s%n", i + 1, peoplesNames[i], generateName());
        }
        System.out.format("%n");
    }
}
