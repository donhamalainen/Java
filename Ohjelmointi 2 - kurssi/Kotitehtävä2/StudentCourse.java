import java.time.Year;

public class StudentCourse {
    /* ATTRIBUUTIT */

    // A course a student has completed.
    private Course course;

    /*
     * A grade of the student for the course.
     * For a numerically graded course the range is 0-5, for a letter graded course
     * the value can either be ‘F’ (failed) or ‘A’ (accepted).
     */
    private int gradeNum;

    /*
     * Year when the student has completed this course. The year must be within
     * the range 2000 < yearCompleted < currentYear.
     */
    private int yearCompleted;

    /* ATTRIBUUTIT END */

    /* MUODOSTIMET */

    // Parameter-less constructor (no functionality).
    public StudentCourse() {
    }

    /*
     * The constructor will set the given course, gradeNum and
     * yearCompleted for the course. Preferably, for the gradeNum the
     * method setGrade should be used.
     */
    public StudentCourse(Course course, final int gradeNum, final int yearCompleted) {
        setCourse(course);
        setGrade(gradeNum);
        setYear(yearCompleted);
    }

    /* MUODOSTIMET END */

    /* METODIT */

    // Returns the course.
    public Course getCourse() {
        return course;
    }

    // The method will set the course.
    public void setCourse(Course course) {
        this.course = course;
    }

    // The method will return gradeNum.
    public int getGradeNum() {
        return gradeNum;
    }

    // The method will return false if the grade is 0 or ‘F’.
    public boolean isPassed() {
        if (gradeNum == ConstantValues.MIN_GRADE
                || Character.toUpperCase((char) gradeNum) == ConstantValues.GRADE_FAILED) {
            return false;
        }
        return true;
    }

    // The method will return yearCompleted.
    public int getYear() {
        return yearCompleted;
    }

    /*
     * The method will set the yearCompleted if the given value
     * is within the range 2000 < year <= currentYear
     */
    public void setYear(final int year) {
        if (2000 < year && year <= Year.now().getValue()) {
            this.yearCompleted = year;
        }
    }

    // ========== PRIVATE, PROTECTED METHDOS ===========

    /*
     * The method will check whether the course is graded numerically or not.
     * - If the course is graded numerically, the given value
     * must be within the range (0 <= value <= 5, utilize
     * method checkGradeValidity)
     * - If the course has letter grading, the value must be
     * either ‘F’ or ‘A’ (utilize method checkGradeValidity).
     * - In addition, if yearCompleted has not been set, it will
     * bet set to the current year.
     */
    protected void setGrade(int gradeNum) {
        if (checkGradeValidity(gradeNum)) {
            this.gradeNum = gradeNum;
        }

        if (this.yearCompleted == 0) {
            this.yearCompleted = Year.now().getValue();
        }
    }

    /*
     * The method will check whether the
     * given value is acceptable (0-5 or ‘F’ or ‘A’). Only if the
     * value is acceptable, the method will return true.
     */
    private boolean checkGradeValidity(final int gradeNum) {
        char x = Character.toUpperCase((char) gradeNum);
        if (course.isNumericGrade()) {
            return (gradeNum >= ConstantValues.MIN_GRADE && gradeNum <= ConstantValues.MAX_GRADE);
        } else if (!course.isNumericGrade()) {
            return (x == 'A' || x == 'F');
        }
        return false;
    }

    /*
     * OMA METODI
     * Tarkistaa gradeNumberin. Jos se on 0, niin ulos tulee "Not graded"
     * Jos numeerinen 1-5 niin tulee numero
     * Jos "F", niin "F."
     * Jos "A", niin "A."
     */
    private String checkGrade(final int check) {
        char letter = (char) check;
        if (letter == 'F' || letter == 'f') {
            return "F";
        } else if (letter == 'A' || letter == 'a') {
            return "A";
        } else if (letter == 0) {
            return "\"Not graded\"";
        } else {
            return String.format("%s", gradeNum);
        }
    }
    // ======== PRIVATE, PROTECTED METHDOS END ===========

    public String toString() {
        return String.format("%s Year: %s, Grade: %s.]", course, yearCompleted, checkGrade(gradeNum));
    }

    /* METODIT END */
}
