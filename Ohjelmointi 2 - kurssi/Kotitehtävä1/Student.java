
/*
 * KIRJASTO:
 * 
 * Random antaa meille numerot 1-100.
 * Year antaa meille nykyvuoden arvon.
 */
import java.util.Random;
import java.time.Year;

public class Student {

    // 1. ATTRIBUUTIT
    private Random random = new Random();

    private String firstName;
    private String lastName;
    private int id;
    private double bachelorCredits;
    private double masterCredits;

    private String titleOfMasterThesis;
    private String titleOfBachelorThesis;
    private int startYear;
    private int graduationYear;
    private String birthDate;

    // 2. MUODOSTIMET

    public Student() {
        this(ConstantValues.NO_NAME, ConstantValues.NO_NAME);
    }

    public Student(String lname, String fname) {
        firstName = null != fname ? fname : ConstantValues.NO_NAME;
        lastName = null != lname ? lname : ConstantValues.NO_NAME;
        id = getRandomId();
        bachelorCredits = 0;
        masterCredits = 0;
        titleOfMasterThesis = ConstantValues.NO_TITLE;
        titleOfBachelorThesis = ConstantValues.NO_TITLE;
        startYear = Year.now().getValue();
        birthDate = "\"" + ConstantValues.NO_BIRTHDATE + "\"";
    }

    // 3. METODIT

    // =============== NAMES, ID ===============

    // getFirstName getteri
    public String getFirstName() {
        return firstName;
    }

    /*
     * setFirstName saa arvokseen etunimen ja se tarkistaa että onko parametriä
     * syötetty, jos ei niin vakioarvo joka on attribuutissa pysyy.
     */
    public void setFirstName(String firstName) {
        if (firstName != null) {
            this.firstName = firstName;
        }
    }

    // getLastName getteri
    public String getLastName() {
        return lastName;
    }

    /*
     * setLastName saa arvokseen sukunimen ja se tarkistaa että onko parametriä
     * syötetty, jos ei niin vakioarvo joka on attribuutissa pysyy.
     */
    public void setLastName(String lastName) {
        if (lastName != null) {
            this.lastName = lastName;
        }
    }

    // getId getteri
    public int getId() {
        return id;
    }

    /*
     * setId saa arvokseen generoidun numeron ja tarkistaa että se on väliltä MAX ja
     * MIN, jos se on niin se asettaa sen id:n arvoksi. Muutoin ei aseta mitään.
     */
    public void setId(final int id) {
        if (id >= ConstantValues.MIN_ID && id <= ConstantValues.MAX_ID) {
            this.id = id;
        }
    }

    // =============== NAMES, ID (END) ===============

    // =============== CREDITS, TITLES ===============

    // getBachelorCredits getteri
    public double getBachelorCredits() {
        return bachelorCredits;
    }

    /*
     * Hyväksyy arvot väliltä 0 - 300, Pienin vaadittu pistemäärä valmistumiseen on
     * 180 (+ maisteri pisteet). Tarkistetaan siis että parametrinä saatu arvo ei
     * ole pienempää tai suurempaa kuin 0 ja 300
     */
    public void setBachelorCredits(final double bachelorCredits) {
        if (bachelorCredits >= ConstantValues.MIN_CREDITS && bachelorCredits <= ConstantValues.MAX_CREDITS) {
            this.bachelorCredits = bachelorCredits;
        }
    }

    // getMasterCredits getteri
    public double getMasterCredits() {
        return masterCredits;
    }

    /*
     * Hyväksyy arvot väliltä 0 - 300, Pienin vaadittu pistemäärä valmistumiseen on
     * 120 (+ kandi pisteet). Tarkistetaan siis että parametrinä saatu arvo ei
     * ole pienempää tai suurempaa kuin 0 ja 300
     */
    public void setMasterCredits(final double masterCredits) {
        if (masterCredits >= ConstantValues.MIN_CREDITS && masterCredits <= ConstantValues.MAX_CREDITS) {
            this.masterCredits = masterCredits;
        }
    }

    // getTitleOfMasterThesis getteri
    public String getTitleOfMasterThesis() {
        return titleOfMasterThesis;
    }

    // Asettaa titlen titleOfMastersThesis muuttujaan
    public void setTitleOfMasterThesis(String titleOfMasterThesis) {
        if (titleOfMasterThesis != null)
            this.titleOfMasterThesis = titleOfMasterThesis;
    }

    // getTitleOfBachelorThesis getteri
    public String getTitleOfBachelorThesis() {
        return titleOfBachelorThesis;
    }

    // Asettaa titlen titleOfBachelorThesis muuttujaan
    public void setTitleOfBachelorThesis(String titleOfBachelorThesis) {
        if (titleOfBachelorThesis != null) {
            this.titleOfBachelorThesis = titleOfBachelorThesis;
        }
    }

    // =============== CREDITS, TITLES (END) ===============
    // =============== YEARS, BIRTHDATE, GRADUATE ===============

