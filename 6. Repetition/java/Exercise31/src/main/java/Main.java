import java.io.IOException;

public class Main {
  public static void main(String[] args) throws IOException {
    KarvonenHeartRatePrinter karvonenHeartRatePrinter = new KarvonenHeartRatePrinter();
    karvonenHeartRatePrinter.readAge();
    karvonenHeartRatePrinter.readHeartRate();
    karvonenHeartRatePrinter.printHeartRate();
  }
}
