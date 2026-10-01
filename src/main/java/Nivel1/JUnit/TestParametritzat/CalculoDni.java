package Nivel1.JUnit.TestParametritzat;

import com.sun.jdi.StringReference;

public class CalculoDni {

    private int dniNumber;
    private char dniLetter;

    public CalculoDni(int dniNumber, char dniLetter) {
        this.dniNumber = dniNumber;
        this.dniLetter = dniLetter;
    }

    public char getDniLetter() {
        return dniLetter;
    }

    public char calculateDniLetter (int dniNumber){
       int numberPosition = dniNumber % 23;
       String letterPosition = "TRWAGMYFPDXBNJZSQVHLCKE";
        return letterPosition.charAt(numberPosition);
    }
}
