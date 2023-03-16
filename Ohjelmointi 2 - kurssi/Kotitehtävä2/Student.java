
/* KIRJASTOT */
// Random antaa meille numerot 1-100.
import java.util.Random;
// Year antaa meille vuoden arvon.
import java.time.Year;

/* KIRJASTOT END */
public class Student {
    /* ATTRIBUUTIT */
    Random random = new Random();
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
        this(ConstantValues.NO_NAME, ConstantValues.NO_NAME);
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
        setFirstName(fname);
        setLastName(fname);
        setId(getRandomId());
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
        if (!canGraduate())
            return "Check the required studies";
        if (graduationYear < startYear || graduationYear > Year.now().getValue())
            return "Check graduation year";

        this.graduationYear = graduationYear;
        return "Ok";

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
            degrees[i].addStudentCourse(course);
            return true;
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

        for (int k = 0; k < courses.length; k++) {
            if (addCourse(i, courses[k])) {
                count++;
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
                        System.out.println(course.getCourse());
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
            for (Degree result : degrees) {
                result.setTitleOfThesis(title);
            }
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
        if (person != null) {
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

    // The method will calculate a random integer for the range 1-100 (inclusive).
    public int getRandomId() {
        return random.nextInt(ConstantValues.MIN_ID, ConstantValues.MAX_ID);
    }
    // ========= PRIVATE METHODS =========

    /*
     * The method will check the required
     * studies for graduation, i.e., the student has enough of
     * required credits (for both bachelor and masters) and
     * the student has titles for both theses (bachelor and
     * masters). Use ConstantValues.BACHELOR_CREDITS and
     * ConstantValues.MASTER_CREDITS.
     */

    private boolean canGraduate() {

        return degrees[0].getCredits() >= ConstantValues.BACHELOR_CREDITS
                && degrees[1].getCredits() >= ConstantValues.MASTER_CREDITS;

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

    // ======= PRIVATE METHODS END =======

    public String toString() {
        return String.format(
                "Student id: %d\n\tFirst name: %s, Last name: %s\n\tDate of birth: %s\n\tStatus: %s\n\tStart year: %s (studies have lasted for %s years)\n\tTotal credits: %s\n\tBachelor credits: %s\n\t\tTotal bachelor credits completed (%s/180.0)\n\t\tTitle of BSc Thesis: \"%s\"\n\tMaster credits: %s\n\t\tTotal master's credits completed (%s/120.0)\n\t\tTitle of MSc Thesis: \"%s\"",
                id,
                firstName,
                lastName, birthDate,
                hasGraduated() ? String.format("The student has graduated in %s", getGraduationYear())
                        : "The student has not graduated, yet",
                startYear,
                getStudyYears(),
                credits(),
                calcCredits(0), calcCredits(0), getThesis(0), calcCredits(1), calcCredits(1), getThesis(1));
    }

    /* METODIT END */
}
