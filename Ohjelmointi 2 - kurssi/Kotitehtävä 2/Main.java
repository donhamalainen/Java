
/*
 * 1. PersonID.java
 * 2. Course.java
 * 3. StudentCourse.java
 * 4. Degree.java
 * 5. Student.java
 */
public class Main {
    public static void main(String[] args) {
        // ====== PersonID.java ======

        // PersonID person = new PersonID();

        /*
         * TEST
         * 
         * (If you test this, change PersonID.java line 112 to public)!
         * 
         * String x = person.setPersonID("120499-1238");
         * boolean y = person.checkBirthdate("11.06.2000");
         * System.out.println(y);
         */

        // ====== PersonID.java END ======
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

        Course testi1 = new Course("humzdaigol", 989760, 'S', 1, 1, 38.0, true);
        Course testi2 = new Course("qsefhsimkp", 229717, 'S', 0, 5, 54.0, true);
        Course testi3 = new Course("srictimhvj", 684376, 'P', 1, 3, 51.0, true);
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
        StudentCourse opiskelija8 = new StudentCourse(kurssi8, 2, 2020);
        StudentCourse opiskelija9 = new StudentCourse(kurssi9, 0, 2021);
        StudentCourse opiskelija10 = new StudentCourse(kurssi10, 'A', 2021);
        StudentCourse opiskelija11 = new StudentCourse(kurssi11, 'f', 2022);

        StudentCourse opiskelijaTesti1 = new StudentCourse(testi1, 0, 2012);
        StudentCourse opiskelijaTesti2 = new StudentCourse(testi2, 1, 2022);
        StudentCourse opiskelijaTesti3 = new StudentCourse(testi3, 2, 2010);

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
        Degree degree3 = new Degree();
        Degree test = new Degree();

        StudentCourse[] bachelor = { opiskelija1, opiskelija2, opiskelija3, opiskelija4, opiskelija5, opiskelija6,
                opiskelija7, opiskelija8, opiskelija9, opiskelija10, opiskelija11, opiskelija1, opiskelija2,
                opiskelija3, opiskelija4, opiskelija5, opiskelija6,
                opiskelija7, opiskelija8, opiskelija9, opiskelija10, opiskelija11, opiskelija1, opiskelija2,
                opiskelija3, opiskelija4, opiskelija5, opiskelija6,
                opiskelija7, opiskelija8, opiskelija9, opiskelija10, opiskelija11, opiskelija1, opiskelija2,
                opiskelija3, opiskelija4, opiskelija5, opiskelija6,
                opiskelija7, opiskelija8, opiskelija9, opiskelija10, opiskelija11, opiskelija6, opiskelija7,
                opiskelija8, opiskelija9, opiskelija10, opiskelija11, opiskelija1 };
        StudentCourse[] master = { opiskelija6, opiskelija7, opiskelija8, opiskelija9, opiskelija10, opiskelija11 };
        StudentCourse[] testi = { opiskelija11, opiskelija11, opiskelija1 };

        /*
         * degree1.addStudentCourse(opiskelijaTesti1);
         * degree1.addStudentCourse(opiskelijaTesti2);
         * degree1.addStudentCourse(opiskelijaTesti3);
         */

        degree1.addStudentCourses(testi);
        System.out.println(degree1.getCreditsByBase('P'));
        /*
         * degree1.isCourseCompleted(opiskelijaTesti1);
         * degree1.addStudentCourses(opiskelijaTesti1);
         * degree1.isCourseCompleted(opiskelijaTesti1);
         * degree1.addStudentCourse(opiskelijaTesti1);
         * degree1.isCourseCompleted(opiskelijaTesti1);
         */
        // test.addStudentCourse();

        degree1.setDegreeTitle("Bachelor of Science");
        degree2.setDegreeTitle("Master of Science");

        degree1.setTitleOfThesis("Christmas - The most wonderful time of the year");

        degree2.setTitleOfThesis("Master thesis title");

        /*
         * 
         * System.out.println(degree1.toString());
         * System.out.println(degree2.toString());
         * System.out.println(degree3.toString());
         * 
         * TEST
         *
         * System.out.println(degree1.toString());
         * System.out.println(degree2.toString());
         * System.out.println(degree3.toString());
         */

        // ====== Degree.java END ======

        // ====== Student.java ======

        Student student = new Student();
        Student testiStudent = new Student();

        student.addCourses(0, bachelor);
        student.addCourses(1, master);

        student.setstartYear(2001);
        student.setGraduationYear(2020);

        student.setFirstName("Donald");
        student.setLastName("Duck");

        // student.setBirthDate("230498-045T");
        student.setTitleOfThesis(0, "Christmas - The most wonderful time of the year");
        student.setTitleOfThesis(1, "Dreaming of a white Christmas");

        /*
         * testiStudent.setFirstName("Minnie");
         * testiStudent.setLastName("Mouse");
         * testiStudent.setId(14674);
         * testiStudent.addCourse(0, opiskelijaTesti3);
         * testiStudent.setTitleOfThesis(0, "Time Exciting Christmas");
         * testiStudent.setstartYear(2005);
         * testiStudent.setGraduationYear(2022);
         */

        // System.out.println(testiStudent.addCourses(0, bachelor));

        /*
         * TEST
         * System.out.println(student.toString());
         */

        // ====== Student.java END ======
    }
}

/*
 * studentid34
 * firstname duck, lastname unexpected
 * dateofbirth 16121950
 * status: thestudenthasnotgraduatedyet
 * startyear2023 (studieshavelastedfor0years)
 * total credits: 129.0
 * bachelorcredits: 42.0
 * totalbachelorcreditscompleted (42.0/180.0)
 * titleofbscthesis: "christmasyearexcitin"
 * gthemastercredits870totalmasterscreditscompleted8701200titleofmscthesisnotitle
 */