package com.company;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    void main() {
        String myArray1="GeorgeRosescu       ";
        String myArray2=" GeorgeRosescu  ";
        String myArray3="";
        String myArray4=null;
        String myArray5="George Rosescu    ";
        String myArray6="   George     Rosescu  ";
        String myArray7="Mr. George    Rosescu       ";
        String myArray8="Mr. Phd.  George      Rosescu       ";
        String myArray9="Mrs. Phd. Popa    Ana       ";
        String myArray10="Mrs.   Popa Ana     ";
        String myArray11=" George99   Ro$e$cu       ";

        myArray1 = Main.handleMyStrings(myArray1);
        myArray2 = Main.handleMyStrings(myArray2);
        myArray3 = Main.handleMyStrings(myArray3);
        myArray4 = Main.handleMyStrings(myArray4);
        myArray5 = Main.handleMyStrings(myArray5);
        myArray6 = Main.handleMyStrings(myArray6);
        myArray7 = Main.handleMyStrings(myArray7);
        myArray8 = Main.handleMyStrings(myArray8);
        myArray9 = Main.handleMyStrings(myArray9);
        myArray10 = Main.handleMyStrings(myArray10);
        myArray11 = Main.handleMyStrings(myArray11);

        String[] name = {myArray3};
        String[] expexted = {""};
        Assert.assertArrayEquals(expexted,name);
    }
}