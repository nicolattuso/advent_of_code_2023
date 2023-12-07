package day1.part2;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import utils.TestUtils;

class SolverTest {
  @Test
  void should_process_example() {
    var sampleInput =
        """
        two1nine
        eightwothree
        abcone2threexyz
        xtwone3four
        4nineeightseven2
        zoneight234
        7pqrstsixteen
        """;
    assertThat(Solver.solve(sampleInput)).isEqualTo(281);
  }

  @Test
  void should_solve_part2() {
    var input = TestUtils.getFileContentFromClasspath("/day1/input.txt", this.getClass());
    assertThat(Solver.solve(input)).isEqualTo(54530);
  }
}
