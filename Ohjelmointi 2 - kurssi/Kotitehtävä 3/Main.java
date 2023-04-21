
/* KIRJASTO */
import java.util.*;
/* KIRJASTO END */
/*
 * 
 * 1. PersonID
 * 2. Course
 * 3. StudentCourse
 * 4. Person (include student.java)
 * 5. Employee (include person and implementing Payment)
 * 6. Payment (include MonthlyPayment and HourBasedPayment)
 * 7. Teacher
 * 8. AssistantTeacher (include Employee and implementing Teacher and Payment)
 * 9. ResponsibleTeacher (include Employee and implementing Teacher and Payment)
 * 10. DesignatedCourse
 */

public class Main {
    public static void main(String[] arg) {
        // ====== Course.java ======

        Course kurssi1 = new Course("Programming 1", 811104, 'P', 1, 1, 1.0, true);
        Course kurssi2 = new Course("All kinds of basic studies", 112233, 'P', 1, 2, 1.0, true);
        Course kurssi3 = new Course("More basic studies", 223344, 'a', 1, 1, 1, true);
        Course kurssi4 = new Course("Even more basic studies", 556677, 'a', 0, 3, 4.0, true);
        Course kurssi5 = new Course("Final basic studies", 123123, 'A', 1, 4, 5, true);

        Course kurssi6 = new Course("Programming 2", 616161, 'A', 1, 3, 25.0, true);
        Course kurssi7 = new Course("All kinds of master studies", 717171, 'P', 0, 2, 45.0, true);
        Course kurssi8 = new Course("More master studies", 818181, 'A', 1, 1, 25.0, true);
        Course kurssi9 = new Course("Even more basic studies", 919191, 'S', 1, 3, 20.0, true);
        Course kurssi10 = new Course("Extra master studies", 666666, 'S', 0, 5, 8.0, false);
        Course kurssi11 = new Course("Final master studies", 223344, 'S', 1, 5, 18.0, false);

        /*
         * TEST
         * 
         * System.out.println(kurssi1);
         * System.out.println(kurssi2);
         * System.out.println(kurssi8);
         * System.out.println(kurssi10);
         * System.out.println(kurssi9);
         */

        // ====== Course.java END ======

        // ====== StudentCourse.java ======

        StudentCourse opiskelija1 = new StudentCourse(kurssi1, 1, 2013);
        StudentCourse opiskelija2 = new StudentCourse(kurssi2, 1, 2014);
        StudentCourse opiskelija3 = new StudentCourse(kurssi3, 1, 2015);
        StudentCourse opiskelija4 = new StudentCourse(kurssi4, 4, 2016);
        StudentCourse opiskelija5 = new StudentCourse(kurssi5, 5, 2017);

        StudentCourse opiskelija6 = new StudentCourse(kurssi6, 1, 2018);
        StudentCourse opiskelija7 = new StudentCourse(kurssi7, 1, 2019);
        StudentCourse opiskelija8 = new StudentCourse(kurssi8, 1, 2020);
        StudentCourse opiskelija9 = new StudentCourse(kurssi9, 2, 2021);
        StudentCourse opiskelija10 = new StudentCourse(kurssi10, 'A', 2021);
        StudentCourse opiskelija11 = new StudentCourse(kurssi11, 'f', 2022);

        /*
         * TEST
         * 
         * System.out.println(opiskelija1);
         * System.out.println(opiskelija2);
         * System.out.println(opiskelija3);
         * System.out.println(opiskelija4);
         * System.out.println(opiskelija5);
         * System.out.println(opiskelija6);
         * System.out.println(opiskelija7);
         * System.out.println(opiskelija8);
         * System.out.println(opiskelija9);
         * System.out.println(opiskelija10);
         * System.out.println(opiskelija11);
         */

        // ====== StudentCourse.java END ======

        // ====== DesignatedCourse.java ======

        // ====== DesignatedCourse.java END ======

        // ====== Degree.java ======
        Degree degree = new Degree();
        Degree degree2 = new Degree();

        List<StudentCourse> bachelor = new ArrayList<>();
        bachelor.add(opiskelija1);
        bachelor.add(opiskelija2);
        bachelor.add(opiskelija3);
        bachelor.add(opiskelija4);
        bachelor.add(opiskelija5);
        List<StudentCourse> master = new ArrayList<>();
        master.add(opiskelija6);
        master.add(opiskelija7);
        master.add(opiskelija8);
        master.add(opiskelija9);
        master.add(opiskelija10);
        master.add(opiskelija11);

        degree.setDegreeTitle("Bachelor of Science");
        degree.setTitleOfThesis("Christmas - The most wonderful time of the year");
        degree2.setDegreeTitle("Master of Science");
        degree2.setTitleOfThesis("Dreaming of a white Christmas");

        degree.addStudentCourses(bachelor);
        degree.addStudentCourses(master);

        /*
         * TESTS
         * 
         * System.out.println(degree.toString());
         * System.out.println(degree2.toString());
         * System.out.println(degree.getGPA(0));
         * 
         */

        // ====== Degree.java END ======

        // ====== Person.java ======
        // !!!!! EXTENDED Student.java !!!!!

        Student student = new Student("Duck", "Donald");
        student.setDegreeTitle(0, "Bachelor of Science");
        student.setDegreeTitle(1, "Master of Science");
        student.setTitleOfThesis(0, "Bachelor thesis title");
        student.setTitleOfThesis(1, "Masters thesis title");
        student.setStartYear(2001);
        student.addCourses(0, bachelor);
        student.addCourses(1, master);
        // TESTING
        /*
         * System.out.println(student.toString());
         */
        System.out.println(student.toString());

        // !!!!! EXTENDED Student.java END !!!!!

        // ====== Person.java END ======

        // ====== Employee.java ======
        // ====== Employee.java END ======

        /* TEST */
        ResponsibleTeacher RT = new ResponsibleTeacher("Mouse", "Mickey");
        MonthlyPayment MP = new MonthlyPayment();
        MP.setSalary(756.85);
        RT.setBirthDate("230498-045T");
        RT.setPayment(MP);
        AssistantTeacher goofy = new AssistantTeacher("The Dog", "Goofy");
        HourBasedPayment GTF = new HourBasedPayment();
        goofy.setBirthDate("141200A2315");
        GTF.setEurosPerHour(3.5);
        GTF.setHours(11);
        goofy.setPayment(GTF);

        Student opiskelija = new Student("Mouse", "Mickey");
        List<DesignatedCourse> courses = new ArrayList<>();
        DesignatedCourse dcKurssi = new DesignatedCourse(kurssi3, true, 2023);
        DesignatedCourse dcKurssi2 = new DesignatedCourse(kurssi4, false, 2023);
        DesignatedCourse dcKurssi3 = new DesignatedCourse(kurssi10, false, 2022);
        DesignatedCourse dcKurssi4 = new DesignatedCourse(kurssi11, true, 2023);
        courses.add(dcKurssi);
        courses.add(dcKurssi2);
        courses.add(dcKurssi3);
        courses.add(dcKurssi4);

        RT.setCourses(courses);
        goofy.setCourses(courses);

        /*
         * System.out.println(RT.toString());
         * System.out.println(goofy.toString());
         * 
         */

    }
}