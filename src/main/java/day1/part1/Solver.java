package day1.part1;

public class Solver {
  public static CalibrationValue parseLine(String line) {
    var firstDigit = line.chars().filter(Character::isDigit).findFirst().getAsInt();
    var lastDigit = new StringBuilder(line).reverse().toString().chars().filter(Character::isDigit).findFirst().getAsInt();
    String calibrationValueString = String.valueOf((char) firstDigit) +
        (char) lastDigit;
    return new CalibrationValue(Integer.parseInt(calibrationValueString));
  }

  public static int solve(String input) {
    return input.lines().map(Solver::parseLine).mapToInt(CalibrationValue::value).sum();
  }
}
