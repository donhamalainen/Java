
// KIRJASTO
// Random antaa meille numerot 1-100.
// Year antaa meille vuoden arvon.
import java.time.Year;
// Antaa meille ArrayList ja List kirjaston käyttöön. 
import java.util.ArrayList;
import java.util.List;

// KIRJASTO END
public class Student extends Person {
    /* ATTRIBUUTIT */
    private int id;
    private int startYear = Year.now().getValue();
    private int graduationYear;

    /*
     * ArrayList of the student’s degree studies (class Degree)
     * (0 = bachelor, 1 = master, 2 = reserved for doctoral studies)
     */
    private List<Degree> degrees = new ArrayList<>();

    /* ATTRIBUUTIT END */

    /* MUODOSTIMET */

    /*
     * The id for the student will also be set in the constructor (note
     * inheritance).
     */
    public Student(String lname, String fname) {
        super(lname, fname);
        setId(super.getRandomId(ConstantValues.MIN_STUDENT_ID, ConstantValues.MAX_STUDENT_ID));

        // Create objects for the list
        for (int i = 0; i < 3; i++) {
            degrees.add(i, new Degree());
        }
    }

    /* MUODOSTIMET END */

    /* METODIT */

    // Return Person class getRandomId
    public int getId() {
        return id;
    }

    // Allowed values are 1-100, otherwise not set.
    public void setId(final int id) {
        if (id >= ConstantValues.MIN_STUDENT_ID && id <= ConstantValues.MAX_STUDENT_ID) {
            this.id = id;
        }
    }

    // By default, current year (if not set).
    public int getStartYear() {
        return startYear;
    }

    /*
     * The year must be after 2000 and cannot be in the
     * future, i.e., 2000 < startYear <= current year.
     */
    public void setStartYear(final int startYear) {
        if (startYear > 2000 && startYear <= Year.now().getValue()) {
            this.startYear = startYear;
        }
    }

    // Return getGraduationYear
    public int getGraduationYear() {
        return graduationYear;
    }

    /*
     * Utilize the method canGraduate here.
     * The graduation year can be set only if the student has
     * a) completed all required credits (both bachelor &
     * masters) plus the titles of both theses are in place and
     * b) the given year is within the timeframe from the
     * start of the studies to this date (neither before the
     * start of the studies nor in the future). If…
     * • a student cannot graduate (above case a), the
     * method will return “Check amount of required
     * credits”.
     * • the given year is invalid (above case b), the method
     * will return “Check graduation year”.
     * • both cases are fine, the method will return “Ok”.
     */
    public String setGraduationYear(final int graduationYear) {
        if (!canGraduate()) {
            return "Check amount of required credits";
        } else if (graduationYear < startYear || graduationYear > Year.now().getValue()) {
            return "Check graduation year";
        } else {
            this.graduationYear = graduationYear;
            return "Ok";
        }

    }

    /*
     * The method will set the title for the given degree (see
     * class Degree) if the given index is valid (0 <= i <
     * number of degrees) and the given title is not null.
     */
    public void setDegreeTitle(final int i, String dName) {
        if ((0 <= i && i < degrees.size()) && (dName != null)) {
            if (degrees.get(i) != null) {
                this.degrees.get(i).setDegreeTitle(dName);
            }
        }
    }

    /*
     * The method will add the course for the given degree
     * (see class Degree) if the given index is valid (0 <= i <
     * number of degrees) and the given course is not null
     */

    public boolean addCourse(final int i, StudentCourse course) {
        if ((i >= 0 && i < degrees.size()) && course != null) {
            if (degrees.get(i).addStudentCourse(course)) {
                return true;
            }
        }
        return false;
    }

    /*
     * The method will add the courses for the given degree
     * (see class Degree) if the given index is valid (0 <= i <
     * number of degrees) and the given ListArray or single
     * course is not null. The method will return the number
     * of added courses
     */

    public int addCourses(final int i, List<StudentCourse> courses) {
        int count = 0;
        if (i >= 0 && i < degrees.size() && (!degrees.isEmpty()) && courses != null) {
            for (StudentCourse course : courses) {
                if (addCourse(i, course)) {
                    count++;
                }
            }
        }
        return count;
    }

    /*
     * The method will print all the student’s possible
     * courses from all degrees (not null values). See classes
     * Degree and StudentCourse.
     */
    public void printCourses() {
        for (Degree result : degrees) {
            if (result != null) {
                for (StudentCourse course : result.getCourses()) {
                    if (course != null) {
                        System.out.println(course.toString() + "]");
                    }
                }
            }
        }
    }

