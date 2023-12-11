package day2.part2;

import day2.model.Game;
import day2.model.Set;
import day2.visitors.InputVisitor;
import day2.gen.Day2Lexer;
import day2.gen.Day2Parser;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

public class Solver {
  public static int solve(String input) {
    var inputCtx = buildInputContext(input);
    var inputVisitor = new InputVisitor();
    var inputGames = inputVisitor.visitInput(inputCtx);
    return inputGames.getGames().stream().map(Solver::computeGamePower).mapToInt(Integer::intValue).sum();
  }

  public static int computeGamePower(Game game) {
    var maxRedCount = game.getSets().stream().mapToInt(Set::getRed).max().getAsInt();
    var maxGreenCount = game.getSets().stream().mapToInt(Set::getGreen).max().getAsInt();
    var maxBlueCount = game.getSets().stream().mapToInt(Set::getBlue).max().getAsInt();
    return maxRedCount * maxGreenCount * maxBlueCount;
  }

  private static Day2Parser.InputContext buildInputContext(String input) {
    var tokenSource = new Day2Lexer(CharStreams.fromString(input));
    var inputParser = new Day2Parser(new CommonTokenStream(tokenSource));
    return inputParser.input();
  }
}
