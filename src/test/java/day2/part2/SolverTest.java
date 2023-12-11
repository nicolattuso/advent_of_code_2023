package day2.part2;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import utils.TestUtils;


class SolverTest {
  @Test
  void should_process_example() {
    var sampleInput =
        """
           Game 1: 3 blue, 4 red; 1 red, 2 green, 6 blue; 2 green
           Game 2: 1 blue, 2 green; 3 green, 4 blue, 1 red; 1 green, 1 blue
           Game 3: 8 green, 6 blue, 20 red; 5 blue, 4 red, 13 green; 5 green, 1 red
           Game 4: 1 green, 3 red, 6 blue; 3 green, 6 red; 3 green, 15 blue, 14 red
           Game 5: 6 red, 1 blue, 3 green; 2 blue, 1 red, 2 green""";
    assertThat(Solver.solve(sampleInput)).isEqualTo(2286);
  }

  @Test
  void should_solve_part1() {
    var input = TestUtils.getFileContentFromClasspath("/day2/input.txt", this.getClass());
    assertThat(Solver.solve(input)).isEqualTo(63981);
  }
}