    /*
     * The method will print all the student’s degrees (not
     * null values). See class Degree.
     */
    public void printDegrees() {
        for (Degree result : degrees) {
            if (result != null) {
                System.out.println(result);
            }
        }
    }

    /*
     * The method will set the title for the given thesis (see
     * class Degree) if the given index is valid (0 <= i <
     * degreeCount) and the given title is not null.
     */

    public void setTitleOfThesis(final int i, String title) {
        if ((0 <= i && i < degrees.size()) && title != null) {
            degrees.get(i).setTitleOfThesis(title);
        }
    }

    /*
     * Returns the information whether the student has
     * graduated or not (based on the graduationYear).
     */
    public boolean hasGraduated() {
        return graduationYear != 0;
    }

    /*
     * The method will check if the student has graduated or
     * not and will return the number of years used for the
     * studies.
     */
    public int getStudyYears() {
        if (hasGraduated()) {
            return graduationYear - startYear;
        } else {
            return Year.now().getValue() - startYear;
        }
    }
    // ====== PRIVATE METHODS ======

    /*
     * The method will check the required
     * studies for graduation, i.e., the student has enough of
     * required credits (all and mandatory, for both bachelor
     * and masters) and the student has titles for both
     * theses (bachelor and masters).
     * Use ConstantValues.BACHELOR_MANDATORY,
     * ConstantValues.MASTER_MANDATORY,
     * ConstantValues.BACHELOR_CREDITS and
     * ConstantValues.MASTER_CREDITS.
     */
    private boolean canGraduate() {
        return (((degrees.get(0).getCredits() >= ConstantValues.BACHELOR_MANDATORY
                && degrees.get(0).getCredits() >= ConstantValues.BACHELOR_CREDITS)
                && (degrees.get(1).getCredits() >= ConstantValues.MASTER_MANDATORY
                        && degrees.get(1).getCredits() >= ConstantValues.MASTER_CREDITS))
                && (!degrees.get(0).getTitleOfThesis().equals(ConstantValues.NO_TITLE)
                        && !degrees.get(1).getTitleOfThesis().equals(ConstantValues.NO_TITLE)));
    }

    /*
     * The method will return a string of a user id (“Student
     * id: nnn”).
     * For example… Student id: 42
     * 
     * We do not use public or private fields in this method because they are not
     * accessible and not used in Person.java getIdString
     */
    String getIdString() {
        return "Student id: " + getId();
    }
    /*
     * OMA METODI
     * Metodi palauttaa Degree creditsien double arvon jota hyödynnetään toString()
     * metodissa
     */

    private double credits() {
        double x = 0;
        for (Degree result : degrees) {
            x += result.getCredits();
        }
        return x;
    }

    /*
     * OMA METODI
     * Hankkii tiedon GPA:sta degree tiedostosta.
     * Koska listassa on esimerkki:
     * [12.0, 5.0, 2.4]
     * [5.0, 6.0, 1.25]
     * [0.0, 0.0, 0.0]
     * 
     * Hyödynnetään index 0 ja 2 jottaa saadaan GPA:n todellinen laskenta josta on
     * poistettu ei numeerisen kurssit, jollain saamme oikean tuloksen. Esimerkissä
     * keskellä olevat numerot [5 ja 6] ovat kaikkien kurssien määriä.
     * 
     * Haluan käyttää kyseistä metodia
     * 
     * i:n arvot vastaavat:
     * 0 = OPTIONAL,
     * 1 = MANDATORY,
     * 2 = ALL
     * 
     * k:n arvot vastaavat:
     * 0 = Bachelor
     * 1 = Master
     * 2 = Doctor
     * 3 = Total
     */

    private double GPA(int i, int k) {
        double gpa = 0.0;
        switch (k) {
            // BACHELOR
            case 0:
                gpa = degrees.get(k).getGPA(i).get(2);
                break;

            // MASTER
            case 1:
                gpa = degrees.get(k).getGPA(i).get(2);
                break;
            // DOCTOR
            case 2:
                for (Degree result : degrees) {
                    gpa = result.getGPA(i).get(2);
                }
                break;
            // TOTAL
            case 3:
                double sum = 0.0;
                double total = 0.0;
                double ave = 0.0;
                double realCount = 0.0;

                for (Degree result : degrees) {
                    ave = result.getGPA(i).get(2);
                    sum = result.getGPA(i).get(0);
                    total += result.getGPA(i).get(0);
                    if (ave != 0 || sum != 0) {
                        realCount += sum / ave;
                    }

                }
                // System.out.println(total / realCount);
                gpa = total / realCount;
                break;
        }
        return gpa;
    }

