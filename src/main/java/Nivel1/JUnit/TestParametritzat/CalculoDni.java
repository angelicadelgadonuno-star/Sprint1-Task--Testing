package Nivel1.JUnit.TestParametritzat;

public class CalculoDni {

    private static final String LETTERS = "TRWAGMYFPDXBNJZSQVHLCKE";
    private static final int DNI_MAX = 99999999;

    public static char calculateDniLetter(int dniNumber) {
        if(dniNumber < 0 || dniNumber > DNI_MAX){
            throw new IllegalArgumentException("DNI number out of range. Must be between 0 and " + DNI_MAX);
        }
        int numberPosition = dniNumber % LETTERS.length();
        return LETTERS.charAt(numberPosition);
    }
}
