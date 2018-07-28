package com.bravedroid.application;

import java.util.Calendar;

public class RetirementCalculator {
    private int currentYear = Calendar.getInstance().get(Calendar.YEAR);

    int calculateRetirementYearsLeft(int currentAge, int ageOfRetirement) {
        return ageOfRetirement - currentAge;
    }

    int calculateYearForRetirement(int currentAge, int ageOfRetirement) {
        int retirementYearsLeft = ageOfRetirement - currentAge;
        return currentYear + retirementYearsLeft;
    }

    public String provideRetirementInfo(int currentAge, int ageOfRetirement){
        int retirementYearsLefted=calculateRetirementYearsLeft(currentAge,ageOfRetirement);
        int yearOfTheRetirement=calculateYearForRetirement( currentAge, ageOfRetirement);
        return"You have " + retirementYearsLefted + " years left until you can retire."+"\n"+
                "It's " + currentYear + ", so you can retire in " + yearOfTheRetirement + ".";
    }
}
