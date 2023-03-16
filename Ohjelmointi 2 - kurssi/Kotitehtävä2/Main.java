
/*
 * 1. PersonID.java
 * 2. Course.java
 * 3. StudentCourse.java
 * 4. Degree.java
 * 5. Student.java
 */
public class Main {
    public static void main(String[] args) {
        // Student opiskelija = new Student();

        // ====== Course.java ======
        Course kurssi1 = new Course("Programming 1", 811104, 'P', 1, 1, 5.0, true);
        Course kurssi2 = new Course("All kinds of basic studies", 112233, 'P', 1, 2, 45.0, true);
        Course kurssi3 = new Course("More basic studies", 223344, 'a', 1, 1, 50.5, true);
        Course kurssi4 = new Course("Even more basic studies", 556677, 'a', 0, 3, 50.0, true);
        Course kurssi5 = new Course("Final basic studies", 123123, 'A', 1, 4, 50.5, true);
        Course kurssi6 = new Course("Programming 2", 616161, 'A', 1, 3, 25.0, true);
        Course kurssi7 = new Course("All kinds of master studies", 717171, 'P', 0, 2, 45.0, true);
        Course kurssi8 = new Course("More master studies", 818181, 'A', 1, 1, 25.0, true);
        Course kurssi9 = new Course("Even more basic studies", 919191, 'S', 1, 3, 20.0, true);
        Course kurssi10 = new Course("Extra master studies", 666666, 'S', 0, 5, 8.0, false);
        Course kurssi11 = new Course("Final master studies", 223344, 'S', 1, 5, 18.0, false);

        /*
         * TEST
         * 
         * 
         * System.out.println(kurssi2);
         * System.out.println(kurssi8);
         * System.out.println(kurssi10);
         * System.out.println(kurssi9);
         */
        System.out.println(kurssi1);
        // ====== Course.java END ======

        // ====== StudentCourse.java ======

        StudentCourse opiskelija1 = new StudentCourse(kurssi1, 1, 2013);
        StudentCourse opiskelija2 = new StudentCourse(kurssi2, 1, 2014);
        StudentCourse opiskelija3 = new StudentCourse(kurssi3, 1, 2015);
        StudentCourse opiskelija4 = new StudentCourse(kurssi4, 4, 2016);
        StudentCourse opiskelija5 = new StudentCourse(kurssi5, 5, 2017);
        StudentCourse opiskelija6 = new StudentCourse(kurssi6, 1, 2018);
        StudentCourse opiskelija7 = new StudentCourse(kurssi7, 1, 2019);
        StudentCourse opiskelija8 = new StudentCourse(kurssi8, 2, 2020);
        StudentCourse opiskelija9 = new StudentCourse(kurssi9, 0, 2021);
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

        // ====== Degree.java ======
        Degree degree1 = new Degree();
        Degree degree2 = new Degree();
        StudentCourse[] bachelor = { opiskelija1, opiskelija2, opiskelija3, opiskelija4, opiskelija5 };
        StudentCourse[] master = { opiskelija6, opiskelija7, opiskelija8, opiskelija9, opiskelija10, opiskelija11 };
        degree1.addStudentCourses(bachelor);
        degree2.addStudentCourses(master);

        degree1.setDegreeTitle("Bachelor of Science");
        degree2.setDegreeTitle("Master of Science");

        degree1.setTitleOfThesis("Bachelor thesis title");
        degree2.setTitleOfThesis("Master thesis title");

        /*
         * TEST
         * 
         * System.out.println(degree1.toString());
         * System.out.println(degree2.toString());
         * System.out.println(degree3.toString());
         */

        // ====== Degree.java END ======

        // ====== Student.java ======

        Student student = new Student();
        student.addCourses(0, bachelor);
        student.addCourses(1, master);

        student.setstartYear(2001);
        student.setGraduationYear(2020);

        student.setFirstName("Donald");
        student.setLastName("Duck");

        student.setBirthDate("230498-045T");
        student.setTitleOfThesis(0, "Christmas - The most wonderful time of the year");
        student.setTitleOfThesis(1, "Dreaming of a white Christmas");

        System.out.println(student.toString());

        // ====== Student.java END ======
    }
}