    // getStartYear getteri
    public int getStartYear() {
        return startYear;
    }

    /*
     * setStartYear asettaa aloitusvuoden, se myös tarkistaa että vuosi on 2000
     * luvun paremmalla puolella eikä alle sen. Tarkistaa myös että aika ei ole
     * tulevaisuudessa
     */
    public void setStartYear(final int startYear) {
        if (startYear > 2000 && startYear <= Year.now().getValue()) {
            this.startYear = startYear;
        }
    }

    /*
     * getStudyYears palauttaa kokonaisluvun joka on vuosi kauanko on aikaa kulunut
     * aloitusvuodesta valmistumiseen. Jos oppilas ei ole valmistunut niin aikaa
     * nykyhetkeen.
     */
    public int getStudyYears() {
        if (graduationYear != 0) {
            return graduationYear - startYear;
        } else {
            return Year.now().getValue() - startYear;
        }
    }

    // getGraduationYear getteri
    public int getGraduationYear() {
        return graduationYear;
    }

    /*
     * setGraduationYear palauttaa merkkijonon.
     * Tarkistaa että voidaanko valmistumisvuotta asettaa.
     * Ehtona on canGraduate() ja sitten valmistumis ja aloitus vuosi, sekä
     * nykyisyys
     */
    public String setGraduationYear(final int graduationYear) {
        if (!canGraduate())
            return "Check the required studies";
        if (graduationYear < startYear || graduationYear > Year.now().getValue())
            return "Check graduation year";

        this.graduationYear = graduationYear;
        return "Ok";
    }

    // getBirthDate palauttaa birthDate arvon
    public String getBirthDate() {
        return birthDate;
    }

    // setBirthDate asettaa arvon
    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    /*
     * hasGraduated palauttaa totuusarvon. Palauttaa arvon valmistumis vuoden
     * perusteella.
     */
    public boolean hasGraduated() {
        return graduationYear != 0;
    }

    /*
     * setPersonId palauttaa merkkijonon, mutta ideana on että se asettaa birthdate
     * muuttujaan syntymäpäivän henkilötunnuksesta formaattiin dd.mm.yyyy.
     */
    public String setPersonId(final String personId) {
        if (checkPersonIDNumber(personId)) {
            try {
                StringBuilder date = new StringBuilder();
                date.append(personId.substring(0, 2) + ".");
                date.append(personId.substring(2, 4) + ".");
                date.append(getYear(personId.substring(4, 6), personId.substring(6, 7)));
                String dateString = date.toString();

                if (checkBirthDate(dateString)) {
                    if (checkValidCharacter(personId)) {
                        setBirthDate(dateString);
                        return "Ok";
                    }
                    return ConstantValues.INCORRECT_CHECKMARK;
                }
                return ConstantValues.INVALID_BIRTHDAY;
            } catch (RuntimeException e) {
                return ConstantValues.INVALID_BIRTHDAY;
            }
        }
        return ConstantValues.INVALID_BIRTHDAY;
    }

    private String getYear(String yearEnd, String centuryCharacter) {
        if (Character.compare(yearEnd.charAt(0), '-') == 0)
            throw new RuntimeException("Invalid year");

        switch (centuryCharacter) {
            case "+":
                return "18" + yearEnd;
            case "-":
                return "19" + yearEnd;
            case "A":
                return "20" + yearEnd;
            default:
                throw new RuntimeException("Invalid century character");
        }
    }

    // =============== YEARS, BIRTHDATE, GRADUATE (END) ===============
    // =============== PRIVATE METHODS ===============

    /*
     * getRandomId generoi satunnaisen kokonaisluvun väliltä ConstantValue.MAX_ID ja
     * ConstantValues.MIN_ID ja palauttaa generoidun arvon
     */
    private int getRandomId() {
        return random.nextInt(ConstantValues.MIN_ID, ConstantValues.MAX_ID + 1);
    }

    /*
     * canGraduate palauttaa totuusarvon:
     * Tarkistaa opintopisteiden vaadittavan määrän ja opinnäytetyön otsikoinnin
     */
    private boolean canGraduate() {
        return bachelorCredits >= ConstantValues.BACHELOR_CREDITS && masterCredits >= ConstantValues.MASTER_CREDITS
                && !titleOfBachelorThesis.equals(ConstantValues.NO_TITLE)
                && !titleOfMasterThesis.equals(ConstantValues.NO_TITLE);
    }

    /*
     * checkPersonIDNumber palauttaa totuusarvon:
     * Tarkistaa että tarkistusmerkki on olemassa, sekä että merkkejä on 11
     */
    private boolean checkPersonIDNumber(final String checkStatus) {
        char c = checkStatus.charAt(6);
        boolean x = false;
        if (checkStatus.length() == 11) {
            if (c == '-' || c == 'A' || c == '+') {
                x = true;
            }
        }
        return x;
    }

