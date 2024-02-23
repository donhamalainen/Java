
/* KIRJASTO */

import java.util.List;
import java.util.ArrayList;
import java.lang.StringBuilder;

/* KIRJASTO END */

public class AssistantTeacher extends Employee implements Teacher {
    /* ATTRIBUUTIT */
    private List<DesignatedCourse> courses = new ArrayList<>();
    /* ATTRIBUUTIT END */

    /* MUODOSTIN */

    // Sets the last and first name of the assistant teacher.
    public AssistantTeacher(String lname, String fname) {
        super(lname, fname);
    }
    /* MUODOSTIN END */

    /* METODIT */
    /*
     * Returns the string “OY_ASSISTANT_”
     */
    public String getEmployeeIdString() {
        return "OY_ASSISTANT_";
    }

    /*
     * Returns a string including the data for the
     * 
     * DesignatedCourse class).
     * 
     */
    public String getCourses() {
        StringBuilder builder = new StringBuilder();
        for (DesignatedCourse course : courses) {
            if (course != null) {
                builder.append("\t").append(course.toString()).append("\n");
            }

        }
        return builder.toString();
    }

    /*
     * Sets the given courses (if the given parameter is
     * not null).
     */
    public void setCourses(List<DesignatedCourse> courses) {
        if (courses != null) {
            this.courses = courses;
        }
    }

    // OUTPUT
    public String toString() {
        return String.format(
                "Teacher id: %s\n\tFirst name: %s, Last name: %s\n\tBirthdate: %s\n\tSalary: %.2f\n\tAssistant for courses: %s",
                getIdString(),
                getFirstName(),
                getLastName(), getBirthDate(), getPayment().calculatePayment(), getCourses());
    }
    /* METODIT END */
}
