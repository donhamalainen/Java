
/* KIRJASTOT */
// Random antaa meille numerot 1-100.
import java.util.Random;
// Year antaa meille vuoden arvon.
import java.time.Year;

/* KIRJASTOT END */
public class Student {
    /* ATTRIBUUTIT */
    private Random random = new Random();
    private String firstName = ConstantValues.NO_NAME;
    private String lastName = ConstantValues.NO_NAME;;
    private int id;
    private int startYear = Year.now().getValue();
    private int graduationYear;
    private String birthDate = "\"" + ConstantValues.NO_BIRTHDATE + "\"";

    // (0 = bachelor, 1 = master, 2 = reserved for doctoral studies
    private int degreeCount = 3;
    private Degree[] degrees = new Degree[degreeCount];

    /* ATTRIBUUTIT END */

    /* MUODOSTIMET */

    /*
     * The id for the student will be set in the constructor.
     * By default, the startYear is set to the currentYear.
     * The array elements are created here.
     */
    public Student() {
        for (int i = 0; i < degrees.length; i++) {
            degrees[i] = new Degree();
        }
        setId(getRandomId());
    }

    /*
     * The id for the student will also be set in the constructor (utilize
     * the above version of the constructor).
     */
    public Student(String lname, String fname) {
        this();
        setFirstName(fname);
        setLastName(lname);
    }
    /* MUODOSTIMET END */

    /* METODIT */

    // By default, returns “No name”.
    public String getFirstName() {
        return firstName;
    }

    // Can be set only if the given name is not null.
    public void setFirstName(String firstName) {
        if (firstName != null) {
            this.firstName = firstName;
        }
    }

    // By default, returns “No name”.
    public String getLastName() {
        return lastName;
    }

    // Can be set only if the given name is not null
    public void setLastName(String lastName) {
        if (lastName != null) {
            this.lastName = lastName;
        }
    }

    // The method will return the id of the student.
    public int getId() {
        return id;
    }

    // Allowed values are 1-100, otherwise not set.
    public void setId(final int id) {
        if (id > 0 && id <= 100) {
            this.id = id;
        }
    }

    // Returns the startYear (by default, current year, if not set).
    public int getstartYear() {
        return startYear;
    }

    /*
     * The year must be after 2000 and cannot be in the
     * future, i.e., 2000 < startYear <= current year.
     */
    public void setstartYear(final int startYear) {
        if (2000 < startYear && startYear <= Year.now().getValue()) {
            this.startYear = startYear;
        }
    }

    // returns the graduationYear
    public int getGraduationYear() {
        return graduationYear;
    }

    /*
     * The graduation year can be set only if the student has
     * a) completed all required credits (both bachelor &
     * masters) and b) the given year is within the timeframe
     * from the start of the studies to this date (neither before
     * the start of the studies nor in the future). Utilize the
     * method canGraduate here. If…
     * • a student cannot graduate (above case a), the
     * method will return “Check amount of required
     * credits”.
     * • the given year is invalid (above case b), the method
     * will return “Check graduation year”.
     * • both cases are fine, the method will return “Ok”
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
     * degreeCount) and the given title is not null.
     */

    public void setDegreeTitle(final int i, String dName) {
        if ((0 <= i && i < degreeCount) && (dName != null)) {
            degrees[i].setDegreeTitle(dName);
        }
    }

    /*
     * The method will add the course for the given degree
     * (see class Degree) if the given index is valid (0 <= i <
     * degreeCount) and the given course is not null.
     */
    public boolean addCourse(final int i, StudentCourse course) {
        if ((i >= 0 && i <= degreeCount) && (course != null)) {
            if (degrees[i].addStudentCourse(course)) {
                return true;
            }
        }
        return false;
    }

    /*
     * The method will add the courses for the given degree
     * (see class Degree) if the given index is valid (0 <= i <
     * degreeCount) and the given array or single course is not
     * null. The method will return the number of added
     * courses.
     */
    public int addCourses(final int i, StudentCourse[] courses) {
        int count = 0;
        if (courses != null) {
            for (int k = 0; k < courses.length; k++) {
                if (count < 50 && courses[k] != null && addCourse(i, courses[k])) {
                    count++;
                }
            }
        }
        return count;
    }

