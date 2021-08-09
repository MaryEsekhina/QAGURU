import com.codeborne.xlstest.XLS;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.InputStream;

public class CheckXlsxFileTest {
    @Test
    void checkXlsTest() throws Exception {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        InputStream stream = classLoader.getResourceAsStream("Excel.xlsx");
        XLS xlsFile = new XLS(stream);
        String textExample = "ПЛАТЬЕ";
        textExample = new String(textExample.getBytes("windows-1251"), "utf-8");
        Assertions.assertEquals(textExample, xlsFile.excel.getSheetAt(3).getSheetName());
    }
}
