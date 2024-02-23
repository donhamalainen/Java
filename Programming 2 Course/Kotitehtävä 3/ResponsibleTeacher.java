
/* KIRJASTO */
import java.util.List;
import java.lang.StringBuilder;
import java.util.ArrayList;

/* KIRJASTO END */
public class ResponsibleTeacher extends Employee implements Teacher, Payment {
    /* ATTRIBUUTIT */

    // An ArrayList of DesignatedCourse objects
    private List<DesignatedCourse> courses = new ArrayList<>();
    /* ATTRIBUUTIT END */

    /* MUODOSTIN */

    // Sets the last and first name of the responsible teacher.
    public ResponsibleTeacher(String lname, String fname) {
        super(lname, fname);
    }
    /* MUODOSTIN END */

    /* METODIT */

    // Returns the string “OY_TEACHER_”.
    protected String getEmployeeIdString() {
        return "OY_TEACHER_";

    }

    /*
     * 
     * Returns a string including the data for the
     * designated courses (utilize toString method of the
     * DesignatedCourse class).
     * Note - If the teacher is responsible for a specific
     * course, the method will add the pre-fix
     * “Responsible teacher: “ to the course output. If
     * the teacher is just a teacher, there is a pre-fix
     * “Teacher: “.
     */

    public String getCourses() {
        String string = "";
        for (DesignatedCourse course : courses) {
            if (course != null) {
                if (course.isResponsible()) {
                    string += "\t" + "Responsible teacher: " + course.toString() + "\n";
                } else {
                    string += "\t" + "Teacher: " + course.toString() + "\n";
                }
            }
        }
        return string;
    }

    // Sets the given courses (if the given parameter is not null).
    public void setCourses(List<DesignatedCourse> courses) {
        if (courses != null) {
            this.courses = courses;
        }
    }

    /*
     * 
     * The method will output the expected output for a
     * ResponsibleTeacher.
     */
    public String toString() {
        return String.format(
                "Teacher id: %s\n\tFirst name: %s, Last name: %s\n\tBirthdate: %s\n\tSalary: %.2f\n\tTeacher for courses: %s",
                getIdString(), getFirstName(),
                getLastName(), getBirthDate(), getPayment().calculatePayment(), getCourses());
    }
    /* METODIT END */
}
