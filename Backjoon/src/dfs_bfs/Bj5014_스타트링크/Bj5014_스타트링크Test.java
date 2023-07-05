package dfs_bfs.Bj5014_스타트링크;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class Bj5014_스타트링크Test {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final String failMsg = "use the stairs";

    @BeforeEach
    public void setUpStream() {
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    public void flushStreams() {
        System.out.flush();
    }

    @Test
    void case1() throws Exception {
        System.setIn(new ByteArrayInputStream("10 1 10 2 1".getBytes()));
        Bj5014_스타트링크.main(new String[]{});
        assertEquals("6", outContent.toString().strip());
    }

    @Test
    void case2() throws Exception {
        System.setIn(new ByteArrayInputStream("100 2 1 1 0".getBytes()));
        Bj5014_스타트링크.main(new String[]{});
        assertEquals(failMsg, outContent.toString().strip());
    }

    @Test
    void case3() throws Exception {
        System.setIn(new ByteArrayInputStream("14 1 12 2 0".getBytes()));
        Bj5014_스타트링크.main(new String[]{});
        assertEquals(failMsg, outContent.toString().strip());
    }

    @Test
    void case4() throws Exception {
        System.setIn(new ByteArrayInputStream("14 1 12 3 2".getBytes()));
        Bj5014_스타트링크.main(new String[]{});
        assertEquals("7", outContent.toString().strip());
    }

    @Test
    void case5() throws Exception {
        System.setIn(new ByteArrayInputStream("14 1 12 4 2".getBytes()));
        Bj5014_스타트링크.main(new String[]{});
        assertEquals(failMsg, outContent.toString().strip());
    }
}