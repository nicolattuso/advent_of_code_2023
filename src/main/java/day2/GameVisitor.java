package day2;

import day2.gen.Day2Parser;
import day2.gen.Day2ParserBaseVisitor;

public class GameVisitor extends Day2ParserBaseVisitor<Game> {
  @Override
  public Game visitGame(Day2Parser.GameContext ctx) {
    var gameBuilder = Game.builder();
    gameBuilder.id(Integer.parseInt(ctx.INTEGER().getText()));
    for (var setCtx : ctx.sets().set()) {
      var setVisitor = new SetVisitor();
      gameBuilder.set(setVisitor.visitSet(setCtx));
    }
    return gameBuilder.build();
  }
}
