package day1.part1;

import org.junit.jupiter.api.Test;
import utils.TestUtils;

import static org.assertj.core.api.Assertions.assertThat;

class SolverTest {

  @Test
  void should_process_example() {
    var sampleInput = """
            1abc2
            pqr3stu8vwx
            a1b2c3d4e5f
            treb7uchet
        """;
    assertThat(Solver.solve(sampleInput)).isEqualTo(142);
  }

  @Test
  void should_solve_part1() {
    var input = TestUtils.getFileContentFromClasspath("/day1/input.txt", this.getClass());
    assertThat(Solver.solve(input)).isEqualTo(56049);
  }
}