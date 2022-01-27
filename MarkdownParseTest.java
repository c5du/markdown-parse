import static org.junit.Assert.*;
import org.junit.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class MarkdownParseTest {
    @Test
    public void addition() {
        assertEquals(2, 1 + 1);
    }

    @Test
    public void testGetLink() throws IOException{
        Path fileName = Path.of("test-file.md");
        String contents = Files.readString(fileName);
        ArrayList<String> links = MarkdownParse.getLinks(contents);
        List<String> expectedList = List.of("https://something.com", "some-page.html");
        assertEquals(expectedList, links);
    }

    @Test
    public void testGetLinkTwo() throws IOException{
        Path fileName = Path.of("test-file-2.md");
        String contents = Files.readString(fileName);
        ArrayList<String> links = MarkdownParse.getLinks(contents);
        List<String> expectedList = List.of("https://www.google.com");
        assertEquals(expectedList, links);
    }
    
}