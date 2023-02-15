
/*
 * KIRJASTO:
 * 
 * Random antaa meille numerot 1-100.
 * Year antaa meille nykyvuoden arvon.
 * SimpleDateFormat antaa meille mahdollisuuden formalisoida syntymäpäivä.
 * Date antaa meille mahdollisuuden päästä käsiksi Date kansioon.
 */
import java.util.Random;
import java.time.Year;
import java.text.SimpleDateFormat;
import java.util.Date;

/* 
 * Luokka Student:
 * 1. ATTRIBUUTIT
 *      - ConstantValue on tiedosto, jossa on oletusarvot
 * 2. MUODOSTIMET
 * 3. METODIT
 */
public class Student {

    // 1. ATTRIBUUTIT
    // NAMES, ID
    private String firstName = ConstantValues.NO_NAME;
    private String lastName = ConstantValues.NO_NAME;
    private int id;

    // CREDITS, TITLES
    private double bachelorCredits;
    private double masterCredits;
    private String titleOfMastersThesis = ConstantValues.NO_TITLE;
    private String titleOfBachelorThesis = ConstantValues.NO_TITLE;

    // YEARS, BIRTHDATE
    private int startYear = Year.now().getValue();
    private int graduationYear;
    private String birthDate = "\"" + ConstantValues.NO_BIRTHDATE + "\"";

    // 2. MUODOSTIMET

    // Asettaa setId:n, mutta muuten joudutaan käyttämään settereitä
    public Student() {
        setId(getRandomId());
    }

