public class Course {
    /* ATTRIBUUTIT */

    private String name;
    private String courseCode;
    private Character courseBase;
    private int courseType;
    private int period;
    private double credits = ConstantValues.MIN_CREDITS;
    private boolean numericGrade;

    /* ATTRIBUUTIT END */

    /* MUODOSTIN */

    // Parameter-less constructor (no functionality).
    public Course() {
    }

    /*
     * The constructor must set the attribute values (and check for valid
     * values for most of those – preferably by utilizing methods of the
     * class (setName, setCourseCode, setCourseType, setPeriod,
     * setCredits).
     */
    public Course(String name, final int code, Character courseBase, final int type, final int period,
            final double credits, boolean numericGrade) {
        setName(name);
        setCourseCode(code, courseBase);
        setCourseType(type);
        setPeriod(period);
        setCredits(credits);
        setNumericGrade(numericGrade);
    }

    // The constructor must set the attribute values.
    public Course(Course course) {
        this.name = course.name;
        this.courseBase = course.courseBase;
        this.courseType = course.courseType;
        this.courseCode = course.courseCode;
        this.credits = course.credits;
        this.numericGrade = course.numericGrade;
        this.period = course.period;
    }

    /* MUODOSTIN END */

    /* METODIT */

    // Returns the course name.
    public String getName() {
        return name;
    }

    // The method will set the name of the course if the name is not empty or null.
    public void setName(String name) {
        if (name != null && !name.isEmpty()) {
            this.name = name;
        }
    }

    /*
     * The method will return the string description of the course type (0 =
     * “Optional” and 1 = “Mandatory”
     */
    public String getCourseTypeString() {
        return (courseType == 0) ? "Optional" : "Mandatory";
    }

    // The method will return the type of the course (0 or 1).
    public int getCourseType() {
        return courseType;
    }

    // The method will set the type if the value is either 0 or 1
    public void setCourseType(final int type) {
        if (type == 0 || type == 1) {
            this.courseType = type;
        }
    }

    // The method will return the courseCode.
    public String getCourseCode() {
        return courseCode;
    }

    /*
     * If the courseCode is valid (0 < courseCode <
     * 1000000) and courseBase is valid (‘A’, or ‘P’, or ‘S’),
     * the method will set the courseCode as e.g., 811322A
     * (concatenate the courseCode and courseBase) and
     * set the courseBase.
     */
    public void setCourseCode(final int courseCode, Character courseBase) {
        if ((0 < courseCode && courseCode < 1000000) && (courseBase == 'A' || courseBase == 'P' || courseBase == 'S'
                || courseBase == 'a' || courseBase == 'p' || courseBase == 's')) {
            this.courseBase = Character.toUpperCase(courseBase);
            this.courseCode = String.valueOf(courseCode) + this.courseBase;
        }
    }

    // The method will return the courseBase.
    public Character getCourseBase() {
        return courseBase;
    }

    // The method will return the period of the course
    public int getPeriod() {
        return period;
    }

    /*
     * The method will set the period if the given period is
     * within the limits
     * (MIN_PERIOD <= period <= MAX_PERIOD).
     */
    public void setPeriod(final int period) {
        if (ConstantValues.MIN_PERIOD <= period && period <= ConstantValues.MAX_PERIOD) {
            this.period = period;
        }
    }

    // The method will return the number of credits.
    public double getCredits() {
        return credits;
    }

    // The method will return numericGrade
    public boolean isNumericGrade() {
        return numericGrade;
    }

    // The method will set numericGrade.
    public void setNumericGrade(boolean numericGrade) {
        this.numericGrade = numericGrade;
    }
    // =========== PRIVATE METODIT ===========

    /*
     * Private method. The method will set the credits if
     * the given value is within the limits
     * (MIN_CREDITS <= credits <= MAX_COURSE_CREDITS)
     */
    private void setCredits(final double credits) {
        if (ConstantValues.MIN_CREDITS <= credits && credits <= ConstantValues.MAX_COURSE_CREDITS) {
            this.credits = credits;
        }
    }

    // ========= PRIVATE METODIT END =========

    /*
     * The method will output the expected output for an
     * object of type Course.
     */
    public String toString() {
        return String.format("[%s (%5.2f cr), \"%s\". %s, period: %s].", courseCode, credits, name,
                getCourseTypeString(),
                period);
    }

    /* METODIT END */
}