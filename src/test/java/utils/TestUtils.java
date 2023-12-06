package utils;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Objects;

public class TestUtils {
  public static String getFileContentFromClasspath(final String filePath, final Class<?> aClass) {
    try {
      return Files.readString(Paths.get(getUriFromClasspath(filePath, aClass)));
    } catch (IOException | URISyntaxException e) {
      throw new RuntimeException(e);
    }
  }

  private static URI getUriFromClasspath(String filePath, Class<?> aClass)
      throws URISyntaxException {
    return Objects.requireNonNull(aClass.getResource(filePath)).toURI();
  }
}