    /*
     * Asettaa setId:n, sekä parametrien avulla asettaa nimen ja sukunimen. Muuten
     * joudutaan käyttämään settereitä
     */
    public Student(String lname, String fname) {
        setId(getRandomId());
        setFirstName(fname);
        setLastName(lname);
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
        if (id < ConstantValues.MAX_ID && id > ConstantValues.MIN_ID) {
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
        if (bachelorCredits >= ConstantValues.MIN_CREDIT && bachelorCredits <= ConstantValues.MAX_CREDITS) {
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
        if (masterCredits >= ConstantValues.MIN_CREDIT && masterCredits <= ConstantValues.MAX_CREDITS) {
            this.masterCredits = masterCredits;
        }
    }

    // getTitleOfMastersThesis getteri
    public String getTitleOfMastersThesis() {
        return titleOfMastersThesis;
    }

    // Asettaa titlen titleOfMastersThesis muuttujaan
    public void setTitleOfMastersThesis(String titleOfMastersThesis) {
        if (titleOfMastersThesis != null) {
            this.titleOfMastersThesis = titleOfMastersThesis;
        }
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
        int currentYear = Year.now().getValue();
        if (startYear > 2000 && startYear <= currentYear) {
            this.startYear = startYear;
        }
    }

    /*
     * getStudyYears palauttaa kokonaisluvun joka on vuosi kauanko on aikaa kulunut
     * aloitusvuodesta valmistumiseen. Jos oppilas ei ole valmistunut niin aikaa
     * nykyhetkeen.
     */
    public int getStudyYears() {
        int currentYear = Year.now().getValue();
        if (graduationYear != 0) {
            return graduationYear - startYear;
        } else {
            return currentYear - startYear;
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
        int currentYear = Year.now().getValue();
        if (canGraduate()) {
            if (startYear < graduationYear && graduationYear < currentYear) {
                this.graduationYear = graduationYear;
                return "Ok";
            } else {
                return "Check graduation year";
            }
        } else {
            return "Check the required studies";
        }
    }

    /*
     * hasGraduated palauttaa totuusarvon. Palauttaa arvon valmistumis vuoden
     * perusteella.
     * 
     */
    public boolean hasGraduated() {
        if (graduationYear != 0) {
            return true;
        } else {
            return false;
        }
    }

    /*
     * setPersonId palauttaa merkkijonon, mutta ideana on että se asettaa birthdate
     * muuttujaan syntymäpäivän henkilötunnuksesta formaattiin dd.mm.yyyy.
     */
    public String setPersonId(final String personId) {
        String formattedPersonId = personId.substring(0, 6);
        String x = "";
        if (checkPersonIDNumber(personId) == true && checkBirthdate(personId) == true) {

            if (checkValidCharacter(personId) == true) {
                try {
                    Date date = new SimpleDateFormat("ddMMyy").parse(formattedPersonId);
                    SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");
                    this.birthDate = formatter.format(date);
                    x = "Ok";
                } catch (Exception e) {
                    x = "Virhe formalisoinnissa " + e;
                }
            } else {
                x = ConstantValues.INCORRECT_CHECKMARK;
            }
        } else {
            x = ConstantValues.INVALID_BIRTHDAY;
        }
        return x;
    }

    // =============== YEARS, BIRTHDATE, GRADUATE (END) ===============
    // =============== PRIVATE METHODS ===============

    /*
     * getRandomId generoi satunnaisen kokonaisluvun väliltä ConstantValue.MAX_ID ja
     * ConstantValues.MIN_ID ja palauttaa generoidun arvon
     */
    private int getRandomId() {
        Random randomNumber = new Random();
        return randomNumber.nextInt(ConstantValues.MAX_ID) + ConstantValues.MIN_ID;
    }

    /*
     * OMA METODI
     * Palauttaa totuusarvon jos credittejä on haluttu määrä. Näkyy tulostuksessa
     * (x ? y : z) menetelmänä
     */
    private boolean missingCredits(double value, double wantedValue) {
        if (value < wantedValue) {
            return false;
        } else {
            return true;
        }
    }

    /*
     * canGraduate palauttaa totuusarvon:
     * Tarkistaa opintopisteiden vaadittavan määrän ja opinnäytetyön otsikoinnin
     */
    private boolean canGraduate() {
        boolean x = false;
        if (bachelorCredits >= ConstantValues.BACHELOR_CREDITS && masterCredits >= ConstantValues.MASTER_CREDITS) {
            if (titleOfBachelorThesis != ConstantValues.NO_TITLE && titleOfMastersThesis != ConstantValues.NO_TITLE) {
                x = true;
            }
        }
        return x;
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
        if (year % 400 == 0) {
            return true;
        } else if (year % 100 == 0) {
            return false;
        } else if (year % 4 == 0) {
            return true;
        } else {
            return false;
        }
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
    private boolean checkBirthdate(final String date) {
        int karkauspaivat[] = new int[] { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
        int days = Integer.parseInt(date.substring(0, 2));
        int month = Integer.parseInt(date.substring(2, 4));
        int years = Integer.parseInt(date.substring(4, 6));
        boolean x = false;
        if (checkLeapYear(years) == true) {
            karkauspaivat[1] = 29;
        }
        if (years >= 0) {
            if (month <= 12 && month >= 1) {
                if (karkauspaivat[month - 1] >= days && days >= 1) {
                    x = true;
                }
            }
        }
        return x;
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
                "Student id: %d\nFirstName: %s, LastName: %s\nDate of birth: %s\nStatus: %s\nStartYear: %s (studies have lasted for %s years)\nBachelorCredits: %s ==> %s\nTitleOfBachelorThesis: \"%s\"\nMasterCredits: %s ==> %s\nTitleOfMastersThesis: \"%s\"\n",
                getId(),
                getFirstName(),
                getLastName(),
                birthDate,
                hasGraduated() ? String.format("The student has graduated in %s", getGraduationYear())
                        : "The student has not graduated, yet",
                getStartYear(),
                getStudyYears(),
                getBachelorCredits(),
                missingCredits(bachelorCredits, ConstantValues.BACHELOR_CREDITS)
                        ? String.format("All required bachelor credits completed (%s/180)", bachelorCredits)
                        : String.format("Missing bachelor credits %s (%s/180.0)",
                                ConstantValues.BACHELOR_CREDITS - bachelorCredits, bachelorCredits),
                getTitleOfBachelorThesis(), getMasterCredits(),
                missingCredits(bachelorCredits, ConstantValues.BACHELOR_CREDITS)
                        ? String.format("All required bachelor credits completed (%s/120)", masterCredits)
                        : String.format("Missing bachelor credits %s (%s/120.0)",
                                ConstantValues.BACHELOR_CREDITS - masterCredits, masterCredits),
                getTitleOfMastersThesis());
    }

    // =============== toString PRINT (END) ===============
}
