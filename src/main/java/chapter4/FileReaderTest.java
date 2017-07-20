package chapter4;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;

/*
File tests - Different inputs check how the data has changed in the file
DB tests - Different inputs check how the data has changed in the DB
GUI tests - Different inputs check how the data is reflected in the GUI (application is the same)
Tests - Risk driven
 */
public class FileReaderTest {

    FileReader reader;
    int lengthToRead = 4;

    @Before
    public void setUp() throws IOException {
        reader = new FileReader("data.txt");
    }

    @Test(expected = FileNotFoundException.class)
    public void testFileNotFoundException() throws Exception {
        new FileReader("notexistingfile.txt");
    }

    @Test(expected = IOException.class)
    public void testIOException() throws Exception {
        reader.close();
        reader.read();
    }

    @Test
    public void testRead() throws Exception {
        char target = 'd';
        Assert.assertTrue(isFound(target));
    }

    @Test
    public void testReadNonExisting() throws Exception {
        char target = 'z';
        Assert.assertFalse(isFound(target));
    }

    @Test
    public void testReadBoundary() throws Exception {
        char target = 'd';
        Assert.assertTrue(isFound(target));
    }

    @Test
    public void testBeyondBoundary() throws Exception {
        char target = 'f';
        Assert.assertFalse(isFound(target));
    }

    @Test
    public void testEmptyRead() throws IOException {
        // this created a file
        File file = new File("empty.txt");
        FileOutputStream outputStream = new FileOutputStream(file);
        outputStream.close();
        FileReader reader = new FileReader("empty.txt");
        Assert.assertEquals(-1, reader.read());
    }

    private boolean isFound(char target) throws IOException {
        boolean result = false;
        for(int i = 0; i < lengthToRead; i++) {
            char c = (char) reader.read();
            result = (c == target);
            if(result) {
                break;
            }
        }
        return result;
    }

}
