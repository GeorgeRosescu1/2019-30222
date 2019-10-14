package com.company;
/*
    HomeWork text(part of it):
    For the 􏰀first assignment you are asked to create a Java app whose scope would be that given a FirstName LastName
    it will return the LastName, FirstName. Sounds easy? Let's see if you manage to cover all the test cases.
    The requirement for this assignment is to create a method which receives a String as a
    parameter and returns another String following the upcoming rules:
􏰁   Given null the method returns null (consider this as being a value for a String just as any other)
􏰁   Given "" the method returns ""
􏰁   Given "SingleWord" the method returns "SingleWord"
􏰁   Given "FirstName LastName" the method returns "LastName, FirstName" (perform the inversion and separate the words using the comma character)
􏰁   Given " SingleWord " the method returns "SingleWord" (trim the whitespaces in this case)
􏰁   Given" FirstName LastName "themethodreturns"LastName, FirstName"(trimthewhites-
    paces and perform the inversion in this case)
􏰁   Given "Mr. FirstName LastName" the method returns "LastName, FirstName Mr." (perform the @TODO
    inversion and place the Mr. title last; please consider Mrs. as well)
􏰁   Given"Mr. Phd. FirstName LastName"themethodreturns"LastName, FirstName Mr. Phd."(bea-  @TODO
    cuse why not having another title)
*/

import java.util.Calendar;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        String nameArray;
        nameArray = "";
        nameArray = handleMyStrings(nameArray);
        System.out.println(nameArray);

    }

    public static String handleMyStrings(String myNameArray) {
        String newFirstName = "";
        String newLastName = "";
        String returnableArray = "";
        int index;
        int numberOfLetters = 0;
        int numberOfWords = 0;
        int newFirstNameLength = 0;
        int newLastNameLength = 0;
        int numberOfSpaces = 0;
        boolean condition = true;

        if (myNameArray == null) {
            return null;
        } else {
            if (myNameArray.isEmpty()) {
                return "";
            } else {
                for (index = 0; index < myNameArray.length(); index++) {
                    if (Character.isWhitespace(myNameArray.charAt(index)))
                        numberOfSpaces++;
                    if (Character.isLetter(myNameArray.charAt(index))) {
                        numberOfLetters++;
                    }
                }
                for (index = 1; index < myNameArray.length(); index++) {
                    if (Character.isLetter(myNameArray.charAt(index)) && numberOfWords == 0)
                        numberOfWords++;
                    else if (numberOfWords == 1 && Character.isLetter(myNameArray.charAt(index)) && Character.isWhitespace(myNameArray.charAt(index - 1)))
                        numberOfWords++;
                }
            }
            if (numberOfLetters == 0) {
                return "Sirul trebuie sa contina minim o litera!";
            }
            if (numberOfWords == 1 && numberOfSpaces == 0) { //String is like VasilePop
                return myNameArray;

            } else if (numberOfWords == 1 && numberOfSpaces > 0) {
                index = 0;
                myNameArray = myNameArray.trim();
                return myNameArray;
            } else {
                if (isMrsOrMr(myNameArray)) {
                    returnableArray = handleMrsAndMr(myNameArray);
                    return returnableArray;
                } else if (isPhd(myNameArray)) {
                    returnableArray = handlePhd(myNameArray);
                    return returnableArray;
                } else {
                    index = 0;
                    while (index < myNameArray.length() && condition) {
                        while (condition) { //For FirstName
                            if ((Character.isDefined(myNameArray.charAt(index)) && !Character.isWhitespace(myNameArray.charAt(index))) && Character.isWhitespace(myNameArray.charAt(index + 1))) {
                                condition = false;
                            }
                            if (Character.isDefined(myNameArray.charAt(index)) && !Character.isWhitespace(myNameArray.charAt(index))) {
                                newFirstName = newFirstName + myNameArray.charAt(index);
                                newFirstNameLength++;
                            }
                            index++;
                        }
                        condition = true;
                        while (condition) { //For LastName
                            if (index == myNameArray.length()) {
                                condition = false;
                            } else if (Character.isDefined(myNameArray.charAt(index)) && !Character.isWhitespace(myNameArray.charAt(index))) {
                                newLastName = newLastName + myNameArray.charAt(index);
                                newLastNameLength++;
                            }
                            index++;
                        }
                    }
                }
            }

        }
        return newLastName + ", " + newFirstName;
    }

    public static boolean isMrsOrMr(String myArray) {
        if (!myArray.contains("Phd.") && myArray.contains("Mr."))
            return true;
        else if (!myArray.contains("Phd.") && myArray.contains("Mrs."))
            return true;
        return false;
    }

    public static boolean isPhd(String myArray) {
        if (myArray.contains("Mr. Phd."))
            return true;
        else if (myArray.contains("Mrs. Phd."))
            return true;
        return false;
    }

    public static String handleMrsAndMr(String myArray) {
        int firstIndexDot;
        int firstIndexM;
        String newFirstName = "";
        String newLastName = "";
        String title = "";
        String finalArray;
        int index;
        firstIndexM = myArray.indexOf("M");
        firstIndexDot = myArray.indexOf('.');
        for (index = firstIndexM; index <= firstIndexDot; index++)
            title = title + myArray.charAt(index);
        while (Character.isWhitespace(myArray.charAt(index))) {
            index = index + 1;
        }
        while (myArray.charAt(index) != ' ') {
            newFirstName = newFirstName + myArray.charAt(index);
            index++;
        }
        index++;
        while (index != myArray.length()) {
            if (!Character.isWhitespace(myArray.charAt(index)))
                newLastName = newLastName + myArray.charAt(index);
            index++;
        }
        finalArray = newLastName + ", " + newFirstName + " " + title;
        return finalArray;
    }

    public static String handlePhd(String myArray) {
        int firstIndexD;
        int firstIndexM;
        String newFirstName = "";
        String newLastName = "";
        String title = "";
        String finalArray;
        int index;
        firstIndexM = myArray.indexOf("M");
        firstIndexD = myArray.indexOf('d') + 1;
        for (index = firstIndexM; index <= firstIndexD; index++)
            title = title + myArray.charAt(index);
        while (Character.isWhitespace(myArray.charAt(index))) {
            index = firstIndexD + 2;
        }
        while (myArray.charAt(index) != ' ') {
            newFirstName = newFirstName + myArray.charAt(index);
            index++;
        }
        index++;
        while (index != myArray.length()) {
            if (!Character.isWhitespace(myArray.charAt(index)))
                newLastName = newLastName + myArray.charAt(index);
            index++;
        }
        finalArray = newLastName + ", " + newFirstName + " " + title;
        return finalArray;
    }
}
