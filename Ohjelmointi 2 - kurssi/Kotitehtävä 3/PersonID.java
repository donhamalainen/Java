
public class PersonID {
    /* ATTRIBUUTIT */
    private String birthDate = ConstantValues.NO_BIRTHDATE;
    /* ATTRIBUUTIT END */

    /* METODIT */

    // Returns the birthDate, by default “Not available”.
    public String getBirthDate() {
        return birthDate;
    }

    /*
     * The method will first call the method
     * checkPersonIDNumber, if that is ok, the method
     * will split the given string into format dd. mm.yyyy
     * and check that the 7th character in the person ID is
     * valid (either ‘+’, ‘-‘ or ‘A’, based on the year of
     * birth). The method will also check the given String
     * has a valid date (yymmdd with method
     * checkBirthdate) and that the check mark in the
     * given person id is correct (with method
     * checkValidCharacter).
     * - If the given string does not have 11 characters in
     * it or the 7th character is not a valid one (see
     * method checkPersonIDNumber), the method
     * will return “Invalid birthday!”.
     * - If the given string does not include a valid date
     * (see method checkBirthdate), the method will
     * return “Invalid birthday!”.
     * - If the given string does not have a valid check
     * character (see method checkValidCharacter),
     * the method will return “Incorrect check mark!”.
     * - If the given string is ok, the method will set the
     * birthdate and return “Ok”.
     */
    public String setPersonID(final String personID) {
        if (checkPersonIDNumber(personID)) {
            String days = personID.substring(0, 2);
            String month = personID.substring(2, 4);
            String year = personID.substring(4, 6);
            year = checkYear(year, personID.charAt(6));
            String formattedDate = (days + "." + month + "." + year);

            if (checkBirthdate(formattedDate)) {
                if (checkValidCharacter(personID)) {
                    this.birthDate = formattedDate;
                    return "Ok";
                }
                return ConstantValues.INCORRECT_CHECKMARK;
            }
            return ConstantValues.INVALID_BIRTHDAY;
        }
        return ConstantValues.INVALID_BIRTHDAY;
    }

    // ===================== PRIVATE METODIT ======================

    /*
     * Private method. The method will check the given
     * string has 11 characters and that the “century
     * character” in the string is a valid one, ‘+’, ‘-‘ or ‘A’.
     */
    private boolean checkPersonIDNumber(final String personID) {
        char century = personID.charAt(6);
        if (personID.length() != 11 || (century != '+' && century != '-' && century != 'A')) {
            return false;
        }
        return true;
    }

    /*
     * Private method. The method will check whether
     * the given year is a leap year or not (true = leap
     * year).
     */
    private boolean checkLeapYear(int year) {
        return year % 4 == 0 && (year % 100 != 0 || year % 400 == 0);
    }

    /*
     * The method will check the last
     * character of the person id is given correctly.
     * Note – here, in this method, the value “221199-
     * 123A” can be set to be a valid test value (although
     * not a valid value in real life)
     */
    private boolean checkValidCharacter(final String personID) {
        char[] list = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F', 'H', 'J', 'K',
                'L', 'M', 'N', 'P', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y' };

        char lastCharacter = personID.charAt(personID.length() - 1);
        String ppkkvv = personID.substring(0, 6);
        String nnn = personID.substring(7, 10);
        String muunnos = ppkkvv + nnn;
        int x = Integer.parseInt(muunnos) % 31;
        if (list[x] == lastCharacter) {
            return true;
        }
        return false;
    }

    /*
     * The method will split the day,
     * month and year from the given string and ensures
     * the given year (positive value), the given month (1-
     * 12) and day (1-31) is within those valid ranges. In
     * addition, if the previous conditions are met, the
     * method will have to ensure the given days are valid
     * for the given month. In the possible special case off
     */
    private boolean checkBirthdate(final String date) {
        if (date.length() != 10) {
            return false;
        }
        int days = Integer.parseInt(date.substring(0, 2));
        int month = Integer.parseInt(date.substring(3, 5));
        int year = Integer.parseInt(date.substring(6, 10));
        if (year >= 0 && (month > 0 && month <= 12) && (days > 0 && days <= 31)) {
            return checkDay(days, month, year);

        }
        return false;
    }

    private boolean checkDay(int day, int month, int year) {
        if (day < 1)
            return false;

        switch (month) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                return day <= 31;
            case 4:
            case 6:
            case 9:
            case 11:
                return day <= 30;
            case 2:
                if (checkLeapYear(year))
                    return day <= 29;
                return day <= 28;
            default:
                throw new RuntimeException("Invalid month");
        }
    }

    /*
     * OMA METODI
     * Tarkistaa vuoden ja tarkistusmerkin yhteneväisyyden
     */
    private String checkYear(String year, char century) {
        switch (century) {
            case '+':
                return "18" + year;
            case '-':
                return "19" + year;
            case 'A':
                return "20" + year;
            default:
                throw new RuntimeException("Invalid century character");
        }
    }

    // =================== PRIVATE METODIT END ====================
    /* METODIT END */
}
