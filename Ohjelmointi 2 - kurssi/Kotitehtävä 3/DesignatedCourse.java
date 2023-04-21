
/* KIRJASTO
 * 
 * Year. Antaa meille vuoden
 */
import java.time.Year;

/* KIRJASTO END */
public class DesignatedCourse {
    /* ATTRIBUUTIT */
    private Course course;
    private boolean responsible;
    private int year;
    /* ATTRIBUUTIT END */

    /* MUODOSTIN */
    public DesignatedCourse() {

    }

    public DesignatedCourse(Course course, boolean resp, int year) {
        setCourse(course);
        setResponsible(resp);
        setYear(year);

    }
    /* MUODOSTIN END */

    /* METODIT */

    // Returns the course.
    public Course getCourse() {
        return course;
    }

    // Sets the given course (if not null).
    public void setCourse(Course course) {
        if (course != null) {
            this.course = course;
        }
    }

    // false = not responsible, true = responsible
    public boolean isResponsible() {
        if (getResponsible()) {
            return true;
        }
        return false;
    }

    // Sets the given value.
    public void setResponsible(boolean responsible) {
        this.responsible = responsible;
    }

    // Returns the responsible.
    public boolean getResponsible() {
        return responsible;
    }

    // Returns the year
    public int getYear() {
        return year;
    }

    /*
     * The method sets the given year if the value is
     * 2000 <= year <= (current year +1 ).
     */
    public void setYear(int year) {
        if (2000 <= year && year <= (Year.now().getValue() + 1)) {
            this.year = year;
        }
    }

    /*
     * The method will output the expected output for a
     * DesignatedCourse. ***)
     */

    /* ================ PRIVATE METODS ================ */

    /* ================ PRIVATE METODS END ================ */
    public String toString() {
        return String.format("[course=%s, year=%d]", course, year);
    }
    /* METODIT END */
}