    /*
     * The method will print all the student’s possible courses
     * from all degrees (not null values). See classes Degree
     * and StudentCourse.
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
     * The method will print all the student’s degrees (not null
     * values). See class Degree.
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
        if ((0 <= i && i < degreeCount) && title != null) {
            degrees[i].setTitleOfThesis(title);
        }
    }

    // Returns the birthDate, by default “Not available”.
    public String getBirthDate() {
        return birthDate;
    }

    /*
     * If the given person id is valid (the method will have to
     * call setPersonID), the method will set the attribute
     * birthdate and return it. If the given person id is not
     * valid, the method will return “No change”. The given
     * person id cannot be null.
     */
    public String setBirthDate(String personId) {
        PersonID person = new PersonID();
        if (personId != null) {
            if (person.setPersonID(personId) == "Ok") {
                this.birthDate = person.getBirthDate();
                return this.birthDate;
            }
        }
        return "No change";
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
        if (graduationYear != 0) {
            return graduationYear - startYear;
        } else {
            return Year.now().getValue() - startYear;
        }
    }

    // ========= PRIVATE METHODS =========

    // The method will calculate a random integer for the range 1-100 (inclusive).
    private int getRandomId() {
        return random.nextInt(ConstantValues.MIN_ID, ConstantValues.MAX_ID);
    }

    /*
     * The method will check the required
     * studies for graduation, i.e., the student has enough of
     * required credits (for both bachelor and masters) and
     * the student has titles for both theses (bachelor and
     * masters). Use ConstantValues.BACHELOR_CREDITS and
     * ConstantValues.MASTER_CREDITS.
     */

    private boolean canGraduate() {
        return ((degrees[0].getCredits() >= ConstantValues.BACHELOR_CREDITS
                && degrees[1].getCredits() >= ConstantValues.MASTER_CREDITS)
                && (!degrees[0].getTitleOfThesis().equals(ConstantValues.NO_TITLE)
                        && !degrees[1].getTitleOfThesis().equals(ConstantValues.NO_TITLE)));
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
     * Lasketaan listasta Master ja Bachelor pisteet.
     * Riippuen i:n arvosta joko 0 tai 1
     */

    private double calcCredits(int i) {
        return degrees[i].getCredits();
    }

    /*
     * OMA METODI
     * getteri joka hakee Master tai Bachelor thesiksen
     */
    private String getThesis(int i) {
        return degrees[i].getTitleOfThesis();
    }

    /*
     * OMA METODI
     * 
     */
    private String checkBachelor() {
        if (degrees[0].getCredits() < ConstantValues.BACHELOR_CREDITS) {
            return String.format("Missing bachelor's credits %.1f (%.1f/180.0)",
                    ConstantValues.BACHELOR_CREDITS - degrees[0].getCredits(), degrees[0].getCredits());
        }
        return String.format("Total bachelor credits completed (%.1f/180.0)", degrees[0].getCredits());
    }

    /*
     * OMA METODI
     * 
     */
    private String checkMaster() {
        if (degrees[1].getCredits() < ConstantValues.MASTER_CREDITS) {
            return String.format("Missing master's credits %.1f (%.1f/120.0)",
                    ConstantValues.MASTER_CREDITS - degrees[1].getCredits(), degrees[1].getCredits());
        }
        return String.format("Total master's credits completed (%.1f/120.0)", degrees[1].getCredits());
    }

    // ======= PRIVATE METHODS END =======

    public String toString() {
        return String.format(
                "Student id: %d\n\tFirst name: %s, Last name: %s\n\tDate of birth: %s\n\tStatus: %s\n\tStart year: %s (studies have lasted for %s years)\n\tTotal credits: %.1f\n\tBachelor credits: %.1f\n\t\t%s\n\t\tTitle of BSc Thesis: \"%s\"\n\tMaster credits: %.1f\n\t\t%s\n\t\tTitle of MSc Thesis: \"%s\"",
                id,
                firstName,
                lastName, birthDate,
                hasGraduated() ? String.format("The student has graduated in %s", getGraduationYear())
                        : "The student has not graduated, yet",
                startYear,
                getStudyYears(),
                credits(),
                calcCredits(0), checkBachelor(), getThesis(0), calcCredits(1), checkMaster(), getThesis(1));
    }

    /* METODIT END */
}