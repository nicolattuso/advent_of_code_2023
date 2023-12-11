package day2;

import day2.gen.Day2Parser;
import day2.gen.Day2ParserBaseVisitor;

public class SetVisitor extends Day2ParserBaseVisitor<Set> {
  @Override
  public Set visitSet(Day2Parser.SetContext ctx) {
    var setBuilder = Set.builder();
    for (var setElementCtx : ctx.setElement()) {
      if (setElementCtx.color().RED() != null) {
        setBuilder.red(Integer.parseInt(setElementCtx.INTEGER().getText()));
      } else if (setElementCtx.color().GREEN() != null) {
        setBuilder.green(Integer.parseInt(setElementCtx.INTEGER().getText()));
      } else if (setElementCtx.color().BLUE() != null) {
        setBuilder.blue(Integer.parseInt(setElementCtx.INTEGER().getText()));
      } else {
        throw new RuntimeException("Unknown set element: " + setElementCtx.getText());
      }
    }
    return setBuilder.build();
  }
}