    /*
     * OMA METODI
     * Lasketaan listasta Master ja Bachelor pisteet.
     * Riippuen i:n arvosta joko 0 tai 1
     */

    private double calcCredits(int i) {
        return degrees.get(i).getCredits();
    }

    /*
     * OMA METODI
     * getteri joka hakee Master tai Bachelor thesiksen
     */
    private String getThesis(int i) {
        return degrees.get(i).getTitleOfThesis();
    }

    /*
     * OMA METODI BACHELOR
     * 
     */
    private String checkBachelor() {
        if (degrees.get(0).getCredits() < ConstantValues.BACHELOR_CREDITS) {
            return String.format("Missing bachelor's credits %.1f (%.1f/180.0)",
                    ConstantValues.BACHELOR_CREDITS - degrees.get(0).getCredits(), degrees.get(0).getCredits());
        }
        return String.format(
                "Total bachelor credits completed (%.1f/180.0)",
                degrees.get(0).getCredits());
    }

    /*
     * OMA METODI
     * 
     */
    private String checkMaster() {
        if (degrees.get(1).getCredits() < ConstantValues.MASTER_CREDITS) {
            return String.format("Missing master's credits %.1f (%.1f/120.0)",
                    ConstantValues.MASTER_CREDITS - degrees.get(1).getCredits(), degrees.get(1).getCredits());
        }
        return String.format(
                "Total master's credits completed (%.1f/120.0)",
                degrees.get(1).getCredits());
    }

    /* OMA METODI */
    private String checkThesis(final int i) {
        return degrees.get(i).getTitleOfThesis();
    }

    /*
     * OMA METODI
     */
    private String checkMandatory(final int i) {

        // Bachelor
        if (i == 0) {
            if (degrees.get(i).getCreditsByType(1) >= ConstantValues.BACHELOR_MANDATORY) {
                return String.format("All mandatory bachelor credits completed (%.1f/150.0)",
                        degrees.get(i).getCreditsByType(1));
            } else {
                return String.format("Mandatory bachelor credits missing (%.1f/150.0)",
                        degrees.get(i).getCreditsByType(1));
            }
        }

        // Master
        if (i == 1) {
            if (degrees.get(i).getCreditsByType(1) >= ConstantValues.MASTER_MANDATORY) {
                return String.format("All mandatory bachelor credits completed (%.1f/150.0)",
                        degrees.get(i).getCreditsByType(1));
            } else {
                return String.format("Mandatory bachelor credits missing (%.1f/150.0)",
                        degrees.get(i).getCreditsByType(1));
            }
        }

        return "Unknown";
    }

    /*
     * OMA METODI
     */
    private String checkGPA(final int i) {

        // Bachelor
        if (i == 0) {
            return String.format("GPA of Bachelor studies: %.2f", degrees.get(i).getGPA(2).get(2));
        }
        // Master
        if (i == 1) {
            return String.format("GPA of Master studies: %.2f", degrees.get(i).getGPA(2).get(2));
        }

        return "unknown";
    }
    // ====== PRIVATE METHODS END ======

    // Tulostus
    public String toString() {
        return String.format(
                "%s\n\tFirst name: %s, Last name: %s\n\tDate of birth: %s\n\tStatus: %s\n\tStart year: %d (studies have lasted for %d years)\n\tTotal credits: %.1f (GPA = %.2f)\n\tBachelor credits: %.1f\n\t\t%s\n\t\t%s\n\t\t%s\n\t\tTitle of BSc thesis: \"%s\"\n\tMaster credits: %.1f\n\t\t%s\n\t\t%s\n\t\t%s\n\t\tTitle of MSc thesis: \"%s\"",
                getIdString(), getFirstName(),
                getLastName(), getBirthDate(),
                hasGraduated() ? String.format("The student has graduated in %d", graduationYear)
                        : "The student has not graduated, yet",
                getStartYear(), getStudyYears(), credits(), GPA(2, 3), calcCredits(0), checkBachelor(),
                checkMandatory(0), checkGPA(0), checkThesis(0), calcCredits(1),
                checkMaster(), checkMandatory(1), checkGPA(1), checkThesis(1));
    }
    /* METODIT END */
}
