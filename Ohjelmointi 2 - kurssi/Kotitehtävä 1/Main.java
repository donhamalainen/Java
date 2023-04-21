public class Main {
    public static void main(String[] args) {
        Student opiskelija = new Student();
        Student opiskelija2 = new Student("Mouse", "Micky");
        Student opiskelija3 = new Student("Mouse", "Minnie");

        // 1. Opiskelija
        opiskelija.setFirstName("Donald");
        opiskelija.setLastName("Duck");
        opiskelija.setBachelorCredits(120);
        opiskelija.setMasterCredits(180);
        opiskelija.setTitleOfBachelorThesis("Bachelor thesis title");
        opiskelija.setTitleOfMasterThesis("Masters thesis title");
        opiskelija.setStartYear(2001);
        opiskelija.setGraduationYear(2020);
        // 2. Opiskelija

        // opiskelija2.setPersonalid
        opiskelija2.setPersonId("221199-123K");
        opiskelija2.setTitleOfBachelorThesis("A new exciting purpose of life");
        opiskelija2.setBachelorCredits(65);
        opiskelija2.setMasterCredits(22);
        // 3. Opiskelija
        opiskelija3.setTitleOfBachelorThesis("Dreaming of a white Christmas");
        opiskelija3.setTitleOfMasterThesis("Christmas - The most wonderful time of the year");
        opiskelija3.setBachelorCredits(216);
        opiskelija3.setMasterCredits(120);
        opiskelija3.setStartYear(2018);
        opiskelija3.setGraduationYear(2022);

        System.out.println(opiskelija.toString());
        System.out.println(opiskelija2.toString());
        System.out.println(opiskelija3.toString());

        System.out.println(opiskelija.setPersonId("This is a string"));
        System.out.println(opiskelija.setPersonId("320187-1234"));
        System.out.println(opiskelija.setPersonId("11111111-3334"));
        System.out.println(opiskelija.setPersonId("121298-830A"));

    }
}