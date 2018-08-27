package com.bravedroid;

import com.bravedroid.businesslogic.PasswordStrengthIndicator;

public class Main {
  public static void main(String[] args) {
    PasswordStrengthIndicator passwordStrengthIndicator =new PasswordStrengthIndicator();
    passwordStrengthIndicator.indicatePasswordStrength("hyu)!!,?323");
  }
}