    /*
     * checkLeapYear palauttaa totuusarvon.
     * Tarkistaa onko kyseessä karkausvuosi.
     * Virallisesti karkauspäivänä syntyneet voivat viettää syntymäpäiväänsä
     * haluamaan päivänä, joko 28.2 tai 1.3. Vaikka syntymäpäivän saa valita, lain
     * mukaan kyseisenä päivänä syntynyt on täysi-ikäinen vasta täytettyään
     * 18-vuotta, eli vasta maaliskuun ensimmäisenä päivänä.
     */
    private boolean checkLeapYear(int year) {
        return year % 4 == 0 && (year % 100 != 0 || year % 400 == 0);
    }

    /*
     * checkValidCharacter palauttaa totuusarvon:
     * jakamalla syntymäajan ja yksilönumeron muodostaman 9-numeroisen luvun
     * (ppkkvvnnn) 31:llä saadaan haluttu kirjain
     * 
     * ["0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "A", "B", "C", "D", "E",
     * "F", "H", "J", "K",
     * "L", "M", "N", "P", "R", "S", "T", "U", "V", "W", "X", "Y"]
     */
    private boolean checkValidCharacter(final String personID) {
        char[] list = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F', 'H', 'J', 'K',
                'L', 'M', 'N', 'P', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y' };

        char lastCharacter = personID.charAt(personID.length() - 1);
        String ppkkvv = personID.substring(0, 6);
        String nnn = personID.substring(7, 10);
        String muunnos = ppkkvv + nnn;
        int x = Integer.parseInt(muunnos) % 31;
        if (list[x] == lastCharacter) {
            return true;
        } else {
            return false;
        }
    }

    /*
     * checkBirthdate palauttaa totuusarvon:
     * Tarkistaa annetun pvm että se päivät eivät mm ole enempää kuin 31 ja
     * kuukaudet enempää kuin 12 ja vuodet eivät ole negatiivisia
     */
    private boolean checkBirthDate(final String date) {
        try {
            String[] dates = date.split("\\.");
            int day = Integer.parseInt(dates[0]);
            int month = Integer.parseInt(dates[1]);
            int year = Integer.parseInt(dates[2]);

            if (month < 1 || month > 12)
                return false;

            return checkDay(day, month, year);
        } catch (RuntimeException e) {
            e.printStackTrace();
            return false;
        }
    }

    private boolean checkDay(int day, int month, int year) {
        if (day < 1)
            return false;

        switch (month) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                return day <= 31;
            case 4:
            case 6:
            case 9:
            case 11:
                return day <= 30;
            case 2:
                if (checkLeapYear(year))
                    return day <= 29;
                return day <= 28;
            default:
                throw new RuntimeException("Invalid month");
        }
    }

    private boolean checkBachelor() {
        if (bachelorCredits < ConstantValues.BACHELOR_CREDITS) {
            return false;
        }
        return true;
    }

    private boolean checkMaster() {
        if (masterCredits < ConstantValues.MASTER_CREDITS) {
            return false;
        }
        return true;
    }

    // =============== PRIVATE METHDOS (END) ===============
    // =============== toString PRINT ===============

    /*
     * toString on tulostus metodi, jossa kaikki tulostetaan ulos muodossa:*
     * Student id: 72
     * FirstName: Donald, LastName: Duck
     * Date of birth: "Not available"
     * Status: The student has not graduated, yet
     * StartYear: 2001 (studies have lasted for 22 years)
     * BachelorCredits: 120.0 ==> Missing bachelor credits 60.0 (120.0/180.0)
     * TitleOfBachelorThesis: "Bachelor thesis title"
     * MasterCredits: 180.0 ==> All required master's credits completed
     * (180.0/120.0)
     * TitleOfMastersThesis: "Masters thesis title"
     */

    public String toString() {
        return String.format(
                "Student id: %d\nFirstName: %s, LastName: %s\nDate of birth: %s\nStatus: %s\nStartYear: %s (studies lasted for %s years)\nBachelorCreadits: %s ==> %s\nTitleOfBachelorThesis: \"%s\"\nMasterCredits: %s ==> %s\nTitleOfMastersThesis: \"%s\"\n",
                getId(),
                getFirstName(), getLastName(), getBirthDate(),
                hasGraduated() ? String.format("The student has graduated in %s", getGraduationYear())
                        : "The student has not graduated, yet",
                getStartYear(), getStudyYears(), getBachelorCredits(),
                checkBachelor()
                        ? String.format("All required bachelor credits completed (%s/180.0)", getBachelorCredits())
                        : String.format("Missing bachelor credits %s (%s/180.0)",
                                ConstantValues.BACHELOR_CREDITS - getBachelorCredits(), getBachelorCredits()),
                getTitleOfBachelorThesis(), getMasterCredits(),
                checkMaster()
                        ? String.format("All required bachelor credits completed (%s/120.0)", getMasterCredits())
                        : String.format("Missing bachelor credits %s (%s/120.0)",
                                ConstantValues.MASTER_CREDITS - getMasterCredits(), getMasterCredits()),
                getTitleOfMasterThesis());
    }

    // =============== toString PRINT (END) ===============
}
