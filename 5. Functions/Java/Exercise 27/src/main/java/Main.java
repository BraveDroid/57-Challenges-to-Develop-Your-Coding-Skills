import java.io.IOException;

public class Main {
  public static void main(String[] args) throws IOException {
    ValidatingInputPrinter validatingInputPrinter = new ValidatingInputPrinter();
    validatingInputPrinter.readFirstName();
    validatingInputPrinter.readLastName();
    validatingInputPrinter.readZIPCode();
    validatingInputPrinter.readEmployeeID();
    validatingInputPrinter.treatErrorMessages();
    validatingInputPrinter.treatNoErrorMessage();
  }
}
