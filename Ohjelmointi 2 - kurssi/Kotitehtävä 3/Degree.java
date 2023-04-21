
/* KIRJASTO */
import java.util.ArrayList;
import java.util.List;
/* KIRJASTO END */

public class Degree {
    /* ATTRIBUUTIT */
    private static final int MAX_COURSES = 50;
    private String degreeTitle = ConstantValues.NO_TITLE;
    private String titleOfThesis = ConstantValues.NO_TITLE;
    private List<StudentCourse> myCourses = new ArrayList<>(MAX_COURSES);
    /* ATTRIBUUTIT END */

    /* METODIT */

    // Returns the courses of this degree.
    public List<StudentCourse> getCourses() {
        return myCourses;
    }

    /*
     * The method will set the courses if the
     * object is not null and courses can be
     * added. The method should utilize the
     * method addStudentCourse (see below).
     */

    public void addStudentCourses(List<StudentCourse> courses) {
        if (courses != null) {
            for (StudentCourse input : courses) {
                addStudentCourse(input);
            }
        }
    }

    /*
     * The method will set the course if the
     * method is not null and the number of
     * added courses is less than
     * MAX_COURSES.
     */
    public boolean addStudentCourse(StudentCourse course) {
        if (course != null && myCourses.size() < MAX_COURSES) {
            myCourses.add(course);
            return true;
        }
        return false;
    }

    // The method returns the degreeTitle
    public String getDegreeTitle() {
        return degreeTitle;
    }

    // The method will set the degreeTitle if the given string is not null.
    public void setDegreeTitle(String degreeTitle) {
        if (degreeTitle != null) {
            this.degreeTitle = degreeTitle;
        }
    }

    // The method will return the title of the thesis.
    public String getTitleOfThesis() {
        return titleOfThesis;
    }

    // The method will set the titleOfThesis is the given string is not null.
    public void setTitleOfThesis(String titleOfThesis) {
        if (titleOfThesis != null) {
            this.titleOfThesis = titleOfThesis;
        }
    }

    /*
     * The method will return the sum of the
     * credits for all completed courses for a
     * given base (‘P’, ‘A’ or ‘S’).
     */

    public double getCreditsByBase(Character base) {
        double count = 0;
        for (StudentCourse courses : myCourses) {
            if (courses != null && (base == 'A' || base == 'S' || base == 'P')) {
                if ((courses.getCourse().getCourseBase() == base) && isCourseCompleted(courses)) {
                    count += courses.getCourse().getCredits();
                }

            }
        }
        return count;
    }

    /*
     * The method will return the sum of the credits
     * for all completed courses for a given type (0 =
     * optional , 1 = mandatory).
     */
    public double getCreditsByType(final int courseType) {
        double count = 0;
        for (StudentCourse courses : myCourses) {
            if (courses != null && (courseType == 0 || courseType == 1)) {
                if (courses.getCourse().getCourseType() == courseType && isCourseCompleted(courses)) {
                    count += courses.getCourse().getCredits();
                }
            }
        }
        return count;
    }

    /*
     * The method will return the sum of all
     * completed courses
     */
    public double getCredits() {
        double creditCount = 0.0;
        for (StudentCourse courses : myCourses) {
            if (courses != null && isCourseCompleted(courses)) {
                creditCount += courses.getCourse().getCredits();
            }
        }
        return creditCount;
    }

    /*
     * The method will calculate the sum, count
     * and average of the given type of courses
     * for the degree (type => OPTIONAL,
     * MANDATORY, ALL) – and store those
     * values to the list (as double values) in that given order (sum, count,
     * average). If
     * there are no courses, the values will be
     * set to 0.0.
     * NOTE
     * – THE GPA is calculated by dividing
     * the SUM of numeric grades DIVIDED by
     * the NUMBER OF COURSES (completed
     * with numeric grading)
     * .
     * E.g., see below example output.
     * There are 5 bachelor courses (all having
     * numeric grading). The sum of the grades
     * is (1+1+1+4+5=) 12 and the count of
     * courses is 5 => therefore GPA here is 2,4.
     * There are 6 masters courses
     * – but only
     * four of them have numeric grading). The
     * sum of the grades is (1+1+2+
     * 0=) 4 =>
     * therefore GPA here is 1,00
     * .
     * So, there are 11 courses in total
     * - of
     * which 9 has numeric grading. The sum of
     * those grades are 16. Therefore the total
     * GPA is 1,78.
     */

    public List<Double> getGPA(int type) {
        double sum = 0.0;
        double count = 0.0;
        double average = 0.0;

        if (type == ConstantValues.ALL) {
            for (StudentCourse course : myCourses) {
                if (course != null) {
                    if (course.getCourse().isNumericGrade()) {
                        sum += course.getGradeNum();
                        count++;
                    }
                }
            }
        } else {
            for (StudentCourse course : myCourses) {
                if (course != null) {
                    if (course.getCourse().isNumericGrade() && course.getCourse().getCourseType() == type) {
                        sum += course.getGradeNum();
                        count++;
                    }
                }
            }
        }
        if (count != 0) {
            average = sum / count;
        }
        List<Double> result = new ArrayList<>();
        result.add(sum);
        result.add(count);
        result.add(average);
        return result;
    }

    // ================ PRIVATE METHODS ================

    /*
     * The method will return the boolean value whether a course is completed or
     * not.
     * - If the course is not null and the course has
     * numeric grading, the course is completed if
     * the grade is > 0.
     * 
     * - If the course is not null and the course has
     * letter grading the course is completed if the
     * grade is ‘A’.
     * 
     *  utilize method isPassed (see
     * StudentCourse class).
     */
    private boolean isCourseCompleted(StudentCourse c) {
        if (c != null && c.isPassed()) {
            return true;
        }
        return false;
    }

    /*
     * OMA METODI
     * Formalisoi merkkijonon kurssien mukaan järjestyksessä tulostusta varten.
     */
    private String printter(List<StudentCourse> c) {
        String formatted = "";
        int x = 1;
        for (StudentCourse course : c) {
            if (course != null) {
                formatted += String.format("\n\t%d. %s", x++, course);
            }
        }
        return formatted;
    }

    // ============== PRIVATE METHODS END ==============

    /*
     * The method will output all StudentCourses
     * (which are not null).
     */
    public void printCourses() {
        for (StudentCourse c : myCourses) {
            if (c != null) {
                System.out.println(c);
            }
        }
    }

    /*
     * The method will output the expected output
     * for an object of type Degree.
     */
    public String toString() {
        return String.format("Degree [Title: \"%s\" (courses: %d)\n\tThesis title: \"%s\"%s]\n",
                degreeTitle,
                myCourses.size(),
                titleOfThesis,
                printter(myCourses));
    }
    /* METODIT END */
}
