package day1.part2;

import day1.CalibrationValue;
import java.util.Arrays;
import java.util.regex.Pattern;

public class Solver {
  static final String[] SPELLED_DIGITS = {
    "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"
  };

  private static Pattern getDigitRegex() {
    return Pattern.compile(String.format("\\d|%s", String.join("|", SPELLED_DIGITS)));
  }

  private static Pattern getReversedDigitRegex() {
    return Pattern.compile(
        String.format(
            "\\d|%s",
            String.join(
                "|",
                Arrays.stream(SPELLED_DIGITS)
                    .map(StringBuilder::new)
                    .map(StringBuilder::reverse)
                    .map(StringBuilder::toString)
                    .toArray(String[]::new))));
  }

  private static int convertMatchedDigit(String matchedDigit) {
    return switch (matchedDigit) {
      case "one", "eno" -> 1;
      case "two", "owt" -> 2;
      case "three", "eerht" -> 3;
      case "four", "ruof" -> 4;
      case "five", "evif" -> 5;
      case "six", "xis" -> 6;
      case "seven", "neves" -> 7;
      case "eight", "thgie" -> 8;
      case "nine", "enin" -> 9;
      default -> Integer.parseInt(matchedDigit);
    };
  }

  public static CalibrationValue parseLine(String line) {
    var firstDigitMatcher = getDigitRegex().matcher(line);
    if (!firstDigitMatcher.find()) throw new RuntimeException("No digit found");
    var firstDigit = convertMatchedDigit(firstDigitMatcher.group(0));
    var lastDigitMatcher =
        getReversedDigitRegex().matcher(new StringBuilder(line).reverse().toString());
    if (!lastDigitMatcher.find()) throw new RuntimeException("No digit found");
    var lastDigit = convertMatchedDigit(lastDigitMatcher.group(0));
    return new CalibrationValue(firstDigit * 10 + lastDigit);
  }

  public static int solve(String input) {
    return input.lines().map(Solver::parseLine).mapToInt(CalibrationValue::value).sum();
  }
}
