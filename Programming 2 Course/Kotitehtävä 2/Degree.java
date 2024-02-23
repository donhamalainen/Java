public class Degree {
    /* ATTRIBUUTIT */

    private static final int MAX_COURSES = 50;
    private int count = 0;
    private String degreeTitle = ConstantValues.NO_TITLE;
    private String titleOfThesis = ConstantValues.NO_TITLE;
    private StudentCourse[] myCourses = new StudentCourse[MAX_COURSES];

    /* ATTRIBUUTIT END */

    /* METODIT */

    // Returns the courses of this degree.
    public StudentCourse[] getCourses() {
        return myCourses;
    }

    /*
     * The method will set the courses if the object is
     * not null and courses can be added. The
     * method should utilize the method
     * addStudentCourse (see below).
     */
    public void addStudentCourses(StudentCourse[] courses) {
        if (courses != null) {
            for (StudentCourse input : courses) {
                addStudentCourse(input);
            }
        }
    }

    /*
     * The method will set the course if the method
     * is not null and the number of added courses is
     * less than MAX_COURSES. The method will also
     * udpate the value of count.
     */
    public boolean addStudentCourse(StudentCourse course) {
        if (course != null && count < MAX_COURSES) {
            // Asettaa kurssin taulukkoon
            myCourses[count] = course;
            count++;
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
     * The method will return the sum of the credits
     * for all completed courses for a given base (‘P’,
     * ‘A’ or ‘S’).
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
    private String printter(StudentCourse[] c) {
        String formatted = "";
        int x = 1;
        for (StudentCourse course : c) {
            if (course != null) {
                formatted += String.format("\n\t%d. %s]", x++, course);
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
                count,
                titleOfThesis,
                printter(myCourses));
    }
    /* METODIT END */
}
