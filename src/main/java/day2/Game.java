package day2;

import java.util.List;
import lombok.Builder;
import lombok.Getter;
import lombok.Singular;

@Getter
@Builder
public class Game {
  int id;
  @Singular List<Set> sets;
}
