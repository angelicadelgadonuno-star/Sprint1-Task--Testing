package Nivel1.JUnit.ControlDeExcepciones;

public class ArrayAccess {

    private static final String[] TOYS = {"Doll", "Robot", "Ball"};

    public static String getToyByPosition(int position){
        return TOYS[position];
    }
}
