package com.bravedroid.businesslogic;

import com.bravedroid.presenter.InputFormUserDTO;

public class BloodAlcoholCalculator {
    public double calculateBloodAlcohol(InputFormUserDTO inputFormUserDTO) {
        // formula is BAC=(A*5.14/W*r)-0.015*H
        // formula is BAC=(x/y1)-z

        String gender = inputFormUserDTO.getGender();
        double x = inputFormUserDTO.getAmountOfAlcoholConsumed() * 5.14;
        double y1 = inputFormUserDTO.getWeight() * 0.73;
        double y2= inputFormUserDTO.getWeight() * 0.66;
        double z = 0.05 * inputFormUserDTO.getAmountOfTimeSinceLastDrink();
        if (gender.equals("man")) {
            return (x /y1) - z;
        } else {
            return (x /y2) - z;
        }
    }
}
