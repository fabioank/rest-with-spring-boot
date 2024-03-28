package com.github.restwithspringboot;

public class MathMethods {

    public static boolean isNumeric(String str) {
        if(str == null){
            return false;
        }
        String number = str.replaceAll(",", ".");
        return number.matches("[-+]?[0-9]*\\.?[0-9]+");
    }

    public static Double sum (String n1, String n2){
        return Double.parseDouble(n1) + Double.parseDouble(n2);
    }
}
