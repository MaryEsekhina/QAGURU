import org.apache.commons.io.IOUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.nio.charset.StandardCharsets;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class CheckZipFileTest {
    @Test
    void checkZipTest() throws Exception {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        String entryAsString = null;
        try (ZipInputStream stream = new ZipInputStream(classLoader.getResourceAsStream("Files.zip"))) {
            ZipEntry entry;
            while ((entry = stream.getNextEntry()) != null) {
                entryAsString = IOUtils.toString(stream, StandardCharsets.UTF_8);
            }
        }
        String textExample = "Александр Пушкин — Зимнее утро";
        textExample = new String(textExample.getBytes("windows-1251"), "utf-8");
        Assertions.assertTrue(entryAsString.contains(textExample));
    }
}
