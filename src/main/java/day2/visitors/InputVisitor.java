package day2.visitors;

import day2.gen.Day2Parser.InputContext;
import day2.gen.Day2ParserBaseVisitor;
import day2.model.Input;

public class InputVisitor extends Day2ParserBaseVisitor<Input> {
  @Override
  public Input visitInput(InputContext ctx) {
    var gamesBuilder = Input.builder();
    var gameVisitor = new GameVisitor();
    for (var gameCtx : ctx.game()) {
      gamesBuilder.game(gameVisitor.visitGame(gameCtx));
    }
    return gamesBuilder.build();
  }
}
