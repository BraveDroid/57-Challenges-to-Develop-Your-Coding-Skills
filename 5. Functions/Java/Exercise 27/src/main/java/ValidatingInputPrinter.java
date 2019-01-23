import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidatingInputPrinter {
  private boolean mustExit;
  private String firstName;
  private String lastName;
  private String employeeID;
  private String ZIPCodeInString;
  private BufferedReader input;

  ValidatingInputPrinter() {
    input = new BufferedReader(new InputStreamReader(System.in));
  }

  public void readFirstName() throws IOException {
    if (mustExit) {
      return;
    }
    System.out.println("Enter the first name: ");
    firstName = input.readLine();
    if (mustExit(firstName)) {
      mustExit = true;
    }
  }

  public void readLastName() throws IOException {
    if (mustExit) {
      return;
    }
    System.out.println("Enter the last name: ");
    lastName = input.readLine();
    if (mustExit(lastName)) {
      mustExit = true;
    }
  }

  public void readZIPCode() throws IOException {
    if (mustExit) {
      return;
    }
    System.out.println("Enter the ZIP code: ");
    ZIPCodeInString = input.readLine();
    if (mustExit(ZIPCodeInString)) {
      mustExit = true;
    }
  }

  public void readEmployeeID() throws IOException {
    if (mustExit) {
      return;
    }
    System.out.println("Enter an employee ID: ");
    employeeID = input.readLine();
    if (mustExit(employeeID)) {
      mustExit = true;
    }
  }

  public void treatErrorMessages() {
    if (mustExit) return;
    if (isEmpty(firstName)) {
      System.out.println("The first Name must be filled in.");
    }
    if (isEmpty(lastName)) {
      System.out.println("The last Name must be filled in.");
    }
    if (!isValidateNames(firstName) && (!isEmpty(firstName))) {
      System.out.println("\" " + firstName + "\" " + " is not a valid first name. It is too shortIt is too short.");
    }
    if (!isValidateNames(lastName) && (!isEmpty(lastName))) {
      System.out.println("\" " + firstName + "\" " + " is not a valid last name. It is too shortIt is too short.");
    }
    if (!isValidateZIPCode(ZIPCodeInString)) {
      System.out.println("The ZIP code must be numeric.");
    }
    if (isValidateEmployeeID(employeeID)) {
      System.out.println(employeeID + " is not a valid ID.");
    }
  }

  public void treatNoErrorMessage() {
    if (mustExit) return;
    if (isValidateNames(firstName)
            && isValidateNames(lastName)
            && (!isEmpty(firstName))
            && (!isEmpty(lastName))
            && isValidateZIPCode(ZIPCodeInString)
            && isValidateEmployeeID(employeeID))
      System.out.println("There were no errors found");
  }

  private boolean isValidateNames(String inputFromUser) {
    boolean isValidName;
    isValidName = inputFromUser.length() >= 2;
    return isValidName;
  }

  private boolean isValidateZIPCode(String ZIPCodeInString) {
    boolean isValidZipCode;
    try {
      Integer.parseInt(ZIPCodeInString);
      isValidZipCode = true;
    } catch (IllegalArgumentException ex) {
      isValidZipCode = false;
    }
    return isValidZipCode;
  }

  private boolean isValidateEmployeeID(String employeeID) {
    boolean isValidEmployeeID;
    String patternEmployeeID = "(\\w{2})-(\\d{3})";
    isValidEmployeeID = isPatternMatched(employeeID, patternEmployeeID);
    return isValidEmployeeID;
  }

  private boolean isPatternMatched(String string, String pattern) {
    Pattern regex = Pattern.compile(pattern);
    Matcher matcher = regex.matcher(string);
    return matcher.find();
  }

  private static boolean isEmpty(String input) {
    return input.equals("");
  }

  private boolean mustExit(String input) {
    mustExit = input.equals("exit");
    return mustExit;
  }
}
