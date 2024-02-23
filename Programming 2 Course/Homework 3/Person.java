
/* KIRJASTO */
// Random antaa meille satunnaisuuden jota käytetään Student Id:n arpomiseen
import java.util.Random;
/* KIRJASTO END */

public abstract class Person {
    /* ATTRIBUUTIT */
    private Random random = new Random();
    private String firstName = ConstantValues.NO_NAME;
    private String lastName = ConstantValues.NO_NAME;
    private String birthDate = "\"" + ConstantValues.NO_BIRTHDATE + "\"";

    /* ATTRIBUUTIT END */

    /* MUODOSTIN */

    // What should you remember to take care of here?
    public Person(String lname, String fname) {
        setFirstName(fname);
        setLastName(lname);
    }

    /* MUODOSTIN END */

    /* METODIT */

    // By default, returns “No name”.
    public String getFirstName() {
        return firstName;
    }

    // Can be set only if the given name is not null.
    public void setFirstName(String firstName) {
        if (firstName != null) {
            this.firstName = firstName;
        }
    }

    // By default, returns “No name”.
    public String getLastName() {
        return lastName;
    }

    // Can be set only if the given name is not null.
    public void setLastName(String lastName) {
        if (lastName != null) {
            this.lastName = lastName;
        }
    }

    // Returns the birthDate, by default “Not available”
    public String getBirthDate() {
        return birthDate;
    }

    /*
     * If the given person id is valid (the method will have to
     * call setPersonID), the method will set the attribute
     * birthdate and return it. If the given person id is not
     * valid, the method will return “No change”. The given
     * person id cannot be null.
     */

    public String setBirthDate(String personId) {
        PersonID person = new PersonID();
        if (personId != null) {
            if (person.setPersonID(personId) == "Ok") {
                this.birthDate = person.getBirthDate();
                return this.birthDate;
            }
        }
        return "No change";
    }

    // ============== PRIVATE, ABSTRACT METHODS ==============
    // The method will calculate a random integer for the range 1-100 (inclusive).
    protected int getRandomId(final int min, final int max) {
        return min + random.nextInt(max - min) + 1;
    }

    // Abstract method (no functionality).
    abstract String getIdString();

    // ============== PRIVATE, ABSTRACT METHODS END ==============
    /* METODIT END */
}
