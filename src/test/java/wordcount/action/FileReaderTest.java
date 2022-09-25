package wordcount.action;

import org.junit.Assert;
import org.junit.Test;

import java.io.FileNotFoundException;

public class FileReaderTest {

    private final FileReader fileReader = new FileReader();

    private static final String PATH_TO_TEST_RESOURCES = "./src/test/resources";

    @Test
    public void testReadFileSuccess() throws FileNotFoundException {
        String data = this.fileReader.readFileToString(PATH_TO_TEST_RESOURCES + "/test.txt");
        Assert.assertEquals("Hello World!", data);
    }

    @Test(expected = FileNotFoundException.class)
    public void testFileNotFound() throws FileNotFoundException {
        this.fileReader.readFileToString(PATH_TO_TEST_RESOURCES + "/does_not_exist.txt");
    }


}
