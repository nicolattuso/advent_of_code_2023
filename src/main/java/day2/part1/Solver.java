package day2.part1;

import day2.Game;
import day2.InputVisitor;
import day2.gen.Day2Lexer;
import day2.gen.Day2Parser;
import day2.gen.Day2Parser.InputContext;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

public class Solver {
  public static int solve(String input) {
    var inputCtx = buildInputContext(input);
    var inputVisitor = new InputVisitor();
    var inputGames = inputVisitor.visitInput(inputCtx);
    var validGamesSum = 0;
    for (var game : inputGames.getGames()) {
      if (isGamePossible(game)) {
        validGamesSum += game.getId();
      }
    }
    return validGamesSum;
  }

  public static boolean isGamePossible(Game game) {
    var maxRedCount = game.getSets().stream().mapToInt(set -> set.getRed()).max().getAsInt();
    var maxGreenCount = game.getSets().stream().mapToInt(set -> set.getGreen()).max().getAsInt();
    var maxBlueCount = game.getSets().stream().mapToInt(set -> set.getBlue()).max().getAsInt();
    return maxRedCount <= 12 && maxGreenCount <= 13 && maxBlueCount <= 14;
  }

  private static InputContext buildInputContext(String input) {
    var tokenSource = new Day2Lexer(CharStreams.fromString(input));
    var inputParser = new Day2Parser(new CommonTokenStream(tokenSource));
    return inputParser.input();
  }
}
